package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.VenularSpore257.eternal_end_for_java.client.ModSounds;

/**
 * Shadow Deer - A dark, corrupted deer found in the End.
 */
public class ShadowDeer extends GildedDeer {

    public ShadowDeer(EntityType<? extends ShadowDeer> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 25)
                .add(Attributes.MOVEMENT_SPEED, 0.45);
    }

    @Override
    @Nullable
    protected SoundEvent getAmbientSound() {
        return ModSounds.SHADOW_DEER_AMBIENT.get();
    }

    @Override
    @Nullable
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return ModSounds.SHADOW_DEER_HURT.get();
    }

    @Override
    @Nullable
    protected SoundEvent getDeathSound() {
        return ModSounds.SHADOW_DEER_DEATH.get();
    }

    protected SoundEvent getAttackSound() {
        return ModSounds.SHADOW_DEER_ATTACK.get();
    }
}
