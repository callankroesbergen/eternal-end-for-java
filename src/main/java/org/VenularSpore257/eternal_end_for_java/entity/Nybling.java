package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.VenularSpore257.eternal_end_for_java.client.ModSounds;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

/**
 * Nybling - A small passive End creature.
 */
public class Nybling extends Animal implements GeoAnimatable {
    private static final EntityDataAccessor<Boolean> DATA_BEGGING_ID = SynchedEntityData.defineId(Nybling.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_SLEEPING_ID = SynchedEntityData.defineId(Nybling.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_HAPPY_ID = SynchedEntityData.defineId(Nybling.class, EntityDataSerializers.BOOLEAN);

    private int happyTimer = 0;
    private Player beggingTarget = null;

    public Nybling(EntityType<? extends Nybling> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.4));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 8)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.FOLLOW_RANGE, 16);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_BEGGING_ID, false);
        builder.define(DATA_SLEEPING_ID, false);
        builder.define(DATA_HAPPY_ID, false);
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

    public boolean isHappy() {
        return this.entityData.get(DATA_HAPPY_ID);
    }

    public void setHappy(boolean happy) {
        this.entityData.set(DATA_HAPPY_ID, happy);
        if (happy) {
            this.happyTimer = 50; // Happy state lasts ~2.5 seconds
        }
    }

    @Override
    public void tick() {
        super.tick();

        // Handle happy timer
        if (this.isHappy() && this.happyTimer > 0) {
            this.happyTimer--;
            if (this.happyTimer <= 0) {
                this.setHappy(false);
            }
        }

        // Check for nearby players holding seeds to trigger begging
        if (!this.level().isClientSide && !this.isSleeping()) {
            boolean shouldBeg = false;
            for (Player player : this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(8.0))) {
                ItemStack mainHandItem = player.getMainHandItem();
                ItemStack offHandItem = player.getOffhandItem();
                // Nyblings are tempted by seeds
                if (mainHandItem.is(Items.CHORUS_FRUIT) || offHandItem.is(Items.CHORUS_FRUIT) ||
                    mainHandItem.is(Items.PUMPKIN_SEEDS) || offHandItem.is(Items.PUMPKIN_SEEDS) ||
                    mainHandItem.is(Items.MELON_SEEDS) || offHandItem.is(Items.MELON_SEEDS)) {
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
    public @NotNull InteractionResult mobInteract(Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!this.level().isClientSide && this.isAlive()) {
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

            // Right-click with empty hand to pet (trigger happy dance)
            if (itemstack.isEmpty()) {
                this.setSleeping(false); // Wake up if sleeping
                if (!this.isHappy()) {
                    this.setHappy(true);
                    this.spawnHeartParticles();
                }
                return InteractionResult.SUCCESS;
            }
        }
        return super.mobInteract(player, hand);
    }

    private void spawnHeartParticles() {
        for (int i = 0; i < 5; i++) {
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
        compound.putBoolean("Begging", this.isBegging());
        compound.putBoolean("Sleeping", this.isSleeping());
        compound.putBoolean("Happy", this.isHappy());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setBegging(compound.getBoolean("Begging"));
        this.setSleeping(compound.getBoolean("Sleeping"));
        this.setHappy(compound.getBoolean("Happy"));
    }

    @Override
    public boolean isFood(net.minecraft.world.item.ItemStack stack) {
        return false;
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.NYBLING_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return ModSounds.NYBLING_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.NYBLING_DEATH.get();
    }

    // ========== GeoAnimatable Implementation ==========

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object instance) {
        return this.tickCount;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "animation_controller", 0, event -> {
            // Priority order: sleeping > begging > happy > moving > idle

            if (isSleeping()) {
                event.setAnimation(RawAnimation.begin().thenLoop("sleeping"));
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

            if (event.isMoving()) {
                event.setAnimation(RawAnimation.begin().thenLoop("walk"));
                return PlayState.CONTINUE;
            }

            event.setAnimation(RawAnimation.begin().thenLoop("idle"));
            return PlayState.CONTINUE;
        }));
    }
}
