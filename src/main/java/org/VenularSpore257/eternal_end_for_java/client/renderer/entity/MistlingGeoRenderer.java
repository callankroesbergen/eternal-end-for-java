package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.MistlingGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.Mistling;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MistlingGeoRenderer extends GeoEntityRenderer<Mistling> {
    public MistlingGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new MistlingGeoModel());
    }
}
