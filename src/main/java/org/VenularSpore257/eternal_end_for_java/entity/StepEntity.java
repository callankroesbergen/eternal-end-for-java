package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Step Entity - Utility entity for stepping/teleportation effects.
 */
public class StepEntity extends Entity {

    public StepEntity(EntityType<? extends StepEntity> type, Level level) {
        super(type, level);
    }

    public StepEntity(EntityType<? extends StepEntity> type, Level level, double x, double y, double z) {
        this(type, level);
        this.setPos(x, y, z);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount > 20) {
            this.discard();
        }
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
