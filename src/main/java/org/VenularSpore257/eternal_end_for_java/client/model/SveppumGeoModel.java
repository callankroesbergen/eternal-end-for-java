package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.Sveppum;
import software.bernie.geckolib.model.GeoModel;

public class SveppumGeoModel extends GeoModel<Sveppum> {
    @Override
    public ResourceLocation getModelResource(Sveppum animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/sveppum.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(Sveppum animatable) {
        int variant = animatable.getTextureVariant();
        String state = animatable.isAggressive() ? "aggressive" : "passive";
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/sveppum/" + state + "_" + variant + ".png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(Sveppum animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/sveppum.animation.json"
        );
    }
}
