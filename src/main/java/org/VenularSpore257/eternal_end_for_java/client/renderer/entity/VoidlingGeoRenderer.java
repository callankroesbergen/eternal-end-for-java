package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.VoidlingGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.Voidling;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class VoidlingGeoRenderer extends GeoEntityRenderer<Voidling> {
    public VoidlingGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new VoidlingGeoModel());
    }
}
