package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.VerdantLizardGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.VerdantLizard;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class VerdantLizardGeoRenderer extends GeoEntityRenderer<VerdantLizard> {
    public VerdantLizardGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new VerdantLizardGeoModel());
    }
}
