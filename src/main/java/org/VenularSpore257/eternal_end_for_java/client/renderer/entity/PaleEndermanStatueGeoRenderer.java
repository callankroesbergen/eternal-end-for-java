package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.PaleEndermanStatueGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.PaleEndermanStatue;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PaleEndermanStatueGeoRenderer extends GeoEntityRenderer<PaleEndermanStatue> {
    public PaleEndermanStatueGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new PaleEndermanStatueGeoModel());
    }
}
