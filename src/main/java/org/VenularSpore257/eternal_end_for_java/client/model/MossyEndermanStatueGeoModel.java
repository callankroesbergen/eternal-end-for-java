package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.MossyEndermanStatue;
import software.bernie.geckolib.model.GeoModel;

public class MossyEndermanStatueGeoModel extends GeoModel<MossyEndermanStatue> {
    @Override
    public ResourceLocation getModelResource(MossyEndermanStatue animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/mossy_enderman.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(MossyEndermanStatue animatable) {
        String state = animatable.isActive() ? "active" : "inactive";
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/statue/mossy/" + state + ".png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(MossyEndermanStatue animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/enderman_statue.animation.json"
        );
    }
}
