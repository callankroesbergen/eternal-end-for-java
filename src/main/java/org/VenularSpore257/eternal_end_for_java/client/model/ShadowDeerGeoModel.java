package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.ShadowDeer;
import software.bernie.geckolib.model.GeoModel;

public class ShadowDeerGeoModel extends GeoModel<ShadowDeer> {
    @Override
    public ResourceLocation getModelResource(ShadowDeer animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/gilded_deer.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(ShadowDeer animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/shadow_deer.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(ShadowDeer animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/gilded_deer.animation.json"
        );
    }
}
