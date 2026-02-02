package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
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

import java.util.EnumSet;

/**
 * Void Dragon - The main boss of the Eternal End mod.
 * A complex multi-phase boss with AI states: statue, spawn, circle, shoot, catch, death.
 * Ported from Bedrock Edition panascais_end:void_dragon
 * Has GeckoLib rendering.
 */
public class VoidDragon extends FlyingMob implements GeoEntity {
    private static final EntityDataAccessor<Boolean> DATA_DELAYED_DEATH_ID = SynchedEntityData.defineId(VoidDragon.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> DATA_PHASE_ID = SynchedEntityData.defineId(VoidDragon.class, EntityDataSerializers.INT);

    private static final int PHASE_STATUE = 6;
    private static final int PHASE_SPAWN = 0;
    private static final int PHASE_DEATH = 1;
    private static final int PHASE_CIRCLE = 2;
    private static final int PHASE_SHOOT = 4;
    private static final int PHASE_CATCH = 5;
    private static final int PHASE_PRE_DEATH = 7;

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final ServerBossEvent bossEvent;
    private BlockPos homePosition;
    private int attackTimer;
    private int phaseTimer;

    public VoidDragon(EntityType<? extends VoidDragon> type, Level level) {
        super(type, level);
        this.bossEvent = new ServerBossEvent(Component.translatable("entity.eternal_end_for_java:void_dragon.name"), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS);
        this.bossEvent.setProgress(1.0f);
        this.setPersistenceRequired();
        this.xpReward = 1500;
        this.setNoGravity(true);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "movement", 0, event -> {
            int phase = getPhase();

            // Statue phase - the dragon appears as a dormant statue
            if (phase == PHASE_STATUE) {
                event.setAnimation(RawAnimation.begin().thenLoop("statue"));
                return PlayState.CONTINUE;
            }

            // Death phase - plays death animation once
            if (phase == PHASE_DEATH || phase == PHASE_PRE_DEATH) {
                event.setAnimation(RawAnimation.begin().thenPlay("death"));
                return PlayState.CONTINUE;
            }

            // Regeneration phase (could be added as a new phase)
            if (this.isDelayedDeath()) {
                event.setAnimation(RawAnimation.begin().thenLoop("regeneration"));
                return PlayState.CONTINUE;
            }

            // Spawn phase - initial spawn animation
            if (phase == PHASE_SPAWN) {
                event.setAnimation(RawAnimation.begin().thenLoop("spawn"));
                return PlayState.CONTINUE;
            }

            // Circle/Catch phases - flying animations
            if (phase == PHASE_CIRCLE || phase == PHASE_CATCH) {
                event.setAnimation(RawAnimation.begin().thenLoop("fly"));
                return PlayState.CONTINUE;
            }

            // Shoot phase - attack animation
            if (phase == PHASE_SHOOT) {
                event.setAnimation(RawAnimation.begin().thenLoop("attack"));
                return PlayState.CONTINUE;
            }

            // Default idle animation
            event.setAnimation(RawAnimation.begin().thenLoop("idle"));
            return PlayState.CONTINUE;
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new DragonCircleGoal(this));
        this.goalSelector.addGoal(2, new DragonShootGoal(this));
        this.goalSelector.addGoal(3, new DragonCatchGoal(this));
        this.goalSelector.addGoal(4, new DragonReturnHomeGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 600)
                .add(Attributes.MOVEMENT_SPEED, 1.8)
                .add(Attributes.ATTACK_DAMAGE, 17)
                .add(Attributes.FOLLOW_RANGE, 300)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_DELAYED_DEATH_ID, false);
        builder.define(DATA_PHASE_ID, PHASE_SPAWN);
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();

        if (!this.level().isClientSide) {
            this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());

            int phase = this.getPhase();

            // Phase transitions
            if (phase == PHASE_STATUE) {
                this.setDeltaMovement(0, 0, 0);
                return;
            }

            if (phase == PHASE_SPAWN) {
                this.phaseTimer++;
                if (this.phaseTimer > 100) {
                    this.setPhase(PHASE_CIRCLE);
                }
            } else if (phase == PHASE_CIRCLE) {
                // Circle goal handles this
                if (this.attackTimer++ > 200) {
                    this.setPhase(PHASE_SHOOT);
                    this.attackTimer = 0;
                }
            } else if (phase == PHASE_SHOOT) {
                if (this.attackTimer++ > 60) {
                    this.setPhase(PHASE_CATCH);
                    this.attackTimer = 0;
                }
            } else if (phase == PHASE_CATCH) {
                if (this.attackTimer++ > 100) {
                    this.setPhase(PHASE_CIRCLE);
                    this.attackTimer = 0;
                }
            }
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();

        // Handle flight
        if (!this.isNoGravity()) {
            this.setNoGravity(true);
        }
    }

    @Override
    public void travel(@NotNull net.minecraft.world.phys.Vec3 travelVec) {
        // Override to handle flying movement
        if (this.isEffectiveAi() || this.isControlledByLocalInstance()) {
            double speed = this.getSpeed();

            if (this.isInWater()) {
                // Slower in water
                speed *= 0.5;
            }

            this.moveRelative(this.getSpeed(), travelVec);
            this.move(MoverType.SELF, this.getDeltaMovement());
        }
    }

    @Override
    public boolean hurt(@NotNull DamageSource source, float amount) {
        if (source.is(DamageTypes.FELL_OUT_OF_WORLD) || source.is(DamageTypes.IN_FIRE) || source.is(DamageTypes.MAGIC)) {
            return false;
        }

        return super.hurt(source, amount);
    }

    @Override
    public void die(@NotNull DamageSource cause) {
        super.die(cause);
        if (!this.level().isClientSide) {
            // Drop rewards
            // TODO: Add drops
        }
    }

    public boolean isFireImmune() {
        return true;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.VOID_DRAGON_FLAP.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return ModSounds.VOID_DRAGON_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.VOID_DRAGON_DEATH.get();
    }

    protected SoundEvent getAttackSound() {
        return ModSounds.VOID_DRAGON_ATTACK.get();
    }

    protected SoundEvent getFlapSound() {
        return ModSounds.VOID_DRAGON_FLAP.get();
    }

    @Override
    public boolean isInvulnerableTo(@NotNull DamageSource source) {
        return source.is(DamageTypes.FELL_OUT_OF_WORLD) || source.is(DamageTypes.IN_FIRE) || super.isInvulnerableTo(source);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("DelayedDeath", this.isDelayedDeath());
        compound.putInt("DragonPhase", this.getPhase());
        if (this.homePosition != null) {
            compound.putInt("HomeX", this.homePosition.getX());
            compound.putInt("HomeY", this.homePosition.getY());
            compound.putInt("HomeZ", this.homePosition.getZ());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setDelayedDeath(compound.getBoolean("DelayedDeath"));
        this.setPhase(compound.getInt("DragonPhase"));
        if (compound.contains("HomeX")) {
            this.homePosition = new BlockPos(
                compound.getInt("HomeX"),
                compound.getInt("HomeY"),
                compound.getInt("HomeZ")
            );
        }
    }

    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }

    // Getters and Setters
    public boolean isDelayedDeath() {
        return this.entityData.get(DATA_DELAYED_DEATH_ID);
    }

    public void setDelayedDeath(boolean delayed) {
        this.entityData.set(DATA_DELAYED_DEATH_ID, delayed);
    }

    public int getPhase() {
        return this.entityData.get(DATA_PHASE_ID);
    }

    public void setPhase(int phase) {
        this.entityData.set(DATA_PHASE_ID, phase);
    }

    public BlockPos getHomePosition() {
        return homePosition;
    }

    public void setHomePosition(BlockPos pos) {
        this.homePosition = pos;
    }

    // AI Goals
    static class DragonCircleGoal extends Goal {
        private final VoidDragon dragon;
        private double angle;
        private double radius;
        private double targetY;

        DragonCircleGoal(VoidDragon dragon) {
            this.dragon = dragon;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return dragon.getPhase() == PHASE_CIRCLE;
        }

        @Override
        public void start() {
            this.angle = dragon.getRandom().nextDouble() * Math.PI * 2;
            this.radius = 15 + dragon.getRandom().nextDouble() * 25;
            this.targetY = dragon.getY() + dragon.getRandom().nextDouble() * 8 - 4;
        }

        @Override
        public void tick() {
            // Circle around home position
            BlockPos home = dragon.getHomePosition();
            if (home == null) home = dragon.blockPosition();

            this.angle += 0.02;
            double x = home.getX() + Math.cos(this.angle) * this.radius;
            double z = home.getZ() + Math.sin(this.angle) * this.radius;

            // Smooth Y movement towards target
            double dy = this.targetY - dragon.getY();
            dragon.setDeltaMovement(
                (x - dragon.getX()) * 0.1,
                dy * 0.02,
                (z - dragon.getZ()) * 0.1
            );

            dragon.getLookControl().setLookAt(x, dragon.getY(), z);
        }
    }

    static class DragonShootGoal extends Goal {
        private final VoidDragon dragon;
        private int timer;

        DragonShootGoal(VoidDragon dragon) {
            this.dragon = dragon;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return dragon.getPhase() == PHASE_SHOOT;
        }

        @Override
        public void tick() {
            // Move towards player and prepare to shoot
            LivingEntity target = dragon.getTarget();
            if (target != null) {
                double dist = dragon.distanceToSqr(target);
                if (dist < 45 && dist > 5) {
                    // Move closer
                    dragon.getLookControl().setLookAt(target);
                    // TODO: Shoot projectiles
                }
            }
        }
    }

    static class DragonCatchGoal extends Goal {
        private final VoidDragon dragon;
        private int timer;

        DragonCatchGoal(VoidDragon dragon) {
            this.dragon = dragon;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return dragon.getPhase() == PHASE_CATCH;
        }

        @Override
        public void start() {
            this.timer = 0;
        }

        @Override
        public void tick() {
            // Circle and prepare to catch player
            LivingEntity target = dragon.getTarget();
            if (target != null && target.isPassenger()) {
                // Fly towards and try to mount
                dragon.getLookControl().setLookAt(target);
                // TODO: Mount player when close
            }
        }
    }

    static class DragonReturnHomeGoal extends Goal {
        private final VoidDragon dragon;

        DragonReturnHomeGoal(VoidDragon dragon) {
            this.dragon = dragon;
        }

        @Override
        public boolean canUse() {
            return dragon.getPhase() == PHASE_PRE_DEATH;
        }

        @Override
        public void tick() {
            BlockPos home = dragon.getHomePosition();
            if (home != null) {
                // Move towards home
                double dx = home.getX() - dragon.getX();
                double dy = home.getY() - dragon.getY();
                double dz = home.getZ() - dragon.getZ();
                dragon.setDeltaMovement(dx * 0.02, dy * 0.02, dz * 0.02);
            }
        }
    }
}
