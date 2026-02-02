package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.Nybling;
import software.bernie.geckolib.model.GeoModel;

public class NyblingGeoModel extends GeoModel<Nybling> {
    @Override
    public ResourceLocation getModelResource(Nybling animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/nybling.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(Nybling animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/nybling.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(Nybling animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/nybling.animation.json"
        );
    }
}
