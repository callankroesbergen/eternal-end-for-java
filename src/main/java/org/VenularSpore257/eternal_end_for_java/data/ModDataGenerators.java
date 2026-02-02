package org.VenularSpore257.eternal_end_for_java.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

/**
 * Central registration for all data generators.
 */
@EventBusSubscriber
public class ModDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        PackOutput output = event.getGenerator().getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // ========== WORLDGEN DATA GENERATORS ==========
        // TODO: Worldgen (biomes, features, placements) will be added via JSON
        // or custom providers once the NeoForge 1.21.1 API is finalized

        // ========== TAG DATA GENERATORS ==========

        // Register block tag provider
        ModBlockTagProvider blockTagProvider = new ModBlockTagProvider(output, lookupProvider, existingFileHelper);
        event.getGenerator().addProvider(event.includeServer(), blockTagProvider);

        // Register item tag provider (depends on block tags)
        event.getGenerator().addProvider(event.includeServer(),
                new ModItemTagProvider(output, lookupProvider, blockTagProvider.contentsGetter(), existingFileHelper));

        // Register recipe provider
        event.getGenerator().addProvider(event.includeServer(), new ModRecipeProvider(output, lookupProvider));

        // Register loot table provider
        event.getGenerator().addProvider(event.includeServer(), new ModLootTableProvider(output, lookupProvider));

        System.out.println("Eternal End data generators registered successfully");
    }
}
