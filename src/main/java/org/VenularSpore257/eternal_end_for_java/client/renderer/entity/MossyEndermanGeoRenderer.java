package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.MossyEndermanGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.MossyEnderman;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MossyEndermanGeoRenderer extends GeoEntityRenderer<MossyEnderman> {
    public MossyEndermanGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new MossyEndermanGeoModel());
    }
}
