package org.VenularSpore257.eternal_end_for_java.client.model;

import net.minecraft.resources.ResourceLocation;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;
import org.VenularSpore257.eternal_end_for_java.entity.projectile.WingedEndermanProjectile;
import software.bernie.geckolib.model.GeoModel;

public class WingedEndermanProjectileGeoModel extends GeoModel<WingedEndermanProjectile> {
    @Override
    public ResourceLocation getModelResource(WingedEndermanProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "geo/entity/winged_enderman_projectile.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(WingedEndermanProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "textures/entity/winged_enderman.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(WingedEndermanProjectile animatable) {
        return ResourceLocation.fromNamespaceAndPath(
            Eternal_end_for_java.MODID, "animations/entity/projectile.animation.json"
        );
    }
}
