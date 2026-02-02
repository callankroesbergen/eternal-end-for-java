package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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
 * Winged Enderman - A flying variant of the Enderman with GeckoLib animations.
 */
public class WingedEnderman extends Monster implements GeoEntity {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public WingedEnderman(EntityType<? extends WingedEnderman> type, Level level) {
        super(type, level);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "movement", 0, this::movementController));
    }

    private PlayState movementController(AnimationState<WingedEnderman> state) {
        if (state.isMoving()) {
            return state.setAndContinue(RawAnimation.begin().thenLoop("walk"));
        }
        return state.setAndContinue(RawAnimation.begin().thenLoop("idle"));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9, 32.0f));
        this.goalSelector.addGoal(3, new net.minecraft.world.entity.ai.goal.RandomStrollGoal(this, 0.6));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 40)
                .add(Attributes.MOVEMENT_SPEED, 0.28)
                .add(Attributes.ATTACK_DAMAGE, 7)
                .add(Attributes.FOLLOW_RANGE, 32);
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();

        // Flying behavior - move toward target if it has one
        if (!this.onGround() && this.getTarget() != null) {
            double targetX = this.getTarget().getX();
            double targetY = this.getTarget().getY() + 2.0; // Hover above target
            double targetZ = this.getTarget().getZ();

            // Move towards the target
            this.getMoveControl().setWantedPosition(targetX, targetY, targetZ, 1.0);
        }

        // Random flying when idle
        if (!this.onGround() && this.getTarget() == null && this.getRandom().nextFloat() < 0.02f) {
            // Random hover movement
            this.setDeltaMovement(
                this.getRandom().nextGaussian() * 0.1,
                this.getRandom().nextGaussian() * 0.1,
                this.getRandom().nextGaussian() * 0.1
            );
        }

        // Prevent falling by applying upward velocity when in air
        if (!this.onGround() && this.getDeltaMovement().y < 0) {
            this.setDeltaMovement(this.getDeltaMovement().x, this.getDeltaMovement().y * 0.6, this.getDeltaMovement().z);
        }
    }

    @Override
    public void tick() {
        super.tick();

        // Apply no-gravity effect when in air (fly)
        if (!this.onGround()) {
            this.setNoGravity(true);
        } else {
            this.setNoGravity(false);
        }
    }

    @Override
    protected boolean isFlapping() {
        return !this.onGround();
    }

    @Override
    protected float getFlyingSpeed() {
        return this.getSpeed() * 0.6F;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ENDERMAN_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return ModSounds.ENDERMAN_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ENDERMAN_DEATH.get();
    }

    protected SoundEvent getAttackSound() {
        return ModSounds.WINGED_ENDERMAN_ATTACK.get();
    }
}
