package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

/**
 * Mycotic Enderman - A fungal, mushroom-covered variant of the Enderman.
 */
public class MycoticEnderman extends PaleEnderman {

    public MycoticEnderman(EntityType<? extends MycoticEnderman> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PaleEnderman.createAttributes()
                .add(Attributes.MAX_HEALTH, 45);
    }
}
