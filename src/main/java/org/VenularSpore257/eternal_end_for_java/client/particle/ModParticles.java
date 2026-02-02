package org.VenularSpore257.eternal_end_for_java.client.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;

/**
 * Registry for all Eternal End custom particles.
 * Particles add visual flair to blocks, entities, and events.
 *
 * Categories:
 * - Portal Particles: Custom end portal effects
 * - Block Particles: Break/place effects for custom blocks
 * - Entity Particles: Trails, auras, and effects
 * - Ambient Particles: Biome atmosphere effects
 */
public class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLES =
        DeferredRegister.create(Registries.PARTICLE_TYPE, Eternal_end_for_java.MODID);

    // ========== Void Dragon Particles ==========
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> VOID_DRAGON_BREATH = register("void_dragon_breath");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> VOID_DRAGON_FLAME = register("void_dragon_flame");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> VOID_DRAGON_SPARKLE = register("void_dragon_sparkle");

    // ========== Portal/Teleportation Particles ==========
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> VOID_PORTAL = register("void_portal");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ETERNAL_PORTAL = register("eternal_portal");

    // ========== Enderman Variant Particles ==========
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PALE_ENDERMAN_PORTAL = register("pale_enderman_portal");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MOSSY_ENDERMAN_SPORE = register("mossy_enderman_spore");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GILDED_ENDERMAN_GLINT = register("gilded_enderman_glint");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MYCOTIC_ENDERMAN_SPORE = register("mycotic_enderman_spore");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> WINGED_ENDERMAN_WING = register("winged_enderman_wing");

    // ========== Biome Ambient Particles ==========
    // Sporelight (purple/blue spores floating)
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPORELIGHT_SPORE = register("sporelight_spore");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPORELIGHT_GLOW = register("sporelight_glow");

    // Verdant (green nature particles)
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> VERDANT_LEAF = register("verdant_leaf");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> VERDANT_SPORE = register("verdant_spore");

    // Gilded (golden shimmer particles)
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GILDED_SHIMMER = register("gilded_shimmer");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GILDED_SPARKLE = register("gilded_sparkle");

    // Prism (rainbow refraction particles)
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PRISM_REFRACTION = register("prism_refraction");

    // Shadow (dark wispy particles)
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SHADOW_WISP = register("shadow_wisp");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SHADOW_SMOKE = register("shadow_smoke");

    // ========== Block Particles ==========
    // Chorus wood particles
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CHORUS_FLOWER_PETAL = register("chorus_flower_petal");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CHORUS_SAP = register("chorus_sap");

    // Cryolite ice particles
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CRYOLITE_SHARD = register("cryolite_shard");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CRYOLITE_DUST = register("cryolite_dust");

    // Ametrine particles
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> AMETRINE_SHARD = register("ametrine_shard");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> AMETRINE_SPARKLE = register("ametrine_sparkle");

    // Noctral particles (dark purple)
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> NOCTRAL_DUST = register("noctral_dust");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> NOCTRAL_WISP = register("noctral_wisp");

    // ========== Entity Effect Particles ==========
    // Lost soul trail
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LOST_SOUL_TRAIL = register("lost_soul_trail");

    // Voidling essence
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> VOIDLING_ESSENCE = register("voidling_essence");

    // Glowling glow
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GLOWLING_GLOW = register("glowling_glow");

    // Mistling mist
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MISTLING_MIST = register("mistling_mist");

    // Frostling frost
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FROSTLING_FROST = register("frostling_frost");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FROSTLING_SNOWFLAKE = register("frostling_snowflake");

    // ========== Special Effect Particles ==========
    // Void totem activation
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> VOID_TOTEM_ACTIVATE = register("void_totem_activate");

    // Gateway activation
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> VOID_GATEWAY_ACTIVATE = register("void_gateway_activate");

    // Boss summoning particles
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BOSS_SUMMON = register("boss_summon");

    // Teleportation effect
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ETERNAL_TELEPORT = register("eternal_teleport");

    /**
     * Helper method to register a simple particle type.
     * @param name The particle type name (without namespace)
     * @return A DeferredHolder for the particle type
     */
    private static DeferredHolder<ParticleType<?>, SimpleParticleType> register(String name) {
        return PARTICLES.register(name, () -> new SimpleParticleType(true));
    }

    /**
     * Register all particles with the mod event bus.
     * Call this from the main mod class.
     */
    public static void register(IEventBus modEventBus) {
        PARTICLES.register(modEventBus);
    }
}
