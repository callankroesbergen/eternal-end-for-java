package org.VenularSpore257.eternal_end_for_java.world;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;

/**
 * Biomes for the Eternal End mod.
 * Based on the Bedrock addon's 6 End biomes.
 */
public class ModBiomes {
    public static final ResourceKey<Biome> VANILLA_BIOME = createKey("vanilla_biome");
    public static final ResourceKey<Biome> GILDED_RIDGE = createKey("gilded_ridge");
    public static final ResourceKey<Biome> PRISM_PEAK = createKey("prism_peak");
    public static final ResourceKey<Biome> SPORELIGHT_HOLLOW = createKey("sporelight_hollow");
    public static final ResourceKey<Biome> VERDANT_GROVE = createKey("verdant_grove");
    public static final ResourceKey<Biome> SHADOW_FOLD = createKey("shadow_fold");

    private static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, name));
    }

    /**
     * Bootstraps the biome data for datagen.
     */
    public static void bootstrap(BootstrapContext<Biome> context) {
        context.register(VANILLA_BIOME, createEndBiome(context, 0x080808, 0x050505, 0.5F, 0.5F));
        context.register(GILDED_RIDGE, createEndBiome(context, 0x181410, 0x1A1808, 0.5F, 0.0F));
        context.register(PRISM_PEAK, createEndBiome(context, 0x181828, 0x1A1828, 0.4F, 0.3F));
        context.register(SPORELIGHT_HOLLOW, createEndBiome(context, 0x102810, 0x081808, 0.6F, 0.8F));
        context.register(VERDANT_GROVE, createEndBiome(context, 0x081808, 0x081808, 0.7F, 0.9F));
        context.register(SHADOW_FOLD, createEndBiome(context, 0x050505, 0x030303, 0.3F, 0.5F));
    }

    /**
     * Creates a basic End biome with specified colors.
     */
    private static Biome createEndBiome(BootstrapContext<Biome> ctx, int skyColor, int fogColor, float temp, float downfall) {
        BiomeGenerationSettings.Builder generation = new BiomeGenerationSettings.Builder(
                ctx.lookup(Registries.PLACED_FEATURE),
                ctx.lookup(Registries.CONFIGURED_CARVER)
        );

        BiomeSpecialEffects.Builder effects = new BiomeSpecialEffects.Builder()
                .skyColor(skyColor)
                .fogColor(fogColor)
                .waterColor(0x3F76E4)
                .waterFogColor(0x050533)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.END);

        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();

        // Add Enderman spawns to all End biomes
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(
                EntityType.ENDERMAN, 10, 1, 4
        ));

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(temp)
                .downfall(downfall)
                .specialEffects(effects.build())
                .mobSpawnSettings(spawns.build())
                .generationSettings(generation.build())
                .build();
    }

    public static void register() {
        // Registration handled by deferred register and datagen
    }
}
