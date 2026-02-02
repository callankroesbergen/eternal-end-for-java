package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.GildedDeerGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.GildedDeer;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GildedDeerGeoRenderer extends GeoEntityRenderer<GildedDeer> {
    public GildedDeerGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new GildedDeerGeoModel());
    }
}
