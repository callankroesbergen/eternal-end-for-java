package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.SporeLizardProjectileGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.projectile.SporeLizardProjectile;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SporeLizardProjectileGeoRenderer extends GeoEntityRenderer<SporeLizardProjectile> {
    public SporeLizardProjectileGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new SporeLizardProjectileGeoModel());
    }
}
