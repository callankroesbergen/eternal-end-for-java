package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Player Utility - Invisible utility entity attached to players.
 */
public class PlayerUtility extends Entity {

    public PlayerUtility(EntityType<? extends PlayerUtility> type, Level level) {
        super(type, level);
    }

    public PlayerUtility(EntityType<? extends PlayerUtility> type, Level level, double x, double y, double z) {
        this(type, level);
        this.setPos(x, y, z);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        // No data needed
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        // No data to read
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        // No data to save
    }
}
