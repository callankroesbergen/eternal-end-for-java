package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.VoidDragonGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.VoidDragon;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class VoidDragonGeoRenderer extends GeoEntityRenderer<VoidDragon> {
    public VoidDragonGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new VoidDragonGeoModel());
    }
}
