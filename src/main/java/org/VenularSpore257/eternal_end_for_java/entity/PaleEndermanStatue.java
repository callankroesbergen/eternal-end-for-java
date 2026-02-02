package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Pale Enderman Statue - Pale variant statue.
 */
public class PaleEndermanStatue extends EndermanStatue {

    public PaleEndermanStatue(EntityType<? extends PaleEndermanStatue> type, Level level) {
        super(type, level);
    }

    public PaleEndermanStatue(EntityType<? extends PaleEndermanStatue> type, double x, double y, double z, Level level) {
        super(type, x, y, z, level);
    }
}
