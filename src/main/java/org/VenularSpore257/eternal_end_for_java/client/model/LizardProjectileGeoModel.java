package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.projectile.LizardProjectile;
import software.bernie.geckolib.model.GeoModel;

public class LizardProjectileGeoModel extends GeoModel<LizardProjectile> {
    @Override
    public ResourceLocation getModelResource(LizardProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/lizard_projectile.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(LizardProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/lizard_projectile.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(LizardProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/projectile.animation.json"
        );
    }
}
