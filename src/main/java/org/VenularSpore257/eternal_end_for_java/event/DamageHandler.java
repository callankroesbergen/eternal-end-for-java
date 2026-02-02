package org.VenularSpore257.eternal_end_for_java.event;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingKnockBackEvent;
import org.VenularSpore257.eternal_end_for_java.EternalEndEntities;

/**
 * Handles damage modifications and special damage behaviors.
 *
 * Converted from Bedrock entity damage_sensor components and JavaScript logic.
 *
 * Key responsibilities:
 * - Enderman teleport when hit by projectiles
 * - Void Dragon damage immunity states
 * - Gilded Golem damage resistance
 * - Lost Soul damage immunity
 * - Spore Lizard "death" state (doesn't take fatal damage)
 * - Companion suffocation immunity
 * - Water damage for Enderman variants
 *
 * Bedrock source reference:
 * - entities/gilded_enderman.json (damage_sensor for projectile)
 * - entities/winged_enderman.json (damage_sensor for projectile)
 * - entities/void_dragon.json (damage_sensor with various immunities)
 * - entities/gilded_golem.json (fire_immune)
 * - entities/lost_soul.json (damage_sensor all->false)
 */
@EventBusSubscriber(modid = "eternal_end_for_java")
public class DamageHandler {

    /**
     * Handles living entity damage event (before damage is applied).
     * Uses LivingDamageEvent.Pre with setNewDamage(0) to negate damage.
     */
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        if (event.getEntity().level().isClientSide()) return;

        LivingEntity entity = event.getEntity();
        DamageSource source = event.getSource();
        ResourceLocation entityId = BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType());

        // Only handle our mod's entities
        if (!entityId.getNamespace().equals("eternal_end_for_java")) return;

        String entityPath = entityId.getPath();

        switch (entityPath) {
            // Enderman variants - teleport on projectile hit
            case "gilded_enderman", "pale_enderman", "mossy_enderman",
                 "mycotic_enderman", "winged_enderman" -> {
                handleEndermanHurt(event, entity, source);
            }

            // Void Dragon - complex damage handling
            case "void_dragon" -> {
                handleVoidDragonHurt(event, entity, source);
            }

            // Gilded Golem - fire immune
            case "gilded_golem" -> {
                handleGildedGolemHurt(event, entity, source);
            }

            // Lost Soul - damage immune
            case "lost_soul" -> {
                event.setNewDamage(0);
            }

            // Companions - suffocation immune
            case "frostling", "glowling", "mistling", "nybling", "voidling" -> {
                handleCompanionHurt(event, entity, source);
            }

            // Spore/Verdant Lizard - death state handling
            case "spore_lizard", "verdant_lizard" -> {
                handleLizardHurt(event, entity, source);
            }
        }
    }

    /**
     * Handles knockback modifications.
     */
    @SubscribeEvent
    public static void onLivingKnockback(LivingKnockBackEvent event) {
        if (event.getEntity().level().isClientSide()) return;

        LivingEntity entity = event.getEntity();
        ResourceLocation entityId = BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType());

        if (!entityId.getNamespace().equals("eternal_end_for_java")) return;

        String entityPath = entityId.getPath();

        switch (entityPath) {
            // Void Dragon - immune to knockback
            case "void_dragon" -> {
                event.setCanceled(true);
            }

            // Gilded Golem - high knockback resistance (0.65 in Bedrock)
            case "gilded_golem" -> {
                event.setStrength(event.getStrength() * 0.35f);
            }

            // Enderman variants - reduced knockback
            case "gilded_enderman", "pale_enderman", "mossy_enderman",
                 "mycotic_enderman", "winged_enderman" -> {
                event.setStrength(event.getStrength() * 0.5f);
            }
        }
    }

    /**
     * Handles Enderman damage and teleportation.
     *
     * From Bedrock: entities/gilded_enderman.json, winged_enderman.json
     * - Teleport away when hit by projectiles
     * - Water/rain damage
     */
    private static void handleEndermanHurt(LivingDamageEvent.Pre event, LivingEntity entity, DamageSource source) {
        // Projectile damage - teleport away and negate
        if (source.is(DamageTypes.ARROW) || source.is(DamageTypes.TRIDENT) ||
            source.is(DamageTypes.MAGIC) || source.is(DamageTypes.THROWN) ||
            source.is(DamageTypes.PLAYER_ATTACK)) {
            // Check if source is projectile
            Entity sourceEntity = source.getDirectEntity();
            if (sourceEntity instanceof net.minecraft.world.entity.projectile.Projectile ||
                source.is(DamageTypes.ARROW) || source.is(DamageTypes.TRIDENT)) {
                event.setNewDamage(0);
                teleportEnderman(entity);
                return;
            }
        }

        // Water damage - teleport away
        if (source.is(DamageTypes.DROWN) || entity.isInWater()) {
            teleportEnderman(entity);
        }
    }

    /**
     * Handles Void Dragon damage with phase-based immunities.
     *
     * From Bedrock: entities/void_dragon.json
     * damage_sensor triggers:
     * - fatal damage (not in statue mode) -> pre_delayed_death
     * - suffocation -> no damage
     * - fly_into_wall -> no damage
     * - fire -> no damage
     * - fall -> no damage
     * - projectile -> 65% damage
     * - has slowness effect -> no damage
     * - has resistance effect -> no damage
     */
    private static void handleVoidDragonHurt(LivingDamageEvent.Pre event, LivingEntity entity, DamageSource source) {
        // Get dragon variant/phase from entity data
        int variant = entity.getPersistentData().getInt("eternal_end:variant");

        // Variant 6 = statue mode - immune to all damage
        if (variant == 6) {
            event.setNewDamage(0);
            return;
        }

        // Suffocation damage - negate
        if (source.is(DamageTypes.IN_WALL)) {
            event.setNewDamage(0);
            return;
        }

        // Fall damage - negate
        if (source.is(DamageTypes.FALL)) {
            event.setNewDamage(0);
            return;
        }

        // Fire damage - negate (fire_immune in Bedrock)
        if (source.is(DamageTypes.ON_FIRE) || source.is(DamageTypes.IN_FIRE) ||
            source.is(DamageTypes.LAVA)) {
            event.setNewDamage(0);
            return;
        }

        // Projectile damage - 65% of original
        if (source.is(DamageTypes.ARROW) || source.is(DamageTypes.TRIDENT) ||
            source.is(DamageTypes.THROWN)) {
            event.setNewDamage(event.getNewDamage() * 0.65f);
        }

        // Slowness effect - immune
        if (entity.hasEffect(net.minecraft.world.effect.MobEffects.MOVEMENT_SLOWDOWN)) {
            event.setNewDamage(0);
            return;
        }

        // Resistance effect - immune
        if (entity.hasEffect(net.minecraft.world.effect.MobEffects.DAMAGE_RESISTANCE)) {
            event.setNewDamage(0);
            return;
        }

        // Fatal damage handling - trigger delayed death sequence
        if (event.getNewDamage() >= entity.getHealth()) {
            // Cancel the death and start delayed death sequence
            event.setNewDamage(0);
            startVoidDragonDelayedDeath(entity);
        }
    }

    /**
     * Handles Gilded Golem damage.
     *
     * From Bedrock: entities/gilded_golem.json
     * - fire_immune component
     * - Levitation immune
     */
    private static void handleGildedGolemHurt(LivingDamageEvent.Pre event, LivingEntity entity, DamageSource source) {
        // Fire damage - immune
        if (source.is(DamageTypes.ON_FIRE) || source.is(DamageTypes.IN_FIRE) ||
            source.is(DamageTypes.LAVA) || source.is(DamageTypes.HOT_FLOOR)) {
            event.setNewDamage(0);
        }
    }

    /**
     * Handles Companion damage.
     *
     * From Bedrock: entities/frostling.json
     * - suffocation damage immunity (damage_sensor)
     */
    private static void handleCompanionHurt(LivingDamageEvent.Pre event, LivingEntity entity, DamageSource source) {
        // Suffocation damage - negate
        if (source.is(DamageTypes.IN_WALL)) {
            event.setNewDamage(0);
        }

        // Frozen companions take no damage
        if (entity.getPersistentData().getBoolean("eternal_end:frozen")) {
            event.setNewDamage(0);
        }
    }

    /**
     * Handles Lizard damage with death state.
     *
     * From Bedrock: entities/spore_lizard.json
     * - fatal damage -> set "dead" property instead of dying
     * - Apply infinite slowness when "dead"
     */
    private static void handleLizardHurt(LivingDamageEvent.Pre event, LivingEntity entity, DamageSource source) {
        // Check if already in death state
        if (entity.getPersistentData().getBoolean("eternal_end:lizard_dead")) {
            event.setNewDamage(0);
            return;
        }

        // Fatal damage - enter death state instead of dying
        if (event.getNewDamage() >= entity.getHealth()) {
            event.setNewDamage(0);
            entity.getPersistentData().putBoolean("eternal_end:lizard_dead", true);
            entity.setHealth(entity.getMaxHealth()); // Keep alive but marked as dead

            // Apply infinite slowness
            entity.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                net.minecraft.world.effect.MobEffects.MOVEMENT_SLOWDOWN,
                1000000, 255, false, false));
        }

        // Stalagmite damage is always dealt
        // Piston damage is negated
    }

    /**
     * Teleports an Enderman away randomly.
     *
     * From Bedrock: teleport component with spreadplayers command
     */
    private static void teleportEnderman(LivingEntity entity) {
        Level level = entity.level();

        // Play teleport sound
        level.playSound(null, entity.blockPosition(),
            SoundEvents.ENDERMAN_TELEPORT,
            SoundSource.NEUTRAL, 1.0F, 1.0F);

        // Random teleport within 32 blocks
        double x = entity.getX() + (level.random.nextDouble() - 0.5) * 32;
        double y = entity.getY();
        double z = entity.getZ() + (level.random.nextDouble() - 0.5) * 32;

        // Find safe Y position
        while (y > entity.level().getMinBuildHeight() && level.getBlockState(
            net.minecraft.core.BlockPos.containing(x, y, z)).isAir()) {
            y--;
        }
        y++; // Move up to the first non-air block

        // Teleport
        entity.teleportTo(x, y, z);

        // Spawn teleport particles
        if (level instanceof net.minecraft.server.level.ServerLevel serverLevel) {
            serverLevel.sendParticles(
                net.minecraft.core.particles.ParticleTypes.PORTAL,
                entity.getX(), entity.getY() + 1, entity.getZ(),
                10, 0.5, 1, 0.5, 0.1);
        }
    }

    /**
     * Starts the Void Dragon's delayed death sequence.
     *
     * From Bedrock: panascais_end:delayed_death event
     * - Transitions to death mode (variant 1)
     * - Applies infinite slowness
     * - Triggers death animation
     */
    private static void startVoidDragonDelayedDeath(LivingEntity entity) {
        // Set death mode
        entity.getPersistentData().putInt("eternal_end:variant", 1);
        entity.getPersistentData().putBoolean("eternal_end:delayed_death", true);

        // Apply infinite slowness
        entity.addEffect(new net.minecraft.world.effect.MobEffectInstance(
            net.minecraft.world.effect.MobEffects.MOVEMENT_SLOWDOWN,
            1000000, 255, false, false));

        // The entity will handle the actual death after the animation
        // This is handled in the entity's tick method
    }
}
