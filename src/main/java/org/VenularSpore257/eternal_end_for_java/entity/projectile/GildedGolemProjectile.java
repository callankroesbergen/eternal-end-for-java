package org.VenularSpore257.eternal_end_for_java.entity.projectile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

/**
 * Gilded Golem Projectile - A projectile fired by gilded golems.
 * Has GeckoLib rendering with spinning animation.
 */
public class GildedGolemProjectile extends AbstractArrow implements GeoEntity {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public GildedGolemProjectile(EntityType<? extends GildedGolemProjectile> type, Level level) {
        super(type, level);
        this.setBaseDamage(8);
    }

    public GildedGolemProjectile(Level level, double x, double y, double z) {
        super(EternalEndProjectiles.GILDED_GOLEM_PROJECTILE.get(), level);
        this.setPos(x, y, z);
        this.setBaseDamage(8);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "spin", 0, this::spinController));
    }

    private PlayState spinController(AnimationState<GildedGolemProjectile> state) {
        return state.setAndContinue(RawAnimation.begin().thenLoop("spin"));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.inGround || this.isInWater()) {
            this.discard();
        }
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
