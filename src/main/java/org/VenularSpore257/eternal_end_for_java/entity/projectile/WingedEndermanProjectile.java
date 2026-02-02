package org.VenularSpore257.eternal_end_for_java.entity.projectile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

/**
 * Winged Enderman Projectile - A projectile fired by winged endermen.
 * Has GeckoLib rendering with spinning animation.
 */
public class WingedEndermanProjectile extends AbstractArrow implements GeoEntity {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public WingedEndermanProjectile(EntityType<? extends WingedEndermanProjectile> type, Level level) {
        super(type, level);
        this.setBaseDamage(6);
    }

    public WingedEndermanProjectile(Level level, double x, double y, double z) {
        super(EternalEndProjectiles.WINGED_ENDERMAN_PROJECTILE.get(), level);
        this.setPos(x, y, z);
        this.setBaseDamage(6);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "spin", 0, this::spinController));
    }

    private PlayState spinController(AnimationState<WingedEndermanProjectile> state) {
        return state.setAndContinue(RawAnimation.begin().thenLoop("spin"));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        // Additional effects
        if (result.getEntity() != null) {
            // Teleport randomly on hit
            if (this.random.nextInt(4) == 0) {
                double d0 = this.getX() + (this.random.nextDouble() - 0.5) * 8;
                double d1 = this.getY() + (this.random.nextDouble() - 0.5) * 4;
                double d2 = this.getZ() + (this.random.nextDouble() - 0.5) * 8;
                this.teleportTo(d0, d1, d2);
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        // Fade out over time
        if (this.inGround || this.isInWater()) {
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        this.discard();
    }

    @Override
    public ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack getDefaultPickupItem() {
        return ItemStack.EMPTY;
    }
}
