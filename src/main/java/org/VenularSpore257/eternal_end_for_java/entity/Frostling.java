package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import org.VenularSpore257.eternal_end_for_java.client.ModSounds;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

/**
 * Frostling - A passive, tameable ice companion mob.
 * Ported from Bedrock Edition panascais_end:frostling
 */
public class Frostling extends Animal implements GeoAnimatable {
    private static final EntityDataAccessor<Boolean> DATA_HAPPY_ID = SynchedEntityData.defineId(Frostling.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_FROZEN_ID = SynchedEntityData.defineId(Frostling.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_SITTING_ID = SynchedEntityData.defineId(Frostling.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_BEGGING_ID = SynchedEntityData.defineId(Frostling.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_SLEEPING_ID = SynchedEntityData.defineId(Frostling.class, EntityDataSerializers.BOOLEAN);

    private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(Items.CHORUS_FRUIT, Items.CHORUS_FLOWER);

    private int happyTimer = 0;
    private Player beggingTarget = null;

    public Frostling(EntityType<? extends Frostling> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.45));
        this.goalSelector.addGoal(3, new BreedGoal(this, 0.8));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.0, TEMPTATION_ITEMS, false));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.15));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10)
                .add(Attributes.MOVEMENT_SPEED, 0.15)
                .add(Attributes.FOLLOW_RANGE, 16);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_HAPPY_ID, false);
        builder.define(DATA_FROZEN_ID, false);
        builder.define(DATA_SITTING_ID, false);
        builder.define(DATA_BEGGING_ID, false);
        builder.define(DATA_SLEEPING_ID, false);
    }

    public boolean isHappy() {
        return this.entityData.get(DATA_HAPPY_ID);
    }

    public boolean isBegging() {
        return this.entityData.get(DATA_BEGGING_ID);
    }

    public void setBegging(boolean begging) {
        this.entityData.set(DATA_BEGGING_ID, begging);
    }

    public boolean isSleeping() {
        return this.entityData.get(DATA_SLEEPING_ID);
    }

    public void setSleeping(boolean sleeping) {
        this.entityData.set(DATA_SLEEPING_ID, sleeping);
    }

    public void setHappy(boolean happy) {
        this.entityData.set(DATA_HAPPY_ID, happy);
        if (happy) {
            // Happy state lasts for ~2.5 seconds (50 ticks) - one animation cycle
            this.happyTimer = 50;
        }
    }

    public boolean isFrozen() {
        return this.entityData.get(DATA_FROZEN_ID);
    }

    public void setFrozen(boolean frozen) {
        this.entityData.set(DATA_FROZEN_ID, frozen);
        if (frozen) {
            this.setNoGravity(true);
            this.setSilent(true);
        } else {
            this.setNoGravity(false);
            this.setSilent(false);
        }
    }

    public boolean isSitting() {
        return this.entityData.get(DATA_SITTING_ID);
    }

    public void setSitting(boolean sitting) {
        this.entityData.set(DATA_SITTING_ID, sitting);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.isFrozen() && this.level().getBlockState(this.blockPosition()).isAir()) {
            // Melt if not in ice
            this.setFrozen(false);
        }

        // Handle happy timer
        if (this.isHappy() && this.happyTimer > 0) {
            this.happyTimer--;
            if (this.happyTimer <= 0) {
                this.setHappy(false);
            }
        }

        // Check for nearby players with food to trigger begging
        if (!this.level().isClientSide && !this.isSleeping() && !this.isFrozen()) {
            boolean shouldBeg = false;
            for (Player player : this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(8.0))) {
                ItemStack mainHandItem = player.getMainHandItem();
                ItemStack offHandItem = player.getOffhandItem();
                if (isFood(mainHandItem) || isFood(offHandItem)) {
                    shouldBeg = true;
                    beggingTarget = player;
                    break;
                }
            }
            this.setBegging(shouldBeg);
            if (!shouldBeg) {
                beggingTarget = null;
            }
        }
    }

    @Override
    public double getTick(Object instance) {
        // Return entity age for animation timing
        return this.tickCount;
    }

    @Override
    public boolean isFood(@NotNull ItemStack stack) {
        // Frostlings love chorus fruit and flowers
        return stack.is(Items.CHORUS_FRUIT) || stack.is(Items.CHORUS_FLOWER);
    }

    @Override
    public @NotNull InteractionResult mobInteract(Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!this.level().isClientSide && this.isAlive()) {
            if (this.isFrozen()) {
                // Cannot interact while frozen
                return InteractionResult.PASS;
            }

            // Right-click with bed item to toggle sleeping
            if (itemstack.is(Items.WHITE_BED) || itemstack.is(Items.BLACK_BED) ||
                itemstack.is(Items.BLUE_BED) || itemstack.is(Items.BROWN_BED) ||
                itemstack.is(Items.CYAN_BED) || itemstack.is(Items.GRAY_BED) ||
                itemstack.is(Items.GREEN_BED) || itemstack.is(Items.LIGHT_BLUE_BED) ||
                itemstack.is(Items.LIGHT_GRAY_BED) || itemstack.is(Items.LIME_BED) ||
                itemstack.is(Items.MAGENTA_BED) || itemstack.is(Items.ORANGE_BED) ||
                itemstack.is(Items.PINK_BED) || itemstack.is(Items.PURPLE_BED) ||
                itemstack.is(Items.RED_BED) || itemstack.is(Items.YELLOW_BED)) {
                this.setSleeping(!this.isSleeping());
                return InteractionResult.SUCCESS;
            }

            // Right-click with empty hand to toggle sitting
            if (itemstack.isEmpty()) {
                this.setSleeping(false); // Wake up if sleeping
                this.setSitting(!this.isSitting());
                this.setInLove(player); // Also triggers hearts
                return InteractionResult.SUCCESS;
            }

            if (this.isFood(itemstack)) {
                // Wake up if sleeping
                this.setSleeping(false);

                // Feed the frostling
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                this.setHappy(true);
                this.heal(2.0f); // Heal when fed
                this.spawnHeartParticles();

                // Breed if adult
                if (this.getAge() == 0 && !this.isInLove()) {
                    this.setInLove(player);
                }

                return InteractionResult.SUCCESS;
            }
        }
        return super.mobInteract(player, hand);
    }

    private void spawnHeartParticles() {
        for (int i = 0; i < 7; i++) {
            double d0 = this.random.nextGaussian() * 0.02;
            double d1 = this.random.nextGaussian() * 0.02;
            double d2 = this.random.nextGaussian() * 0.02;
            this.level().addParticle(
                net.minecraft.core.particles.ParticleTypes.HEART,
                this.getX() + (this.random.nextFloat() * this.getBbWidth() * 2.0F) - this.getBbWidth(),
                this.getY() + 0.5 + (this.random.nextFloat() * this.getBbHeight()),
                this.getZ() + (this.random.nextFloat() * this.getBbWidth() * 2.0F) - this.getBbWidth(),
                d0, d1, d2
            );
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Happy", this.isHappy());
        compound.putBoolean("Frozen", this.isFrozen());
        compound.putBoolean("Sitting", this.isSitting());
        compound.putBoolean("Begging", this.isBegging());
        compound.putBoolean("Sleeping", this.isSleeping());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setHappy(compound.getBoolean("Happy"));
        this.setFrozen(compound.getBoolean("Frozen"));
        this.setSitting(compound.getBoolean("Sitting"));
        this.setBegging(compound.getBoolean("Begging"));
        this.setSleeping(compound.getBoolean("Sleeping"));
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.FROSTLING_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return ModSounds.FROSTLING_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.FROSTLING_DEATH.get();
    }

    @Nullable
    protected SoundEvent getStepSound() {
        return ModSounds.FROSTLING_STEP.get();
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return null; // Frostlings do not breed
    }

    // ========== GeoAnimatable Implementation ==========

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "animation_controller", 0, event -> {
            // Priority order: sleeping > frozen > begging > happy > sitting > moving > idle

            if (isSleeping()) {
                event.setAnimation(RawAnimation.begin().thenLoop("sleeping"));
                return PlayState.CONTINUE;
            }

            if (isFrozen()) {
                event.setAnimation(RawAnimation.begin().thenPlay("frozen"));
                return PlayState.CONTINUE;
            }

            if (isBegging()) {
                event.setAnimation(RawAnimation.begin().thenLoop("begging"));
                return PlayState.CONTINUE;
            }

            if (isHappy()) {
                event.setAnimation(RawAnimation.begin().thenPlay("happy_dance"));
                return PlayState.CONTINUE;
            }

            if (isSitting()) {
                event.setAnimation(RawAnimation.begin().thenLoop("sit"));
                return PlayState.CONTINUE;
            }

            if (event.isMoving()) {
                event.setAnimation(RawAnimation.begin().thenLoop("walk"));
                return PlayState.CONTINUE;
            }

            event.setAnimation(RawAnimation.begin().thenLoop("idle"));
            return PlayState.CONTINUE;
        }));
    }
}
