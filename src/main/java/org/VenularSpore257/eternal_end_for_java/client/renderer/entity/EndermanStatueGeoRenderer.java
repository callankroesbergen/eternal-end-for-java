package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.EndermanStatueGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.EndermanStatue;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class EndermanStatueGeoRenderer extends GeoEntityRenderer<EndermanStatue> {
    public EndermanStatueGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new EndermanStatueGeoModel());
    }
}
