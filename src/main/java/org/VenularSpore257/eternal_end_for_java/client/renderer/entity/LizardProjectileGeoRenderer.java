package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.LizardProjectileGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.projectile.LizardProjectile;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LizardProjectileGeoRenderer extends GeoEntityRenderer<LizardProjectile> {
    public LizardProjectileGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new LizardProjectileGeoModel());
    }
}
