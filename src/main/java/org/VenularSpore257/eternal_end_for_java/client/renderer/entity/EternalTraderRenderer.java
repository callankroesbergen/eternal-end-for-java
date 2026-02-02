package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.Villager;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;

/**
 * Renderer for Eternal Trader - uses custom End-dimension merchant texture.
 */
public class EternalTraderRenderer extends VillagerRenderer {
    private static final ResourceLocation TEXTURE =
        ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, "textures/entity/eternal_trader.png");

    public EternalTraderRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Villager villager) {
        return TEXTURE;
    }
}
