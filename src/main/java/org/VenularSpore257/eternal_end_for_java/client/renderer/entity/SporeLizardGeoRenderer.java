package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.SporeLizardGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.SporeLizard;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SporeLizardGeoRenderer extends GeoEntityRenderer<SporeLizard> {
    public SporeLizardGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new SporeLizardGeoModel());
    }
}
