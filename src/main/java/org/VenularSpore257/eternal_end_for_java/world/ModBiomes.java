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
 * 17 unique End biomes converted from Bedrock addon.
 */
public class ModBiomes {

    // ===== GILDED BIOMES =====
    public static final ResourceKey<Biome> GILDED_FIELDS = createKey("gilded_fields");
    public static final ResourceKey<Biome> GILDED_RIDGE = createKey("gilded_ridge");
    public static final ResourceKey<Biome> GILDED_WOODS = createKey("gilded_woods");

    // ===== NORMAL BIOMES =====
    public static final ResourceKey<Biome> NORMAL_FOREST = createKey("normal_forest");
    public static final ResourceKey<Biome> NORMAL_WASTELAND = createKey("normal_wasteland");

    // ===== PRISM BIOMES =====
    public static final ResourceKey<Biome> PRISM_DEFAULT = createKey("prism_default");
    public static final ResourceKey<Biome> PRISM_FOREST = createKey("prism_forest");
    public static final ResourceKey<Biome> PRISM_PEAKS = createKey("prism_peaks");
    public static final ResourceKey<Biome> PRISM_PILLARS = createKey("prism_pillars");
    public static final ResourceKey<Biome> PRISM_PONDS = createKey("prism_ponds");

    // ===== SHADOW BIOME =====
    public static final ResourceKey<Biome> SHADOW_FOLD = createKey("shadow_fold");

    // ===== SPORELIGHT BIOMES =====
    public static final ResourceKey<Biome> SPORELIGHT_FUNGAL_FOREST = createKey("sporelight_fungal_forest");
    public static final ResourceKey<Biome> SPORELIGHT_MIXED_FOREST = createKey("sporelight_mixed_forest");
    public static final ResourceKey<Biome> SPORELIGHT_SPORED_FOREST = createKey("sporelight_spored_forest");
    public static final ResourceKey<Biome> SPORELIGHT_VOID_ISLANDS = createKey("sporelight_void_islands");

    // ===== VERDANT BIOMES =====
    public static final ResourceKey<Biome> VERDANT_GLADE = createKey("verdant_glade");
    public static final ResourceKey<Biome> VERDANT_GROVE = createKey("verdant_grove");
    public static final ResourceKey<Biome> VERDANT_SPIKE_ISLANDS = createKey("verdant_spike_islands");

    private static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, name));
    }

    /**
     * Bootstraps all 17 biomes for the Eternal End dimension.
     */
    public static void bootstrap(BootstrapContext<Biome> context) {
        // GILDED BIOMES - Golden/warm tones
        context.register(GILDED_FIELDS, createEndBiome(context, 0x2A2818, 0x2A2518, 0.6F, 0.3F));
        context.register(GILDED_RIDGE, createEndBiome(context, 0x181410, 0x1A1808, 0.5F, 0.0F));
        context.register(GILDED_WOODS, createEndBiome(context, 0x222018, 0x241C10, 0.55F, 0.4F));

        // NORMAL BIOMES - Standard End colors
        context.register(NORMAL_FOREST, createEndBiome(context, 0x080808, 0x050505, 0.5F, 0.5F));
        context.register(NORMAL_WASTELAND, createEndBiome(context, 0x0A0A0A, 0x070707, 0.4F, 0.2F));

        // PRISM BIOMES - Crystal/cold purple-blue tones
        context.register(PRISM_DEFAULT, createEndBiome(context, 0x181828, 0x1A1820, 0.45F, 0.35F));
        context.register(PRISM_FOREST, createEndBiome(context, 0x202030, 0x222028, 0.5F, 0.4F));
        context.register(PRISM_PEAKS, createEndBiome(context, 0x181828, 0x1A1828, 0.4F, 0.3F));
        context.register(PRISM_PILLARS, createEndBiome(context, 0x202535, 0x222228, 0.42F, 0.32F));
        context.register(PRISM_PONDS, createEndBiome(context, 0x1A1A2A, 0x1C1A22, 0.48F, 0.6F));

        // SHADOW BIOME - Dark/mysterious
        context.register(SHADOW_FOLD, createEndBiome(context, 0x050505, 0x030303, 0.3F, 0.5F));

        // SPORELIGHT BIOMES - Fungal/green tones
        context.register(SPORELIGHT_FUNGAL_FOREST, createEndBiome(context, 0x102810, 0x081808, 0.6F, 0.8F));
        context.register(SPORELIGHT_MIXED_FOREST, createEndBiome(context, 0x182018, 0x101810, 0.58F, 0.7F));
        context.register(SPORELIGHT_SPORED_FOREST, createEndBiome(context, 0x202818, 0x182018, 0.62F, 0.75F));
        context.register(SPORELIGHT_VOID_ISLANDS, createEndBiome(context, 0x081008, 0x080808, 0.5F, 0.5F));

        // VERDANT BIOMES - Lush/green tones
        context.register(VERDANT_GLADE, createEndBiome(context, 0x081808, 0x081808, 0.7F, 0.9F));
        context.register(VERDANT_GROVE, createEndBiome(context, 0x081808, 0x081808, 0.7F, 0.9F));
        context.register(VERDANT_SPIKE_ISLANDS, createEndBiome(context, 0x101810, 0x081008, 0.65F, 0.7F));
    }

    /**
     * Creates a basic End biome with specified colors and climate.
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

        // Base Enderman spawns for all End biomes
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

    /**
     * Get all biome resource keys for registration.
     */
    public static ResourceKey<Biome>[] getAllBiomes() {
        return new ResourceKey[]{
                GILDED_FIELDS, GILDED_RIDGE, GILDED_WOODS,
                NORMAL_FOREST, NORMAL_WASTELAND,
                PRISM_DEFAULT, PRISM_FOREST, PRISM_PEAKS, PRISM_PILLARS, PRISM_PONDS,
                SHADOW_FOLD,
                SPORELIGHT_FUNGAL_FOREST, SPORELIGHT_MIXED_FOREST, SPORELIGHT_SPORED_FOREST, SPORELIGHT_VOID_ISLANDS,
                VERDANT_GLADE, VERDANT_GROVE, VERDANT_SPIKE_ISLANDS
        };
    }

    public static void register() {
        // Registration handled by deferred register and datagen
    }
}
