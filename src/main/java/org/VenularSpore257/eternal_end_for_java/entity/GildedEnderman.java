package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

/**
 * Gilded Enderman - A golden variant of the Enderman.
 */
public class GildedEnderman extends PaleEnderman {

    public GildedEnderman(EntityType<? extends GildedEnderman> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PaleEnderman.createAttributes()
                .add(Attributes.MAX_HEALTH, 50);
    }
}
