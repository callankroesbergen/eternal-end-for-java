package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.WingedEnderman;
import software.bernie.geckolib.model.GeoModel;

public class WingedEndermanGeoModel extends GeoModel<WingedEnderman> {
    @Override
    public ResourceLocation getModelResource(WingedEnderman animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/winged_enderman.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(WingedEnderman animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/winged_enderman.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(WingedEnderman animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/winged_enderman.animation.json"
        );
    }
}
