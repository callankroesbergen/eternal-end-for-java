package org.VenularSpore257.eternal_end_for_java.client;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;

/**
 * Registry for all Eternal End custom sounds.
 * Sounds are converted from the Bedrock addon's sound_definitions.json.
 *
 * Categories:
 * - Entity Sounds: Ambient, hurt, death, attack sounds for all mobs
 * - Ambient Sounds: Biome-specific ambient loops
 * - UI Sounds: Totem use, book page switch
 * - Dragon Sounds: Boss spawn, death, hurt, attack, flap
 */
public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS =
        DeferredRegister.create(Registries.SOUND_EVENT, Eternal_end_for_java.MODID);

    // ========== UI Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> VOID_TOTEM_USE = register("item.void_totem.use");

    // ========== Void Dragon Boss Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> VOID_DRAGON_SPAWN = register("entity.void_dragon.spawn");
    public static final DeferredHolder<SoundEvent, SoundEvent> VOID_DRAGON_DEATH = register("entity.void_dragon.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> VOID_DRAGON_HURT = register("entity.void_dragon.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> VOID_DRAGON_ATTACK = register("entity.void_dragon.attack");
    public static final DeferredHolder<SoundEvent, SoundEvent> VOID_DRAGON_FLAP = register("entity.void_dragon.flap");

    // ========== Enderman Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> ENDERMAN_AMBIENT = register("entity.enderman.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENDERMAN_HURT = register("entity.enderman.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENDERMAN_DEATH = register("entity.enderman.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENDERMAN_ATTACK = register("entity.enderman.attack");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENDERMAN_AGGRESSIVE = register("entity.enderman.aggressive");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENDERMAN_STATUE_ACTIVATE = register("entity.enderman_statue.activate");

    // Winged Enderman
    public static final DeferredHolder<SoundEvent, SoundEvent> WINGED_ENDERMAN_ATTACK = register("entity.winged_enderman.attack");

    // ========== Doomed Wolf Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> DOOMED_WOLF_AMBIENT = register("entity.doomed_wolf.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> DOOMED_WOLF_HURT = register("entity.doomed_wolf.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> DOOMED_WOLF_DEATH = register("entity.doomed_wolf.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> DOOMED_WOLF_ATTACK = register("entity.doomed_wolf.attack");

    // ========== Endray Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> ENDRAY_AMBIENT = register("entity.endray.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENDRAY_HURT = register("entity.endray.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENDRAY_DEATH = register("entity.endray.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENDRAY_FLAP = register("entity.endray.flap");

    // ========== Deer Sounds ==========
    // Gilded Deer
    public static final DeferredHolder<SoundEvent, SoundEvent> GILDED_DEER_AMBIENT = register("entity.gilded_deer.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> GILDED_DEER_HURT = register("entity.gilded_deer.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> GILDED_DEER_DEATH = register("entity.gilded_deer.death");

    // Shadow Deer
    public static final DeferredHolder<SoundEvent, SoundEvent> SHADOW_DEER_AMBIENT = register("entity.shadow_deer.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHADOW_DEER_HURT = register("entity.shadow_deer.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHADOW_DEER_DEATH = register("entity.shadow_deer.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHADOW_DEER_ATTACK = register("entity.shadow_deer.attack");

    // ========== Golem Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> GILDED_GOLEM_AMBIENT = register("entity.gilded_golem.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> GILDED_GOLEM_HURT = register("entity.gilded_golem.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> GILDED_GOLEM_DEATH = register("entity.gilded_golem.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> GILDED_GOLEM_ATTACK = register("entity.gilded_golem.attack");
    public static final DeferredHolder<SoundEvent, SoundEvent> GILDED_GOLEM_STEP = register("entity.gilded_golem.step");

    // ========== Turtle Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> GILDED_TURTLE_AMBIENT = register("entity.gilded_turtle.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> GILDED_TURTLE_HURT = register("entity.gilded_turtle.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> GILDED_TURTLE_DEATH = register("entity.gilded_turtle.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> GILDED_TURTLE_ROLL_UP = register("entity.gilded_turtle.roll_up");
    public static final DeferredHolder<SoundEvent, SoundEvent> GILDED_TURTLE_STEP = register("entity.gilded_turtle.step");

    // ========== Lizard Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> SPORE_LIZARD_AMBIENT = register("entity.spore_lizard.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> SPORE_LIZARD_HURT = register("entity.spore_lizard.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> SPORE_LIZARD_DEATH = register("entity.spore_lizard.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> SPORE_LIZARD_ATTACK = register("entity.spore_lizard.attack");

    // ========== Frozen Jellyfish Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> FROZEN_JELLYFISH_AMBIENT = register("entity.frozen_jellyfish.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> FROZEN_JELLYFISH_HURT = register("entity.frozen_jellyfish.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> FROZEN_JELLYFISH_DEATH = register("entity.frozen_jellyfish.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> FROZEN_JELLYFISH_ATTACK = register("entity.frozen_jellyfish.attack");

    // ========== Void Eye Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> VOID_EYE_AMBIENT = register("entity.void_eye.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> VOID_EYE_HURT = register("entity.void_eye.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> VOID_EYE_DEATH = register("entity.void_eye.death");

    // ========== Lost Soul Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> LOST_SOUL_AMBIENT = register("entity.lost_soul.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> LOST_SOUL_HURT = register("entity.lost_soul.hurt");

    // ========== Villager Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> VILLAGER_AMBIENT = register("entity.villager.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> VILLAGER_HURT = register("entity.villager.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> VILLAGER_DEATH = register("entity.villager.death");

    // ========== Sprenging Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> SPRENGING_AMBIENT = register("entity.sprenging.ambient");

    // ========== Sveppum Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> SVEPPUM_HURT = register("entity.sveppum.hurt");

    // ========== Ambient Biome Sounds ==========
    // Normal End
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_NORMAL_BASE = register("ambient.end_normal.base");
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_NORMAL_BASE_SWAP = register("ambient.end_normal.base_swap");
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_NORMAL_RANDOM = register("ambient.end_normal.random");

    // Shadow End
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_SHADOW_BASE = register("ambient.end_shadow.base");
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_SHADOW_BASE_SWAP = register("ambient.end_shadow.base_swap");
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_SHADOW_RANDOM = register("ambient.end_shadow.random");

    // Gilded End
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_GILDED_BASE = register("ambient.end_gilded.base");
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_GILDED_BASE_SWAP = register("ambient.end_gilded.base_swap");
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_GILDED_RANDOM = register("ambient.end_gilded.random");

    // Prism End
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_PRISM_BASE = register("ambient.end_prism.base");
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_PRISM_BASE_SWAP = register("ambient.end_prism.base_swap");
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_PRISM_RANDOM = register("ambient.end_prism.random");

    // Sporelight End
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_SPORELIGHT_BASE = register("ambient.end_sporelight.base");
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_SPORELIGHT_BASE_SWAP = register("ambient.end_sporelight.base_swap");
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_SPORELIGHT_RANDOM = register("ambient.end_sporelight.random");

    // Verdant End
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_VERDANT_BASE = register("ambient.end_verdant.base");
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_VERDANT_BASE_SWAP = register("ambient.end_verdant.base_swap");
    public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_END_VERDANT_RANDOM = register("ambient.end_verdant.random");

    // ========== Companion Sounds (for future use) ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> COMPANION_AMBIENT = register("entity.companion.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> COMPANION_HAPPY = register("entity.companion.happy");
    public static final DeferredHolder<SoundEvent, SoundEvent> COMPANION_SNORE = register("entity.companion.snore");
    public static final DeferredHolder<SoundEvent, SoundEvent> COMPANION_HURT = register("entity.companion.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> COMPANION_DEATH = register("entity.companion.death");

    // ========== Frostling Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> FROSTLING_AMBIENT = register("entity.frostling.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> FROSTLING_HURT = register("entity.frostling.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> FROSTLING_DEATH = register("entity.frostling.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> FROSTLING_STEP = register("entity.frostling.step");

    // ========== Glowling Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> GLOWLING_AMBIENT = register("entity.glowling.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> GLOWLING_HURT = register("entity.glowling.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> GLOWLING_DEATH = register("entity.glowling.death");

    // ========== Nybling Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> NYBLING_AMBIENT = register("entity.nybling.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> NYBLING_HURT = register("entity.nybling.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> NYBLING_DEATH = register("entity.nybling.death");

    // ========== Mistling Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> MISTLING_AMBIENT = register("entity.mistling.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> MISTLING_HURT = register("entity.mistling.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> MISTLING_DEATH = register("entity.mistling.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> MISTLING_ATTACK = register("entity.mistling.attack");

    // ========== Voidling Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> VOIDLING_AMBIENT = register("entity.voidling.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> VOIDLING_HURT = register("entity.voidling.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> VOIDLING_DEATH = register("entity.voidling.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> VOIDLING_ATTACK = register("entity.voidling.attack");

    // ========== Ender Slime Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> ENDER_SLIME_AMBIENT = register("entity.ender_slime.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENDER_SLIME_HURT = register("entity.ender_slime.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENDER_SLIME_DEATH = register("entity.ender_slime.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENDER_SLIME_SQUISH = register("entity.ender_slime.squish");

    // ========== Verdant Lizard Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> VERDANT_LIZARD_AMBIENT = register("entity.verdant_lizard.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> VERDANT_LIZARD_HURT = register("entity.verdant_lizard.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> VERDANT_LIZARD_DEATH = register("entity.verdant_lizard.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> VERDANT_LIZARD_ATTACK = register("entity.verdant_lizard.attack");

    // ========== Sveppum Sounds ==========
    public static final DeferredHolder<SoundEvent, SoundEvent> SVEPPUM_AMBIENT = register("entity.sveppum.ambient");
    public static final DeferredHolder<SoundEvent, SoundEvent> SVEPPUM_DEATH = register("entity.sveppum.death");

    /**
     * Helper method to register a sound event.
     * @param name The sound event name (without namespace)
     * @return A DeferredHolder for the sound event
     */
    private static DeferredHolder<SoundEvent, SoundEvent> register(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, name)));
    }

    /**
     * Register all sounds with the mod event bus.
     * Call this from the main mod class.
     */
    public static void register(IEventBus modEventBus) {
        SOUNDS.register(modEventBus);
    }
}
