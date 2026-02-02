package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.projectile.GildedGolemProjectile;
import software.bernie.geckolib.model.GeoModel;

public class GildedGolemProjectileGeoModel extends GeoModel<GildedGolemProjectile> {
    @Override
    public ResourceLocation getModelResource(GildedGolemProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/golem_projectile.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(GildedGolemProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/gilded_golem.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(GildedGolemProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/projectile.animation.json"
        );
    }
}
