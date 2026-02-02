package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.projectile.ThrowableProjectile;

/**
 * Generic renderer for projectile entities.
 * Uses vanilla's ThrownItemRenderer for simple item-based projectiles.
 */
public class GenericProjectileRenderer extends ThrownItemRenderer {

    public GenericProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
    }
}
