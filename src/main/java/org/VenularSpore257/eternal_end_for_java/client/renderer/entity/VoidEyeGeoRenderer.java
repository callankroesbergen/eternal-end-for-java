package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.VoidEyeGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.VoidEye;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class VoidEyeGeoRenderer extends GeoEntityRenderer<VoidEye> {
    public VoidEyeGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new VoidEyeGeoModel());
    }
}
