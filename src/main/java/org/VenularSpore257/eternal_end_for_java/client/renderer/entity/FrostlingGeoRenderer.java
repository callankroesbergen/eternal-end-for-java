package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.FrostlingGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.Frostling;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

/**
 * GeckoLib renderer for Frostling entity.
 * Loads Bedrock-style geo.json model and animations.
 */
public class FrostlingGeoRenderer extends GeoEntityRenderer<Frostling> {

    public FrostlingGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new FrostlingGeoModel());
    }
}
