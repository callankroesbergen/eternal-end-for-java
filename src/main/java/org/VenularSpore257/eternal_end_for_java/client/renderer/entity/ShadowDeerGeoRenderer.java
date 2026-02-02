package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.ShadowDeerGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.ShadowDeer;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ShadowDeerGeoRenderer extends GeoEntityRenderer<ShadowDeer> {
    public ShadowDeerGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new ShadowDeerGeoModel());
    }
}
