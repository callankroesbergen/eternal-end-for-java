package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.EndermanStatue;
import software.bernie.geckolib.model.GeoModel;

public class EndermanStatueGeoModel extends GeoModel<EndermanStatue> {
    @Override
    public ResourceLocation getModelResource(EndermanStatue animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/enderman.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(EndermanStatue animatable) {
        String state = animatable.isActive() ? "active" : "inactive";
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/statue/enderman_statue/" + state + ".png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(EndermanStatue animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/enderman_statue.animation.json"
        );
    }
}
