package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Mossy Enderman Statue - Mossy variant statue.
 */
public class MossyEndermanStatue extends EndermanStatue {

    public MossyEndermanStatue(EntityType<? extends MossyEndermanStatue> type, Level level) {
        super(type, level);
    }

    public MossyEndermanStatue(EntityType<? extends MossyEndermanStatue> type, double x, double y, double z, Level level) {
        super(type, x, y, z, level);
    }
}
