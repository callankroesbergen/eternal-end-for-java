package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.Frostling;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

/**
 * GeckoLib model for Frostling entity.
 * Loads the Bedrock-style geo.json model.
 */
public class FrostlingGeoModel extends GeoModel<Frostling> {

    @Override
    public ResourceLocation getModelResource(Frostling animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/frostling.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(Frostling animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/frostling.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(Frostling animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/frostling.animation.json"
        );
    }
}
