package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.Sprenging;
import software.bernie.geckolib.model.GeoModel;

public class SprengingGeoModel extends GeoModel<Sprenging> {
    @Override
    public ResourceLocation getModelResource(Sprenging animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/sprenging.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(Sprenging animatable) {
        int variant = animatable.getTextureVariant();
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/sprenging_" + variant + ".png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(Sprenging animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/sprenging.animation.json"
        );
    }
}
