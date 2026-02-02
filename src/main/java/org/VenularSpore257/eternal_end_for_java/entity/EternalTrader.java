package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.level.Level;

/**
 * Eternal Trader - A wandering merchant from the End.
 */
public class EternalTrader extends Villager {

    public EternalTrader(EntityType<? extends EternalTrader> type, Level level) {
        super(type, level);
    }
}
