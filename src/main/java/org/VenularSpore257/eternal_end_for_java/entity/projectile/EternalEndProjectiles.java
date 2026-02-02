package org.VenularSpore257.eternal_end_for_java.entity.projectile;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;

/**
 * Registry for Eternal End projectile entities.
 */
public class EternalEndProjectiles {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
        DeferredRegister.create(Registries.ENTITY_TYPE, Eternal_end_for_java.MODID);

    // Factory methods for type-safe entity creation
    private static LizardProjectile lizardProjectile(EntityType<LizardProjectile> type, Level level) {
        return new LizardProjectile(type, level);
    }

    private static WingedEndermanProjectile wingedEndermanProjectile(EntityType<WingedEndermanProjectile> type, Level level) {
        return new WingedEndermanProjectile(type, level);
    }

    private static SporeLizardProjectile sporeLizardProjectile(EntityType<SporeLizardProjectile> type, Level level) {
        return new SporeLizardProjectile(type, level);
    }

    private static GildedGolemProjectile gildedGolemProjectile(EntityType<GildedGolemProjectile> type, Level level) {
        return new GildedGolemProjectile(type, level);
    }

    private static EndrayProjectile endrayProjectile(EntityType<EndrayProjectile> type, Level level) {
        return new EndrayProjectile(type, level);
    }

    public static final DeferredHolder<EntityType<?>, EntityType<LizardProjectile>> LIZARD_PROJECTILE = ENTITIES.register("lizard_projectile",
        () -> EntityType.Builder.of(EternalEndProjectiles::lizardProjectile, MobCategory.MISC)
            .sized(0.25f, 0.25f)
            .build("lizard_projectile"));

    public static final DeferredHolder<EntityType<?>, EntityType<WingedEndermanProjectile>> WINGED_ENDERMAN_PROJECTILE = ENTITIES.register("winged_enderman_projectile",
        () -> EntityType.Builder.of(EternalEndProjectiles::wingedEndermanProjectile, MobCategory.MISC)
            .sized(0.25f, 0.25f)
            .build("winged_enderman_projectile"));

    public static final DeferredHolder<EntityType<?>, EntityType<SporeLizardProjectile>> SPORE_LIZARD_PROJECTILE = ENTITIES.register("spore_lizard_projectile",
        () -> EntityType.Builder.of(EternalEndProjectiles::sporeLizardProjectile, MobCategory.MISC)
            .sized(0.25f, 0.25f)
            .build("spore_lizard_projectile"));

    public static final DeferredHolder<EntityType<?>, EntityType<GildedGolemProjectile>> GILDED_GOLEM_PROJECTILE = ENTITIES.register("gilded_golem_projectile",
        () -> EntityType.Builder.of(EternalEndProjectiles::gildedGolemProjectile, MobCategory.MISC)
            .sized(0.25f, 0.25f)
            .build("gilded_golem_projectile"));

    public static final DeferredHolder<EntityType<?>, EntityType<EndrayProjectile>> ENDRAY_PROJECTILE = ENTITIES.register("endray_projectile",
        () -> EntityType.Builder.of(EternalEndProjectiles::endrayProjectile, MobCategory.MISC)
            .sized(0.25f, 0.25f)
            .build("endray_projectile"));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
