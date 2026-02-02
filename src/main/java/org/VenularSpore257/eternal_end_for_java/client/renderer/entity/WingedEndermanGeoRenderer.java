package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.WingedEndermanGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.WingedEnderman;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WingedEndermanGeoRenderer extends GeoEntityRenderer<WingedEnderman> {
    public WingedEndermanGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new WingedEndermanGeoModel());
    }
}
