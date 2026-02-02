package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.Glowling;
import software.bernie.geckolib.model.GeoModel;

public class GlowlingGeoModel extends GeoModel<Glowling> {
    @Override
    public ResourceLocation getModelResource(Glowling animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/glowling.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(Glowling animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/glowling.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(Glowling animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/glowling.animation.json"
        );
    }
}
