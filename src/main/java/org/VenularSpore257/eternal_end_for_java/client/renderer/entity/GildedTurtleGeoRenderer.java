package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.GildedTurtleGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.GildedTurtle;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GildedTurtleGeoRenderer extends GeoEntityRenderer<GildedTurtle> {
    public GildedTurtleGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new GildedTurtleGeoModel());
    }
}
