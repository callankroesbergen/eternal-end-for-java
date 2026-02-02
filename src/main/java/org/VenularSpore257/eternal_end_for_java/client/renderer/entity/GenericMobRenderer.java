package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;

/**
 * Generic renderer for living entities using the humanoid model.
 * This is a placeholder renderer that allows entities to be visible in-game.
 * Custom models can be created later by replacing the model class.
 *
 * @param <T> The entity type
 */
public class GenericMobRenderer<T extends Mob> extends MobRenderer<T, HumanoidModel<T>> {

    private final ResourceLocation texture;

    /**
     * Create a generic mob renderer.
     *
     * @param context The renderer context
     * @param textureName The name of the texture file (e.g., "frostling.png")
     */
    @SuppressWarnings("unchecked")
    public GenericMobRenderer(EntityRendererProvider.Context context, String textureName) {
        super(context, new HumanoidModel<>(context.bakeLayer(net.minecraft.client.model.geom.ModelLayers.PLAYER)), 0.5f);
        this.texture = ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, "textures/entity/" + textureName);
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return texture;
    }
}
