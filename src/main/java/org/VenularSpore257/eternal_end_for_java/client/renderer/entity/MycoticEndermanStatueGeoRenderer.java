package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.MycoticEndermanStatueGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.MycoticEndermanStatue;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MycoticEndermanStatueGeoRenderer extends GeoEntityRenderer<MycoticEndermanStatue> {
    public MycoticEndermanStatueGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new MycoticEndermanStatueGeoModel());
    }
}
