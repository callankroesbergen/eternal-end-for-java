package org.VenularSpore257.eternal_end_for_java;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.VenularSpore257.eternal_end_for_java.entity.*;
import org.VenularSpore257.eternal_end_for_java.entity.projectile.*;

/**
 * Registry for all Eternal End entity types.
 * 46 entities total from the Bedrock addon.
 */
public class EternalEndEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
        DeferredRegister.create(Registries.ENTITY_TYPE, Eternal_end_for_java.MODID);

    // Factory methods for type-safe entity creation (entities that extend Entity base class directly)
    private static EndermanStatue endermanStatue(EntityType<EndermanStatue> type, Level level) {
        return new EndermanStatue(type, level);
    }

    private static PaleEndermanStatue paleEndermanStatue(EntityType<PaleEndermanStatue> type, Level level) {
        return new PaleEndermanStatue(type, level);
    }

    private static GildedEndermanStatue gildedEndermanStatue(EntityType<GildedEndermanStatue> type, Level level) {
        return new GildedEndermanStatue(type, level);
    }

    private static MossyEndermanStatue mossyEndermanStatue(EntityType<MossyEndermanStatue> type, Level level) {
        return new MossyEndermanStatue(type, level);
    }

    private static MycoticEndermanStatue mycoticEndermanStatue(EntityType<MycoticEndermanStatue> type, Level level) {
        return new MycoticEndermanStatue(type, level);
    }

    private static WingedEndermanStatue wingedEndermanStatue(EntityType<WingedEndermanStatue> type, Level level) {
        return new WingedEndermanStatue(type, level);
    }

    private static VoidDragonMarker voidDragonMarker(EntityType<VoidDragonMarker> type, Level level) {
        return new VoidDragonMarker(type, level);
    }

    private static StepEntity stepEntity(EntityType<StepEntity> type, Level level) {
        return new StepEntity(type, level);
    }

    private static PlayerUtility playerUtility(EntityType<PlayerUtility> type, Level level) {
        return new PlayerUtility(type, level);
    }

    private static DummyDifficulty dummyDifficulty(EntityType<DummyDifficulty> type, Level level) {
        return new DummyDifficulty(type, level);
    }

    private static EndPortalParticle endPortalParticle(EntityType<EndPortalParticle> type, Level level) {
        return new EndPortalParticle(type, level);
    }

    private static EnderCrystalParticle enderCrystalParticle(EntityType<EnderCrystalParticle> type, Level level) {
        return new EnderCrystalParticle(type, level);
    }

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

    // Boss
    public static final DeferredHolder<EntityType<?>, EntityType<VoidDragon>> VOID_DRAGON = ENTITIES.register("void_dragon",
        () -> EntityType.Builder.of(VoidDragon::new, MobCategory.MONSTER)
            .sized(2.9f, 5f)
            .fireImmune()
            .canSpawnFarFromPlayer()
            .build("void_dragon"));

    // Hostile Mobs
    public static final DeferredHolder<EntityType<?>, EntityType<DoomedWolf>> DOOMED_WOLF = ENTITIES.register("doomed_wolf",
        () -> EntityType.Builder.of(DoomedWolf::new, MobCategory.MONSTER)
            .sized(1.5f, 1.5f)
            .build("doomed_wolf"));

    public static final DeferredHolder<EntityType<?>, EntityType<WingedEnderman>> WINGED_ENDERMAN = ENTITIES.register("winged_enderman",
        () -> EntityType.Builder.of(WingedEnderman::new, MobCategory.MONSTER)
            .sized(0.8f, 3.1f)
            .fireImmune()
            .build("winged_enderman"));

    public static final DeferredHolder<EntityType<?>, EntityType<Mistling>> MISTLING = ENTITIES.register("mistling",
        () -> EntityType.Builder.of(Mistling::new, MobCategory.MONSTER)
            .sized(0.6f, 1.8f)
            .build("mistling"));

    public static final DeferredHolder<EntityType<?>, EntityType<Voidling>> VOIDLING = ENTITIES.register("voidling",
        () -> EntityType.Builder.of(Voidling::new, MobCategory.MONSTER)
            .sized(0.6f, 0.7f)
            .build("voidling"));

    public static final DeferredHolder<EntityType<?>, EntityType<EnderSlime>> ENDER_SLIME = ENTITIES.register("ender_slime",
        () -> EntityType.Builder.of(EnderSlime::new, MobCategory.MONSTER)
            .sized(0.52f, 0.52f)
            .fireImmune()
            .build("ender_slime"));

    // Enderman Variants (Statue versions)
    public static final DeferredHolder<EntityType<?>, EntityType<EndermanStatue>> ENDERMAN_STATUE = ENTITIES.register("enderman_statue",
        () -> EntityType.Builder.of(EternalEndEntities::endermanStatue, MobCategory.MISC)
            .sized(1.5f, 4f)
            .fireImmune()
            .build("enderman_statue"));

    public static final DeferredHolder<EntityType<?>, EntityType<PaleEndermanStatue>> PALE_ENDERMAN_STATUE = ENTITIES.register("pale_enderman_statue",
        () -> EntityType.Builder.of(EternalEndEntities::paleEndermanStatue, MobCategory.MISC)
            .sized(1.5f, 4f)
            .fireImmune()
            .build("pale_enderman_statue"));

    public static final DeferredHolder<EntityType<?>, EntityType<GildedEndermanStatue>> GILDED_ENDERMAN_STATUE = ENTITIES.register("gilded_enderman_statue",
        () -> EntityType.Builder.of(EternalEndEntities::gildedEndermanStatue, MobCategory.MISC)
            .sized(1.5f, 4f)
            .fireImmune()
            .build("gilded_enderman_statue"));

    public static final DeferredHolder<EntityType<?>, EntityType<MossyEndermanStatue>> MOSSY_ENDERMAN_STATUE = ENTITIES.register("mossy_enderman_statue",
        () -> EntityType.Builder.of(EternalEndEntities::mossyEndermanStatue, MobCategory.MISC)
            .sized(1.5f, 4f)
            .fireImmune()
            .build("mossy_enderman_statue"));

    public static final DeferredHolder<EntityType<?>, EntityType<MycoticEndermanStatue>> MYCOTIC_ENDERMAN_STATUE = ENTITIES.register("mycotic_enderman_statue",
        () -> EntityType.Builder.of(EternalEndEntities::mycoticEndermanStatue, MobCategory.MISC)
            .sized(1.5f, 4f)
            .fireImmune()
            .build("mycotic_enderman_statue"));

    public static final DeferredHolder<EntityType<?>, EntityType<WingedEndermanStatue>> WINGED_ENDERMAN_STATUE = ENTITIES.register("winged_enderman_statue",
        () -> EntityType.Builder.of(EternalEndEntities::wingedEndermanStatue, MobCategory.MISC)
            .sized(1.5f, 4f)
            .fireImmune()
            .build("winged_enderman_statue"));

    // Living Enderman Variants
    public static final DeferredHolder<EntityType<?>, EntityType<PaleEnderman>> PALE_ENDERMAN = ENTITIES.register("pale_enderman",
        () -> EntityType.Builder.of(PaleEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 2.9f)
            .fireImmune()
            .build("pale_enderman"));

    public static final DeferredHolder<EntityType<?>, EntityType<MossyEnderman>> MOSSY_ENDERMAN = ENTITIES.register("mossy_enderman",
        () -> EntityType.Builder.of(MossyEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 2.9f)
            .fireImmune()
            .build("mossy_enderman"));

    public static final DeferredHolder<EntityType<?>, EntityType<GildedEnderman>> GILDED_ENDERMAN = ENTITIES.register("gilded_enderman",
        () -> EntityType.Builder.of(GildedEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 2.9f)
            .fireImmune()
            .build("gilded_enderman"));

    public static final DeferredHolder<EntityType<?>, EntityType<MycoticEnderman>> MYCOTIC_ENDERMAN = ENTITIES.register("mycotic_enderman",
        () -> EntityType.Builder.of(MycoticEnderman::new, MobCategory.MONSTER)
            .sized(0.6f, 2.9f)
            .fireImmune()
            .build("mycotic_enderman"));

    // Passive/Neutral Mobs
    public static final DeferredHolder<EntityType<?>, EntityType<Endray>> ENDRAY = ENTITIES.register("endray",
        () -> EntityType.Builder.of(Endray::new, MobCategory.CREATURE)
            .sized(7f, 1.5f)
            .fireImmune()
            .build("endray"));

    public static final DeferredHolder<EntityType<?>, EntityType<Frostling>> FROSTLING = ENTITIES.register("frostling",
        () -> EntityType.Builder.of(Frostling::new, MobCategory.CREATURE)
            .sized(0.6f, 0.85f)
            .fireImmune()
            .build("frostling"));

    public static final DeferredHolder<EntityType<?>, EntityType<Glowling>> GLOWLING = ENTITIES.register("glowling",
        () -> EntityType.Builder.of(Glowling::new, MobCategory.CREATURE)
            .sized(0.5f, 0.5f)
            .fireImmune()
            .build("glowling"));

    public static final DeferredHolder<EntityType<?>, EntityType<Nybling>> NYBLING = ENTITIES.register("nybling",
        () -> EntityType.Builder.of(Nybling::new, MobCategory.CREATURE)
            .sized(0.4f, 0.4f)
            .fireImmune()
            .build("nybling"));

    public static final DeferredHolder<EntityType<?>, EntityType<GildedDeer>> GILDED_DEER = ENTITIES.register("gilded_deer",
        () -> EntityType.Builder.of(GildedDeer::new, MobCategory.CREATURE)
            .sized(2.2f, 3.25f)
            .fireImmune()
            .build("gilded_deer"));

    public static final DeferredHolder<EntityType<?>, EntityType<ShadowDeer>> SHADOW_DEER = ENTITIES.register("shadow_deer",
        () -> EntityType.Builder.of(ShadowDeer::new, MobCategory.CREATURE)
            .sized(1.75f, 1.65f)
            .fireImmune()
            .build("shadow_deer"));

    public static final DeferredHolder<EntityType<?>, EntityType<FrozenJellyfish>> FROZEN_JELLYFISH = ENTITIES.register("frozen_jellyfish",
        () -> EntityType.Builder.of(FrozenJellyfish::new, MobCategory.WATER_CREATURE)
            .sized(1.8f, 4.75f)
            .fireImmune()
            .build("frozen_jellyfish"));

    public static final DeferredHolder<EntityType<?>, EntityType<Sprenging>> SPRENGING = ENTITIES.register("sprenging",
        () -> EntityType.Builder.of(Sprenging::new, MobCategory.CREATURE)
            .sized(2f, 2f)
            .fireImmune()
            .build("sprenging"));

    public static final DeferredHolder<EntityType<?>, EntityType<VoidEye>> VOID_EYE = ENTITIES.register("void_eye",
        () -> EntityType.Builder.of(VoidEye::new, MobCategory.MONSTER)
            .sized(0.9f, 0.9f)
            .fireImmune()
            .build("void_eye"));

    // Lizard Variants
    public static final DeferredHolder<EntityType<?>, EntityType<SporeLizard>> SPORE_LIZARD = ENTITIES.register("spore_lizard",
        () -> EntityType.Builder.of(SporeLizard::new, MobCategory.MONSTER)
            .sized(2.25f, 1.55f)
            .fireImmune()
            .build("spore_lizard"));

    public static final DeferredHolder<EntityType<?>, EntityType<VerdantLizard>> VERDANT_LIZARD = ENTITIES.register("verdant_lizard",
        () -> EntityType.Builder.of(VerdantLizard::new, MobCategory.MONSTER)
            .sized(2.25f, 1.55f)
            .fireImmune()
            .build("verdant_lizard"));

    // Villagers
    public static final DeferredHolder<EntityType<?>, EntityType<EternalTrader>> ETERNAL_TRADER = ENTITIES.register("eternal_trader",
        () -> EntityType.Builder.of(EternalTrader::new, MobCategory.MISC)
            .sized(0.6f, 1.9f)
            .fireImmune()
            .build("eternal_trader"));

    public static final DeferredHolder<EntityType<?>, EntityType<NormalVillager>> NORMAL_VILLAGER = ENTITIES.register("normal_villager",
        () -> EntityType.Builder.of(NormalVillager::new, MobCategory.MISC)
            .sized(0.6f, 1.9f)
            .build("normal_villager"));

    public static final DeferredHolder<EntityType<?>, EntityType<PrismVillager>> PRISM_VILLAGER = ENTITIES.register("prism_villager",
        () -> EntityType.Builder.of(PrismVillager::new, MobCategory.MISC)
            .sized(0.6f, 1.9f)
            .build("prism_villager"));

    public static final DeferredHolder<EntityType<?>, EntityType<SporeVillager>> SPORE_VILLAGER = ENTITIES.register("spore_villager",
        () -> EntityType.Builder.of(SporeVillager::new, MobCategory.MISC)
            .sized(0.6f, 1.9f)
            .build("spore_villager"));

    public static final DeferredHolder<EntityType<?>, EntityType<GildedVillager>> GILDED_VILLAGER = ENTITIES.register("gilded_villager",
        () -> EntityType.Builder.of(GildedVillager::new, MobCategory.MISC)
            .sized(0.6f, 1.9f)
            .build("gilded_villager"));

    public static final DeferredHolder<EntityType<?>, EntityType<ShadowVillager>> SHADOW_VILLAGER = ENTITIES.register("shadow_villager",
        () -> EntityType.Builder.of(ShadowVillager::new, MobCategory.MISC)
            .sized(0.6f, 1.9f)
            .build("shadow_villager"));

    // Golems
    public static final DeferredHolder<EntityType<?>, EntityType<GildedGolem>> GILDED_GOLEM = ENTITIES.register("gilded_golem",
        () -> EntityType.Builder.of(GildedGolem::new, MobCategory.MISC)
            .sized(1.7f, 2.3f)
            .fireImmune()
            .build("gilded_golem"));

    public static final DeferredHolder<EntityType<?>, EntityType<GildedTurtle>> GILDED_TURTLE = ENTITIES.register("gilded_turtle",
        () -> EntityType.Builder.of(GildedTurtle::new, MobCategory.CREATURE)
            .sized(2f, 3.2f)
            .fireImmune()
            .build("gilded_turtle"));

    // Projectiles
    public static final DeferredHolder<EntityType<?>, EntityType<LizardProjectile>> LIZARD_PROJECTILE = ENTITIES.register("lizard_projectile",
        () -> EntityType.Builder.of(EternalEndEntities::lizardProjectile, MobCategory.MISC)
            .sized(0.21f, 0.21f)
            .build("lizard_projectile"));

    public static final DeferredHolder<EntityType<?>, EntityType<WingedEndermanProjectile>> WINGED_ENDERMAN_PROJECTILE = ENTITIES.register("winged_enderman_projectile",
        () -> EntityType.Builder.of(EternalEndEntities::wingedEndermanProjectile, MobCategory.MISC)
            .sized(0.21f, 0.21f)
            .build("winged_enderman_projectile"));

    public static final DeferredHolder<EntityType<?>, EntityType<SporeLizardProjectile>> SPORE_LIZARD_PROJECTILE = ENTITIES.register("spore_lizard_projectile",
        () -> EntityType.Builder.of(EternalEndEntities::sporeLizardProjectile, MobCategory.MISC)
            .sized(0.25f, 0.25f)
            .build("spore_lizard_projectile"));

    public static final DeferredHolder<EntityType<?>, EntityType<GildedGolemProjectile>> GILDED_GOLEM_PROJECTILE = ENTITIES.register("gilded_golem_projectile",
        () -> EntityType.Builder.of(EternalEndEntities::gildedGolemProjectile, MobCategory.MISC)
            .sized(0.25f, 0.25f)
            .build("gilded_golem_projectile"));

    // Special Mobs
    public static final DeferredHolder<EntityType<?>, EntityType<LostSoul>> LOST_SOUL = ENTITIES.register("lost_soul",
        () -> EntityType.Builder.of(LostSoul::new, MobCategory.MISC)
            .sized(0.65f, 0.65f)
            .fireImmune()
            .build("lost_soul"));

    public static final DeferredHolder<EntityType<?>, EntityType<Sveppum>> SVEPPUM = ENTITIES.register("sveppum",
        () -> EntityType.Builder.of(Sveppum::new, MobCategory.CREATURE)
            .sized(1.2f, 1.4f)
            .fireImmune()
            .build("sveppum"));

    // Marker/Utility Entities
    public static final DeferredHolder<EntityType<?>, EntityType<VoidDragonMarker>> VOID_DRAGON_MARKER = ENTITIES.register("void_dragon_marker",
        () -> EntityType.Builder.of(EternalEndEntities::voidDragonMarker, MobCategory.MISC)
            .sized(0.1f, 0.1f)
            .fireImmune()
            .build("void_dragon_marker"));

    public static final DeferredHolder<EntityType<?>, EntityType<StepEntity>> STEP_ENTITY = ENTITIES.register("step_entity",
        () -> EntityType.Builder.of(EternalEndEntities::stepEntity, MobCategory.MISC)
            .sized(0.3f, 0.5f)
            .build("step_entity"));

    public static final DeferredHolder<EntityType<?>, EntityType<PlayerUtility>> PLAYER_UTILITY = ENTITIES.register("player_utility",
        () -> EntityType.Builder.of(EternalEndEntities::playerUtility, MobCategory.MISC)
            .sized(0.1f, 0.1f)
            .build("player_utility"));

    public static final DeferredHolder<EntityType<?>, EntityType<DummyDifficulty>> DUMMY_DIFFICULTY = ENTITIES.register("dummy_difficulty",
        () -> EntityType.Builder.of(EternalEndEntities::dummyDifficulty, MobCategory.MISC)
            .sized(0.1f, 0.1f)
            .build("dummy_difficulty"));

    // Particle entities
    public static final DeferredHolder<EntityType<?>, EntityType<EndPortalParticle>> END_PORTAL_PARTICLE = ENTITIES.register("end_portal_particle",
        () -> EntityType.Builder.of(EternalEndEntities::endPortalParticle, MobCategory.MISC)
            .sized(0.1f, 0.1f)
            .build("end_portal_particle"));

    public static final DeferredHolder<EntityType<?>, EntityType<EnderCrystalParticle>> ENDER_CRYSTAL_PARTICLE = ENTITIES.register("ender_crystal_particle",
        () -> EntityType.Builder.of(EternalEndEntities::enderCrystalParticle, MobCategory.MISC)
            .sized(0.1f, 0.1f)
            .build("ender_crystal_particle"));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
