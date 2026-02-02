package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Winged Enderman Statue - Winged variant statue.
 */
public class WingedEndermanStatue extends EndermanStatue {

    public WingedEndermanStatue(EntityType<? extends WingedEndermanStatue> type, Level level) {
        super(type, level);
    }

    public WingedEndermanStatue(EntityType<? extends WingedEndermanStatue> type, double x, double y, double z, Level level) {
        super(type, x, y, z, level);
    }
}
