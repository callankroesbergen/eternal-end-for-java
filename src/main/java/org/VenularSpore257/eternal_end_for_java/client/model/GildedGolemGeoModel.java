package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.GildedGolem;
import software.bernie.geckolib.model.GeoModel;

public class GildedGolemGeoModel extends GeoModel<GildedGolem> {
    @Override
    public ResourceLocation getModelResource(GildedGolem animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/gilded_golem.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(GildedGolem animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/gilded_golem.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(GildedGolem animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/gilded_golem.animation.json"
        );
    }
}
