package org.VenularSpore257.eternal_end_for_java.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import org.VenularSpore257.eternal_end_for_java.EternalEndEntities;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Handles entity spawning conditions and behaviors.
 *
 * Converted from Bedrock entity JSON spawn rules and JavaScript logic.
 *
 * Key responsibilities:
 * - Biome-specific entity spawning
 * - Spawn capacity management
 * - Special spawn conditions (frozen companions in ice, etc.)
 * - Spawner block logic
 *
 * Bedrock source reference:
 * - entities/*.json (component_groups with spawn conditions)
 * - feature_rules/panascais/end/*.json
 */
public class EntitySpawnHandler {

    /**
     * Track spawn counts per biome to prevent overcrowding
     * Key: biome_id, Value: entity_type -> count
     */
    private static final Map<UUID, Integer> COMPANION_SPAWN_TRACKER = new HashMap<>();
    private static final int MAX_COMPANIONS_PER_PLAYER = 15;

    /**
     * Entity Spawn Weights (for natural spawning)
     * Based on Bedrock spawn probabilities
     */
    private static final Map<EntityType<?>, Integer> SPAWN_WEIGHTS = new HashMap<>();
    static {
        // Passive/Neutral entities
        SPAWN_WEIGHTS.put(EternalEndEntities.FROSTLING.get(), 8);
        SPAWN_WEIGHTS.put(EternalEndEntities.GLOWLING.get(), 8);
        SPAWN_WEIGHTS.put(EternalEndEntities.MISTLING.get(), 8);
        SPAWN_WEIGHTS.put(EternalEndEntities.NYBLING.get(), 8);
        SPAWN_WEIGHTS.put(EternalEndEntities.VOIDLING.get(), 8);

        // Hostile entities
        SPAWN_WEIGHTS.put(EternalEndEntities.ENDER_SLIME.get(), 10);
        SPAWN_WEIGHTS.put(EternalEndEntities.WINGED_ENDERMAN.get(), 5);
        SPAWN_WEIGHTS.put(EternalEndEntities.GILDED_ENDERMAN.get(), 4);
        SPAWN_WEIGHTS.put(EternalEndEntities.PALE_ENDERMAN.get(), 4);
        SPAWN_WEIGHTS.put(EternalEndEntities.MOSSY_ENDERMAN.get(), 4);
        SPAWN_WEIGHTS.put(EternalEndEntities.MYCOTIC_ENDERMAN.get(), 4);
        SPAWN_WEIGHTS.put(EternalEndEntities.SPORE_LIZARD.get(), 6);
        SPAWN_WEIGHTS.put(EternalEndEntities.VERDANT_LIZARD.get(), 6);
        SPAWN_WEIGHTS.put(EternalEndEntities.GILDED_GOLEM.get(), 3);
        SPAWN_WEIGHTS.put(EternalEndEntities.DOOMED_WOLF.get(), 5);

        // Special entities (lower spawn rate)
        SPAWN_WEIGHTS.put(EternalEndEntities.SHADOW_DEER.get(), 4);
        SPAWN_WEIGHTS.put(EternalEndEntities.GILDED_DEER.get(), 3);
        SPAWN_WEIGHTS.put(EternalEndEntities.GILDED_TURTLE.get(), 4);
        SPAWN_WEIGHTS.put(EternalEndEntities.FROZEN_JELLYFISH.get(), 6);
        SPAWN_WEIGHTS.put(EternalEndEntities.SPRENGING.get(), 5);
        SPAWN_WEIGHTS.put(EternalEndEntities.SVEPPUM.get(), 3);
        SPAWN_WEIGHTS.put(EternalEndEntities.ENDRAY.get(), 4);
        SPAWN_WEIGHTS.put(EternalEndEntities.VOID_EYE.get(), 4);
    }

    /**
     * Handles entity joining the level.
     * This is called when an entity is spawned or loaded.
     *
     * From Bedrock: minecraft:entity_spawned event handlers
     */
    public static void onEntitySpawn(EntityJoinLevelEvent event) {
        if (event.getLevel().isClientSide()) return;

        Entity entity = event.getEntity();
        ResourceLocation entityId = BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType());

        // Only handle our mod's entities
        if (!entityId.getNamespace().equals("eternal_end_for_java")) return;

        // Handle special spawn conditions
        switch (entityId.getPath()) {
            // Companion entities - frozen state check
            case "frostling", "glowling", "mistling", "nybling", "voidling" -> {
                handleCompanionSpawn(event);
            }
            // Ender Slime - size randomization
            case "ender_slime" -> {
                handleEnderSlimeSpawn(event);
            }
            // Spore Lizard - scale randomization
            case "spore_lizard", "verdant_lizard" -> {
                handleLizardSpawn(event);
            }
        }
    }

    /**
     * Handles companion entity spawning with special conditions.
     *
     * From Bedrock: frostling.json, glowling.json
     * - 90% adult, 10% baby
     * - Frozen in ice blocks
     * - Spawn capacity checking
     */
    private static void handleCompanionSpawn(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();
        ServerLevel level = (ServerLevel) event.getLevel();

        // Check if spawning in ice (frozen state)
        BlockPos pos = entity.blockPosition();
        if (level.getBlockState(pos).is(net.minecraft.world.level.block.Blocks.ICE)) {
            // Set frozen property/handle frozen state
            // This will be handled by the entity class itself
        }

        // Track spawn capacity (if natural spawn)
        // Check nearby companions for this player area
        // Similar to Bedrock's panascais_common:ignore_spawn_capacity
    }

    /**
     * Handles Ender Slime spawning with size randomization.
     *
     * From Bedrock: ender_slime.json
     * - Equal chance for small, medium, large
     * - Large splits into 2 medium on death
     * - Medium splits into 4 small on death
     */
    private static void handleEnderSlimeSpawn(EntityJoinLevelEvent event) {
        // Size is handled by the entity class constructor
        // But we can enforce randomization here if needed
    }

    /**
     * Handles Lizard spawning with scale randomization.
     *
     * From Bedrock: spore_lizard.json
     * - 33% chance for each scale variant (0.6, 0.75, 1.0)
     * - 90% adult, 10% baby
     */
    private static void handleLizardSpawn(EntityJoinLevelEvent event) {
        // Scale is handled by the entity class
    }

    /**
     * Spawner Block Handler
     * Handles spawning from spawner blocks (frostling_spawner, etc.)
     *
     * From Bedrock: Custom component "panascais_end:spawner"
     */
    public static void handleSpawnerTick(ServerLevel level, BlockPos pos, EntityType<?> entityType) {
        // Check for players nearby (activation range)
        Player nearestPlayer = level.getNearestPlayer(pos.getX(), pos.getY(), pos.getZ(), 16, false);
        if (nearestPlayer == null) return;

        // Spawn conditions based on entity type
        if (!canSpawnFromSpawner(level, pos, entityType)) {
            return;
        }

        // Spawn the entity
        Entity entity = entityType.spawn(level, pos, MobSpawnType.SPAWNER);
        if (entity != null) {
            // Apply any spawner-specific properties
        }
    }

    /**
     * Checks if an entity can spawn from a spawner at the given location.
     */
    private static boolean canSpawnFromSpawner(ServerLevel level, BlockPos pos, EntityType<?> entityType) {
        // Check spawn conditions (light level, blocks, etc.)
        // Most End entities don't care about light, but need solid ground

        // Check if the space above is clear
        BlockPos abovePos = pos.above();
        if (!level.getBlockState(abovePos).isAir() &&
            !level.getBlockState(abovePos).is(net.minecraft.world.level.block.Blocks.WATER)) {
            return false;
        }

        // Check space above that
        BlockPos abovePos2 = pos.above(2);
        if (!level.getBlockState(abovePos2).isAir() &&
            !level.getBlockState(abovePos2).is(net.minecraft.world.level.block.Blocks.WATER)) {
            return false;
        }

        return true;
    }
}
