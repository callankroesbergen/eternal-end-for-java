package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.projectile.SporeLizardProjectile;
import software.bernie.geckolib.model.GeoModel;

public class SporeLizardProjectileGeoModel extends GeoModel<SporeLizardProjectile> {
    @Override
    public ResourceLocation getModelResource(SporeLizardProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/lizard_projectile.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(SporeLizardProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/lizard_projectile.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(SporeLizardProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/projectile.animation.json"
        );
    }
}
