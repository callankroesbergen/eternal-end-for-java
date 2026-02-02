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
                // Add items one by one to avoid stack count issues
                // Use asItem() to convert blocks to their item form
                output.accept(CHORUS_PLANKS.get().asItem());
                output.accept(CHORUS_LOG.get().asItem());
                output.accept(AMETRINE_INGOT.get());
                output.accept(AMETRINE_SWORD.get());
                output.accept(AMETRINE_CHESTPLATE.get());
                output.accept(ETERNAL_HEART.get());
                output.accept(VOID_TOTEM.get());
                output.accept(FROSTLING_SPAWN_EGG.get());
                // Add more items here for testing
            })
            .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
