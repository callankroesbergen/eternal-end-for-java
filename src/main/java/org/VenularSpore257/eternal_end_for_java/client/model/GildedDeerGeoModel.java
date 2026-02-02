package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.GildedDeer;
import software.bernie.geckolib.model.GeoModel;

public class GildedDeerGeoModel extends GeoModel<GildedDeer> {
    @Override
    public ResourceLocation getModelResource(GildedDeer animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/gilded_deer.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(GildedDeer animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/gilded_deer.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(GildedDeer animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/gilded_deer.animation.json"
        );
    }
}
