package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.GildedEndermanGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.GildedEnderman;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GildedEndermanGeoRenderer extends GeoEntityRenderer<GildedEnderman> {
    public GildedEndermanGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new GildedEndermanGeoModel());
    }
}
