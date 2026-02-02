package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.WingedEndermanStatueGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.WingedEndermanStatue;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WingedEndermanStatueGeoRenderer extends GeoEntityRenderer<WingedEndermanStatue> {
    public WingedEndermanStatueGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new WingedEndermanStatueGeoModel());
    }
}
