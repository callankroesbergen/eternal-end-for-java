package org.VenularSpore257.eternal_end_for_java.world;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import org.VenularSpore257.eternal_end_for_java.EternalEndBlocks;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;

import java.util.List;

/**
 * Placement modifiers for Eternal End features.
 * Controls how features are placed in the world (spacing, count, height, etc.)
 */
public class ModPlacementModifiers {

    // ========== TREE PLACEMENT ==========

    public static ResourceKey<PlacedFeature> CHORUS_TREE_PLACED = createKey("chorus_tree_placed");
    public static ResourceKey<PlacedFeature> CRYOLITE_TREE_PLACED = createKey("cryolite_tree_placed");
    public static ResourceKey<PlacedFeature> FUNGAL_TREE_PLACED = createKey("fungal_tree_placed");
    public static ResourceKey<PlacedFeature> WHISPERING_TREE_PLACED = createKey("whispering_tree_placed");
    public static ResourceKey<PlacedFeature> HONEY_TREE_PLACED = createKey("honey_tree_placed");
    public static ResourceKey<PlacedFeature> SCORCHED_TREE_PLACED = createKey("scorched_tree_placed");
    public static ResourceKey<PlacedFeature> SPORED_TREE_PLACED = createKey("spored_tree_placed");

    // ========== ORE PLACEMENT ==========

    public static ResourceKey<PlacedFeature> END_AMETRINE_ORE_PLACED = createKey("end_ametrine_ore_placed");
    public static ResourceKey<PlacedFeature> END_PURPURITE_ORE_PLACED = createKey("end_purpurite_ore_placed");
    public static ResourceKey<PlacedFeature> END_VIRIDIAN_ORE_PLACED = createKey("end_viridian_ore_placed");
    public static ResourceKey<PlacedFeature> AMETRINE_GEODE_PLACED = createKey("ametrine_geode_placed");

    // ========== VEGETATION PLACEMENT ==========

    public static ResourceKey<PlacedFeature> GILDED_GRASS_PLACED = createKey("gilded_grass_placed");
    public static ResourceKey<PlacedFeature> VIOLITE_VOID_GRASS_PLACED = createKey("violite_void_grass_placed");
    public static ResourceKey<PlacedFeature> GLOWTIDE_GRASS_PLACED = createKey("glowtide_grass_placed");
    public static ResourceKey<PlacedFeature> CHORUS_FLOWER_PLACED = createKey("chorus_flower_placed");

    public static ResourceKey<PlacedFeature> FLARE_FERN_PLACED = createKey("flare_fern_placed");
    public static ResourceKey<PlacedFeature> FROSTBLOOM_PLACED = createKey("frostbloom_placed");
    public static ResourceKey<PlacedFeature> GLEAMFLOAT_PLACED = createKey("gleamfloat_placed");

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, name));
    }

    // ========== BOOTSTRAP ==========

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        // Get the configured feature lookup
        HolderGetter<ConfiguredFeature<?, ?>> featureLookup = context.lookup(Registries.CONFIGURED_FEATURE);

        // Register tree placements
        bootstrapTreePlacements(context, featureLookup);
        // Register ore placements
        bootstrapOrePlacements(context, featureLookup);
        // Register vegetation placements
        bootstrapVegetationPlacements(context, featureLookup);
    }

    private static void bootstrapTreePlacements(BootstrapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> featureLookup) {
        // Standard End tree placement
        List<PlacementModifier> treePlacement = List.of(
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                InSquarePlacement.spread(),
                PlacementUtils.countExtra(2, 0.1F, 1),
                BiomeFilter.biome()
        );

        context.register(CHORUS_TREE_PLACED,
                new PlacedFeature(featureLookup.getOrThrow(ModFeatures.CHORUS_TREE), treePlacement));
        context.register(CRYOLITE_TREE_PLACED,
                new PlacedFeature(featureLookup.getOrThrow(ModFeatures.CRYOLITE_TREE), treePlacement));
        context.register(FUNGAL_TREE_PLACED,
                new PlacedFeature(featureLookup.getOrThrow(ModFeatures.FUNGAL_TREE), treePlacement));
        context.register(WHISPERING_TREE_PLACED,
                new PlacedFeature(featureLookup.getOrThrow(ModFeatures.WHISPERING_TREE), treePlacement));
        context.register(HONEY_TREE_PLACED,
                new PlacedFeature(featureLookup.getOrThrow(ModFeatures.HONEY_TREE), treePlacement));
        context.register(SCORCHED_TREE_PLACED,
                new PlacedFeature(featureLookup.getOrThrow(ModFeatures.SCORCHED_TREE), treePlacement));
        context.register(SPORED_TREE_PLACED,
                new PlacedFeature(featureLookup.getOrThrow(ModFeatures.SPORED_TREE), treePlacement));
    }

    private static void bootstrapOrePlacements(BootstrapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> featureLookup) {
        // End ore placements - commonly found in End stone
        List<PlacementModifier> commonOrePlacement = List.of(
                CountPlacement.of(UniformInt.of(8, 16)),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80)),
                BiomeFilter.biome()
        );

        context.register(END_AMETRINE_ORE_PLACED,
                new PlacedFeature(featureLookup.getOrThrow(ModFeatures.AMETRINE_ORE), commonOrePlacement));
        context.register(END_PURPURITE_ORE_PLACED,
                new PlacedFeature(featureLookup.getOrThrow(ModFeatures.PURPURITE_ORE), commonOrePlacement));
        context.register(END_VIRIDIAN_ORE_PLACED,
                new PlacedFeature(featureLookup.getOrThrow(ModFeatures.VIRIDIAN_ORE), commonOrePlacement));

        // Ametrine Geode - rarer, larger
        List<PlacementModifier> geodePlacement = List.of(
                CountPlacement.of(UniformInt.of(1, 4)),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(30)),
                BiomeFilter.biome()
        );

        context.register(AMETRINE_GEODE_PLACED,
                new PlacedFeature(featureLookup.getOrThrow(ModFeatures.AMETRINE_GEODE), geodePlacement));
    }

    private static void bootstrapVegetationPlacements(BootstrapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> featureLookup) {
        // Grass patches - scattered on End stone
        List<PlacementModifier> grassPatchPlacement = List.of(
                CountPlacement.of(UniformInt.of(3, 6)),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                BiomeFilter.biome(),
                BlockPredicateFilter.forPredicate(net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate.matchesBlocks(
                        Blocks.END_STONE))
        );

        context.register(GILDED_GRASS_PLACED,
                new PlacedFeature(featureLookup.getOrThrow(ModFeatures.END_GRASS_PATCH), grassPatchPlacement));
        context.register(VIOLITE_VOID_GRASS_PLACED,
                new PlacedFeature(featureLookup.getOrThrow(ModFeatures.END_GRASS_PATCH), grassPatchPlacement));
        context.register(GLOWTIDE_GRASS_PLACED,
                new PlacedFeature(featureLookup.getOrThrow(ModFeatures.END_GRASS_PATCH), grassPatchPlacement));

        // Flower patches
        List<PlacementModifier> flowerPatchPlacement = List.of(
                CountPlacement.of(UniformInt.of(2, 5)),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                BiomeFilter.biome(),
                BlockPredicateFilter.forPredicate(net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate.matchesBlocks(
                        Blocks.END_STONE))
        );

        context.register(FLARE_FERN_PLACED,
                new PlacedFeature(featureLookup.getOrThrow(ModFeatures.END_FLOWER_PATCH), flowerPatchPlacement));
        context.register(FROSTBLOOM_PLACED,
                new PlacedFeature(featureLookup.getOrThrow(ModFeatures.END_FLOWER_PATCH), flowerPatchPlacement));
        context.register(GLEAMFLOAT_PLACED,
                new PlacedFeature(featureLookup.getOrThrow(ModFeatures.END_FLOWER_PATCH), flowerPatchPlacement));

        // Chorus flower placements (natural) - create inline feature
        Holder<ConfiguredFeature<?, ?>> chorusFlowerFeature =
                new Holder.Direct<>(new ConfiguredFeature<>(
                        net.minecraft.world.level.levelgen.feature.Feature.RANDOM_PATCH,
                        new RandomPatchConfiguration(
                                8,
                                4,
                                2,
                                PlacementUtils.onlyWhenEmpty(
                                        net.minecraft.world.level.levelgen.feature.Feature.SIMPLE_BLOCK,
                                        new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.CHORUS_FLOWER))
                                )
                        )
                ));

        List<PlacementModifier> chorusPlacement = List.of(
                CountPlacement.of(UniformInt.of(1, 3)),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                BiomeFilter.biome(),
                BlockPredicateFilter.forPredicate(net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate.matchesBlocks(
                        Blocks.END_STONE))
        );

        context.register(CHORUS_FLOWER_PLACED,
                new PlacedFeature(chorusFlowerFeature, chorusPlacement));
    }
}
