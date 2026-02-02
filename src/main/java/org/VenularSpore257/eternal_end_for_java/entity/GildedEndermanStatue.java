package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Gilded Enderman Statue - Gilded variant statue.
 */
public class GildedEndermanStatue extends EndermanStatue {

    public GildedEndermanStatue(EntityType<? extends GildedEndermanStatue> type, Level level) {
        super(type, level);
    }

    public GildedEndermanStatue(EntityType<? extends GildedEndermanStatue> type, double x, double y, double z, Level level) {
        super(type, x, y, z, level);
    }
}
