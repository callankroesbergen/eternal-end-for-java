package org.VenularSpore257.eternal_end_for_java.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.*;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * Main event registration class for Eternal End mod.
 *
 * This class registers all server-side event handlers for the mod.
 * Events are organized by category:
 * - Entity spawning and lifecycle
 * - Entity interactions (player right-click, etc.)
 * - Damage modifications
 * - Special block behaviors
 * - World generation hooks
 *
 * Based on Bedrock addon JavaScript logic from:
 * Eternal End Add-On by Panascais BP/scripts/main.js (~618KB)
 *
 * @author Panascais (Bedrock) -> Java conversion by VenularSpore257
 */
@EventBusSubscriber(modid = "eternal_end_for_java")
public class ModServerEvents {

    /**
     * Entity Join Level Event
     * Handles:
     * - Entity spawn conditions (biome-specific spawning)
     * - Spawn initialization for custom entities
     * - Spawn capacity checking
     */
    @SubscribeEvent
    public static void onEntityJoinLevel(EntityJoinLevelEvent event) {
        EntitySpawnHandler.onEntitySpawn(event);
    }

    /**
     * Entity Tick Event
     * Handles:
     * - Custom entity behaviors not covered by AI goals
     * - Companion behaviors (Frostling, Glowling, etc.)
     * - Void Dragon phase transitions
     * - Statue entity behaviors
     */
    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Post event) {
        EntityBehaviorHandler.onEntityTick(event);
    }

    /**
     * Level Tick Event
     * Handles:
     * - Spawner block ticks
     * - Void gateway activation
     * - Endral biome spread
     * - Random entity spawns (spawners)
     */
    @SubscribeEvent
    public static void onLevelTick(LevelTickEvent.Post event) {
        BlockBehaviorHandler.onLevelTick(event);
    }

    /**
     * Player Interact with Entity Event
     * Handles:
     * - Lost Soul bottling (glass bottle interaction)
     * - Companion feeding (flowers, special foods)
     * - Entity naming interactions
     * - Leash interactions
     */
    @SubscribeEvent
    public static void onPlayerInteractWithEntity(PlayerInteractEvent.EntityInteract event) {
        PlayerInteractionHandler.onEntityInteract(event);
    }

    /**
     * Player Interact with Block Event (Right-click)
     * Handles:
     * - Void gateway activation
     * - Special block interactions
     */
    @SubscribeEvent
    public static void onPlayerInteractWithBlock(PlayerInteractEvent.RightClickBlock event) {
        PlayerInteractionHandler.onBlockInteract(event);
    }

    /**
     * Living Entity Use Item Event (Entity feeding)
     * Handles:
     * - Feeding companions
     * - Special breeding items
     */
    @SubscribeEvent
    public static void onEntityUseItem(LivingEntityUseItemEvent event) {
        PlayerInteractionHandler.onEntityUseItem(event);
    }

    /**
     * Living Damage Event
     * Handles:
     * - Enderman teleport on projectile hit
     * - Void dragon damage immunity states
     * - Gilded Golem damage resistance
     * - Lost Soul damage immunity
     * - Spore Lizard death state handling
     */
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        DamageHandler.onLivingDamage(event);
    }

    /**
     * Living Death Event
     * Handles:
     * - Ender Slime splitting (large -> medium -> small)
     * - Void Dragon delayed death sequence
     * - Custom death drops not covered by loot tables
     */
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        EntityBehaviorHandler.onLivingDeath(event);
    }

    /**
     * Living Target Event
     * Handles:
     * - Enderman stare behavior
     * - Winged Enderman targeting
     * - Gilded Enderman targeting
     */
    @SubscribeEvent
    public static void onLivingTargetSet(LivingChangeTargetEvent event) {
        EntityBehaviorHandler.onTargetSet(event);
    }

    /**
     * Living Knockback Event
     * Handles:
     * - Void Dragon knockback immunity
     * - Statue entities knockback resistance
     */
    @SubscribeEvent
    public static void onLivingKnockback(LivingKnockBackEvent event) {
        DamageHandler.onLivingKnockback(event);
    }

    /**
     * Block Place Event
     * Handles:
     * - Special block placement behaviors
     */
    @SubscribeEvent
    public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        BlockBehaviorHandler.onBlockPlace(event);
    }

    /**
     * Block Break Event
     * Handles:
     * - Custom block break behaviors
     */
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        BlockBehaviorHandler.onBlockBreak(event);
    }

    /**
     * Player Tick Event
     * Handles:
     * - Player-specific end effects
     * - End biome effects
     */
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        PlayerInteractionHandler.onPlayerTick(event);
    }
}
