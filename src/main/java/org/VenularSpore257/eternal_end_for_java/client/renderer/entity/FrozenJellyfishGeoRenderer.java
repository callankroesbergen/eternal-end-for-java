package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.VenularSpore257.eternal_end_for_java.client.model.FrozenJellyfishGeoModel;
import org.VenularSpore257.eternal_end_for_java.entity.FrozenJellyfish;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FrozenJellyfishGeoRenderer extends GeoEntityRenderer<FrozenJellyfish> {
    public FrozenJellyfishGeoRenderer(EntityRendererProvider.Context context) {
        super(context, new FrozenJellyfishGeoModel());
    }
}
