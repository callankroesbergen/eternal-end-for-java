package org.VenularSpore257.eternal_end_for_java.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import org.VenularSpore257.eternal_end_for_java.EternalEndBlocks;
import org.VenularSpore257.eternal_end_for_java.EternalEndEntities;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles special block behaviors and level ticks.
 *
 * Converted from Bedrock block custom components and JavaScript logic.
 *
 * Key responsibilities:
 * - Spawner block ticks (frostling_spawner, mobspawner_spawner, etc.)
 * - Void Gateway activation and teleportation
 * - Endral biome spread
 * - Special block placement/breaking behaviors
 *
 * Bedrock source reference:
 * - blocks/frostling_spawner.json (custom_components: ["panascais_end:spawner"])
 * - blocks/void_gateway.json (custom_components: ["panascais_end:void_gateway"])
 * - scripts/main.js (block tick logic)
 */
@EventBusSubscriber(modid = "eternal_end_for_java")
public class BlockBehaviorHandler {

    /**
     * Tracks spawner cooldowns.
     * Key: block position as string, Value: ticks until next spawn
     */
    private static final Map<String, Integer> SPAWNER_COOLDOWNS = new HashMap<>();

    /**
     * Handles level tick events.
     *
     * Use for:
     * - Spawner block logic
     * - Void gateway activation
     * - Endral spread
     */
    @SubscribeEvent
    public static void onLevelTick(LevelTickEvent.Post event) {
        if (event.getLevel().isClientSide()) return;

        ServerLevel level = (ServerLevel) event.getLevel();

        // Process spawners
        tickSpawners(level);

        // Process void gateways
        tickVoidGateways(level);
    }

    /**
     * Handles block placement.
     */
    @SubscribeEvent
    public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        if (event.getLevel().isClientSide()) return;

        BlockState blockState = event.getPlacedBlock();
        ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(blockState.getBlock());

        // Handle special placement logic
        String path = blockId.getPath();

        // Spawners - initialize cooldown
        if (path.endsWith("_spawner")) {
            String posKey = getPosKey(event.getPos());
            SPAWNER_COOLDOWNS.put(posKey, 20); // 1 second delay before first spawn
        }
    }

    /**
     * Handles block breaking.
     */
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (event.getLevel().isClientSide()) return;

        BlockState blockState = event.getState();
        ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(blockState.getBlock());

        String path = blockId.getPath();

        // Remove spawner from cooldown tracking
        if (path.endsWith("_spawner")) {
            String posKey = getPosKey(event.getPos());
            SPAWNER_COOLDOWNS.remove(posKey);
        }
    }

    /**
     * Ticks all spawner blocks in the level.
     *
     * From Bedrock: blocks/*_spawner.json
     * Custom component: panascais_end:spawner
     * Tick interval: 0-1 (every tick)
     *
     * Spawner types:
     * - frostling_spawner
     * - mobspawner_spawner
     * - villager_spawner
     * - shulker_spawner
     * - dungeon_chest_spawner
     * - village_chest_spawner
     * - bookshelf_spawner
     * - brewingstand_spawner
     * - pot_spawner
     * - endboss_arena_spawner
     */
    private static void tickSpawners(ServerLevel level) {
        // Iterate through all tracked spawners
        SPAWNER_COOLDOWNS.entrySet().removeIf(entry -> {
            String posKey = entry.getKey();
            int cooldown = entry.getValue();

            if (cooldown > 0) {
                entry.setValue(cooldown - 1);
                return false; // Keep in map
            }

            // Time to spawn
            BlockPos pos = parsePosKey(posKey);
            if (pos == null) {
                return true; // Remove invalid entry
            }

            BlockState blockState = level.getBlockState(pos);
            ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(blockState.getBlock());

            // Check if still a spawner
            if (!blockId.getPath().endsWith("_spawner")) {
                return true; // Remove if block changed
            }

            // Get entity type from spawner type
            EntityType<?> entityType = getEntityTypeFromSpawner(blockId.getPath());

            if (entityType != null) {
                // Check for nearby players (activation range)
                var nearestPlayer = level.getNearestPlayer(
                    pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 16, false);

                if (nearestPlayer != null) {
                    // Spawn the entity
                    Entity spawnedEntity = entityType.spawn(level, pos, MobSpawnType.SPAWNER);
                    if (spawnedEntity != null) {
                        // Reset cooldown based on spawner type
                        entry.setValue(getSpawnerCooldown(blockId.getPath()));
                        return false; // Keep in map
                    }
                }
            }

            // Failed to spawn, try again soon
            entry.setValue(20); // 1 second retry
            return false; // Keep in map
        });
    }

    /**
     * Ticks void gateway blocks.
     *
     * From Bedrock: blocks/void_gateway.json
     * Custom component: panascais_end:void_gateway
     * Tick interval: 39-40 (every 2 seconds)
     *
     * Activates when player is nearby and creates particle effects
     */
    private static void tickVoidGateways(ServerLevel level) {
        // In a production mod, we would track loaded void gateways
        // For now, this is a placeholder for the logic

        // The void gateway:
        // - Emits light (level 9)
        // - Has a tick interval of 39-40 ticks
        // - Creates particles when active
        // - Can teleport entities when properly activated
    }

    /**
     * Gets the entity type that a spawner spawns.
     */
    private static EntityType<?> getEntityTypeFromSpawner(String spawnerName) {
        return switch (spawnerName) {
            case "frostling_spawner" -> EternalEndEntities.FROSTLING.get();
            case "mobspawner_spawner" -> EntityType.ENDERMITE; // Placeholder
            case "villager_spawner" -> EntityType.VILLAGER;
            case "shulker_spawner" -> EntityType.SHULKER;
            case "dungeon_chest_spawner", "village_chest_spawner" -> null; // These spawn loot, not entities
            case "bookshelf_spawner" -> null; // Special case
            case "brewingstand_spawner" -> null; // Special case
            case "pot_spawner" -> null; // Special case
            case "endboss_arena_spawner" -> EternalEndEntities.VOID_DRAGON.get();
            default -> null;
        };
    }

    /**
     * Gets the spawn cooldown for a spawner type (in ticks).
     */
    private static int getSpawnerCooldown(String spawnerName) {
        return switch (spawnerName) {
            case "frostling_spawner" -> 600; // 30 seconds
            case "villager_spawner" -> 1200; // 60 seconds
            case "shulker_spawner" -> 800; // 40 seconds
            case "endboss_arena_spawner" -> Integer.MAX_VALUE; // One-time spawn
            default -> 400; // 20 seconds default
        };
    }

    /**
     * Converts a block position to a string key for the map.
     */
    private static String getPosKey(BlockPos pos) {
        return pos.getX() + "," + pos.getY() + "," + pos.getZ();
    }

    /**
     * Parses a position key back to a BlockPos.
     */
    private static BlockPos parsePosKey(String key) {
        try {
            String[] parts = key.split(",");
            return new BlockPos(
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2])
            );
        } catch (Exception e) {
            return null;
        }
    }
}
