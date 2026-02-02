package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.WingedEndermanProjectileGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.projectile.WingedEndermanProjectile;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WingedEndermanProjectileGeoRenderer extends GeoEntityRenderer<WingedEndermanProjectile> {
    public WingedEndermanProjectileGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new WingedEndermanProjectileGeoModel());
    }
}
