package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.VoidDragon;
import software.bernie.geckolib.model.GeoModel;

public class VoidDragonGeoModel extends GeoModel<VoidDragon> {
    @Override
    public ResourceLocation getModelResource(VoidDragon animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/void_dragon.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(VoidDragon animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/void_dragon.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(VoidDragon animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/void_dragon.animation.json"
        );
    }
}
