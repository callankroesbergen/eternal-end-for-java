package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/**
 * Renderer for invisible utility/metadata entities.
 * Used for: VoidDragonMarker, StepEntity, PlayerUtility, DummyDifficulty,
 * EndPortalParticle, EnderCrystalParticle
 */
public class InvisibleEntityRenderer extends EntityRenderer<net.minecraft.world.entity.Entity> {

    public InvisibleEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull net.minecraft.world.entity.Entity entity) {
        // Return empty texture - entity should not be visible
        return ResourceLocation.withDefaultNamespace("textures/entity/empty.png");
    }
}
