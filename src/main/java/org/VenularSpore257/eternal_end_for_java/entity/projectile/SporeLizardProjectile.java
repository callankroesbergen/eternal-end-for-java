package org.VenularSpore257.eternal_end_for_java.entity.projectile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrownEgg;
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
 * Spore Lizard Projectile - A projectile fired by spore lizards.
 * Has GeckoLib rendering with spinning animation.
 * Shares model/texture with LizardProjectile.
 */
public class SporeLizardProjectile extends ThrownEgg implements GeoEntity {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public SporeLizardProjectile(EntityType<? extends SporeLizardProjectile> type, Level level) {
        super(type, level);
    }

    public SporeLizardProjectile(Level level, double x, double y, double z) {
        super(EternalEndProjectiles.SPORE_LIZARD_PROJECTILE.get(), level);
        this.setPos(x, y, z);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "spin", 0, this::spinController));
    }

    private PlayState spinController(AnimationState<SporeLizardProjectile> state) {
        return state.setAndContinue(RawAnimation.begin().thenLoop("spin"));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if (result.getEntity() != null) {
            result.getEntity().hurt(this.level().damageSources().thrown(this, this.getOwner()), 5);
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        this.discard();
    }
}
