package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.VerdantLizard;
import software.bernie.geckolib.model.GeoModel;

public class VerdantLizardGeoModel extends GeoModel<VerdantLizard> {
    @Override
    public ResourceLocation getModelResource(VerdantLizard animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/lizard.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(VerdantLizard animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/verdant_lizard.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(VerdantLizard animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/spore_lizard.animation.json"
        );
    }
}
