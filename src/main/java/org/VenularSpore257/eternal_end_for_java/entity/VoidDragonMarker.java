package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Void Dragon Marker - An invisible marker entity for Void Dragon AI navigation.
 */
public class VoidDragonMarker extends Entity {

    public VoidDragonMarker(EntityType<? extends VoidDragonMarker> type, Level level) {
        super(type, level);
        this.setNoGravity(true);
        this.setInvisible(true);
    }

    public VoidDragonMarker(EntityType<? extends VoidDragonMarker> type, Level level, double x, double y, double z) {
        this(type, level);
        this.setPos(x, y, z);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount > 600) {
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
