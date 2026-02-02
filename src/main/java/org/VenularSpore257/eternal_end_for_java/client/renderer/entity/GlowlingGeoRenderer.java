package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.GlowlingGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.Glowling;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GlowlingGeoRenderer extends GeoEntityRenderer<Glowling> {
    public GlowlingGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new GlowlingGeoModel());
    }
}
