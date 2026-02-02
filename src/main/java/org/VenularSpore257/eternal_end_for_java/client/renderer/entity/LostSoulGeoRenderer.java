package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.LostSoulGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.LostSoul;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LostSoulGeoRenderer extends GeoEntityRenderer<LostSoul> {
    public LostSoulGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new LostSoulGeoModel());
    }
}
