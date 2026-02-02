package org.VenularSpore257.eternal_end_for_java.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableProvider.SubProviderEntry;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.VenularSpore257.eternal_end_for_java.EternalEndBlocks;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * Loot table provider for Eternal End mod.
 * Generates loot tables for blocks.
 */
public class ModLootTableProvider extends LootTableProvider {

    public ModLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Set.of(), java.util.List.of(
                new SubProviderEntry(provider -> new BlockLoot(provider), LootContextParamSets.BLOCK)
        ), lookupProvider);
    }

    private static final class BlockLoot extends BlockLootSubProvider {
        private final HolderLookup.Provider lookupProvider;

        protected BlockLoot(HolderLookup.Provider lookupProvider) {
            super(Set.of(), FeatureFlagSet.of(), lookupProvider);
            this.lookupProvider = lookupProvider;
        }

        @Override
        protected void generate() {
            // ===== WOOD BLOCKS =====
            // Logs drop themselves
            dropSelf(EternalEndBlocks.CHORUS_LOG.get());
            dropSelf(EternalEndBlocks.CRYOLITE_LOG.get());
            dropSelf(EternalEndBlocks.FUNGAL_LOG.get());
            dropSelf(EternalEndBlocks.WHISPERING_LOG.get());
            dropSelf(EternalEndBlocks.HONEY_LOG.get());
            dropSelf(EternalEndBlocks.SCORCHED_LOG.get());
            dropSelf(EternalEndBlocks.SPORED_LOG.get());

            // Stripped logs
            dropSelf(EternalEndBlocks.CHORUS_STRIPPED_LOG.get());
            dropSelf(EternalEndBlocks.CRYOLITE_STRIPPED_LOG.get());
            dropSelf(EternalEndBlocks.FUNGAL_STRIPPED_LOG.get());
            dropSelf(EternalEndBlocks.WHISPERING_STRIPPED_LOG.get());
            dropSelf(EternalEndBlocks.HONEY_STRIPPED_LOG.get());
            dropSelf(EternalEndBlocks.SCORCHED_STRIPPED_LOG.get());
            dropSelf(EternalEndBlocks.SPORED_STRIPPED_LOG.get());

            // Wood
            dropSelf(EternalEndBlocks.CHORUS_WOOD.get());
            dropSelf(EternalEndBlocks.CRYOLITE_WOOD.get());
            dropSelf(EternalEndBlocks.FUNGAL_WOOD.get());
            dropSelf(EternalEndBlocks.WHISPERING_WOOD.get());
            dropSelf(EternalEndBlocks.HONEY_WOOD.get());
            dropSelf(EternalEndBlocks.SCORCHED_WOOD.get());
            dropSelf(EternalEndBlocks.SPORED_WOOD.get());

            // Planks
            dropSelf(EternalEndBlocks.CHORUS_PLANKS.get());
            dropSelf(EternalEndBlocks.CRYOLITE_PLANKS.get());
            dropSelf(EternalEndBlocks.FUNGAL_PLANKS.get());
            dropSelf(EternalEndBlocks.WHISPERING_PLANKS.get());
            dropSelf(EternalEndBlocks.HONEY_PLANKS.get());
            dropSelf(EternalEndBlocks.SCORCHED_PLANKS.get());
            dropSelf(EternalEndBlocks.SPORED_PLANKS.get());

            // Leaves drop themselves
            dropSelf(EternalEndBlocks.CHORUS_LEAVES.get());
            dropSelf(EternalEndBlocks.CRYOLITE_LEAVES.get());
            dropSelf(EternalEndBlocks.FUNGAL_LEAVES.get());
            dropSelf(EternalEndBlocks.WHISPERING_LEAVES.get());
            dropSelf(EternalEndBlocks.HONEY_LEAVES.get());
            dropSelf(EternalEndBlocks.SCORCHED_LEAVES.get());
            dropSelf(EternalEndBlocks.SPORED_LEAVES.get());

            // ===== ORES =====
            dropSelf(EternalEndBlocks.AMETRINE_ORE.get());
            dropSelf(EternalEndBlocks.AMETRINE_ORE_DEEPSLATE.get());
            dropSelf(EternalEndBlocks.PURPURITE_ORE.get());
            dropSelf(EternalEndBlocks.DARK_PURPURITE_ORE.get());
            dropSelf(EternalEndBlocks.VIRIDIAN_ORE.get());

            // Smelting/campfire fuel recipes drop self
            dropSelf(EternalEndBlocks.CHORUS_FENCE.get());
            dropSelf(EternalEndBlocks.CHORUS_FENCE_GATE.get());
            dropSelf(EternalEndBlocks.CHORUS_TRAPDOOR.get());
            dropSelf(EternalEndBlocks.CHORUS_DOOR.get());

            // Note: VOID_GATEWAY and VOID_DRAGON_EGG have no loot tables
            // They will simply not drop anything when broken
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return java.util.Collections.emptyList();
        }
    }
}
