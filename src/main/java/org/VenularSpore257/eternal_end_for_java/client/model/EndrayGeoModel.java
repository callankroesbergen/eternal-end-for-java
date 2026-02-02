package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.Endray;
import software.bernie.geckolib.model.GeoModel;

public class EndrayGeoModel extends GeoModel<Endray> {
    @Override
    public ResourceLocation getModelResource(Endray animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/endray.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(Endray animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/endray.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(Endray animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/endray.animation.json"
        );
    }
}
