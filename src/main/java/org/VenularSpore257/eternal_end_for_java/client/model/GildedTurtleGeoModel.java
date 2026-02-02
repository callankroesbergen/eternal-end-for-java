package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.GildedTurtle;
import software.bernie.geckolib.model.GeoModel;

public class GildedTurtleGeoModel extends GeoModel<GildedTurtle> {
    @Override
    public ResourceLocation getModelResource(GildedTurtle animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/gilded_turtle.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(GildedTurtle animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/gilded_turtle.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(GildedTurtle animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/gilded_turtle.animation.json"
        );
    }
}
