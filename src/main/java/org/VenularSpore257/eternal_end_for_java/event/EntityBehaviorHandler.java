package org.VenularSpore257.eternal_end_for_java.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import org.VenularSpore257.eternal_end_for_java.EternalEndEntities;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles custom entity behaviors not covered by AI goals.
 *
 * Converted from Bedrock entity behaviors and JavaScript logic.
 *
 * Key responsibilities:
 * - Ender Slime death splitting (large -> medium -> small)
 * - Companion freezing/thawing (ice block detection)
 * - Void Dragon phase transitions
 * - Entity-specific animations
 * - Enderman stare behavior
 * - Golem resting activation
 *
 * Bedrock source reference:
 * - entities/ender_slime.json (summon on death)
 * - entities/frostling.json (frozen state in ice)
 * - entities/void_dragon.json (phase transitions via events)
 * - entities/gilded_enderman.json (lookat component)
 */
@EventBusSubscriber(modid = "eternal_end_for_java")
public class EntityBehaviorHandler {

    /**
     * Tracks entities that are in special states (frozen, resting, etc.)
     */
    private static final Map<ResourceLocation, Integer> ENTITY_STATE_TIMERS = new HashMap<>();

    /**
     * Handles entity tick events.
     *
     * Use for:
     * - Per-tick behaviors not covered by AI
     * - State transitions based on timers
     * - Environmental sensing (in ice, in water, etc.)
     */
    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Post event) {
        if (event.getEntity().level().isClientSide()) return;

        Entity entity = event.getEntity();
        ResourceLocation entityId = BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType());

        // Only handle our mod's entities
        if (!entityId.getNamespace().equals("eternal_end_for_java")) return;

        String entityPath = entityId.getPath();

        switch (entityPath) {
            // Companions - frozen state checking
            case "frostling", "glowling", "mistling", "nybling", "voidling" -> {
                tickCompanion(entity);
            }

            // Void Dragon - phase management
            case "void_dragon" -> {
                tickVoidDragon(entity);
            }

            // Gilded Golem - resting behavior
            case "gilded_golem" -> {
                tickGildedGolem(entity);
            }

            // Enderman variants - special behaviors
            case "gilded_enderman", "pale_enderman", "mossy_enderman",
                 "mycotic_enderman", "winged_enderman" -> {
                tickEnderman(entity);
            }
        }
    }

    /**
     * Handles living entity death.
     *
     * From Bedrock: entities/ender_slime.json
     * - Large slime spawns 2 medium
     * - Medium slime spawns 4 small
     */
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntity().level().isClientSide()) return;

        LivingEntity entity = event.getEntity();
        ResourceLocation entityId = BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType());

        if (!entityId.getNamespace().equals("eternal_end_for_java")) return;

        String entityPath = entityId.getPath();

        switch (entityPath) {
            case "ender_slime" -> {
                handleEnderSlimeDeath(event);
            }
        }
    }

    /**
     * Handles target change events (for Enderman stare behavior).
     *
     * From Bedrock: entities/gilded_enderman.json
     * - lookat component triggers angry state
     */
    @SubscribeEvent
    public static void onTargetSet(LivingChangeTargetEvent event) {
        if (event.getEntity().level().isClientSide()) return;

        LivingEntity entity = event.getEntity();
        ResourceLocation entityId = BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType());

        if (!entityId.getNamespace().equals("eternal_end_for_java")) return;

        String entityPath = entityId.getPath();

        // Handle Enderman target acquisition
        if (entityPath.equals("gilded_enderman") ||
            entityPath.equals("winged_enderman")) {

            // Play aggressive sound when targeting player
            var newTarget = event.getNewAboutToBeSetTarget();
            if (newTarget != null && newTarget instanceof net.minecraft.world.entity.player.Player) {
                entity.level().playSound(null, entity.blockPosition(),
                    SoundEvents.ENDERMAN_STARE,
                    SoundSource.HOSTILE, 1.0F, 1.0F);
            }
        }
    }

    /**
     * Ticks companion entities.
     *
     * From Bedrock: entities/frostling.json
     * - Frozen when in ice block
     * - Thaws when in air
     */
    private static void tickCompanion(Entity entity) {
        BlockPos pos = entity.blockPosition();
        ServerLevel level = (ServerLevel) entity.level();

        boolean inIce = level.getBlockState(pos).is(Blocks.ICE);
        boolean wasFrozen = entity.getPersistentData().getBoolean("eternal_end:frozen");

        if (inIce && !wasFrozen) {
            // Become frozen
            entity.getPersistentData().putBoolean("eternal_end:frozen", true);

            // Align to block center (from Bedrock: execute align xyz run tp @s ~0.5 ~ ~0.5)
            entity.teleportTo(
                Math.floor(entity.getX()) + 0.5,
                entity.getY(),
                Math.floor(entity.getZ()) + 0.5
            );

            // Play sound
            level.playSound(null, pos, SoundEvents.ENDERMAN_TELEPORT,
                SoundSource.NEUTRAL, 1.0F, 1.0F);

        } else if (!inIce && wasFrozen) {
            // Thaw out
            entity.getPersistentData().putBoolean("eternal_end:frozen", false);
        }
    }

    /**
     * Ticks Void Dragon phase management.
     *
     * From Bedrock: entities/void_dragon.json
     * Phases:
     * - 0: Spawn mode (temporary)
     * - 1: Death mode (dying sequence)
     * - 2: Circle mode (circling player)
     * - 4: Shoot mode (shooting projectiles)
     * - 5: Catch mode (player mounting)
     * - 6: Statue mode (inactive)
     */
    private static void tickVoidDragon(Entity entity) {
        int variant = entity.getPersistentData().getInt("eternal_end:variant");

        // Handle delayed death sequence
        if (entity.getPersistentData().getBoolean("eternal_end:delayed_death")) {
            // Check if death animation should complete
            // This is handled by the entity class
        }

        // Handle phase-specific behaviors
        switch (variant) {
            case 0 -> { // Spawn mode
                // Temporary state, transitions to circle mode
            }
            case 1 -> { // Death mode
                // Dying sequence, no movement
            }
            case 2 -> { // Circle mode
                // Timer based transition to shoot mode
                int timer = entity.getPersistentData().getInt("eternal_end:circle_timer");
                if (timer <= 0) {
                    // Transition to shoot mode
                    entity.getPersistentData().putInt("eternal_end:variant", 4);
                    entity.getPersistentData().putInt("eternal_end:shoot_timer", 60); // 3 seconds
                } else {
                    entity.getPersistentData().putInt("eternal_end:circle_timer", timer - 1);
                }
            }
            case 4 -> { // Shoot mode
                // Timer based transition back to circle mode
                int timer = entity.getPersistentData().getInt("eternal_end:shoot_timer");
                if (timer <= 0) {
                    // Transition to circle mode
                    entity.getPersistentData().putInt("eternal_end:variant", 2);
                    entity.getPersistentData().putInt("eternal_end:circle_timer",
                        60 + (int)(Math.random() * 80)); // 3-7 seconds
                } else {
                    entity.getPersistentData().putInt("eternal_end:shoot_timer", timer - 1);
                }
            }
            case 5 -> { // Catch mode
                // Player mounting, timer based
                int timer = entity.getPersistentData().getInt("eternal_end:catch_timer");
                if (timer <= 0) {
                    // Transition back to circle mode
                    entity.getPersistentData().putInt("eternal_end:variant", 2);
                } else {
                    entity.getPersistentData().putInt("eternal_end:catch_timer", timer - 1);
                }
            }
            case 6 -> { // Statue mode
                // Inactive, no behavior
            }
        }
    }

    /**
     * Ticks Gilded Golem.
     *
     * From Bedrock: entities/gilded_golem.json
     * - Resting state (variant 0) - no movement, no damage
     * - Activates when player near (transitions to attack mode)
     */
    private static void tickGildedGolem(Entity entity) {
        ServerLevel level = (ServerLevel) entity.level();
        int variant = entity.getPersistentData().getInt("eternal_end:variant");

        // Resting state (variant 0)
        if (variant == 0) {
            // Check for nearby players
            var nearestPlayer = level.getNearestPlayer(entity, 16);

            if (nearestPlayer != null) {
                // Activate - transition to melee attack mode
                entity.getPersistentData().putInt("eternal_end:variant", 1);

                // Play activation sound
                level.playSound(null, entity.blockPosition(),
                    SoundEvents.IRON_GOLEM_REPAIR,
                    SoundSource.HOSTILE, 1.0F, 0.5F);
            }
        }
    }

    /**
     * Ticks Enderman variants.
     *
     * From Bedrock: entities/gilded_enderman.json, winged_enderman.json
     * - Water/rain causes teleport
     * - Stare detection
     */
    private static void tickEnderman(Entity entity) {
        ServerLevel level = (ServerLevel) entity.level();
        BlockPos pos = entity.blockPosition();

        // Check if in water or rain
        boolean inWater = entity.isInWater();
        boolean inRain = level.isRainingAt(pos);

        if (inWater || inRain) {
            // Teleport away (handled in DamageHandler for damage)
            // This is for environmental teleport
        }
    }

    /**
     * Handles Ender Slime death with splitting.
     *
     * From Bedrock: entities/ender_slime.json
     * - Large (variant 4) -> spawns 2 medium
     * - Medium (variant 2) -> spawns 4 small
     * - Small (variant 1) -> normal death
     */
    private static void handleEnderSlimeDeath(LivingDeathEvent event) {
        LivingEntity slime = event.getEntity();
        ServerLevel level = (ServerLevel) slime.level();
        int size = slime.getPersistentData().getInt("eternal_end:slime_size");

        if (size == 4) {
            // Large slime - spawn 2 medium
            for (int i = 0; i < 2; i++) {
                Entity newSlime = EternalEndEntities.ENDER_SLIME.get().create(level);
                if (newSlime != null) {
                    newSlime.moveTo(slime.getX(), slime.getY(), slime.getZ());
                    newSlime.getPersistentData().putInt("eternal_end:slime_size", 2);
                    level.addFreshEntity(newSlime);
                }
            }
        } else if (size == 2) {
            // Medium slime - spawn 4 small
            for (int i = 0; i < 4; i++) {
                Entity newSlime = EternalEndEntities.ENDER_SLIME.get().create(level);
                if (newSlime != null) {
                    newSlime.moveTo(slime.getX(), slime.getY(), slime.getZ());
                    newSlime.getPersistentData().putInt("eternal_end:slime_size", 1);
                    level.addFreshEntity(newSlime);
                }
            }
        }
        // Small slimes just die normally
    }
}
