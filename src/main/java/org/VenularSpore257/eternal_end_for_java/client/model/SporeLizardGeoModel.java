package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.SporeLizard;
import software.bernie.geckolib.model.GeoModel;

public class SporeLizardGeoModel extends GeoModel<SporeLizard> {
    @Override
    public ResourceLocation getModelResource(SporeLizard animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/lizard.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(SporeLizard animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/spore_lizard.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(SporeLizard animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/spore_lizard.animation.json"
        );
    }
}
