package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import software.bernie.geckolib.model.GeoModel;

public class GildedEndermanGeoModel extends GeoModel<org.VenularSpore257.eternal_end_for_java.entity.GildedEnderman> {
    @Override
    public ResourceLocation getModelResource(org.VenularSpore257.eternal_end_for_java.entity.GildedEnderman animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/pale_enderman.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(org.VenularSpore257.eternal_end_for_java.entity.GildedEnderman animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/gilded_enderman.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(org.VenularSpore257.eternal_end_for_java.entity.GildedEnderman animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/pale_enderman.animation.json"
        );
    }
}
