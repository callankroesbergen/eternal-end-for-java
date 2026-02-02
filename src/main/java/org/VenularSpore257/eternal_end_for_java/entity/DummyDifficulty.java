package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Dummy Difficulty - Utility entity for difficulty tracking.
 */
public class DummyDifficulty extends Entity {

    public DummyDifficulty(EntityType<? extends DummyDifficulty> type, Level level) {
        super(type, level);
    }

    public DummyDifficulty(EntityType<? extends DummyDifficulty> type, double x, double y, double z, Level level) {
        super(type, level);
        this.moveTo(x, y, z);
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
