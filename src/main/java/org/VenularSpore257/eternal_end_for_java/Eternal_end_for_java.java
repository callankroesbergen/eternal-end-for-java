package org.VenularSpore257.eternal_end_for_java;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;
import org.VenularSpore257.eternal_end_for_java.client.ModClient;
// import org.VenularSpore257.eternal_end_for_java.world.ModBiomes; // TODO: Fix compilation errors
import org.VenularSpore257.eternal_end_for_java.world.ModFeatures;
// import org.VenularSpore257.eternal_end_for_java.world.ModStructures; // TODO: Fix compilation errors

/**
 * Eternal End for Java - A NeoForge 1.21 mod
 * Converting the Eternal End Add-On by Panascais from Bedrock to Java Edition
 *
 * Features:
 * - 261 blocks
 * - 185 items
 * - 46 entities
 * - 28 structures
 * - New biomes and features
 */
@Mod(Eternal_end_for_java.MODID)
public class Eternal_end_for_java {
    public static final String MODID = "eternal_end_for_java";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Eternal_end_for_java(IEventBus modEventBus, ModContainer modContainer) {
        // Register all mod components
        EternalEndBlocks.register(modEventBus);
        EternalEndItems.register(modEventBus);
        EternalEndEntities.register(modEventBus);
        ModCreativeTabs.register(modEventBus);

        // Register world generation - TODO: Re-enable when datapack system is properly implemented
        // ModBiomes.BIOME_MODIFIERS.register(modEventBus);
        // ModFeatures.FEATURES.register(modEventBus);
        // CONFIGURED_FEATURES is a datapack registry, not registered via DeferredRegister
        // ModFeatures.CONFIGURED_FEATURES.register(modEventBus);
        // ModFeatures.BIOME_MODIFIERS.register(modEventBus);

        // Register event handlers
        // ModEvents.register(modEventBus); // TODO: Re-enable when ModEvents is fixed

        // Register client-side components
        ModClient.init(modEventBus);

        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        // Register config
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        LOGGER.info("Eternal End for Java loaded successfully!");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Eternal End common setup complete");

        if (Config.logDirtBlock) {
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);
        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    @net.neoforged.bus.api.SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Eternal End server starting");
    }
}
