package org.VenularSpore257.eternal_end_for_java.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import org.VenularSpore257.eternal_end_for_java.EternalEndBlocks;
import org.VenularSpore257.eternal_end_for_java.EternalEndEntities;
import org.VenularSpore257.eternal_end_for_java.EternalEndItems;

import java.util.Set;

/**
 * Handles player interactions with entities and blocks.
 *
 * Converted from Bedrock entity interaction components and JavaScript logic.
 *
 * Key responsibilities:
 * - Lost Soul bottling (glass bottle -> bottled_lost_soul)
 * - Companion feeding and taming
 * - Special item interactions
 * - Void Gateway activation
 *
 * Bedrock source reference:
 * - entities/lost_soul.json (minecraft:interact with glass_bottle)
 * - entities/frostling.json, glowling.json (feeding interactions)
 * - blocks/void_gateway.json (custom component)
 */
@EventBusSubscriber(modid = "eternal_end_for_java")
public class PlayerInteractionHandler {

    // Items that can be used to tame/feed companion entities
    private static final Set<ResourceLocation> COMPANION_FOODS = Set.of(
        // Vanilla items
        BuiltInRegistries.ITEM.getKey(Items.CHORUS_FRUIT),
        BuiltInRegistries.ITEM.getKey(Items.GLOW_BERRIES),
        BuiltInRegistries.ITEM.getKey(Items.SWEET_BERRIES),
        BuiltInRegistries.ITEM.getKey(Items.DANDELION),
        BuiltInRegistries.ITEM.getKey(Items.POPPY),
        BuiltInRegistries.ITEM.getKey(Items.BLUE_ORCHID),
        BuiltInRegistries.ITEM.getKey(Items.ALLIUM),
        BuiltInRegistries.ITEM.getKey(Items.AZURE_BLUET),
        BuiltInRegistries.ITEM.getKey(Items.ORANGE_TULIP),
        BuiltInRegistries.ITEM.getKey(Items.PINK_TULIP),
        BuiltInRegistries.ITEM.getKey(Items.RED_TULIP),
        BuiltInRegistries.ITEM.getKey(Items.WHITE_TULIP),
        BuiltInRegistries.ITEM.getKey(Items.OXEYE_DAISY),
        BuiltInRegistries.ITEM.getKey(Items.CORNFLOWER),
        BuiltInRegistries.ITEM.getKey(Items.LILY_OF_THE_VALLEY),
        // Mod items (to be added when items are registered)
        ResourceLocation.fromNamespaceAndPath("eternal_end_for_java", "layerloom"),
        ResourceLocation.fromNamespaceAndPath("eternal_end_for_java", "moon_berry"),
        ResourceLocation.fromNamespaceAndPath("eternal_end_for_java", "frostbloom_jelly"),
        ResourceLocation.fromNamespaceAndPath("eternal_end_for_java", "cooked_gilded_venison"),
        ResourceLocation.fromNamespaceAndPath("eternal_end_for_java", "awkward_mushroom_stew"),
        ResourceLocation.fromNamespaceAndPath("eternal_end_for_java", "glow_pearl"),
        ResourceLocation.fromNamespaceAndPath("eternal_end_for_java", "white_essence_drink"),
        ResourceLocation.fromNamespaceAndPath("eternal_end_for_java", "black_essence_drink"),
        ResourceLocation.fromNamespaceAndPath("eternal_end_for_java", "verdant_essence_drink")
    );

    /**
     * Handles player right-clicking on entities.
     *
     * From Bedrock: minecraft:interact component groups
     */
    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        if (event.getLevel().isClientSide()) return;

        Player player = event.getEntity();
        Entity target = event.getTarget();
        InteractionHand hand = event.getHand();
        ItemStack heldItem = player.getItemInHand(hand);

        ResourceLocation entityId = BuiltInRegistries.ENTITY_TYPE.getKey(target.getType());

        // Lost Soul bottling
        if (entityId.getPath().equals("lost_soul")) {
            if (handleLostSoulBottling(event, player, target, heldItem)) {
                event.setCanceled(true);
                return;
            }
        }

        // Companion feeding/taming
        if (isCompanionEntity(entityId)) {
            if (handleCompanionInteraction(event, player, target, heldItem)) {
                // Interaction handled, possibly cancel vanilla behavior
                return;
            }
        }

        // Name tag interaction for Lost Soul persistence
        if (entityId.getPath().equals("lost_soul")) {
            if (heldItem.is(Items.NAME_TAG)) {
                // Name tag makes the Lost Soul persistent (no despawn)
                // This is handled by the entity class
            }
        }
    }

    /**
     * Handles player right-clicking on blocks.
     *
     * From Bedrock: blocks/void_gateway.json custom component
     */
    @SubscribeEvent
    public static void onBlockInteract(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return;

        Player player = event.getEntity();
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        ItemStack heldItem = player.getItemInHand(event.getHand());

        BlockState blockState = level.getBlockState(pos);
        ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(blockState.getBlock());

        // Void Gateway activation
        if (blockId.getPath().equals("void_gateway")) {
            handleVoidGatewayInteraction(event, player, level, pos, heldItem);
        }
    }

    /**
     * Handles Lost Soul bottling.
     *
     * From Bedrock: entities/lost_soul.json
     * Interaction: glass_bottle -> bottled_[biome]_lost_soul
     * Biomes: normal, gilded, prism, sporelight, shadow, verdant
     *
     * The Lost Soul has an enum property "panascais_end:biome" that determines
     * which bottled item is produced.
     */
    private static boolean handleLostSoulBottling(PlayerInteractEvent.EntityInteract event,
                                                   Player player, Entity target, ItemStack heldItem) {
        if (!heldItem.is(Items.GLASS_BOTTLE)) {
            return false;
        }

        // Check if the Lost Soul is in range (should be, from event)
        // Consume the glass bottle
        heldItem.shrink(1);

        // Get the Lost Soul's biome variant
        // This would be stored as entity data/persistent data
        String biomeVariant = getLostSoulBiomeVariant(target);

        // Give the appropriate bottled item
        ResourceLocation bottledItemId = ResourceLocation.fromNamespaceAndPath(
            "eternal_end_for_java",
            "bottled_" + biomeVariant + "_lost_soul"
        );

        // Add the bottled item to player's inventory
        // This requires the items to be registered
        if (player instanceof ServerPlayer serverPlayer) {
            // TODO: Give bottled_lost_soul item
            // player.addItem(new ItemStack(EternalEndItems.BOTTLED_[BIOME]_LOST_SOUL.get()));
        }

        // Play sound and particle
        player.level().playSound(null, target.blockPosition(),
            SoundEvents.BOTTLE_FILL,
            SoundSource.NEUTRAL, 1.0F, 1.0F);

        // Despawn the Lost Soul
        target.discard();

        // Return empty bottle (handled by consume, but bedrock gives it back)
        player.addItem(new ItemStack(Items.GLASS_BOTTLE));

        event.setCanceled(true);
        return true;
    }

    /**
     * Handles companion feeding and taming interactions.
     *
     * From Bedrock: entities/frostling.json, glowling.json
     * - Flowers and special foods can be given to companions
     * - Held item shows in companion's "hand"
     * - Makes companion "happy" (slowness effect)
     */
    private static boolean handleCompanionInteraction(PlayerInteractEvent.EntityInteract event,
                                                      Player player, Entity target, ItemStack heldItem) {
        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(heldItem.getItem());

        // Check if the held item is a valid companion food
        if (!COMPANION_FOODS.contains(itemId)) {
            return false;
        }

        // Take the item from player
        ItemStack itemToGive = heldItem.copy();
        itemToGive.setCount(1);
        heldItem.shrink(1);

        // Give item to companion (stored in entity data)
        // This makes the companion "happy"
        setCompanionHeldItem(target, itemToGive);
        setCompanionHappy(target, true);

        // Apply slowness effect (happy animation state)
        target.getPersistentData().putBoolean("eternal_end:happy", true);

        // Play happy sound
        player.level().playSound(null, target.blockPosition(),
            SoundEvents.VILLAGER_YES,
            SoundSource.NEUTRAL, 1.0F, 1.0F);

        return true;
    }

    /**
     * Handles Void Gateway interaction.
     *
     * From Bedrock: blocks/void_gateway.json
     * Custom component: panascais_end:void_gateway
     * Ticks every 40 ticks and activates when player is near
     */
    private static void handleVoidGatewayInteraction(PlayerInteractEvent.RightClickBlock event,
                                                     Player player, Level level, BlockPos pos, ItemStack heldItem) {
        // The void gateway ticks periodically and activates
        // This is handled in BlockBehaviorHandler

        // Right-clicking might do something special
        // For now, just play a sound
        level.playSound(player, pos, SoundEvents.END_PORTAL_FRAME_FILL,
            SoundSource.BLOCKS, 1.0F, 1.0F);
    }

    /**
     * Handles entity use item event (for feeding).
     */
    public static void onEntityUseItem(LivingEntityUseItemEvent event) {
        // Additional handling for item use on entities
    }

    /**
     * Handles player-specific tick events.
     */
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        // Check for End-specific effects
        if (player.level().dimension() == net.minecraft.world.level.Level.END) {
            // Apply any End-specific effects here
        }
    }

    // Helper methods

    private static boolean isCompanionEntity(ResourceLocation entityId) {
        String path = entityId.getPath();
        return path.equals("frostling") ||
               path.equals("glowling") ||
               path.equals("mistling") ||
               path.equals("nybling") ||
               path.equals("voidling");
    }

    private static String getLostSoulBiomeVariant(Entity entity) {
        // Get from entity persistent data
        return entity.getPersistentData().getString("eternal_end:biome_variant");
    }

    private static void setCompanionHeldItem(Entity entity, ItemStack item) {
        // Store in entity data
        // The entity renderer will read this and show the item
        entity.getPersistentData().putString("eternal_end:held_item",
            BuiltInRegistries.ITEM.getKey(item.getItem()).toString());
    }

    private static void setCompanionHappy(Entity entity, boolean happy) {
        entity.getPersistentData().putBoolean("eternal_end:happy", happy);
    }
}
