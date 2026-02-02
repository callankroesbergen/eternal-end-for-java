package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.GildedEndermanStatue;
import software.bernie.geckolib.model.GeoModel;

public class GildedEndermanStatueGeoModel extends GeoModel<GildedEndermanStatue> {
    @Override
    public ResourceLocation getModelResource(GildedEndermanStatue animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/gilded_enderman.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(GildedEndermanStatue animatable) {
        String state = animatable.isActive() ? "active" : "inactive";
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/statue/gilded/" + state + ".png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(GildedEndermanStatue animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/enderman_statue.animation.json"
        );
    }
}
