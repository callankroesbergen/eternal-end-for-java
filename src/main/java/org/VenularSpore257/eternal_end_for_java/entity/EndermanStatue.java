package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.network.syncher.SynchedEntityData;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

/**
 * Enderman Statue - A decorative statue entity with GeckoLib rendering.
 * Has inactive and active states with different textures.
 */
public class EndermanStatue extends Entity implements GeoEntity {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean isActive = false;

    public EndermanStatue(EntityType<? extends EndermanStatue> type, Level level) {
        super(type, level);
        this.setNoGravity(true);
        this.setInvulnerable(true);
    }

    public EndermanStatue(EntityType<? extends EndermanStatue> type, double x, double y, double z, Level level) {
        super(type, level);
        this.moveTo(x, y, z);
        this.setNoGravity(true);
        this.setInvulnerable(true);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "pose", 0, this::poseController));
    }

    private PlayState poseController(AnimationState<EndermanStatue> state) {
        return state.setAndContinue(RawAnimation.begin().thenLoop("pose"));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        // No synced data needed for basic statue
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.contains("IsActive")) {
            this.isActive = compound.getBoolean("IsActive");
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putBoolean("IsActive", this.isActive);
    }

    @Override
    public boolean isInvulnerableTo(net.minecraft.world.damagesource.DamageSource source) {
        return true;
    }

    @Override
    public boolean hurt(net.minecraft.world.damagesource.DamageSource source, float amount) {
        return false;
    }
}
