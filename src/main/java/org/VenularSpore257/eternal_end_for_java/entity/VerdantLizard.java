package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.VenularSpore257.eternal_end_for_java.client.ModSounds;

/**
 * Verdant Lizard - A green lizard variant found in verdant areas.
 */
public class VerdantLizard extends SporeLizard {

    public VerdantLizard(EntityType<? extends VerdantLizard> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return SporeLizard.createAttributes()
                .add(Attributes.MAX_HEALTH, 25);
    }

    @Override
    @Nullable
    protected SoundEvent getAmbientSound() {
        return ModSounds.VERDANT_LIZARD_AMBIENT.get();
    }

    @Override
    @Nullable
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return ModSounds.VERDANT_LIZARD_HURT.get();
    }

    @Override
    @Nullable
    protected SoundEvent getDeathSound() {
        return ModSounds.VERDANT_LIZARD_DEATH.get();
    }

    protected SoundEvent getAttackSound() {
        return ModSounds.VERDANT_LIZARD_ATTACK.get();
    }
}
