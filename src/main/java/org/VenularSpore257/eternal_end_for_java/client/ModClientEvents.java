package org.VenularSpore257.eternal_end_for_java.client;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import org.VenularSpore257.eternal_end_for_java.EternalEndBlocks;

/**
 * Client-side event handlers for Eternal End.
 * Handles block and item color handlers.
 */
@EventBusSubscriber(value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void registerColorHandlers(RegisterColorHandlersEvent.Block event) {
        // Simple foliage color - uses biome foliage color
        BlockColor foliageColor = (state, level, pos, tintIndex) -> {
            if (level == null || pos == null) {
                return FoliageColor.getDefaultColor();
            }
            return BiomeColors.getAverageFoliageColor(level, pos);
        };

        // Simple grass color - uses biome grass color
        BlockColor grassColor = (state, level, pos, tintIndex) -> {
            if (level == null || pos == null) {
                return 0x91CD59;
            }
            return BiomeColors.getAverageGrassColor(level, pos);
        };

        // Register leaf colors (foliage-colored)
        registerSafe(event, foliageColor, EternalEndBlocks.CHORUS_LEAVES);
        registerSafe(event, foliageColor, EternalEndBlocks.FUNGAL_LEAVES);
        registerSafe(event, foliageColor, EternalEndBlocks.WHISPERING_LEAVES);
        registerSafe(event, foliageColor, EternalEndBlocks.HONEY_LEAVES);
        registerSafe(event, foliageColor, EternalEndBlocks.SCORCHED_LEAVES);
        registerSafe(event, foliageColor, EternalEndBlocks.SPORED_LEAVES);

        // Cryolite leaves are light blue
        BlockColor cryoliteColor = (state, level, pos, tintIndex) -> 0xB0D8F0;
        registerSafe(event, cryoliteColor, EternalEndBlocks.CRYOLITE_LEAVES);
        registerSafe(event, cryoliteColor, EternalEndBlocks.HANGING_CRYOLITE_LEAVES);
        registerSafe(event, cryoliteColor, EternalEndBlocks.HANGING_WHISPERING_LEAVES);

        // Register grass colors (biome grass-colored)
        registerSafe(event, grassColor, EternalEndBlocks.FLARE_GRASS);
        registerSafe(event, grassColor, EternalEndBlocks.GILDED_GRASS);
        registerSafe(event, grassColor, EternalEndBlocks.SCORCHED_GRASS);
        registerSafe(event, grassColor, EternalEndBlocks.GLOWTIDE_GRASS);
        registerSafe(event, grassColor, EternalEndBlocks.FROSTSPIKE_GRASS);
    }

    private static void registerSafe(RegisterColorHandlersEvent.Block event, BlockColor color, DeferredBlock<Block> block) {
        try {
            event.register(color, block.get());
        } catch (Exception ignored) {}
    }
}
