package org.VenularSpore257.eternal_end_for_java.client.renderer.entity;

import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.npc.VillagerProfession;
import org.VenularSpore257.eternal_end_for_java.Eternal_end_for_java;

/**
 * Renderer for Gilded Villager - Golden End dimension variant.
 */
public class GildedVillagerRenderer extends VillagerRenderer {
    private static final String BASE_PATH = "textures/entity/villager/gilded_villager/";

    public GildedVillagerRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Villager villager) {
        VillagerData data = villager.getVillagerData();
        VillagerProfession profession = data.getProfession();
        String textureName = getTextureNameForProfession(profession);
        return ResourceLocation.fromNamespaceAndPath(Eternal_end_for_java.MODID, BASE_PATH + textureName + ".png");
    }

    private String getTextureNameForProfession(VillagerProfession profession) {
        ResourceLocation professionId = BuiltInRegistries.VILLAGER_PROFESSION.getKey(profession);
        String professionName = professionId != null ? professionId.getPath() : "none";
        return switch (professionName) {
            case "armorer" -> "armorer";
            case "butcher" -> "butcher";
            case "cleric" -> "cleric";
            case "farmer" -> "farmer";
            case "mason" -> "stone_mason";
            case "nitwit" -> "unemployed";
            case "none" -> "unemployed";
            case "toolsmith" -> "toolsmith";
            case "weaponsmith" -> "weaponsmith";
            default -> "unemployed";
        };
    }
}
