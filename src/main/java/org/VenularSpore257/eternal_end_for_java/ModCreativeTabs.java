package org.VenularSpore257.eternal_end_for_java;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static org.VenularSpore257.eternal_end_for_java.EternalEndBlocks.*;
import static org.VenularSpore257.eternal_end_for_java.EternalEndItems.*;
import static org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java.MODID;

/**
 * Creative mode tabs for Eternal End mod.
 * Organized by category for better user experience.
 */
public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Single tab for all items - simplified approach
    @SuppressWarnings("unused") // Will be used once populated
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ETERNAL_END = TABS.register("eternal_end",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + MODID + ".eternal_end"))
            .withTabsBefore(CreativeModeTabs.BUILDING_BLOCKS)
            .icon(() -> new ItemStack(CHORUS_PLANKS.get(), 1))
            .displayItems((parameters, output) -> {
                // ===== BUILDING BLOCKS =====
                // Wood
                output.accept(CHORUS_PLANKS.get().asItem());
                output.accept(CHORUS_LOG.get().asItem());
                output.accept(CRYOLITE_PLANKS.get().asItem());
                output.accept(CRYOLITE_LOG.get().asItem());
                output.accept(FUNGAL_PLANKS.get().asItem());
                output.accept(FUNGAL_LOG.get().asItem());
                output.accept(WHISPERING_PLANKS.get().asItem());
                output.accept(WHISPERING_LOG.get().asItem());
                output.accept(HONEY_PLANKS.get().asItem());
                output.accept(HONEY_LOG.get().asItem());
                output.accept(SCORCHED_PLANKS.get().asItem());
                output.accept(SCORCHED_LOG.get().asItem());
                output.accept(SPORED_PLANKS.get().asItem());
                output.accept(SPORED_LOG.get().asItem());

                // Ores
                output.accept(AMETRINE_ORE.get().asItem());
                output.accept(AMETRINE_ORE_DEEPSLATE.get().asItem());
                output.accept(PURPURITE_ORE.get().asItem());
                output.accept(DARK_PURPURITE_ORE.get().asItem());
                output.accept(VIRIDIAN_ORE.get().asItem());

                // Storage Blocks
                output.accept(AMETRINE_BLOCK.get().asItem());
                output.accept(RAW_PURPURITE_BLOCK.get().asItem());
                output.accept(RAW_DARK_PURPURITE_BLOCK.get().asItem());
                output.accept(DARK_PURPUR_BLOCK.get().asItem());

                // Stone Variants
                output.accept(NOCTRAL_STONE.get().asItem());
                output.accept(DARK_PURPUR_BLOCK.get().asItem());

                // ===== MATERIALS =====
                output.accept(AMETRINE_INGOT.get());
                output.accept(EternalEndItems.AMETRINE_CRYSTAL.get());
                output.accept(RAW_PURPURITE.get());
                output.accept(RAW_DARK_PURPURITE.get());
                output.accept(PURPUR_BRICK.get());
                output.accept(DARK_PURPUR_BRICK.get());
                output.accept(VIRIDIAN_CLUMP.get());
                output.accept(VIRIDIAN_BRICK.get());
                output.accept(ENDERITE_INGOT.get());
                output.accept(ENDERITE_SCRAP.get());
                output.accept(ENDERITE_UPGRADE.get());
                output.accept(WHITE_ESSENCE.get());
                output.accept(BLACK_ESSENCE.get());
                output.accept(VERDANT_ESSENCE.get());
                output.accept(ENDERMAN_HEART.get());
                output.accept(WINGED_ENDERMAN_HEART.get());
                output.accept(PALE_ENDERMAN_HEART.get());
                output.accept(MOSSY_ENDERMAN_HEART.get());
                output.accept(GILDED_ENDERMAN_HEART.get());
                output.accept(MYCOTIC_ENDERMAN_HEART.get());
                output.accept(GLOW_PEARL.get());
                output.accept(PALE_PEARL.get());
                output.accept(GOLEM_CORE.get());
                output.accept(ENDER_SLIME.get());

                // ===== FOOD =====
                output.accept(ETERNAL_HEART.get());
                output.accept(AWKWARD_MUSHROOM_STEW.get());
                output.accept(GILDED_VENISON.get());
                output.accept(COOKED_GILDED_VENISON.get());
                output.accept(MOON_BERRY.get());
                output.accept(FROSTBLOOM_JELLY.get());
                output.accept(WHITE_ESSENCE_DRINK.get());
                output.accept(BLACK_ESSENCE_DRINK.get());
                output.accept(VERDANT_ESSENCE_DRINK.get());

                // Flowers and Seeds
                output.accept(EternalEndItems.GILDED_WHEAT_SEEDS.get());
                output.accept(EternalEndItems.FROSTBLOOM_SEEDS.get());
                output.accept(EternalEndItems.MISTVEIL_BLOOM_SEEDS.get());
                output.accept(EternalEndItems.GLEAMFLOAT_SEEDS.get());
                output.accept(EternalEndItems.FLARE_FERN_LEAF.get());
                output.accept(EternalEndItems.ICELUMIA.get());
                output.accept(EternalEndItems.LAYERLOOM.get());
                output.accept(EternalEndItems.LOTUS_BLOOM.get());
                output.accept(EternalEndItems.MOONFLOWER.get());
                output.accept(EternalEndItems.SPRESPROUT.get());
                output.accept(EternalEndItems.TANGLECAPS.get());

                // ===== TOOLS =====
                // Ametrine Tier
                output.accept(AMETRINE_SWORD.get());
                output.accept(AMETRINE_PICKAXE.get());
                output.accept(AMETRINE_AXE.get());
                output.accept(AMETRINE_SHOVEL.get());
                output.accept(AMETRINE_HOE.get());

                // Enderite Tier
                output.accept(ENDERITE_SWORD.get());
                output.accept(ENDERITE_PICKAXE.get());
                output.accept(ENDERITE_AXE.get());
                output.accept(ENDERITE_SHOVEL.get());
                output.accept(ENDERITE_HOE.get());

                // ===== ARMOR =====
                // Ametrine
                output.accept(AMETRINE_HELMET.get());
                output.accept(AMETRINE_CHESTPLATE.get());
                output.accept(AMETRINE_LEGGINGS.get());
                output.accept(AMETRINE_BOOTS.get());

                // Enderite
                output.accept(ENDERITE_HELMET.get());
                output.accept(ENDERITE_CHESTPLATE.get());
                output.accept(ENDERITE_LEGGINGS.get());
                output.accept(ENDERITE_BOOTS.get());

                // Shulker
                output.accept(SHULKER_HELMET.get());
                output.accept(SHULKER_CHESTPLATE.get());
                output.accept(SHULKER_LEGGINGS.get());
                output.accept(SHULKER_BOOTS.get());

                // Cloud Boots
                output.accept(CLOUD_BOOTS.get());

                // ===== SPECIAL ITEMS =====
                output.accept(VOID_TOTEM.get());
                output.accept(EternalEndItems.VOID_DRAGON_EGG.get());
                output.accept(EternalEndItems.VOID_DRAGON_HEAD.get());
                output.accept(BOTTLED_NORMAL_LOST_SOUL.get());
                output.accept(BOTTLED_GILDED_LOST_SOUL.get());
                output.accept(BOTTLED_PRISM_LOST_SOUL.get());
                output.accept(BOTTLED_SHADOW_LOST_SOUL.get());
                output.accept(BOTTLED_SPORELIGHT_LOST_SOUL.get());
                output.accept(BOTTLED_VERDANT_LOST_SOUL.get());
                output.accept(BOOK.get());
                output.accept(BOOK_PAGE_0.get());
                output.accept(BOOK_PAGE_1.get());
                output.accept(BOOK_PAGE_2.get());
                output.accept(BOOK_PAGE_3.get());
                output.accept(BOOK_PAGE_4.get());
                output.accept(BOOK_PAGE_5.get());
                output.accept(BOOK_PAGE_6.get());
                output.accept(BOOK_PAGE_7.get());
                output.accept(BOOK_PAGE_8.get());
                output.accept(BOOK_PAGE_9.get());
                output.accept(SETTINGS.get());

                // ===== SPAWN EGGS =====
                // Hostile Mobs
                output.accept(FROSTLING_SPAWN_EGG.get());
                output.accept(DOOMED_WOLF_SPAWN_EGG.get());
                output.accept(WINGED_ENDERMAN_SPAWN_EGG.get());
                output.accept(MISTLING_SPAWN_EGG.get());
                output.accept(VOIDLING_SPAWN_EGG.get());
                output.accept(ENDER_SLIME_SPAWN_EGG.get());

                // Enderman Variants
                output.accept(PALE_ENDERMAN_SPAWN_EGG.get());
                output.accept(MOSSY_ENDERMAN_SPAWN_EGG.get());
                output.accept(GILDED_ENDERMAN_SPAWN_EGG.get());
                output.accept(MYCOTIC_ENDERMAN_SPAWN_EGG.get());

                // Passive/Neutral Mobs
                output.accept(ENDRAY_SPAWN_EGG.get());
                output.accept(GLOWLING_SPAWN_EGG.get());
                output.accept(NYBLING_SPAWN_EGG.get());
                output.accept(GILDED_DEER_SPAWN_EGG.get());
                output.accept(SHADOW_DEER_SPAWN_EGG.get());
                output.accept(FROZEN_JELLYFISH_SPAWN_EGG.get());
                output.accept(GILDED_TURTLE_SPAWN_EGG.get());
                output.accept(SPORE_LIZARD_SPAWN_EGG.get());
                output.accept(VERDANT_LIZARD_SPAWN_EGG.get());

                // Villagers
                output.accept(ETERNAL_TRADER_SPAWN_EGG.get());
                output.accept(NORMAL_VILLAGER_SPAWN_EGG.get());
                output.accept(PRISM_VILLAGER_SPAWN_EGG.get());
                output.accept(SPORE_VILLAGER_SPAWN_EGG.get());
                output.accept(GILDED_VILLAGER_SPAWN_EGG.get());
                output.accept(SHADOW_VILLAGER_SPAWN_EGG.get());

                // Golems and Special
                output.accept(GILDED_GOLEM_SPAWN_EGG.get());
                output.accept(LOST_SOUL_SPAWN_EGG.get());
                output.accept(SVEPPUM_SPAWN_EGG.get());
                output.accept(SPRENGING_SPAWN_EGG.get());
                output.accept(VOID_EYE_SPAWN_EGG.get());
            })
            .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
