package org.VenularSpore257.eternal_end_for_java.client;

import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.VenularSpore257.eternal_end_for_java.EternalEndEntities;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.DoomedWolfGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.EndrayGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.FrostlingGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.FrozenJellyfishGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.GildedDeerGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.GildedGolemGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.GildedTurtleGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.GlowlingGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.LostSoulGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.MistlingGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.MossyEndermanGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.MycoticEndermanGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.NyblingGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.PaleEndermanGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.GildedEndermanGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.ShadowDeerGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.SporeLizardGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.VerdantLizardGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.VoidEyeGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.VoidlingGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.WingedEndermanGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.EndermanStatueGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.PaleEndermanStatueGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.MossyEndermanStatueGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.GildedEndermanStatueGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.MycoticEndermanStatueGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.WingedEndermanStatueGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.LizardProjectileGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.SporeLizardProjectileGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.WingedEndermanProjectileGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.GildedGolemProjectileGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.GenericMobRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.GenericProjectileRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.SprengingGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.EternalTraderRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.NormalVillagerRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.PrismVillagerRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.SporeVillagerRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.GildedVillagerRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.ShadowVillagerRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.SveppumGeoRenderer;
import org.VenularSpore257.eternal_end_for_java.client.renderer.entity.VoidDragonGeoRenderer;

/**
 * Client-side renderer registration for all Eternal End entities.
 * Uses GenericMobRenderer for all living entities to avoid type compatibility issues.
 * Custom models and animations can be added incrementally.
 */
@EventBusSubscriber(value = Dist.CLIENT)
public class ModEntityRenderers {

    /**
     * Register entity renderers using NeoForge 1.21's EntityRenderersEvent.RegisterRenderers.
     */
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Boss Entity
        event.registerEntityRenderer(EternalEndEntities.VOID_DRAGON.get(), VoidDragonGeoRenderer::new);

        // Hostile Mobs
        event.registerEntityRenderer(EternalEndEntities.DOOMED_WOLF.get(), DoomedWolfGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.MISTLING.get(), MistlingGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.VOIDLING.get(), VoidlingGeoRenderer::new);

        // Ender Slime
        event.registerEntityRenderer(EternalEndEntities.ENDER_SLIME.get(), ctx -> new GenericMobRenderer<>(ctx, "ender_slime.png"));

        // Winged Enderman
        event.registerEntityRenderer(EternalEndEntities.WINGED_ENDERMAN.get(), WingedEndermanGeoRenderer::new);

        // Enderman Variants
        event.registerEntityRenderer(EternalEndEntities.PALE_ENDERMAN.get(), PaleEndermanGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.MOSSY_ENDERMAN.get(), MossyEndermanGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.GILDED_ENDERMAN.get(), GildedEndermanGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.MYCOTIC_ENDERMAN.get(), MycoticEndermanGeoRenderer::new);

        // Enderman Statues - Use GeoRenderers with statue models
        event.registerEntityRenderer(EternalEndEntities.ENDERMAN_STATUE.get(), EndermanStatueGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.PALE_ENDERMAN_STATUE.get(), PaleEndermanStatueGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.GILDED_ENDERMAN_STATUE.get(), GildedEndermanStatueGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.MOSSY_ENDERMAN_STATUE.get(), MossyEndermanStatueGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.MYCOTIC_ENDERMAN_STATUE.get(), MycoticEndermanStatueGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.WINGED_ENDERMAN_STATUE.get(), WingedEndermanStatueGeoRenderer::new);

        // Passive/Neutral Mobs
        event.registerEntityRenderer(EternalEndEntities.ENDRAY.get(), EndrayGeoRenderer::new);
        // GeckoLib renderers for Frostling, Glowling, Nybling
        event.registerEntityRenderer(EternalEndEntities.FROSTLING.get(), FrostlingGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.GLOWLING.get(), GlowlingGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.NYBLING.get(), NyblingGeoRenderer::new);

        // Deer
        event.registerEntityRenderer(EternalEndEntities.GILDED_DEER.get(), GildedDeerGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.SHADOW_DEER.get(), ShadowDeerGeoRenderer::new);

        // Aquatic
        event.registerEntityRenderer(EternalEndEntities.FROZEN_JELLYFISH.get(), FrozenJellyfishGeoRenderer::new);

        // Turtles
        event.registerEntityRenderer(EternalEndEntities.GILDED_TURTLE.get(), GildedTurtleGeoRenderer::new);

        // Lizards
        event.registerEntityRenderer(EternalEndEntities.SPORE_LIZARD.get(), SporeLizardGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.VERDANT_LIZARD.get(), VerdantLizardGeoRenderer::new);

        // Villagers - Use custom renderers with profession-specific textures
        event.registerEntityRenderer(EternalEndEntities.ETERNAL_TRADER.get(), EternalTraderRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.NORMAL_VILLAGER.get(), NormalVillagerRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.PRISM_VILLAGER.get(), PrismVillagerRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.SPORE_VILLAGER.get(), SporeVillagerRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.GILDED_VILLAGER.get(), GildedVillagerRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.SHADOW_VILLAGER.get(), ShadowVillagerRenderer::new);

        // Golems
        event.registerEntityRenderer(EternalEndEntities.GILDED_GOLEM.get(), GildedGolemGeoRenderer::new);

        // Special Mobs
        event.registerEntityRenderer(EternalEndEntities.LOST_SOUL.get(), LostSoulGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.SVEPPUM.get(), SveppumGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.SPRENGING.get(), SprengingGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.VOID_EYE.get(), VoidEyeGeoRenderer::new);

        // Projectiles - Use GeoRenderers
        event.registerEntityRenderer(EternalEndEntities.LIZARD_PROJECTILE.get(), LizardProjectileGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.WINGED_ENDERMAN_PROJECTILE.get(), WingedEndermanProjectileGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.SPORE_LIZARD_PROJECTILE.get(), SporeLizardProjectileGeoRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.GILDED_GOLEM_PROJECTILE.get(), GildedGolemProjectileGeoRenderer::new);

        // Utility/Metadata Entities - Use NoopRenderer (invisible)
        event.registerEntityRenderer(EternalEndEntities.VOID_DRAGON_MARKER.get(), NoopRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.STEP_ENTITY.get(), NoopRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.PLAYER_UTILITY.get(), NoopRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.DUMMY_DIFFICULTY.get(), NoopRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.END_PORTAL_PARTICLE.get(), NoopRenderer::new);
        event.registerEntityRenderer(EternalEndEntities.ENDER_CRYSTAL_PARTICLE.get(), NoopRenderer::new);
    }
}
