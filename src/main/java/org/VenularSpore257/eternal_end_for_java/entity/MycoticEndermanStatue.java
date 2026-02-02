package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Mycotic Enderman Statue - Mycotic variant statue.
 */
public class MycoticEndermanStatue extends EndermanStatue {

    public MycoticEndermanStatue(EntityType<? extends MycoticEndermanStatue> type, Level level) {
        super(type, level);
    }

    public MycoticEndermanStatue(EntityType<? extends MycoticEndermanStatue> type, double x, double y, double z, Level level) {
        super(type, x, y, z, level);
    }
}
