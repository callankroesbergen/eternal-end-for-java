package org.VenularSpore257.eternal_end_for_java.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

/**
 * Custom BlockItem that uses the correct translation key format.
 * Ensures items use {@code item.modid.block_name} instead of {@code block.modid.block_name}.
 */
public class ModBlockItem extends BlockItem {
    private final DeferredHolder<Block, Block> blockHolder;

    public ModBlockItem(DeferredHolder<Block, Block> blockHolder, Item.Properties properties) {
        super(blockHolder.get(), properties);
        this.blockHolder = blockHolder;
    }

    @Override
    public String getDescriptionId() {
        // Use item. prefix instead of block. prefix for translation
        return blockHolder.unwrapKey().map(key -> {
            String registryPath = key.location().getPath();
            return "item." + key.location().getNamespace() + "." + registryPath;
        }).orElseGet(() -> super.getDescriptionId());
    }
}
