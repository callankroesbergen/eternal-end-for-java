package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.MycoticEndermanStatue;
import software.bernie.geckolib.model.GeoModel;

public class MycoticEndermanStatueGeoModel extends GeoModel<MycoticEndermanStatue> {
    @Override
    public ResourceLocation getModelResource(MycoticEndermanStatue animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/mycotic_enderman.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(MycoticEndermanStatue animatable) {
        String state = animatable.isActive() ? "active" : "inactive";
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/statue/mycotic/" + state + ".png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(MycoticEndermanStatue animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/enderman_statue.animation.json"
        );
    }
}
