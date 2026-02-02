package org.VenularSpore257.eternal_end_for_java.world;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.VenularSpore257.eternal_end_for_java.EternalEndBlocks;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;

import java.util.List;

/**
 * Features for the Eternal End mod.
 * Includes tree features, geodes, ore placements, and vegetation.
 */
public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, Eternal_end_for_java.MODID);
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registries.CONFIGURED_FEATURE, Eternal_end_for_java.MODID);

    // ========== FEATURE RESOURCE KEYS ==========
    // Trees
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHORUS_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, "chorus_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYOLITE_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, "cryolite_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> FUNGAL_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, "fungal_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHISPERING_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, "whispering_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> HONEY_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, "honey_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCORCHED_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, "scorched_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPORED_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, "spored_tree"));

    // Geodes
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMETRINE_GEODE = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, "ametrine_geode"));

    // Ores
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMETRINE_ORE = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, "ametrine_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMETRINE_ORE_DEEPSLATE = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, "ametrine_ore_deepslate"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPURITE_ORE = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, "purpurite_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> VIRIDIAN_ORE = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, "viridian_ore"));

    // Vegetation
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_GRASS_PATCH = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, "end_grass_patch"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_FLOWER_PATCH = ResourceKey.create(Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, "end_flower_patch"));

    // ========== TREE CONFIGURATION HELPERS ==========

    /**
     * Creates a basic tree configuration for End wood types
     */
    private static TreeConfiguration.TreeConfigurationBuilder createEndTreeConfig(
            BlockState log,
            BlockState leaves,
            BlockState trunkLog) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(trunkLog),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(leaves),
                new BlobFoliagePlacer(UniformInt.of(2, 2), UniformInt.of(0, 0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        ).ignoreVines();
    }

    /**
     * Creates a large tree configuration
     */
    private static TreeConfiguration.TreeConfigurationBuilder createLargeEndTreeConfig(
            BlockState log,
            BlockState leaves) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(log),
                new StraightTrunkPlacer(6, 4, 0),
                BlockStateProvider.simple(leaves),
                new BlobFoliagePlacer(UniformInt.of(3, 3), UniformInt.of(1, 1), 4),
                new TwoLayersFeatureSize(2, 0, 2)
        ).ignoreVines();
    }

    // ========== ORE CONFIGURATION HELPERS ==========

    /**
     * Creates an ore configuration
     */
    private static OreConfiguration createOreConfig(RuleTest filler, BlockState ore, int size) {
        return new OreConfiguration(filler, ore, size);
    }

    // Common ore targets
    private static final RuleTest END_STONE_REPLACEABLES = new BlockMatchTest(Blocks.END_STONE);
    private static final RuleTest STONE_REPLACEABLES = new BlockMatchTest(Blocks.STONE);
    private static final RuleTest DEEPSLATE_REPLACEABLES = new BlockMatchTest(Blocks.DEEPSLATE);

    // ========== BOOTSTRAP METHOD FOR DATAGEN ==========

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        // ========== TREE FEATURES ==========

        // Chorus Tree - Uses chorus_log and chorus_leaves
        TreeConfiguration chorusConfig = createEndTreeConfig(
                EternalEndBlocks.CHORUS_LOG.get().defaultBlockState(),
                EternalEndBlocks.CHORUS_LEAVES.get().defaultBlockState(),
                EternalEndBlocks.CHORUS_LOG.get().defaultBlockState()
        ).build();
        context.register(CHORUS_TREE, new ConfiguredFeature<>(Feature.TREE, chorusConfig));

        // Cryolite Tree
        TreeConfiguration cryoliteConfig = createEndTreeConfig(
                EternalEndBlocks.CRYOLITE_LOG.get().defaultBlockState(),
                EternalEndBlocks.CRYOLITE_LEAVES.get().defaultBlockState(),
                EternalEndBlocks.CRYOLITE_LOG.get().defaultBlockState()
        ).build();
        context.register(CRYOLITE_TREE, new ConfiguredFeature<>(Feature.TREE, cryoliteConfig));

        // Fungal Tree
        TreeConfiguration fungalConfig = createEndTreeConfig(
                EternalEndBlocks.FUNGAL_LOG.get().defaultBlockState(),
                EternalEndBlocks.FUNGAL_LEAVES.get().defaultBlockState(),
                EternalEndBlocks.FUNGAL_LOG.get().defaultBlockState()
        ).build();
        context.register(FUNGAL_TREE, new ConfiguredFeature<>(Feature.TREE, fungalConfig));

        // Whispering Tree
        TreeConfiguration whisperingConfig = createEndTreeConfig(
                EternalEndBlocks.WHISPERING_LOG.get().defaultBlockState(),
                EternalEndBlocks.WHISPERING_LEAVES.get().defaultBlockState(),
                EternalEndBlocks.WHISPERING_LOG.get().defaultBlockState()
        ).build();
        context.register(WHISPERING_TREE, new ConfiguredFeature<>(Feature.TREE, whisperingConfig));

        // Honey Tree
        TreeConfiguration honeyConfig = createEndTreeConfig(
                EternalEndBlocks.HONEY_LOG.get().defaultBlockState(),
                EternalEndBlocks.HONEY_LEAVES.get().defaultBlockState(),
                EternalEndBlocks.HONEY_LOG.get().defaultBlockState()
        ).build();
        context.register(HONEY_TREE, new ConfiguredFeature<>(Feature.TREE, honeyConfig));

        // Scorched Tree
        TreeConfiguration scorchedConfig = createEndTreeConfig(
                EternalEndBlocks.SCORCHED_LOG.get().defaultBlockState(),
                EternalEndBlocks.SCORCHED_LEAVES.get().defaultBlockState(),
                EternalEndBlocks.SCORCHED_LOG.get().defaultBlockState()
        ).build();
        context.register(SCORCHED_TREE, new ConfiguredFeature<>(Feature.TREE, scorchedConfig));

        // Spored Tree
        TreeConfiguration sporedConfig = createEndTreeConfig(
                EternalEndBlocks.SPORED_LOG.get().defaultBlockState(),
                EternalEndBlocks.SPORED_LEAVES.get().defaultBlockState(),
                EternalEndBlocks.SPORED_LOG.get().defaultBlockState()
        ).build();
        context.register(SPORED_TREE, new ConfiguredFeature<>(Feature.TREE, sporedConfig));

        // ========== GEODE FEATURES ==========

        // Ametrine Geode - Similar to amethyst geodes
        RuleTest ametrineGeodeFiller = new BlockMatchTest(Blocks.END_STONE);
        OreConfiguration ametrineGeodeConfig = new OreConfiguration(
                ametrineGeodeFiller,
                EternalEndBlocks.AMETRINE_CRYSTAL.get().defaultBlockState(),
                12
        );
        context.register(AMETRINE_GEODE, new ConfiguredFeature<>(Feature.ORE, ametrineGeodeConfig));

        // ========== ORE FEATURES ==========

        // Ametrine Ore (Overworld - Stone)
        OreConfiguration ametrineOreConfig = createOreConfig(
                STONE_REPLACEABLES,
                EternalEndBlocks.AMETRINE_ORE.get().defaultBlockState(),
                6
        );
        context.register(AMETRINE_ORE, new ConfiguredFeature<>(Feature.ORE, ametrineOreConfig));

        // Ametrine Ore Deepslate
        OreConfiguration ametrineDeepslateConfig = createOreConfig(
                DEEPSLATE_REPLACEABLES,
                EternalEndBlocks.AMETRINE_ORE_DEEPSLATE.get().defaultBlockState(),
                5
        );
        context.register(AMETRINE_ORE_DEEPSLATE, new ConfiguredFeature<>(Feature.ORE, ametrineDeepslateConfig));

        // Purpurite Ore (End)
        OreConfiguration purpuriteOreConfig = createOreConfig(
                END_STONE_REPLACEABLES,
                EternalEndBlocks.PURPURITE_ORE.get().defaultBlockState(),
                8
        );
        context.register(PURPURITE_ORE, new ConfiguredFeature<>(Feature.ORE, purpuriteOreConfig));

        // Viridian Ore (End)
        OreConfiguration viridianOreConfig = createOreConfig(
                END_STONE_REPLACEABLES,
                EternalEndBlocks.VIRIDIAN_ORE.get().defaultBlockState(),
                7
        );
        context.register(VIRIDIAN_ORE, new ConfiguredFeature<>(Feature.ORE, viridianOreConfig));

        // ========== VEGETATION FEATURES ==========

        // End Grass Patch - Random placement mod grasses
        RandomPatchConfiguration grassPatchConfig = new RandomPatchConfiguration(
                16,
                7,
                3,
                PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(EternalEndBlocks.GILDED_GRASS.get())))
        );
        context.register(END_GRASS_PATCH, new ConfiguredFeature<>(Feature.RANDOM_PATCH, grassPatchConfig));

        // End Flower Patch
        RandomPatchConfiguration flowerPatchConfig = new RandomPatchConfiguration(
                8,
                4,
                2,
                PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(EternalEndBlocks.FLARE_FERN.get())))
        );
        context.register(END_FLOWER_PATCH, new ConfiguredFeature<>(Feature.RANDOM_PATCH, flowerPatchConfig));
    }

    // ========== BIOME MODIFIERS TO ADD FEATURES ==========
    // These modifiers add features to specific biomes
    // TODO: Re-enable when ModBiomes is implemented

    /*
    // Add trees to forest biomes
    public static final DeferredHolder<BiomeModifier, BiomeModifier> ADD_FOREST_TREES = BIOME_MODIFIERS.register("add_forest_trees",
            () -> new BiomeModifiers.AddFeaturesBiomeModifier(
                    List.of(
                            // Gilded Woods
                            ModBiomes.GILDED_WOODS,
                            // Normal Forest
                            ModBiomes.NORMAL_FOREST,
                            // Prism Forest
                            ModBiomes.PRISM_FOREST,
                            // Shadow Fold
                            ModBiomes.SHADOW_FOLD,
                            // Sporelight Forests
                            ModBiomes.SPORELIGHT_FUNGAL_FOREST,
                            ModBiomes.SPORELIGHT_MIXED_FOREST,
                            ModBiomes.SPORELIGHT_SPORED_FOREST,
                            // Verdant Forests
                            ModBiomes.VERDANT_GLADE,
                            ModBiomes.VERDANT_GROVE
                    ).stream()
                            .map(key -> new BiomeModifiers.BiomeModifier.BiomeContext(key))
                            .toList(),
                    List.of(
                            new BiomeModifiers.AddFeaturesBiomeFeature(
                                    BiomeModifiers.BiomeModifier.Phase.VEGETAL_DECORATION,
                                    List.of(
                                            ModFeatures.CHORUS_TREE,
                                            ModFeatures.END_GRASS_PATCH,
                                            ModFeatures.END_FLOWER_PATCH
                                    ).stream()
                                            .map(key -> new BiomeModifier.FeatureContext(key))
                                            .toList()
                            )
                    )
            ));

    // Add ore generation to End biomes
    public static final DeferredHolder<BiomeModifier, BiomeModifier> ADD_END_ORES = BIOME_MODIFIERS.register("add_end_ores",
            () -> new BiomeModifiers.AddFeaturesBiomeModifier(
                    List.of(
                            // All End biomes get ores
                            ModBiomes.GILDED_FIELDS,
                            ModBiomes.GILDED_RIDGE,
                            ModBiomes.GILDED_WOODS,
                            ModBiomes.NORMAL_FOREST,
                            ModBiomes.NORMAL_WASTELAND,
                            ModBiomes.PRISM_DEFAULT,
                            ModBiomes.PRISM_FOREST,
                            ModBiomes.PRISM_PEAKS,
                            ModBiomes.PRISM_PILLARS,
                            ModBiomes.PRISM_PONDS,
                            ModBiomes.SHADOW_FOLD,
                            ModBiomes.SPORELIGHT_FUNGAL_FOREST,
                            ModBiomes.SPORELIGHT_MIXED_FOREST,
                            ModBiomes.SPORELIGHT_SPORED_FOREST,
                            ModBiomes.SPORELIGHT_VOID_ISLANDS,
                            ModBiomes.VERDANT_GLADE,
                            ModBiomes.VERDANT_GROVE,
                            ModBiomes.VERDANT_SPIKE_ISLANDS
                    ).stream()
                            .map(key -> new BiomeModifiers.BiomeModifier.BiomeContext(key))
                            .toList(),
                    List.of(
                            new BiomeModifiers.AddFeaturesBiomeFeature(
                                    BiomeModifiers.BiomeModifier.Phase.UNDERGROUND_ORES,
                                    List.of(
                                            ModFeatures.PURPURITE_ORE,
                                            ModFeatures.VIRIDIAN_ORE,
                                            ModFeatures.AMETRINE_GEODE
                                    ).stream()
                                            .map(key -> new BiomeModifier.FeatureContext(key))
                                            .toList()
                            )
                    )
            ));
    */

    public static void register() {
        // Registration handled by deferred registers
    }
}
