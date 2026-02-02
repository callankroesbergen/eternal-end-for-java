package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.MycoticEndermanGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.MycoticEnderman;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MycoticEndermanGeoRenderer extends GeoEntityRenderer<MycoticEnderman> {
    public MycoticEndermanGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new MycoticEndermanGeoModel());
    }
}
