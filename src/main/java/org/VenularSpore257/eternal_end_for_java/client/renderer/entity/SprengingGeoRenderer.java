package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.SprengingGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.Sprenging;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SprengingGeoRenderer extends GeoEntityRenderer<Sprenging> {
    public SprengingGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new SprengingGeoModel());
    }
}
