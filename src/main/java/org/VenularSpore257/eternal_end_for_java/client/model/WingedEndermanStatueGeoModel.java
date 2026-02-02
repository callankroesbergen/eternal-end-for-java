package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.WingedEndermanStatue;
import software.bernie.geckolib.model.GeoModel;

public class WingedEndermanStatueGeoModel extends GeoModel<WingedEndermanStatue> {
    @Override
    public ResourceLocation getModelResource(WingedEndermanStatue animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/winged_enderman.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(WingedEndermanStatue animatable) {
        String state = animatable.isActive() ? "active" : "inactive";
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/statue/winged/" + state + ".png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(WingedEndermanStatue animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/winged_enderman_statue.animation.json"
        );
    }
}
