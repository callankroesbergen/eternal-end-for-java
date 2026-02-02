package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.GildedEndermanStatueGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.GildedEndermanStatue;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GildedEndermanStatueGeoRenderer extends GeoEntityRenderer<GildedEndermanStatue> {
    public GildedEndermanStatueGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new GildedEndermanStatueGeoModel());
    }
}
