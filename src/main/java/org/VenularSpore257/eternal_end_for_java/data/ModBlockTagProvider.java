package org.VenularSpore257.eternal_end_for_java.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.Tags;
import org.VenularSpore257.eternal_end_for_java.EternalEndBlocks;

import java.util.concurrent.CompletableFuture;

/**
 * Block tag provider for Eternal End mod.
 * Creates tags for:
 * - Mining levels (needs_correct_tool_for_drops)
 * - Tool tiers (mineable/pickaxe, etc.)
 * - Block groups (logs, planks, etc.)
 */
public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                 net.neoforged.neoforge.common.data.ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, "eternal_end_for_java", existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // ========== MINING LEVEL TAGS ==========

        // Stone level (iron tier)
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        // Ametrine ores
                        EternalEndBlocks.AMETRINE_ORE.get(),
                        EternalEndBlocks.AMETRINE_ORE_DEEPSLATE.get(),
                        // Purpurite ores
                        EternalEndBlocks.PURPURITE_ORE.get(),
                        EternalEndBlocks.DARK_PURPURITE_ORE.get(),
                        // Viridian ore
                        EternalEndBlocks.VIRIDIAN_ORE.get(),
                        // Storage blocks
                        EternalEndBlocks.AMETRINE_BLOCK.get(),
                        EternalEndBlocks.ENDERITE_BLOCK.get(),
                        EternalEndBlocks.DARK_PURPUR_BLOCK.get(),
                        EternalEndBlocks.DARK_PURPUR_PILLAR.get(),
                        EternalEndBlocks.DARK_PURPUR_TILES.get(),
                        EternalEndBlocks.AMETRINE_GEODE.get(),
                        EternalEndBlocks.AMETRINE_GEODE_ROCK.get(),
                        EternalEndBlocks.RAW_PURPURITE_BLOCK.get(),
                        EternalEndBlocks.RAW_DARK_PURPURITE_BLOCK.get(),
                        // Noctral stone variants
                        EternalEndBlocks.NOCTRAL_STONE.get(),
                        EternalEndBlocks.NOCTRAL_STONE_SEDIMENT.get(),
                        EternalEndBlocks.NOCTRAL_BRICKS.get(),
                        EternalEndBlocks.NOCTRAL_SLATES.get(),
                        EternalEndBlocks.NOCTRAL_PILLAR.get(),
                        // Viridian stone variants
                        EternalEndBlocks.VIRIDIAN_PILLAR.get(),
                        EternalEndBlocks.CHISELED_VIRIDIAN.get(),
                        EternalEndBlocks.VIRIDIAN_BRICKS.get(),
                        // Dark purpur variants
                        EternalEndBlocks.DARK_PURPUR_TILES.get(),
                        // Mycelion mire
                        EternalEndBlocks.MYCELION_MIRE.get(),
                        EternalEndBlocks.MYCELION_MIRE_SEDIMENT.get(),
                        EternalEndBlocks.MYCELION_MIRE_SLATS.get(),
                        // Enderite blocks
                        EternalEndBlocks.ETERNAL_DEBRIS.get(),
                        EternalEndBlocks.GILDED_ROCK.get()
                );

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(
                        EternalEndBlocks.AMETRINE_ORE.get(),
                        EternalEndBlocks.AMETRINE_ORE_DEEPSLATE.get(),
                        EternalEndBlocks.AMETRINE_GEODE_ROCK.get(),
                        EternalEndBlocks.ETERNAL_DEBRIS.get()
                );

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        EternalEndBlocks.ENDERITE_BLOCK.get(),
                        EternalEndBlocks.AMETRINE_BLOCK.get(),
                        EternalEndBlocks.RAW_PURPURITE_BLOCK.get(),
                        EternalEndBlocks.RAW_DARK_PURPURITE_BLOCK.get()
                );

        // ========== WOOD TAGS ==========

        // Chorus wood
        tag(BlockTags.LOGS_THAT_BURN)
                .add(
                        EternalEndBlocks.CHORUS_LOG.get(),
                        EternalEndBlocks.CHORUS_WOOD.get(),
                        EternalEndBlocks.CHORUS_STRIPPED_LOG.get(),
                        EternalEndBlocks.CHORUS_STRIPPED_WOOD.get(),
                        EternalEndBlocks.CHORUS_PLANKS.get(),
                        // Chorus derivatives
                        EternalEndBlocks.CHORUS_STAIRS.get(),
                        EternalEndBlocks.CHORUS_SLAB.get(),
                        EternalEndBlocks.CHORUS_FENCE.get(),
                        EternalEndBlocks.CHORUS_FENCE_GATE.get(),
                        EternalEndBlocks.CHORUS_TRAPDOOR.get(),

                        EternalEndBlocks.CRYOLITE_LOG.get(),
                        EternalEndBlocks.CRYOLITE_WOOD.get(),
                        EternalEndBlocks.CRYOLITE_STRIPPED_LOG.get(),
                        EternalEndBlocks.CRYOLITE_STRIPPED_WOOD.get(),
                        EternalEndBlocks.CRYOLITE_PLANKS.get(),
                        EternalEndBlocks.CRYOLITE_STAIRS.get(),
                        EternalEndBlocks.CRYOLITE_SLAB.get(),
                        EternalEndBlocks.CRYOLITE_FENCE.get(),
                        EternalEndBlocks.CRYOLITE_FENCE_GATE.get(),
                        EternalEndBlocks.CRYOLITE_TRAPDOOR.get(),

                        EternalEndBlocks.FUNGAL_LOG.get(),
                        EternalEndBlocks.FUNGAL_WOOD.get(),
                        EternalEndBlocks.FUNGAL_STRIPPED_LOG.get(),
                        EternalEndBlocks.FUNGAL_STRIPPED_WOOD.get(),
                        EternalEndBlocks.FUNGAL_PLANKS.get(),
                        EternalEndBlocks.FUNGAL_STAIRS.get(),
                        EternalEndBlocks.FUNGAL_SLAB.get(),
                        EternalEndBlocks.FUNGAL_FENCE.get(),
                        EternalEndBlocks.FUNGAL_FENCE_GATE.get(),
                        EternalEndBlocks.FUNGAL_TRAPDOOR.get(),

                        EternalEndBlocks.WHISPERING_LOG.get(),
                        EternalEndBlocks.WHISPERING_WOOD.get(),
                        EternalEndBlocks.WHISPERING_STRIPPED_LOG.get(),
                        EternalEndBlocks.WHISPERING_STRIPPED_WOOD.get(),
                        EternalEndBlocks.WHISPERING_PLANKS.get(),
                        EternalEndBlocks.WHISPERING_STAIRS.get(),
                        EternalEndBlocks.WHISPERING_SLAB.get(),
                        EternalEndBlocks.WHISPERING_FENCE.get(),
                        EternalEndBlocks.WHISPERING_FENCE_GATE.get(),
                        EternalEndBlocks.WHISPERING_TRAPDOOR.get(),

                        EternalEndBlocks.HONEY_LOG.get(),
                        EternalEndBlocks.HONEY_WOOD.get(),
                        EternalEndBlocks.HONEY_STRIPPED_LOG.get(),
                        EternalEndBlocks.HONEY_STRIPPED_WOOD.get(),
                        EternalEndBlocks.HONEY_PLANKS.get(),
                        EternalEndBlocks.HONEY_STAIRS.get(),
                        EternalEndBlocks.HONEY_SLAB.get(),
                        EternalEndBlocks.HONEY_FENCE.get(),
                        EternalEndBlocks.HONEY_FENCE_GATE.get(),
                        EternalEndBlocks.HONEY_TRAPDOOR.get(),

                        EternalEndBlocks.SCORCHED_LOG.get(),
                        EternalEndBlocks.SCORCHED_WOOD.get(),
                        EternalEndBlocks.SCORCHED_STRIPPED_LOG.get(),
                        EternalEndBlocks.SCORCHED_STRIPPED_WOOD.get(),
                        EternalEndBlocks.SCORCHED_PLANKS.get(),
                        EternalEndBlocks.SCORCHED_STAIRS.get(),
                        EternalEndBlocks.SCORCHED_SLAB.get(),
                        EternalEndBlocks.SCORCHED_FENCE.get(),
                        EternalEndBlocks.SCORCHED_FENCE_GATE.get(),
                        EternalEndBlocks.SCORCHED_TRAPDOOR.get(),

                        EternalEndBlocks.SPORED_LOG.get(),
                        EternalEndBlocks.SPORED_WOOD.get(),
                        EternalEndBlocks.SPORED_STRIPPED_LOG.get(),
                        EternalEndBlocks.SPORED_STRIPPED_WOOD.get(),
                        EternalEndBlocks.SPORED_PLANKS.get(),
                        EternalEndBlocks.SPORED_STAIRS.get(),
                        EternalEndBlocks.SPORED_SLAB.get(),
                        EternalEndBlocks.SPORED_FENCE.get(),
                        EternalEndBlocks.SPORED_FENCE_GATE.get(),
                        EternalEndBlocks.SPORED_TRAPDOOR.get()
                );

        // Axe tags for all wood types
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(
                        // All wood variants
                        EternalEndBlocks.CHORUS_LOG.get(),
                        EternalEndBlocks.CHORUS_WOOD.get(),
                        EternalEndBlocks.CHORUS_STRIPPED_LOG.get(),
                        EternalEndBlocks.CHORUS_STRIPPED_WOOD.get(),
                        EternalEndBlocks.CHORUS_PLANKS.get(),
                        EternalEndBlocks.CHORUS_STAIRS.get(),
                        EternalEndBlocks.CHORUS_SLAB.get(),
                        EternalEndBlocks.CHORUS_FENCE.get(),
                        EternalEndBlocks.CHORUS_FENCE_GATE.get(),
                        EternalEndBlocks.CHORUS_DOOR.get(),
                        EternalEndBlocks.CHORUS_TRAPDOOR.get(),

                        EternalEndBlocks.CRYOLITE_LOG.get(),
                        EternalEndBlocks.CRYOLITE_WOOD.get(),
                        EternalEndBlocks.CRYOLITE_STRIPPED_LOG.get(),
                        EternalEndBlocks.CRYOLITE_STRIPPED_WOOD.get(),
                        EternalEndBlocks.CRYOLITE_PLANKS.get(),
                        EternalEndBlocks.CRYOLITE_STAIRS.get(),
                        EternalEndBlocks.CRYOLITE_SLAB.get(),
                        EternalEndBlocks.CRYOLITE_FENCE.get(),
                        EternalEndBlocks.CRYOLITE_FENCE_GATE.get(),
                        EternalEndBlocks.CRYOLITE_DOOR.get(),
                        EternalEndBlocks.CRYOLITE_TRAPDOOR.get(),

                        EternalEndBlocks.FUNGAL_LOG.get(),
                        EternalEndBlocks.FUNGAL_WOOD.get(),
                        EternalEndBlocks.FUNGAL_STRIPPED_LOG.get(),
                        EternalEndBlocks.FUNGAL_STRIPPED_WOOD.get(),
                        EternalEndBlocks.FUNGAL_PLANKS.get(),
                        EternalEndBlocks.FUNGAL_STAIRS.get(),
                        EternalEndBlocks.FUNGAL_SLAB.get(),
                        EternalEndBlocks.FUNGAL_FENCE.get(),
                        EternalEndBlocks.FUNGAL_FENCE_GATE.get(),
                        EternalEndBlocks.FUNGAL_DOOR.get(),
                        EternalEndBlocks.FUNGAL_TRAPDOOR.get(),

                        EternalEndBlocks.WHISPERING_LOG.get(),
                        EternalEndBlocks.WHISPERING_WOOD.get(),
                        EternalEndBlocks.WHISPERING_STRIPPED_LOG.get(),
                        EternalEndBlocks.WHISPERING_STRIPPED_WOOD.get(),
                        EternalEndBlocks.WHISPERING_PLANKS.get(),
                        EternalEndBlocks.WHISPERING_STAIRS.get(),
                        EternalEndBlocks.WHISPERING_SLAB.get(),
                        EternalEndBlocks.WHISPERING_FENCE.get(),
                        EternalEndBlocks.WHISPERING_FENCE_GATE.get(),
                        EternalEndBlocks.WHISPERING_DOOR.get(),
                        EternalEndBlocks.WHISPERING_TRAPDOOR.get(),

                        EternalEndBlocks.HONEY_LOG.get(),
                        EternalEndBlocks.HONEY_WOOD.get(),
                        EternalEndBlocks.HONEY_STRIPPED_LOG.get(),
                        EternalEndBlocks.HONEY_STRIPPED_WOOD.get(),
                        EternalEndBlocks.HONEY_PLANKS.get(),
                        EternalEndBlocks.HONEY_STAIRS.get(),
                        EternalEndBlocks.HONEY_SLAB.get(),
                        EternalEndBlocks.HONEY_FENCE.get(),
                        EternalEndBlocks.HONEY_FENCE_GATE.get(),
                        EternalEndBlocks.HONEY_DOOR.get(),
                        EternalEndBlocks.HONEY_TRAPDOOR.get(),

                        EternalEndBlocks.SCORCHED_LOG.get(),
                        EternalEndBlocks.SCORCHED_WOOD.get(),
                        EternalEndBlocks.SCORCHED_STRIPPED_LOG.get(),
                        EternalEndBlocks.SCORCHED_STRIPPED_WOOD.get(),
                        EternalEndBlocks.SCORCHED_PLANKS.get(),
                        EternalEndBlocks.SCORCHED_STAIRS.get(),
                        EternalEndBlocks.SCORCHED_SLAB.get(),
                        EternalEndBlocks.SCORCHED_FENCE.get(),
                        EternalEndBlocks.SCORCHED_FENCE_GATE.get(),
                        EternalEndBlocks.SCORCHED_DOOR.get(),
                        EternalEndBlocks.SCORCHED_TRAPDOOR.get(),

                        EternalEndBlocks.SPORED_LOG.get(),
                        EternalEndBlocks.SPORED_WOOD.get(),
                        EternalEndBlocks.SPORED_STRIPPED_LOG.get(),
                        EternalEndBlocks.SPORED_STRIPPED_WOOD.get(),
                        EternalEndBlocks.SPORED_PLANKS.get(),
                        EternalEndBlocks.SPORED_STAIRS.get(),
                        EternalEndBlocks.SPORED_SLAB.get(),
                        EternalEndBlocks.SPORED_FENCE.get(),
                        EternalEndBlocks.SPORED_FENCE_GATE.get(),
                        EternalEndBlocks.SPORED_DOOR.get(),
                        EternalEndBlocks.SPORED_TRAPDOOR.get(),

                        // Special blocks
                        EternalEndBlocks.CHORAL_SPIRE.get(),
                        EternalEndBlocks.CHORUS_LEAVES.get(),
                        EternalEndBlocks.CRYOLITE_LEAVES.get(),
                        EternalEndBlocks.HANGING_CRYOLITE_LEAVES.get(),
                        EternalEndBlocks.FUNGAL_LEAVES.get(),
                        EternalEndBlocks.WHISPERING_LEAVES.get(),
                        EternalEndBlocks.HANGING_WHISPERING_LEAVES.get(),
                        EternalEndBlocks.HONEY_LEAVES.get(),
                        EternalEndBlocks.SCORCHED_LEAVES.get(),
                        EternalEndBlocks.SPORED_LEAVES.get(),

                        // Vegetation
                        EternalEndBlocks.FLARE_FERN.get(),
                        EternalEndBlocks.FROSTBLOOM.get(),
                        EternalEndBlocks.FRILLTOPS.get(),
                        EternalEndBlocks.LOTUS_BLOOM.get(),
                        EternalEndBlocks.MOONFLOWER.get(),
                        EternalEndBlocks.MISTVEIL_BLOOM.get(),
                        EternalEndBlocks.SPRINGBULB.get(),
                        EternalEndBlocks.WICKED_WISTERIA.get(),
                        EternalEndBlocks.SHADOW_WISTERIA.get(),
                        EternalEndBlocks.VIOLET_WISTERIA.get(),
                        EternalEndBlocks.VERDANT_STALK.get(),
                        EternalEndBlocks.SUNSILK_LACE.get(),
                        EternalEndBlocks.AURACREST.get(),
                        EternalEndBlocks.ICELUMIA.get(),
                        EternalEndBlocks.LAYERLOOM.get(),
                        EternalEndBlocks.VERDANT_SPIKE.get(),

                        // Mushrooms
                        EternalEndBlocks.BLOOMLING.get(),
                        EternalEndBlocks.TANGLECAPS.get(),
                        EternalEndBlocks.MEADOWLINGS.get(),
                        EternalEndBlocks.LYRIC_SPROUTS.get(),
                        EternalEndBlocks.SPORESPROUT.get(),

                        // Lily pads
                        EternalEndBlocks.LILECAP.get(),
                        EternalEndBlocks.LIMECAP.get(),
                        EternalEndBlocks.TEALCAP.get(),
                        EternalEndBlocks.GLEAMFLOAT.get(),

                        // Vines
                        EternalEndBlocks.MOON_BERRY_VINES.get(),
                        EternalEndBlocks.SPORE_ALGAE.get(),

                        // Misc
                        EternalEndBlocks.VIOLA_SPECKLE.get(),
                        EternalEndBlocks.GILDED_WHEAT.get(),

                        // Saplings
                        EternalEndBlocks.CHORUS_SAPLING.get(),
                        EternalEndBlocks.CRYOLITE_SAPLING.get(),
                        EternalEndBlocks.FUNGAL_SAPLING.get(),
                        EternalEndBlocks.WHISPERING_SAPLING.get(),
                        EternalEndBlocks.HONEY_SAPLING.get(),
                        EternalEndBlocks.SCORCHED_SAPLING.get(),
                        EternalEndBlocks.SPORED_SAPLING.get(),

                        // Cloud
                        EternalEndBlocks.CLOUD.get(),

                        // Dragon head
                        EternalEndBlocks.VOID_DRAGON_HEAD.get()
                );

        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(
                        // All leaves and vegetation
                        EternalEndBlocks.CHORUS_LEAVES.get(),
                        EternalEndBlocks.CRYOLITE_LEAVES.get(),
                        EternalEndBlocks.HANGING_CRYOLITE_LEAVES.get(),
                        EternalEndBlocks.FUNGAL_LEAVES.get(),
                        EternalEndBlocks.WHISPERING_LEAVES.get(),
                        EternalEndBlocks.HANGING_WHISPERING_LEAVES.get(),
                        EternalEndBlocks.HONEY_LEAVES.get(),
                        EternalEndBlocks.SCORCHED_LEAVES.get(),
                        EternalEndBlocks.SPORED_LEAVES.get(),

                        // Grasses
                        EternalEndBlocks.FLARE_GRASS.get(),
                        EternalEndBlocks.GOLDEN_VOID_GRASS.get(),
                        EternalEndBlocks.VIOLITE_VOID_GRASS.get(),
                        EternalEndBlocks.GILDED_GRASS.get(),
                        EternalEndBlocks.SCORCHED_GRASS.get(),
                        EternalEndBlocks.STARGLOW_GRASS.get(),
                        EternalEndBlocks.FROSTSPIKE_GRASS.get(),
                        EternalEndBlocks.GLOWTIDE_GRASS.get(),
                        EternalEndBlocks.CURLWHISP_GRASS.get(),
                        EternalEndBlocks.ORB_GRASS.get(),
                        EternalEndBlocks.SPIRAL_GRASS.get(),
                        EternalEndBlocks.TWINBLADE_GRASS.get(),
                        EternalEndBlocks.BEAD_GRASS.get(),
                        EternalEndBlocks.BLADE_GRASS.get(),
                        EternalEndBlocks.FLATHEAD_GRASS.get(),

                        // Flowers
                        EternalEndBlocks.FLARE_FERN.get(),
                        EternalEndBlocks.FROSTBLOOM.get(),
                        EternalEndBlocks.FRILLTOPS.get(),
                        EternalEndBlocks.LOTUS_BLOOM.get(),
                        EternalEndBlocks.MOONFLOWER.get(),
                        EternalEndBlocks.MISTVEIL_BLOOM.get(),
                        EternalEndBlocks.SPRINGBULB.get(),
                        EternalEndBlocks.WICKED_WISTERIA.get(),
                        EternalEndBlocks.SHADOW_WISTERIA.get(),
                        EternalEndBlocks.VIOLET_WISTERIA.get(),
                        EternalEndBlocks.VERDANT_STALK.get(),
                        EternalEndBlocks.SUNSILK_LACE.get(),
                        EternalEndBlocks.AURACREST.get(),

                        // Mushrooms
                        EternalEndBlocks.BLOOMLING.get(),
                        EternalEndBlocks.TANGLECAPS.get(),
                        EternalEndBlocks.MEADOWLINGS.get(),
                        EternalEndBlocks.LYRIC_SPROUTS.get(),
                        EternalEndBlocks.SPORESPROUT.get(),

                        // Lily pads
                        EternalEndBlocks.LILECAP.get(),
                        EternalEndBlocks.LIMECAP.get(),
                        EternalEndBlocks.TEALCAP.get(),
                        EternalEndBlocks.GLEAMFLOAT.get(),

                        // Vines
                        EternalEndBlocks.MOON_BERRY_VINES.get(),
                        EternalEndBlocks.SPORE_ALGAE.get(),

                        // Saplings
                        EternalEndBlocks.CHORUS_SAPLING.get(),
                        EternalEndBlocks.CRYOLITE_SAPLING.get(),
                        EternalEndBlocks.FUNGAL_SAPLING.get(),
                        EternalEndBlocks.WHISPERING_SAPLING.get(),
                        EternalEndBlocks.HONEY_SAPLING.get(),
                        EternalEndBlocks.SCORCHED_SAPLING.get(),
                        EternalEndBlocks.SPORED_SAPLING.get(),

                        // Misc
                        EternalEndBlocks.VIOLA_SPECKLE.get(),
                        EternalEndBlocks.GILDED_WHEAT.get(),
                        EternalEndBlocks.ICELUMIA.get(),
                        EternalEndBlocks.LAYERLOOM.get(),
                        EternalEndBlocks.VERDANT_SPIKE.get()
                );

        // ========== END STONE ORE TAGS ==========
        // Add to vanilla end_stone_replaceables tag if it exists
        tag(BlockTags.DIRT)
                .add(
                        EternalEndBlocks.DUSK_SOIL.get(),
                        EternalEndBlocks.DUSK_SOIL_SEDIMENT.get()
                );

        // ========== SPECIAL BLOCKS ==========
        tag(BlockTags.DRAGON_IMMUNE)
                .add(
                        EternalEndBlocks.VOID_DRAGON_EGG.get()
                );

        tag(BlockTags.WITHER_IMMUNE)
                .add(
                        EternalEndBlocks.VOID_DRAGON_EGG.get(),
                        EternalEndBlocks.VOID_GATEWAY.get()
                );

        // ========== STONE VARIANTS ==========
        tag(BlockTags.STONE_BRICKS)
                .add(
                        EternalEndBlocks.NOCTRAL_BRICKS.get(),
                        EternalEndBlocks.VIRIDIAN_BRICKS.get()
                );
    }
}
