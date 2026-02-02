package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.SveppumGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.Sveppum;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SveppumGeoRenderer extends GeoEntityRenderer<Sveppum> {
    public SveppumGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new SveppumGeoModel());
    }
}
