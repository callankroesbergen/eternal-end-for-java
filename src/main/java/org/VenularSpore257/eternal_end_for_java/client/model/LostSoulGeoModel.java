package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.LostSoul;
import software.bernie.geckolib.model.GeoModel;

public class LostSoulGeoModel extends GeoModel<LostSoul> {
    @Override
    public ResourceLocation getModelResource(LostSoul animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/lost_soul.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(LostSoul animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/lost_soul.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(LostSoul animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/lost_soul.animation.json"
        );
    }
}
