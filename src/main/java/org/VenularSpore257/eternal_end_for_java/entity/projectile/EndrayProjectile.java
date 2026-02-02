package org.VenularSpore257.eternal_end_for_java.entity.projectile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

/**
 * Endray Projectile - A projectile fired by endray.
 */
public class EndrayProjectile extends AbstractArrow {

    public EndrayProjectile(EntityType<? extends EndrayProjectile> type, Level level) {
        super(type, level);
        this.setBaseDamage(3);
    }

    public EndrayProjectile(Level level, double x, double y, double z) {
        super(EternalEndProjectiles.ENDRAY_PROJECTILE.get(), level);
        this.setPos(x, y, z);
        this.setBaseDamage(3);
    }

    @Override
    public void tick() {
        super.tick();
        // Float upwards slowly
        if (!this.inGround && !this.isInWater()) {
            this.setDeltaMovement(this.getDeltaMovement().x, 0.02, this.getDeltaMovement().z);
        }
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
