package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.VoidEye;
import software.bernie.geckolib.model.GeoModel;

public class VoidEyeGeoModel extends GeoModel<VoidEye> {
    @Override
    public ResourceLocation getModelResource(VoidEye animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/void_eye.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(VoidEye animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/void_eye.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(VoidEye animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/void_eye.animation.json"
        );
    }
}
