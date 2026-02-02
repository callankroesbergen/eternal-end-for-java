package org.VenularSpore257.eternal_end_for_java.entity;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import org.VenularSpore257.eternal_end_for_java.EternalEndEntities;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;

/**
 * Registers default attributes for all Eternal End entities.
 * Without attribute registration, entities will crash when spawned.
 */
@EventBusSubscriber(modid = Eternal_end_for_java.MODID)
public class ModEntityAttributes {

    /**
     * Register default attributes for all living entities.
     * This is required for entities to spawn without crashing.
     */
    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        // Boss
        event.put(EternalEndEntities.VOID_DRAGON.get(), VoidDragon.createAttributes().build());

        // Hostile Mobs
        event.put(EternalEndEntities.DOOMED_WOLF.get(), DoomedWolf.createAttributes().build());
        event.put(EternalEndEntities.WINGED_ENDERMAN.get(), WingedEnderman.createAttributes().build());
        event.put(EternalEndEntities.MISTLING.get(), Mistling.createAttributes().build());
        event.put(EternalEndEntities.VOIDLING.get(), Voidling.createAttributes().build());
        event.put(EternalEndEntities.ENDER_SLIME.get(), EnderSlime.createAttributes().build());

        // Enderman Variants
        event.put(EternalEndEntities.PALE_ENDERMAN.get(), PaleEnderman.createAttributes().build());
        event.put(EternalEndEntities.MOSSY_ENDERMAN.get(), MossyEnderman.createAttributes().build());
        event.put(EternalEndEntities.GILDED_ENDERMAN.get(), GildedEnderman.createAttributes().build());
        event.put(EternalEndEntities.MYCOTIC_ENDERMAN.get(), MycoticEnderman.createAttributes().build());

        // Passive/Neutral Mobs
        event.put(EternalEndEntities.ENDRAY.get(), Endray.createAttributes().build());
        event.put(EternalEndEntities.FROSTLING.get(), Frostling.createAttributes().build());
        event.put(EternalEndEntities.GLOWLING.get(), Glowling.createAttributes().build());
        event.put(EternalEndEntities.NYBLING.get(), Nybling.createAttributes().build());
        event.put(EternalEndEntities.GILDED_DEER.get(), GildedDeer.createAttributes().build());
        event.put(EternalEndEntities.SHADOW_DEER.get(), ShadowDeer.createAttributes().build());
        event.put(EternalEndEntities.FROZEN_JELLYFISH.get(), FrozenJellyfish.createAttributes().build());
        event.put(EternalEndEntities.SPRENGING.get(), Sprenging.createAttributes().build());
        event.put(EternalEndEntities.VOID_EYE.get(), VoidEye.createAttributes().build());

        // Lizard Variants
        event.put(EternalEndEntities.SPORE_LIZARD.get(), SporeLizard.createAttributes().build());
        event.put(EternalEndEntities.VERDANT_LIZARD.get(), VerdantLizard.createAttributes().build());

        // Villagers
        event.put(EternalEndEntities.ETERNAL_TRADER.get(), EternalTrader.createAttributes().build());
        event.put(EternalEndEntities.NORMAL_VILLAGER.get(), NormalVillager.createAttributes().build());
        event.put(EternalEndEntities.PRISM_VILLAGER.get(), PrismVillager.createAttributes().build());
        event.put(EternalEndEntities.SPORE_VILLAGER.get(), SporeVillager.createAttributes().build());
        event.put(EternalEndEntities.GILDED_VILLAGER.get(), GildedVillager.createAttributes().build());
        event.put(EternalEndEntities.SHADOW_VILLAGER.get(), ShadowVillager.createAttributes().build());

        // Golems
        event.put(EternalEndEntities.GILDED_GOLEM.get(), GildedGolem.createAttributes().build());
        event.put(EternalEndEntities.GILDED_TURTLE.get(), GildedTurtle.createAttributes().build());

        // Special Mobs
        event.put(EternalEndEntities.LOST_SOUL.get(), LostSoul.createAttributes().build());
        event.put(EternalEndEntities.SVEPPUM.get(), Sveppum.createAttributes().build());
    }
}
