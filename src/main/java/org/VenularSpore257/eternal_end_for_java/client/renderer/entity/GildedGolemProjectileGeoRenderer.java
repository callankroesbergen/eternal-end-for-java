package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.GildedGolemProjectileGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.projectile.GildedGolemProjectile;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GildedGolemProjectileGeoRenderer extends GeoEntityRenderer<GildedGolemProjectile> {
    public GildedGolemProjectileGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new GildedGolemProjectileGeoModel());
    }
}
