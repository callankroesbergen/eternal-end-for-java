package org.VenularSpore257.eternal_end_for_java.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

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
}
