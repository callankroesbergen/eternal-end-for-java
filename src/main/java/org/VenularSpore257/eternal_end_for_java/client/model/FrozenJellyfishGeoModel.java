package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.FrozenJellyfish;
import software.bernie.geckolib.model.GeoModel;

public class FrozenJellyfishGeoModel extends GeoModel<FrozenJellyfish> {
    @Override
    public ResourceLocation getModelResource(FrozenJellyfish animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/frozen_jellyfish.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(FrozenJellyfish animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/frozen_jellyfish.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(FrozenJellyfish animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/frozen_jellyfish.animation.json"
        );
    }
}
