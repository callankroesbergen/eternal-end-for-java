package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

/**
 * Lost Soul - A wandering soul found in the End.
 * Can be bottled by players and has different variants based on biome.
 * Converted from Bedrock's panascais_end:lost_soul.
 * Has GeckoLib animations.
 */
public class LostSoul extends Monster implements GeoEntity {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private ResourceLocation biomeVariant = ResourceLocation.withDefaultNamespace("the_end");
    private boolean isPersistent = false;
    private boolean isBaby = false;

    public LostSoul(EntityType<? extends LostSoul> type, Level level) {
        super(type, level);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "movement", 0, this::movementController));
    }

    private PlayState movementController(AnimationState<LostSoul> state) {
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
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.4, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.3, 32.0f));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.2));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 15)
                .add(Attributes.MOVEMENT_SPEED, 0.15)
                .add(Attributes.ATTACK_DAMAGE, 3);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        // Float upwards slowly
        if (!this.onGround() && !this.isInWater()) {
            this.setDeltaMovement(this.getDeltaMovement().x, 0.02, this.getDeltaMovement().z);
        }

        // Despawn if not persistent (converted from Bedrock's unpersistent component)
        if (!isPersistent && !level().isClientSide) {
            // Lost souls despawn after 10-20 seconds if not named/bottled
            if (this.tickCount % 200 == 0 && this.getRandom().nextFloat() < 0.1f) {
                if (!this.hasCustomName()) {
                    this.discard();
                }
            }
        }
    }

    /**
     * Sets the biome variant for this Lost Soul.
     * Used to determine appearance and which bottled soul item is produced.
     */
    public void setBiomeVariant(ResourceLocation biomeId) {
        this.biomeVariant = biomeId;
    }

    /**
     * Gets the biome variant of this Lost Soul.
     */
    public ResourceLocation getBiomeVariant() {
        return biomeVariant;
    }

    /**
     * Sets whether this Lost Soul is persistent (won't despawn).
     * Converted from Bedrock's persistent component group.
     */
    public void setPersistent(boolean persistent) {
        this.isPersistent = persistent;
    }

    /**
     * Sets whether this Lost Soul is a baby (smaller variant).
     * Converted from Bedrock's randomize entity_spawned event.
     */
    public void setBaby(boolean baby) {
        this.isBaby = baby;
        if (baby) {
            this.setBaby(true);
        } else {
            this.setBaby(false);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("BiomeVariant")) {
            this.biomeVariant = ResourceLocation.parse(compound.getString("BiomeVariant"));
        }
        if (compound.contains("Persistent")) {
            this.isPersistent = compound.getBoolean("Persistent");
        }
        if (compound.contains("IsBaby")) {
            this.setBaby(compound.getBoolean("IsBaby"));
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("BiomeVariant", this.biomeVariant.toString());
        compound.putBoolean("Persistent", this.isPersistent);
        compound.putBoolean("IsBaby", this.isBaby);
    }

    /**
     * Lost Souls cannot be hurt by any damage source.
     * Converted from Bedrock: {"cause":"all","deals_damage":false}
     */
    @Override
    public boolean hurt(net.minecraft.world.damagesource.DamageSource source, float amount) {
        return false;
    }

    /**
     * Lost Souls can fly.
     */
    @Override
    protected boolean isFlapping() {
        return !this.onGround();
    }

    /**
     * Lost Souls don't take fall damage.
     */
    @Override
    public boolean causeFallDamage(float fallDistance, float multiplier, net.minecraft.world.damagesource.DamageSource damageSource) {
        return false;
    }
}
