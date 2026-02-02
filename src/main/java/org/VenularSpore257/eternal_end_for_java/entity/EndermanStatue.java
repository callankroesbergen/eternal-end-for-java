package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.VenularSpore257.eternal_end_for_java.client.ModSounds;
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
 * Supports pose, wakeup, and summoning animations.
 */
public class EndermanStatue extends Entity implements GeoEntity {

    private static final EntityDataAccessor<Integer> DATA_ANIMATION_STATE_ID =
        SynchedEntityData.defineId(EndermanStatue.class, EntityDataSerializers.INT);

    // Animation states
    public static final int ANIM_POSE = 0;
    public static final int ANIM_WAKEUP = 1;
    public static final int ANIM_SUMMONING_START = 2;
    public static final int ANIM_SUMMONING_LOOP = 3;

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
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(DATA_ANIMATION_STATE_ID, ANIM_POSE);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "statue_animation", 0, this::statueController));
    }

    private PlayState statueController(AnimationState<EndermanStatue> state) {
        int animState = getAnimationState();

        switch (animState) {
            case ANIM_WAKEUP:
                state.setAnimation(RawAnimation.begin().thenPlay("wakeup"));
                break;
            case ANIM_SUMMONING_START:
                state.setAnimation(RawAnimation.begin().thenPlay("summoning_start"));
                break;
            case ANIM_SUMMONING_LOOP:
                state.setAnimation(RawAnimation.begin().thenLoop("summoning_loop"));
                break;
            case ANIM_POSE:
            default:
                state.setAnimation(RawAnimation.begin().thenLoop("pose"));
                break;
        }

        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    public int getAnimationState() {
        return this.entityData.get(DATA_ANIMATION_STATE_ID);
    }

    public void setAnimationState(int state) {
        this.entityData.set(DATA_ANIMATION_STATE_ID, state);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
        if (active && !this.level().isClientSide) {
            // Play activation sound when statue becomes active
            this.playSound(ModSounds.ENDERMAN_STATUE_ACTIVATE.get(), 1.0F, 1.0F);
            // Trigger wakeup animation
            this.setAnimationState(ANIM_WAKEUP);
        } else if (!active) {
            // Return to pose animation when deactivated
            this.setAnimationState(ANIM_POSE);
        }
    }

    /**
     * Start the summoning animation sequence.
     * Call this when the statue begins summoning entities.
     */
    public void startSummoning() {
        this.setAnimationState(ANIM_SUMMONING_START);
    }

    /**
     * Call this after summoning_start completes to loop the summoning animation.
     */
    public void continueSummoning() {
        this.setAnimationState(ANIM_SUMMONING_LOOP);
    }

    /**
     * Call this when summoning is complete to return to pose animation.
     */
    public void finishSummoning() {
        this.setAnimationState(ANIM_POSE);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.contains("IsActive")) {
            this.isActive = compound.getBoolean("IsActive");
        }
        if (compound.contains("AnimationState")) {
            this.setAnimationState(compound.getInt("AnimationState"));
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putBoolean("IsActive", this.isActive);
        compound.putInt("AnimationState", this.getAnimationState());
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
