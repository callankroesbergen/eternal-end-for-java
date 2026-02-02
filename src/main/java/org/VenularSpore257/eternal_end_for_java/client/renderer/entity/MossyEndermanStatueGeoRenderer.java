package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.MossyEndermanStatueGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.MossyEndermanStatue;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MossyEndermanStatueGeoRenderer extends GeoEntityRenderer<MossyEndermanStatue> {
    public MossyEndermanStatueGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new MossyEndermanStatueGeoModel());
    }
}
