package org.VenularSpore257.eternal_end_for_java.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.Tags;
import org.VenularSpore257.eternal_end_for_java.EternalEndBlocks;
import org.VenularSpore257.eternal_end_for_java.EternalEndItems;

import java.util.concurrent.CompletableFuture;

/**
 * Item tag provider for Eternal End mod.
 * Creates item tags that mirror block tags where applicable,
 * plus item-specific tags for crafting and tool interactions.
 */
public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTagsProvider,
                              ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTagsProvider, "eternal_end_for_java", existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // ========== INGOT TAGS ==========
        tag(Tags.Items.INGOTS).add(
                EternalEndItems.AMETRINE_INGOT.get(),
                EternalEndItems.ENDERITE_INGOT.get()
        );

        // ========== RAW MATERIAL TAGS ==========
        tag(Tags.Items.RAW_MATERIALS).add(
                EternalEndItems.RAW_PURPURITE.get(),
                EternalEndItems.RAW_DARK_PURPURITE.get()
        );

        // ========== GEM TAGS ==========
        tag(Tags.Items.GEMS).add(
                EternalEndItems.AMETRINE_CRYSTAL.get()
        );

        // ========== TOOL TAGS ==========
        tag(Tags.Items.TOOLS).add(
                EternalEndItems.AMETRINE_PICKAXE.get(),
                EternalEndItems.AMETRINE_AXE.get(),
                EternalEndItems.AMETRINE_SHOVEL.get(),
                EternalEndItems.AMETRINE_HOE.get(),
                EternalEndItems.AMETRINE_SWORD.get(),
                EternalEndItems.ENDERITE_PICKAXE.get(),
                EternalEndItems.ENDERITE_AXE.get(),
                EternalEndItems.ENDERITE_SHOVEL.get(),
                EternalEndItems.ENDERITE_HOE.get(),
                EternalEndItems.ENDERITE_SWORD.get()
        );

        // ========== ARMOR TAGS ==========
        tag(Tags.Items.ARMORS).add(
                EternalEndItems.AMETRINE_HELMET.get(),
                EternalEndItems.AMETRINE_CHESTPLATE.get(),
                EternalEndItems.AMETRINE_LEGGINGS.get(),
                EternalEndItems.AMETRINE_BOOTS.get(),
                EternalEndItems.ENDERITE_HELMET.get(),
                EternalEndItems.ENDERITE_CHESTPLATE.get(),
                EternalEndItems.ENDERITE_LEGGINGS.get(),
                EternalEndItems.ENDERITE_BOOTS.get(),
                EternalEndItems.SHULKER_HELMET.get(),
                EternalEndItems.SHULKER_CHESTPLATE.get(),
                EternalEndItems.SHULKER_LEGGINGS.get(),
                EternalEndItems.SHULKER_BOOTS.get(),
                EternalEndItems.CLOUD_BOOTS.get()
        );

        // ========== FOOD TAGS ==========
        tag(Tags.Items.FOODS).add(
                EternalEndItems.ETERNAL_HEART.get(),
                EternalEndItems.AWKWARD_MUSHROOM_STEW.get(),
                EternalEndItems.GILDED_VENISON.get(),
                EternalEndItems.COOKED_GILDED_VENISON.get(),
                EternalEndItems.MOON_BERRY.get(),
                EternalEndItems.FROSTBLOOM_JELLY.get(),
                EternalEndItems.WHITE_ESSENCE_DRINK.get(),
                EternalEndItems.BLACK_ESSENCE_DRINK.get(),
                EternalEndItems.VERDANT_ESSENCE_DRINK.get()
        );

        // ========== DUST TAGS ==========
        tag(Tags.Items.DUSTS).add(
                EternalEndItems.WHITE_ESSENCE.get(),
                EternalEndItems.BLACK_ESSENCE.get(),
                EternalEndItems.VERDANT_ESSENCE.get()
        );
    }

    @Override
    public String getName() {
        return "Eternal End Item Tags";
    }
}
