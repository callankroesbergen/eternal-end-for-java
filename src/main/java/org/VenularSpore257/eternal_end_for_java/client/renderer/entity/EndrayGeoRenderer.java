package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.EndrayGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.Endray;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class EndrayGeoRenderer extends GeoEntityRenderer<Endray> {
    public EndrayGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new EndrayGeoModel());
    }
}
