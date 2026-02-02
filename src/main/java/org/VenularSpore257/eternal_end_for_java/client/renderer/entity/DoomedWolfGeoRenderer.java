package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.DoomedWolfGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.DoomedWolf;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DoomedWolfGeoRenderer extends GeoEntityRenderer<DoomedWolf> {
    public DoomedWolfGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new DoomedWolfGeoModel());
    }
}
