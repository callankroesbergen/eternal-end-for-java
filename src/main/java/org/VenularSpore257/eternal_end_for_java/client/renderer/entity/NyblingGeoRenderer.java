package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.NyblingGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.Nybling;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class NyblingGeoRenderer extends GeoEntityRenderer<Nybling> {
    public NyblingGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new NyblingGeoModel());
    }
}
