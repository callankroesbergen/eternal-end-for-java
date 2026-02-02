package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Ender Crystal Particle - Visual effect entity for ender crystal particles.
 */
public class EnderCrystalParticle extends Entity {

    public EnderCrystalParticle(EntityType<? extends EnderCrystalParticle> type, Level level) {
        super(type, level);
        this.setNoGravity(true);
        this.setInvisible(true);
    }

    public EnderCrystalParticle(EntityType<? extends EnderCrystalParticle> type, Level level, double x, double y, double z) {
        this(type, level);
        this.setPos(x, y, z);
    }

    @Override
    public void tick() {
        super.tick();
        // Spawn ender particles
        if (!this.level().isClientSide && this.random.nextInt(5) == 0) {
            double x = this.getX();
            double y = this.getY() + this.random.nextDouble() * this.getBbHeight();
            double z = this.getZ();
            this.level().addParticle(ParticleTypes.DRAGON_BREATH, x, y, z, 0, 0, 0);
        }
        if (this.tickCount > 60) {
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
