package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.GildedGolemGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.GildedGolem;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GildedGolemGeoRenderer extends GeoEntityRenderer<GildedGolem> {
    public GildedGolemGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new GildedGolemGeoModel());
    }
}
