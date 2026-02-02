package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.Mistling;
import software.bernie.geckolib.model.GeoModel;

public class MistlingGeoModel extends GeoModel<Mistling> {
    @Override
    public ResourceLocation getModelResource(Mistling animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/mistling.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(Mistling animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/mistling.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(Mistling animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/mistling.animation.json"
        );
    }
}
