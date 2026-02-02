package org.VenularSpore257.eternal_end_for_java.block;

import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Snow layer block that doesn't melt.
 * Used for the Eternal End mod's biome layer blocks.
 */
public class EndLayerBlock extends SnowLayerBlock {

    public EndLayerBlock(Properties properties) {
        super(properties);
    }

    /**
     * Override to prevent melting from light exposure.
     * By returning false, the block won't receive random ticks, which means no melting.
     */
    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return false;
    }
}
