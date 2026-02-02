package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.Voidling;
import software.bernie.geckolib.model.GeoModel;

public class VoidlingGeoModel extends GeoModel<Voidling> {
    @Override
    public ResourceLocation getModelResource(Voidling animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/voidling.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(Voidling animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/voidling.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(Voidling animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/voidling.animation.json"
        );
    }
}
