package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.PaleEndermanGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.*;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PaleEndermanGeoRenderer extends GeoEntityRenderer<PaleEnderman> {
    public PaleEndermanGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new PaleEndermanGeoModel());
    }
}
