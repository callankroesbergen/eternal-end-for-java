package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * End Portal Particle - Visual effect entity for end portal particles.
 */
public class EndPortalParticle extends Entity {

    public EndPortalParticle(EntityType<? extends EndPortalParticle> type, Level level) {
        super(type, level);
        this.setNoGravity(true);
        this.setInvisible(true);
    }

    public EndPortalParticle(EntityType<? extends EndPortalParticle> type, Level level, double x, double y, double z) {
        this(type, level);
        this.setPos(x, y, z);
    }

    @Override
    public void tick() {
        super.tick();
        // Spawn purple particles
        if (!this.level().isClientSide && this.random.nextInt(3) == 0) {
            this.level().addParticle(ParticleTypes.DRAGON_BREATH,
                this.getX(), this.getY() + this.random.nextDouble() * this.getBbHeight(),
                this.getZ(), 0, 0, 0);
        }
        if (this.tickCount > 100) {
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
