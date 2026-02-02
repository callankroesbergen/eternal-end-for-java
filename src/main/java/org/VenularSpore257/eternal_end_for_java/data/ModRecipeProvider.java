package org.VenularSpore257.eternal_end_for_java.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import org.VenularSpore257.eternal_end_for_java.EternalEndBlocks;
import org.VenularSpore257.eternal_end_for_java.EternalEndItems;

import java.util.concurrent.CompletableFuture;
import java.util.List;

/**
 * Recipe provider for Eternal End mod.
 *
 * Converted from Bedrock addon recipes.
 *
 * Recipe breakdown:
 * - 353 shaped recipes (crafting grid patterns)
 * - 72 shapeless recipes (ingredient combinations)
 * - 45 smelting recipes (furnace cooking)
 */
public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

    // ========== SHAPED RECIPES ==========

    // spored_planks_smithing.json - spored_planks_smithing
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SMITHING_TABLE)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('I', Items.IRON_INGOT)
        .pattern("II")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // chorus_planks_loom.json - chorus_planks_loom
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LOOM)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('S', Items.STRING)
        .pattern("SS")
        .pattern("##")
        .unlockedBy("has_string", has(Items.STRING))
        .save(output);

    // void_gateway_noctral_slab.json - void_gateway_noctral_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.VOID_GATEWAY)
        .define('C', EternalEndItems.GOLEM_CORE)
        .define('E', Items.END_STONE)
        .define('N', EternalEndBlocks.NOCTRAL_STONE)
        .define('S', EternalEndBlocks.NOCTRAL_SLAB)
        .define('X', Items.ENDER_EYE)
        .pattern("SSS")
        .pattern("XCX")
        .pattern("EEE")
        .unlockedBy("has_noctral_stone", has(EternalEndBlocks.NOCTRAL_STONE))
        .save(output);

    // whispering_trapdoor.json - whispering_trapdoor
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.WHISPERING_TRAPDOOR, 2)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // whispering_planks_chest.json - whispering_planks_chest
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHEST)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .pattern("###")
        .pattern("# #")
        .pattern("###")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // honey_stripped_wood_log.json - honey_stripped_wood_log
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.HONEY_STRIPPED_WOOD, 3)
        .define('#', EternalEndBlocks.HONEY_STRIPPED_LOG)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_honey_stripped_log", has(EternalEndBlocks.HONEY_STRIPPED_LOG))
        .save(output);

    // spored_fence_gate.json - spored_fence_gate
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SPORED_FENCE_GATE)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('S', Items.STICK)
        .pattern("S#S")
        .pattern("S#S")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // spored_planks_bookshelf.json - spored_planks_bookshelf
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BOOKSHELF)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('B', Items.BOOK)
        .pattern("###")
        .pattern("BBB")
        .pattern("###")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // chorus_planks_shield.json - chorus_planks_shield
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SHIELD)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('I', Items.IRON_INGOT)
        .pattern("#I#")
        .pattern("###")
        .pattern(" # ")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // honey_planks_tripwire_hook.json - honey_planks_tripwire_hook
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TRIPWIRE_HOOK)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('I', Items.IRON_INGOT)
        .define('S', Items.STICK)
        .pattern("I")
        .pattern("S")
        .pattern("#")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // scorched_planks_fletching_table.json - scorched_planks_fletching_table
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.FLETCHING_TABLE)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('F', Items.FLINT)
        .pattern("FF")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // cryolite_log_soul_campfire.json - cryolite_log_soul_campfire
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SOUL_CAMPFIRE)
        .define('#', EternalEndBlocks.CRYOLITE_LOG)
        .define('C', Items.SOUL_SAND)
        .define('S', Items.STICK)
        .pattern(" S ")
        .pattern("SCS")
        .pattern("###")
        .unlockedBy("has_cryolite_log", has(EternalEndBlocks.CRYOLITE_LOG))
        .save(output);

    // noctral_slab.json - noctral_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.NOCTRAL_SLAB, 6)
        .define('#', EternalEndBlocks.NOCTRAL_STONE)
        .pattern("###")
        .unlockedBy("has_noctral_stone", has(EternalEndBlocks.NOCTRAL_STONE))
        .save(output);

    // chorus_planks_jukebox.json - chorus_planks_jukebox
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.JUKEBOX)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('D', Items.DIAMOND)
        .pattern("###")
        .pattern("#D#")
        .pattern("###")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // honey_planks_noteblock.json - honey_planks_noteblock
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NOTE_BLOCK)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('R', Items.REDSTONE)
        .pattern("###")
        .pattern("#R#")
        .pattern("###")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // spored_planks_shovel.json - spored_planks_shovel
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_SHOVEL)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('S', Items.STICK)
        .pattern("#")
        .pattern("S")
        .pattern("S")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // chorus_wood_log.json - chorus_wood_log
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CHORUS_WOOD, 3)
        .define('#', EternalEndBlocks.CHORUS_LOG)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_chorus_log", has(EternalEndBlocks.CHORUS_LOG))
        .save(output);

    // cryolite_fence_gate.json - cryolite_fence_gate
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CRYOLITE_FENCE_GATE)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('S', Items.STICK)
        .pattern("S#S")
        .pattern("S#S")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // purpur_wall.json - purpur_wall
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.PURPUR_WALL, 6)
        .define('#', Items.PURPUR_BLOCK)
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_purpur_block", has(Items.PURPUR_BLOCK))
        .save(output);

    // spored_planks_sticks.json - spored_planks_sticks
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 4)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .pattern("#")
        .pattern("#")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // whispering_planks_beehive.json - whispering_planks_beehive
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BEEHIVE)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('H', Items.HONEYCOMB)
        .pattern("###")
        .pattern("HHH")
        .pattern("###")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // fungal_stairs_left.json - fungal_stairs_left
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.FUNGAL_STAIRS, 4)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // fungal_log_soul_campfire.json - fungal_log_soul_campfire
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SOUL_CAMPFIRE)
        .define('#', EternalEndBlocks.FUNGAL_LOG)
        .define('C', Items.SOUL_SAND)
        .define('S', Items.STICK)
        .pattern(" S ")
        .pattern("SCS")
        .pattern("###")
        .unlockedBy("has_fungal_log", has(EternalEndBlocks.FUNGAL_LOG))
        .save(output);

    // noctral_slates_slab.json - noctral_slates_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.NOCTRAL_SLATES_SLAB, 6)
        .define('#', EternalEndBlocks.NOCTRAL_SLATES)
        .pattern("###")
        .unlockedBy("has_noctral_slates", has(EternalEndBlocks.NOCTRAL_SLATES))
        .save(output);

    // fungal_fence_gate.json - fungal_fence_gate
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.FUNGAL_FENCE_GATE)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('S', Items.STICK)
        .pattern("S#S")
        .pattern("S#S")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // whispering_planks_grindstone.json - whispering_planks_grindstone
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GRINDSTONE)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('P', Items.STONE_SLAB)
        .define('S', Items.STICK)
        .pattern("SPS")
        .pattern("# #")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // whispering_planks_sword.json - whispering_planks_sword
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_SWORD)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('S', Items.STICK)
        .pattern("#")
        .pattern("# ")
        .pattern("S")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // chorus_planks_fletching_table.json - chorus_planks_fletching_table
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.FLETCHING_TABLE)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('F', Items.FLINT)
        .pattern("FF")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // fungal_door.json - fungal_door
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.FUNGAL_DOOR, 3)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .pattern("##")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // fungal_planks_piston.json - fungal_planks_piston
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PISTON)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('C', Items.COBBLESTONE)
        .define('I', Items.IRON_INGOT)
        .define('R', Items.REDSTONE)
        .pattern("###")
        .pattern("CIC")
        .pattern("CRC")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // honey_planks_fletching_table.json - honey_planks_fletching_table
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.FLETCHING_TABLE)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('F', Items.FLINT)
        .pattern("FF")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // noctral_stairs_right.json - noctral_stairs_right
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.NOCTRAL_STAIRS, 4)
        .define('#', EternalEndBlocks.NOCTRAL_STONE)
        .pattern("  #")
        .pattern(" ##")
        .pattern("###")
        .unlockedBy("has_noctral_stone", has(EternalEndBlocks.NOCTRAL_STONE))
        .save(output);

    // chorus_planks_cartography_table.json - chorus_planks_cartography_table
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CARTOGRAPHY_TABLE)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('P', Items.PAPER)
        .pattern("PP")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // spored_door.json - spored_door
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SPORED_DOOR, 3)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .pattern("##")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // scorched_slab.json - scorched_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SCORCHED_SLAB, 6)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .pattern("###")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // cryolite_planks_crafting.json - cryolite_planks_crafting
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CRAFTING_TABLE)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // chorus_slab.json - chorus_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CHORUS_SLAB, 6)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .pattern("###")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // scorched_planks_grindstone.json - scorched_planks_grindstone
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GRINDSTONE)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('P', Items.STONE_SLAB)
        .define('S', Items.STICK)
        .pattern("SPS")
        .pattern("# #")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // shulker_leggings.json - shulker_leggings
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndItems.SHULKER_LEGGINGS)
        .define('#', Items.SHULKER_SHELL)
        .pattern("###")
        .pattern("# #")
        .pattern("# #")
        .unlockedBy("has_shulker_shell", has(Items.SHULKER_SHELL))
        .save(output);

    // dark_purpur_stairs_right.json - dark_purpur_stairs_right
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.DARK_PURPUR_STAIRS, 4)
        .define('#', EternalEndBlocks.DARK_PURPUR_BLOCK)
        .pattern("  #")
        .pattern(" ##")
        .pattern("###")
        .unlockedBy("has_dark_purpur_block", has(EternalEndBlocks.DARK_PURPUR_BLOCK))
        .save(output);

    // spored_planks_beehive.json - spored_planks_beehive
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BEEHIVE)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('H', Items.HONEYCOMB)
        .pattern("###")
        .pattern("HHH")
        .pattern("###")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // honey_stairs_left.json - honey_stairs_left
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.HONEY_STAIRS, 4)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // chorus_planks_noteblock.json - chorus_planks_noteblock
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NOTE_BLOCK)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('R', Items.REDSTONE)
        .pattern("###")
        .pattern("#R#")
        .pattern("###")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // fungal_log_campfire.json - fungal_log_campfire
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CAMPFIRE)
        .define('#', EternalEndBlocks.FUNGAL_LOG)
        .define('C', Items.COAL)
        .define('S', Items.STICK)
        .pattern(" S ")
        .pattern("SCS")
        .pattern("###")
        .unlockedBy("has_fungal_log", has(EternalEndBlocks.FUNGAL_LOG))
        .save(output);

    // spored_slab_chiseled_bookshelf.json - spored_slab_chiseled_bookshelf
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHISELED_BOOKSHELF)
        .define('#', EternalEndBlocks.SPORED_SLAB)
        .define('P', EternalEndBlocks.SPORED_PLANKS)
        .pattern("PPP")
        .pattern("###")
        .pattern("PPP")
        .unlockedBy("has_spored_slab", has(EternalEndBlocks.SPORED_SLAB))
        .save(output);

    // cryolite_trapdoor.json - cryolite_trapdoor
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CRYOLITE_TRAPDOOR, 2)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // spored_log_campfire.json - spored_log_campfire
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CAMPFIRE)
        .define('#', EternalEndBlocks.SPORED_LOG)
        .define('C', Items.COAL)
        .define('S', Items.STICK)
        .pattern(" S ")
        .pattern("SCS")
        .pattern("###")
        .unlockedBy("has_spored_log", has(EternalEndBlocks.SPORED_LOG))
        .save(output);

    // scorched_fence.json - scorched_fence
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SCORCHED_FENCE, 3)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('S', Items.STICK)
        .pattern("#S#")
        .pattern("#S#")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // honey_planks_piston.json - honey_planks_piston
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PISTON)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('C', Items.COBBLESTONE)
        .define('I', Items.IRON_INGOT)
        .define('R', Items.REDSTONE)
        .pattern("###")
        .pattern("CIC")
        .pattern("CRC")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // whispering_planks_sticks.json - whispering_planks_sticks
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 4)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .pattern("#")
        .pattern("#")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // fungal_planks_smithing.json - fungal_planks_smithing
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SMITHING_TABLE)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('I', Items.IRON_INGOT)
        .pattern("II")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // scorched_planks_beehive.json - scorched_planks_beehive
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BEEHIVE)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('H', Items.HONEYCOMB)
        .pattern("###")
        .pattern("HHH")
        .pattern("###")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // noctral_wall.json - noctral_wall
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.NOCTRAL_WALL, 6)
        .define('#', EternalEndBlocks.NOCTRAL_STONE)
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_noctral_stone", has(EternalEndBlocks.NOCTRAL_STONE))
        .save(output);

    // scorched_slab_lectern.json - scorched_slab_lectern
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LECTERN)
        .define('#', EternalEndBlocks.SCORCHED_SLAB)
        .define('B', Items.BOOKSHELF)
        .pattern("###")
        .pattern(" B ")
        .pattern(" # ")
        .unlockedBy("has_scorched_slab", has(EternalEndBlocks.SCORCHED_SLAB))
        .save(output);

    // honey_wood_log.json - honey_wood_log
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.HONEY_WOOD, 3)
        .define('#', EternalEndBlocks.HONEY_LOG)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_honey_log", has(EternalEndBlocks.HONEY_LOG))
        .save(output);

    // cryolite_planks_chest.json - cryolite_planks_chest
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHEST)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .pattern("###")
        .pattern("# #")
        .pattern("###")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // spored_planks_loom.json - spored_planks_loom
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LOOM)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('S', Items.STRING)
        .pattern("SS")
        .pattern("##")
        .unlockedBy("has_string", has(Items.STRING))
        .save(output);

    // scorched_log_smoker.json - scorched_log_smoker
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SMOKER)
        .define('#', EternalEndBlocks.SCORCHED_LOG)
        .define('F', Items.FURNACE)
        .pattern(" # ")
        .pattern("#F#")
        .pattern(" # ")
        .unlockedBy("has_scorched_log", has(EternalEndBlocks.SCORCHED_LOG))
        .save(output);

    // cryolite_planks_beehive.json - cryolite_planks_beehive
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BEEHIVE)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('H', Items.HONEYCOMB)
        .pattern("###")
        .pattern("HHH")
        .pattern("###")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // chorus_planks_chest.json - chorus_planks_chest
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHEST)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .pattern("###")
        .pattern("# #")
        .pattern("###")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // scorched_planks_shovel.json - scorched_planks_shovel
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_SHOVEL)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('S', Items.STICK)
        .pattern("#")
        .pattern("S")
        .pattern("S")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // whispering_slab_chiseled_bookshelf.json - whispering_slab_chiseled_bookshelf
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHISELED_BOOKSHELF)
        .define('#', EternalEndBlocks.WHISPERING_SLAB)
        .define('P', EternalEndBlocks.WHISPERING_PLANKS)
        .pattern("PPP")
        .pattern("###")
        .pattern("PPP")
        .unlockedBy("has_whispering_slab", has(EternalEndBlocks.WHISPERING_SLAB))
        .save(output);

    // honey_planks_beehive.json - honey_planks_beehive
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BEEHIVE)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('H', Items.HONEYCOMB)
        .pattern("###")
        .pattern("HHH")
        .pattern("###")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // whispering_planks_smithing.json - whispering_planks_smithing
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SMITHING_TABLE)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('I', Items.IRON_INGOT)
        .pattern("II")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // ametrine_boots.json - ametrine_boots
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndItems.AMETRINE_BOOTS)
        .define('#', EternalEndItems.AMETRINE_CRYSTAL)
        .pattern("# #")
        .pattern("# #")
        .unlockedBy("has_ametrine_crystal", has(EternalEndItems.AMETRINE_CRYSTAL))
        .save(output);

    // settings.json - settings
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndItems.SETTINGS)
        .define('e', Items.ENDER_PEARL)
        .define('i', Items.IRON_INGOT)
        .pattern(" i ")
        .pattern("iei")
        .pattern(" i ")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // honey_slab_daylight_sensor.json - honey_slab_daylight_sensor
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.DAYLIGHT_DETECTOR)
        .define('#', EternalEndBlocks.HONEY_SLAB)
        .define('G', Items.GLASS)
        .define('Q', Items.QUARTZ)
        .pattern("GGG")
        .pattern("QQQ")
        .pattern("###")
        .unlockedBy("has_honey_slab", has(EternalEndBlocks.HONEY_SLAB))
        .save(output);

    // chorus_planks_hoe.json - chorus_planks_hoe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_HOE)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('S', Items.STICK)
        .pattern("##")
        .pattern(" S")
        .pattern(" S")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // fungal_planks_fletching_table.json - fungal_planks_fletching_table
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.FLETCHING_TABLE)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('F', Items.FLINT)
        .pattern("FF")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // whispering_planks_hoe.json - whispering_planks_hoe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_HOE)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('S', Items.STICK)
        .pattern("##")
        .pattern(" S")
        .pattern(" S")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // honey_slab_lectern.json - honey_slab_lectern
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LECTERN)
        .define('#', EternalEndBlocks.HONEY_SLAB)
        .define('B', Items.BOOKSHELF)
        .pattern("###")
        .pattern(" B ")
        .pattern(" # ")
        .unlockedBy("has_honey_slab", has(EternalEndBlocks.HONEY_SLAB))
        .save(output);

    // noctral_stairs_left.json - noctral_stairs_left
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.NOCTRAL_STAIRS, 4)
        .define('#', EternalEndBlocks.NOCTRAL_STONE)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .unlockedBy("has_noctral_stone", has(EternalEndBlocks.NOCTRAL_STONE))
        .save(output);

    // scorched_planks_bookshelf.json - scorched_planks_bookshelf
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BOOKSHELF)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('B', Items.BOOK)
        .pattern("###")
        .pattern("BBB")
        .pattern("###")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // honey_planks_hoe.json - honey_planks_hoe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_HOE)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('S', Items.STICK)
        .pattern("##")
        .pattern(" S")
        .pattern(" S")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // cryolite_door.json - cryolite_door
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CRYOLITE_DOOR, 3)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .pattern("##")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // noctral_slates_wall.json - noctral_slates_wall
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.NOCTRAL_SLATES_WALL, 6)
        .define('#', EternalEndBlocks.NOCTRAL_SLATES)
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_noctral_slates", has(EternalEndBlocks.NOCTRAL_SLATES))
        .save(output);

    // cryolite_planks_shield.json - cryolite_planks_shield
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SHIELD)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('I', Items.IRON_INGOT)
        .pattern("#I#")
        .pattern("###")
        .pattern(" # ")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // cryolite_planks_sword.json - cryolite_planks_sword
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_SWORD)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('S', Items.STICK)
        .pattern("#")
        .pattern("# ")
        .pattern("S")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // scorched_planks_sticks.json - scorched_planks_sticks
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 4)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .pattern("#")
        .pattern("#")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // chorus_planks_sword.json - chorus_planks_sword
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_SWORD)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('S', Items.STICK)
        .pattern("#")
        .pattern("# ")
        .pattern("S")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // ender_slime_lead.json - ender_slime_lead
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LEAD, 2)
        .define('O', EternalEndItems.ENDER_SLIME)
        .define('~', Items.STRING)
        .pattern("~~ ")
        .pattern("~O ")
        .pattern("  ~")
        .unlockedBy("has_string", has(Items.STRING))
        .save(output);

    // fungal_fence.json - fungal_fence
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.FUNGAL_FENCE, 3)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('S', Items.STICK)
        .pattern("#S#")
        .pattern("#S#")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // honey_planks_axe.json - honey_planks_axe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_AXE)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('S', Items.STICK)
        .pattern("##")
        .pattern("#S")
        .pattern(" S")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // spored_trapdoor.json - spored_trapdoor
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SPORED_TRAPDOOR, 2)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // whispering_planks_shovel.json - whispering_planks_shovel
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_SHOVEL)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('S', Items.STICK)
        .pattern("#")
        .pattern("S")
        .pattern("S")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // whispering_planks_axe.json - whispering_planks_axe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_AXE)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('S', Items.STICK)
        .pattern("##")
        .pattern("#S")
        .pattern(" S")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // chorus_planks_axe.json - chorus_planks_axe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_AXE)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('S', Items.STICK)
        .pattern("##")
        .pattern("#S")
        .pattern(" S")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // cryolite_slab_barrel.json - cryolite_slab_barrel
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BARREL)
        .define('#', EternalEndBlocks.CRYOLITE_SLAB)
        .define('P', EternalEndBlocks.CRYOLITE_PLANKS)
        .pattern("P#P")
        .pattern("P P")
        .pattern("P#P")
        .unlockedBy("has_cryolite_slab", has(EternalEndBlocks.CRYOLITE_SLAB))
        .save(output);

    // spored_planks_noteblock.json - spored_planks_noteblock
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NOTE_BLOCK)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('R', Items.REDSTONE)
        .pattern("###")
        .pattern("#R#")
        .pattern("###")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // mycelion_mire_stairs_right.json - mycelion_mire_stairs_right
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.MYCELION_MIRE_STAIRS, 4)
        .define('#', EternalEndBlocks.MYCELION_MIRE)
        .pattern("  #")
        .pattern(" ##")
        .pattern("###")
        .unlockedBy("has_mycelion_mire", has(EternalEndBlocks.MYCELION_MIRE))
        .save(output);

    // mycelion_mire_stairs_left.json - mycelion_mire_stairs_left
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.MYCELION_MIRE_STAIRS, 4)
        .define('#', EternalEndBlocks.MYCELION_MIRE)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .unlockedBy("has_mycelion_mire", has(EternalEndBlocks.MYCELION_MIRE))
        .save(output);

    // shulker_boots.json - shulker_boots
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndItems.SHULKER_BOOTS)
        .define('#', Items.SHULKER_SHELL)
        .pattern("# #")
        .pattern("# #")
        .unlockedBy("has_shulker_shell", has(Items.SHULKER_SHELL))
        .save(output);

    // fungal_trapdoor.json - fungal_trapdoor
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.FUNGAL_TRAPDOOR, 2)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // fungal_planks_sword.json - fungal_planks_sword
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_SWORD)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('S', Items.STICK)
        .pattern("#")
        .pattern("# ")
        .pattern("S")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // ametrine_helmet.json - ametrine_helmet
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndItems.AMETRINE_HELMET)
        .define('#', EternalEndItems.AMETRINE_CRYSTAL)
        .pattern("###")
        .pattern("# #")
        .unlockedBy("has_ametrine_crystal", has(EternalEndItems.AMETRINE_CRYSTAL))
        .save(output);

    // chorus_stairs_left.json - chorus_stairs_left
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CHORUS_STAIRS, 4)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // spored_planks_sword.json - spored_planks_sword
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_SWORD)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('S', Items.STICK)
        .pattern("#")
        .pattern("# ")
        .pattern("S")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // whispering_planks_shield.json - whispering_planks_shield
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SHIELD)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('I', Items.IRON_INGOT)
        .pattern("#I#")
        .pattern("###")
        .pattern(" # ")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // shulker_chestplate.json - shulker_chestplate
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndItems.SHULKER_CHESTPLATE)
        .define('#', Items.SHULKER_SHELL)
        .pattern("# #")
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_shulker_shell", has(Items.SHULKER_SHELL))
        .save(output);

    // whispering_planks_pickaxe.json - whispering_planks_pickaxe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_PICKAXE)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('S', Items.STICK)
        .pattern("###")
        .pattern(" S ")
        .pattern(" S ")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // cryolite_slab_daylight_sensor.json - cryolite_slab_daylight_sensor
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.DAYLIGHT_DETECTOR)
        .define('#', EternalEndBlocks.CRYOLITE_SLAB)
        .define('G', Items.GLASS)
        .define('Q', Items.QUARTZ)
        .pattern("GGG")
        .pattern("QQQ")
        .pattern("###")
        .unlockedBy("has_cryolite_slab", has(EternalEndBlocks.CRYOLITE_SLAB))
        .save(output);

    // spored_wood_wood.json - spored_wood_wood
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SPORED_LOG, 4)
        .define('#', EternalEndBlocks.SPORED_WOOD)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_spored_wood", has(EternalEndBlocks.SPORED_WOOD))
        .save(output);

    // spored_planks_pickaxe.json - spored_planks_pickaxe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_PICKAXE)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('S', Items.STICK)
        .pattern("###")
        .pattern(" S ")
        .pattern(" S ")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // spored_planks_grindstone.json - spored_planks_grindstone
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GRINDSTONE)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('P', Items.STONE_SLAB)
        .define('S', Items.STICK)
        .pattern("SPS")
        .pattern("# #")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // cryolite_planks_shovel.json - cryolite_planks_shovel
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_SHOVEL)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('S', Items.STICK)
        .pattern("#")
        .pattern("S")
        .pattern("S")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // whispering_slab_barrel.json - whispering_slab_barrel
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BARREL)
        .define('#', EternalEndBlocks.WHISPERING_SLAB)
        .define('P', EternalEndBlocks.WHISPERING_PLANKS)
        .pattern("P#P")
        .pattern("P P")
        .pattern("P#P")
        .unlockedBy("has_whispering_slab", has(EternalEndBlocks.WHISPERING_SLAB))
        .save(output);

    // honey_stairs_right.json - honey_stairs_right
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.HONEY_STAIRS, 4)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .pattern("  #")
        .pattern(" ##")
        .pattern("###")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // cryolite_planks_smithing.json - cryolite_planks_smithing
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SMITHING_TABLE)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('I', Items.IRON_INGOT)
        .pattern("II")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // honey_planks_bookshelf.json - honey_planks_bookshelf
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BOOKSHELF)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('B', Items.BOOK)
        .pattern("###")
        .pattern("BBB")
        .pattern("###")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // scorched_planks_cartography_table.json - scorched_planks_cartography_table
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CARTOGRAPHY_TABLE)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('P', Items.PAPER)
        .pattern("PP")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // fungal_planks_bed.json - fungal_planks_bed
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WHITE_BED)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('W', Items.WHITE_WOOL)
        .pattern("WWW")
        .pattern("###")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // whispering_planks_bowl.json - whispering_planks_bowl
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BOWL, 4)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .pattern("# #")
        .pattern(" # ")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // cryolite_log_campfire.json - cryolite_log_campfire
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CAMPFIRE)
        .define('#', EternalEndBlocks.CRYOLITE_LOG)
        .define('C', Items.COAL)
        .define('S', Items.STICK)
        .pattern(" S ")
        .pattern("SCS")
        .pattern("###")
        .unlockedBy("has_cryolite_log", has(EternalEndBlocks.CRYOLITE_LOG))
        .save(output);

    // spored_planks_crafting.json - spored_planks_crafting
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CRAFTING_TABLE)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // chorus_log_campfire.json - chorus_log_campfire
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CAMPFIRE)
        .define('#', EternalEndBlocks.CHORUS_LOG)
        .define('C', Items.COAL)
        .define('S', Items.STICK)
        .pattern(" S ")
        .pattern("SCS")
        .pattern("###")
        .unlockedBy("has_chorus_log", has(EternalEndBlocks.CHORUS_LOG))
        .save(output);

    // fungal_planks_loom.json - fungal_planks_loom
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LOOM)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('S', Items.STRING)
        .pattern("SS")
        .pattern("##")
        .unlockedBy("has_string", has(Items.STRING))
        .save(output);

    // shulker_helmet.json - shulker_helmet
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndItems.SHULKER_HELMET)
        .define('#', Items.SHULKER_SHELL)
        .pattern("###")
        .pattern("# #")
        .unlockedBy("has_shulker_shell", has(Items.SHULKER_SHELL))
        .save(output);

    // scorched_wood_log.json - scorched_wood_log
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SCORCHED_WOOD, 3)
        .define('#', EternalEndBlocks.SCORCHED_LOG)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_scorched_log", has(EternalEndBlocks.SCORCHED_LOG))
        .save(output);

    // fungal_planks_tripwire_hook.json - fungal_planks_tripwire_hook
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TRIPWIRE_HOOK)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('I', Items.IRON_INGOT)
        .define('S', Items.STICK)
        .pattern("I")
        .pattern("S")
        .pattern("#")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // cryolite_planks_sticks.json - cryolite_planks_sticks
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 4)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .pattern("#")
        .pattern("#")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // scorched_stairs_right.json - scorched_stairs_right
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SCORCHED_STAIRS, 4)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .pattern("  #")
        .pattern(" ##")
        .pattern("###")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // scorched_planks_shield.json - scorched_planks_shield
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SHIELD)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('I', Items.IRON_INGOT)
        .pattern("#I#")
        .pattern("###")
        .pattern(" # ")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // cryolite_planks_bed.json - cryolite_planks_bed
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WHITE_BED)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('W', Items.WHITE_WOOL)
        .pattern("WWW")
        .pattern("###")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // honey_slab_composter.json - honey_slab_composter
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COMPOSTER)
        .define('#', EternalEndBlocks.HONEY_SLAB)
        .pattern("# #")
        .pattern("# #")
        .pattern("###")
        .unlockedBy("has_honey_slab", has(EternalEndBlocks.HONEY_SLAB))
        .save(output);

    // fungal_planks_chest.json - fungal_planks_chest
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHEST)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .pattern("###")
        .pattern("# #")
        .pattern("###")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // spored_planks_chest.json - spored_planks_chest
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHEST)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .pattern("###")
        .pattern("# #")
        .pattern("###")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // scorched_slab_composter.json - scorched_slab_composter
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COMPOSTER)
        .define('#', EternalEndBlocks.SCORCHED_SLAB)
        .pattern("# #")
        .pattern("# #")
        .pattern("###")
        .unlockedBy("has_scorched_slab", has(EternalEndBlocks.SCORCHED_SLAB))
        .save(output);

    // void_gateway_stand_noctral_bricks_slab.json - void_gateway_stand_noctral_bricks_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.VOID_GATEWAY_STAND)
        .define('E', Items.EMERALD)
        .define('N', EternalEndBlocks.NOCTRAL_BRICKS_SLAB)
        .define('S', Items.END_STONE)
        .pattern("NEN")
        .pattern(" S ")
        .pattern("NNN")
        .unlockedBy("has_emerald", has(Items.EMERALD))
        .save(output);

    // cryolite_planks_bowl.json - cryolite_planks_bowl
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BOWL, 4)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .pattern("# #")
        .pattern(" # ")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // viridian_wall.json - viridian_wall
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.VIRIDIAN_WALL, 6)
        .define('#', EternalEndBlocks.VIRIDIAN_BRICKS)
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_viridian_bricks", has(EternalEndBlocks.VIRIDIAN_BRICKS))
        .save(output);

    // spored_planks_bed.json - spored_planks_bed
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WHITE_BED)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('W', Items.WHITE_WOOL)
        .pattern("WWW")
        .pattern("###")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // cryolite_slab_composter.json - cryolite_slab_composter
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COMPOSTER)
        .define('#', EternalEndBlocks.CRYOLITE_SLAB)
        .pattern("# #")
        .pattern("# #")
        .pattern("###")
        .unlockedBy("has_cryolite_slab", has(EternalEndBlocks.CRYOLITE_SLAB))
        .save(output);

    // scorched_planks_hoe.json - scorched_planks_hoe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_HOE)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('S', Items.STICK)
        .pattern("##")
        .pattern(" S")
        .pattern(" S")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // respawn_anchor.json - respawn_anchor
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.RESPAWN_ANCHOR)
        .define('C', EternalEndItems.GOLEM_CORE)
        .define('E', Items.END_STONE)
        .define('N', EternalEndBlocks.NOCTRAL_STONE)
        .define('V', EternalEndItems.VERDANT_ESSENCE)
        .pattern("NNN")
        .pattern("VCV")
        .pattern("EEE")
        .unlockedBy("has_noctral_stone", has(EternalEndBlocks.NOCTRAL_STONE))
        .save(output);

    // cryolite_planks_fletching_table.json - cryolite_planks_fletching_table
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.FLETCHING_TABLE)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('F', Items.FLINT)
        .pattern("FF")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // noctral_bricks_stairs_right.json - noctral_bricks_stairs_right
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.NOCTRAL_BRICKS_STAIRS, 4)
        .define('#', EternalEndBlocks.NOCTRAL_BRICKS)
        .pattern("  #")
        .pattern(" ##")
        .pattern("###")
        .unlockedBy("has_noctral_bricks", has(EternalEndBlocks.NOCTRAL_BRICKS))
        .save(output);

    // chorus_planks_bookshelf.json - chorus_planks_bookshelf
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BOOKSHELF)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('B', Items.BOOK)
        .pattern("###")
        .pattern("BBB")
        .pattern("###")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // fungal_stripped_wood_log.json - fungal_stripped_wood_log
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.FUNGAL_STRIPPED_WOOD, 3)
        .define('#', EternalEndBlocks.FUNGAL_STRIPPED_LOG)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_fungal_stripped_log", has(EternalEndBlocks.FUNGAL_STRIPPED_LOG))
        .save(output);

    // cryolite_fence.json - cryolite_fence
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CRYOLITE_FENCE, 3)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('S', Items.STICK)
        .pattern("#S#")
        .pattern("#S#")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // void_gateway_noctral_slates_slab.json - void_gateway_noctral_slates_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.VOID_GATEWAY)
        .define('C', EternalEndItems.GOLEM_CORE)
        .define('E', Items.END_STONE)
        .define('N', EternalEndBlocks.NOCTRAL_STONE)
        .define('S', EternalEndBlocks.NOCTRAL_SLATES_SLAB)
        .define('X', Items.ENDER_EYE)
        .pattern("SSS")
        .pattern("XCX")
        .pattern("EEE")
        .unlockedBy("has_noctral_stone", has(EternalEndBlocks.NOCTRAL_STONE))
        .save(output);

    // fungal_planks_jukebox.json - fungal_planks_jukebox
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.JUKEBOX)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('D', Items.DIAMOND)
        .pattern("###")
        .pattern("#D#")
        .pattern("###")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // noctral_slates_stairs_left.json - noctral_slates_stairs_left
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.NOCTRAL_SLATES_STAIRS, 4)
        .define('#', EternalEndBlocks.NOCTRAL_SLATES)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .unlockedBy("has_noctral_slates", has(EternalEndBlocks.NOCTRAL_SLATES))
        .save(output);

    // whispering_slab_composter.json - whispering_slab_composter
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COMPOSTER)
        .define('#', EternalEndBlocks.WHISPERING_SLAB)
        .pattern("# #")
        .pattern("# #")
        .pattern("###")
        .unlockedBy("has_whispering_slab", has(EternalEndBlocks.WHISPERING_SLAB))
        .save(output);

    // honey_planks_loom.json - honey_planks_loom
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LOOM)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('S', Items.STRING)
        .pattern("SS")
        .pattern("##")
        .unlockedBy("has_string", has(Items.STRING))
        .save(output);

    // honey_planks_cartography_table.json - honey_planks_cartography_table
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CARTOGRAPHY_TABLE)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('P', Items.PAPER)
        .pattern("PP")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // chorus_planks_sticks.json - chorus_planks_sticks
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 4)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .pattern("#")
        .pattern("#")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // spored_slab_composter.json - spored_slab_composter
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COMPOSTER)
        .define('#', EternalEndBlocks.SPORED_SLAB)
        .pattern("# #")
        .pattern("# #")
        .pattern("###")
        .unlockedBy("has_spored_slab", has(EternalEndBlocks.SPORED_SLAB))
        .save(output);

    // scorched_slab_barrel.json - scorched_slab_barrel
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BARREL)
        .define('#', EternalEndBlocks.SCORCHED_SLAB)
        .define('P', EternalEndBlocks.SCORCHED_PLANKS)
        .pattern("P#P")
        .pattern("P P")
        .pattern("P#P")
        .unlockedBy("has_scorched_slab", has(EternalEndBlocks.SCORCHED_SLAB))
        .save(output);

    // fungal_slab_daylight_sensor.json - fungal_slab_daylight_sensor
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.DAYLIGHT_DETECTOR)
        .define('#', EternalEndBlocks.FUNGAL_SLAB)
        .define('G', Items.GLASS)
        .define('Q', Items.QUARTZ)
        .pattern("GGG")
        .pattern("QQQ")
        .pattern("###")
        .unlockedBy("has_fungal_slab", has(EternalEndBlocks.FUNGAL_SLAB))
        .save(output);

    // spored_stairs_left.json - spored_stairs_left
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SPORED_STAIRS, 4)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // scorched_planks_axe.json - scorched_planks_axe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_AXE)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('S', Items.STICK)
        .pattern("##")
        .pattern("#S")
        .pattern(" S")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // cryolite_planks_tripwire_hook.json - cryolite_planks_tripwire_hook
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TRIPWIRE_HOOK)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('I', Items.IRON_INGOT)
        .define('S', Items.STICK)
        .pattern("I")
        .pattern("S")
        .pattern("#")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // spored_planks_shield.json - spored_planks_shield
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SHIELD)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('I', Items.IRON_INGOT)
        .pattern("#I#")
        .pattern("###")
        .pattern(" # ")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // chorus_planks_shovel.json - chorus_planks_shovel
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_SHOVEL)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('S', Items.STICK)
        .pattern("#")
        .pattern("S")
        .pattern("S")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // whispering_slab.json - whispering_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.WHISPERING_SLAB, 6)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .pattern("###")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // honey_log_soul_campfire.json - honey_log_soul_campfire
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SOUL_CAMPFIRE)
        .define('#', EternalEndBlocks.HONEY_LOG)
        .define('C', Items.SOUL_SAND)
        .define('S', Items.STICK)
        .pattern(" S ")
        .pattern("SCS")
        .pattern("###")
        .unlockedBy("has_honey_log", has(EternalEndBlocks.HONEY_LOG))
        .save(output);

    // honey_door.json - honey_door
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.HONEY_DOOR, 3)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .pattern("##")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // chorus_planks_grindstone.json - chorus_planks_grindstone
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GRINDSTONE)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('P', Items.STONE_SLAB)
        .define('S', Items.STICK)
        .pattern("SPS")
        .pattern("# #")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // fungal_planks_cartography_table.json - fungal_planks_cartography_table
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CARTOGRAPHY_TABLE)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('P', Items.PAPER)
        .pattern("PP")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // scorched_planks_noteblock.json - scorched_planks_noteblock
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NOTE_BLOCK)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('R', Items.REDSTONE)
        .pattern("###")
        .pattern("#R#")
        .pattern("###")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // spored_planks_cartography_table.json - spored_planks_cartography_table
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CARTOGRAPHY_TABLE)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('P', Items.PAPER)
        .pattern("PP")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // scorched_planks_bowl.json - scorched_planks_bowl
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BOWL, 4)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .pattern("# #")
        .pattern(" # ")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // whispering_fence.json - whispering_fence
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.WHISPERING_FENCE, 3)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('S', Items.STICK)
        .pattern("#S#")
        .pattern("#S#")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // honey_planks_pickaxe.json - honey_planks_pickaxe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_PICKAXE)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('S', Items.STICK)
        .pattern("###")
        .pattern(" S ")
        .pattern(" S ")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // chorus_log_smoker.json - chorus_log_smoker
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SMOKER)
        .define('#', EternalEndBlocks.CHORUS_LOG)
        .define('F', Items.FURNACE)
        .pattern(" # ")
        .pattern("#F#")
        .pattern(" # ")
        .unlockedBy("has_chorus_log", has(EternalEndBlocks.CHORUS_LOG))
        .save(output);

    // fungal_planks_crafting.json - fungal_planks_crafting
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CRAFTING_TABLE)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // whispering_log_smoker.json - whispering_log_smoker
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SMOKER)
        .define('#', EternalEndBlocks.WHISPERING_LOG)
        .define('F', Items.FURNACE)
        .pattern(" # ")
        .pattern("#F#")
        .pattern(" # ")
        .unlockedBy("has_whispering_log", has(EternalEndBlocks.WHISPERING_LOG))
        .save(output);

    // cryolite_stripped_wood_log.json - cryolite_stripped_wood_log
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CRYOLITE_STRIPPED_WOOD, 3)
        .define('#', EternalEndBlocks.CRYOLITE_STRIPPED_LOG)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_cryolite_stripped_log", has(EternalEndBlocks.CRYOLITE_STRIPPED_LOG))
        .save(output);

    // ender_slime_slime.json - ender_slime_slime
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SLIME_BALL)
        .define('#', EternalEndItems.ENDER_SLIME)
        .pattern("###")
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_ender_slime", has(EternalEndItems.ENDER_SLIME))
        .save(output);

    // honey_wood_wood.json - honey_wood_wood
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.HONEY_LOG, 4)
        .define('#', EternalEndBlocks.HONEY_WOOD)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_honey_wood", has(EternalEndBlocks.HONEY_WOOD))
        .save(output);

    // ametrine_leggings.json - ametrine_leggings
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndItems.AMETRINE_LEGGINGS)
        .define('#', EternalEndItems.AMETRINE_CRYSTAL)
        .pattern("###")
        .pattern("# #")
        .pattern("# #")
        .unlockedBy("has_ametrine_crystal", has(EternalEndItems.AMETRINE_CRYSTAL))
        .save(output);

    // scorched_planks_pickaxe.json - scorched_planks_pickaxe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_PICKAXE)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('S', Items.STICK)
        .pattern("###")
        .pattern(" S ")
        .pattern(" S ")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // whispering_log_campfire.json - whispering_log_campfire
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CAMPFIRE)
        .define('#', EternalEndBlocks.WHISPERING_LOG)
        .define('C', Items.COAL)
        .define('S', Items.STICK)
        .pattern(" S ")
        .pattern("SCS")
        .pattern("###")
        .unlockedBy("has_whispering_log", has(EternalEndBlocks.WHISPERING_LOG))
        .save(output);

    // honey_log_smoker.json - honey_log_smoker
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SMOKER)
        .define('#', EternalEndBlocks.HONEY_LOG)
        .define('F', Items.FURNACE)
        .pattern(" # ")
        .pattern("#F#")
        .pattern(" # ")
        .unlockedBy("has_honey_log", has(EternalEndBlocks.HONEY_LOG))
        .save(output);

    // viridian_slab.json - viridian_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.VIRIDIAN_SLAB, 6)
        .define('#', EternalEndBlocks.VIRIDIAN_BRICKS)
        .pattern("###")
        .unlockedBy("has_viridian_bricks", has(EternalEndBlocks.VIRIDIAN_BRICKS))
        .save(output);

    // spored_fence.json - spored_fence
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SPORED_FENCE, 3)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('S', Items.STICK)
        .pattern("#S#")
        .pattern("#S#")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // cryolite_planks_pickaxe.json - cryolite_planks_pickaxe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_PICKAXE)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('S', Items.STICK)
        .pattern("###")
        .pattern(" S ")
        .pattern(" S ")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // whispering_planks_crafting.json - whispering_planks_crafting
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CRAFTING_TABLE)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // scorched_fence_gate.json - scorched_fence_gate
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SCORCHED_FENCE_GATE)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('S', Items.STICK)
        .pattern("S#S")
        .pattern("S#S")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // honey_log_campfire.json - honey_log_campfire
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CAMPFIRE)
        .define('#', EternalEndBlocks.HONEY_LOG)
        .define('C', Items.COAL)
        .define('S', Items.STICK)
        .pattern(" S ")
        .pattern("SCS")
        .pattern("###")
        .unlockedBy("has_honey_log", has(EternalEndBlocks.HONEY_LOG))
        .save(output);

    // spored_wood_log.json - spored_wood_log
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SPORED_WOOD, 3)
        .define('#', EternalEndBlocks.SPORED_LOG)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_spored_log", has(EternalEndBlocks.SPORED_LOG))
        .save(output);

    // void_gateway_stand_noctral_slates_slab.json - void_gateway_stand_noctral_slates_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.VOID_GATEWAY_STAND)
        .define('E', Items.EMERALD)
        .define('N', EternalEndBlocks.NOCTRAL_SLATES_SLAB)
        .define('S', Items.END_STONE)
        .pattern("NEN")
        .pattern(" S ")
        .pattern("NNN")
        .unlockedBy("has_emerald", has(Items.EMERALD))
        .save(output);

    // spored_log_soul_campfire.json - spored_log_soul_campfire
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SOUL_CAMPFIRE)
        .define('#', EternalEndBlocks.SPORED_LOG)
        .define('C', Items.SOUL_SAND)
        .define('S', Items.STICK)
        .pattern(" S ")
        .pattern("SCS")
        .pattern("###")
        .unlockedBy("has_spored_log", has(EternalEndBlocks.SPORED_LOG))
        .save(output);

    // chorus_planks_beehive.json - chorus_planks_beehive
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BEEHIVE)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('H', Items.HONEYCOMB)
        .pattern("###")
        .pattern("HHH")
        .pattern("###")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // dark_purpur_tiles_stairs_right.json - dark_purpur_tiles_stairs_right
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.DARK_PURPUR_TILES_STAIRS, 4)
        .define('#', EternalEndBlocks.DARK_PURPUR_TILES)
        .pattern("  #")
        .pattern(" ##")
        .pattern("###")
        .unlockedBy("has_dark_purpur_tiles", has(EternalEndBlocks.DARK_PURPUR_TILES))
        .save(output);

    // honey_slab_barrel.json - honey_slab_barrel
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BARREL)
        .define('#', EternalEndBlocks.HONEY_SLAB)
        .define('P', EternalEndBlocks.HONEY_PLANKS)
        .pattern("P#P")
        .pattern("P P")
        .pattern("P#P")
        .unlockedBy("has_honey_slab", has(EternalEndBlocks.HONEY_SLAB))
        .save(output);

    // honey_planks_crafting.json - honey_planks_crafting
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CRAFTING_TABLE)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // scorched_planks_loom.json - scorched_planks_loom
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LOOM)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('S', Items.STRING)
        .pattern("SS")
        .pattern("##")
        .unlockedBy("has_string", has(Items.STRING))
        .save(output);

    // chorus_planks_bed.json - chorus_planks_bed
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WHITE_BED)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('W', Items.WHITE_WOOL)
        .pattern("WWW")
        .pattern("###")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // scorched_wood_wood.json - scorched_wood_wood
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SCORCHED_LOG, 4)
        .define('#', EternalEndBlocks.SCORCHED_WOOD)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_scorched_wood", has(EternalEndBlocks.SCORCHED_WOOD))
        .save(output);

    // chorus_planks_crafting.json - chorus_planks_crafting
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CRAFTING_TABLE)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // whispering_planks_bed.json - whispering_planks_bed
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WHITE_BED)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('W', Items.WHITE_WOOL)
        .pattern("WWW")
        .pattern("###")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // fungal_planks_noteblock.json - fungal_planks_noteblock
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NOTE_BLOCK)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('R', Items.REDSTONE)
        .pattern("###")
        .pattern("#R#")
        .pattern("###")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // dark_purpur_stairs_left.json - dark_purpur_stairs_left
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.DARK_PURPUR_STAIRS, 4)
        .define('#', EternalEndBlocks.DARK_PURPUR_BLOCK)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .unlockedBy("has_dark_purpur_block", has(EternalEndBlocks.DARK_PURPUR_BLOCK))
        .save(output);

    // honey_planks_bed.json - honey_planks_bed
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WHITE_BED)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('W', Items.WHITE_WOOL)
        .pattern("WWW")
        .pattern("###")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // chorus_planks_piston.json - chorus_planks_piston
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PISTON)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('C', Items.COBBLESTONE)
        .define('I', Items.IRON_INGOT)
        .define('R', Items.REDSTONE)
        .pattern("###")
        .pattern("CIC")
        .pattern("CRC")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // chorus_planks_tripwire_hook.json - chorus_planks_tripwire_hook
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TRIPWIRE_HOOK)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('I', Items.IRON_INGOT)
        .define('S', Items.STICK)
        .pattern("I")
        .pattern("S")
        .pattern("#")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // viridian_stairs_right.json - viridian_stairs_right
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.VIRIDIAN_STAIRS, 4)
        .define('#', EternalEndBlocks.VIRIDIAN_BRICKS)
        .pattern("  #")
        .pattern(" ##")
        .pattern("###")
        .unlockedBy("has_viridian_bricks", has(EternalEndBlocks.VIRIDIAN_BRICKS))
        .save(output);

    // mycelion_mire_slats_wall.json - mycelion_mire_slats_wall
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.MYCELION_MIRE_SLATS_WALL, 6)
        .define('#', EternalEndBlocks.MYCELION_MIRE_SLATS)
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_mycelion_mire_slats", has(EternalEndBlocks.MYCELION_MIRE_SLATS))
        .save(output);

    // dark_purpur_slab.json - dark_purpur_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.DARK_PURPUR_SLAB, 6)
        .define('#', EternalEndBlocks.DARK_PURPUR_BLOCK)
        .pattern("###")
        .unlockedBy("has_dark_purpur_block", has(EternalEndBlocks.DARK_PURPUR_BLOCK))
        .save(output);

    // viridian_stairs_left.json - viridian_stairs_left
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.VIRIDIAN_STAIRS, 4)
        .define('#', EternalEndBlocks.VIRIDIAN_BRICKS)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .unlockedBy("has_viridian_bricks", has(EternalEndBlocks.VIRIDIAN_BRICKS))
        .save(output);

    // fungal_slab_lectern.json - fungal_slab_lectern
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LECTERN)
        .define('#', EternalEndBlocks.FUNGAL_SLAB)
        .define('B', Items.BOOKSHELF)
        .pattern("###")
        .pattern(" B ")
        .pattern(" # ")
        .unlockedBy("has_fungal_slab", has(EternalEndBlocks.FUNGAL_SLAB))
        .save(output);

    // spored_planks_jukebox.json - spored_planks_jukebox
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.JUKEBOX)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('D', Items.DIAMOND)
        .pattern("###")
        .pattern("#D#")
        .pattern("###")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // spored_slab_lectern.json - spored_slab_lectern
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LECTERN)
        .define('#', EternalEndBlocks.SPORED_SLAB)
        .define('B', Items.BOOKSHELF)
        .pattern("###")
        .pattern(" B ")
        .pattern(" # ")
        .unlockedBy("has_spored_slab", has(EternalEndBlocks.SPORED_SLAB))
        .save(output);

    // honey_trapdoor.json - honey_trapdoor
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.HONEY_TRAPDOOR, 2)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // honey_planks_bowl.json - honey_planks_bowl
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BOWL, 4)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .pattern("# #")
        .pattern(" # ")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // cryolite_wood_log.json - cryolite_wood_log
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CRYOLITE_WOOD, 3)
        .define('#', EternalEndBlocks.CRYOLITE_LOG)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_cryolite_log", has(EternalEndBlocks.CRYOLITE_LOG))
        .save(output);

    // fungal_slab.json - fungal_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.FUNGAL_SLAB, 6)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .pattern("###")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // scorched_log_campfire.json - scorched_log_campfire
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CAMPFIRE)
        .define('#', EternalEndBlocks.SCORCHED_LOG)
        .define('C', Items.COAL)
        .define('S', Items.STICK)
        .pattern(" S ")
        .pattern("SCS")
        .pattern("###")
        .unlockedBy("has_scorched_log", has(EternalEndBlocks.SCORCHED_LOG))
        .save(output);

    // cryolite_planks_noteblock.json - cryolite_planks_noteblock
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NOTE_BLOCK)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('R', Items.REDSTONE)
        .pattern("###")
        .pattern("#R#")
        .pattern("###")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // dark_purpur_tiles_slab.json - dark_purpur_tiles_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.DARK_PURPUR_TILES_SLAB, 6)
        .define('#', EternalEndBlocks.DARK_PURPUR_TILES)
        .pattern("###")
        .unlockedBy("has_dark_purpur_tiles", has(EternalEndBlocks.DARK_PURPUR_TILES))
        .save(output);

    // mycelion_mire_slats_stairs_right.json - mycelion_mire_slats_stairs_right
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.MYCELION_MIRE_SLATS_STAIRS, 4)
        .define('#', EternalEndBlocks.MYCELION_MIRE_SLATS)
        .pattern("  #")
        .pattern(" ##")
        .pattern("###")
        .unlockedBy("has_mycelion_mire_slats", has(EternalEndBlocks.MYCELION_MIRE_SLATS))
        .save(output);

    // scorched_door.json - scorched_door
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SCORCHED_DOOR, 3)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .pattern("##")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // spored_slab.json - spored_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SPORED_SLAB, 6)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .pattern("###")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // whispering_planks_jukebox.json - whispering_planks_jukebox
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.JUKEBOX)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('D', Items.DIAMOND)
        .pattern("###")
        .pattern("#D#")
        .pattern("###")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // chorus_stairs_right.json - chorus_stairs_right
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CHORUS_STAIRS, 4)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .pattern("  #")
        .pattern(" ##")
        .pattern("###")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // fungal_planks_shield.json - fungal_planks_shield
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SHIELD)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('I', Items.IRON_INGOT)
        .pattern("#I#")
        .pattern("###")
        .pattern(" # ")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // chorus_door.json - chorus_door
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CHORUS_DOOR, 3)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .pattern("##")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // cryolite_stairs_right.json - cryolite_stairs_right
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CRYOLITE_STAIRS, 4)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .pattern("  #")
        .pattern(" ##")
        .pattern("###")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // fungal_slab_composter.json - fungal_slab_composter
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COMPOSTER)
        .define('#', EternalEndBlocks.FUNGAL_SLAB)
        .pattern("# #")
        .pattern("# #")
        .pattern("###")
        .unlockedBy("has_fungal_slab", has(EternalEndBlocks.FUNGAL_SLAB))
        .save(output);

    // fungal_slab_chiseled_bookshelf.json - fungal_slab_chiseled_bookshelf
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHISELED_BOOKSHELF)
        .define('#', EternalEndBlocks.FUNGAL_SLAB)
        .define('P', EternalEndBlocks.FUNGAL_PLANKS)
        .pattern("PPP")
        .pattern("###")
        .pattern("PPP")
        .unlockedBy("has_fungal_slab", has(EternalEndBlocks.FUNGAL_SLAB))
        .save(output);

    // honey_planks_shield.json - honey_planks_shield
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SHIELD)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('I', Items.IRON_INGOT)
        .pattern("#I#")
        .pattern("###")
        .pattern(" # ")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // cryolite_planks_loom.json - cryolite_planks_loom
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LOOM)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('S', Items.STRING)
        .pattern("SS")
        .pattern("##")
        .unlockedBy("has_string", has(Items.STRING))
        .save(output);

    // honey_planks_jukebox.json - honey_planks_jukebox
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.JUKEBOX)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('D', Items.DIAMOND)
        .pattern("###")
        .pattern("#D#")
        .pattern("###")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // scorched_stripped_wood_log.json - scorched_stripped_wood_log
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SCORCHED_STRIPPED_WOOD, 3)
        .define('#', EternalEndBlocks.SCORCHED_STRIPPED_LOG)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_scorched_stripped_log", has(EternalEndBlocks.SCORCHED_STRIPPED_LOG))
        .save(output);

    // cryolite_planks_jukebox.json - cryolite_planks_jukebox
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.JUKEBOX)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('D', Items.DIAMOND)
        .pattern("###")
        .pattern("#D#")
        .pattern("###")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // cryolite_log_smoker.json - cryolite_log_smoker
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SMOKER)
        .define('#', EternalEndBlocks.CRYOLITE_LOG)
        .define('F', Items.FURNACE)
        .pattern(" # ")
        .pattern("#F#")
        .pattern(" # ")
        .unlockedBy("has_cryolite_log", has(EternalEndBlocks.CRYOLITE_LOG))
        .save(output);

    // whispering_stripped_wood_log.json - whispering_stripped_wood_log
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.WHISPERING_STRIPPED_WOOD, 3)
        .define('#', EternalEndBlocks.WHISPERING_STRIPPED_LOG)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_whispering_stripped_log", has(EternalEndBlocks.WHISPERING_STRIPPED_LOG))
        .save(output);

    // scorched_planks_jukebox.json - scorched_planks_jukebox
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.JUKEBOX)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('D', Items.DIAMOND)
        .pattern("###")
        .pattern("#D#")
        .pattern("###")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // mycelion_mire_slats_stairs_left.json - mycelion_mire_slats_stairs_left
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.MYCELION_MIRE_SLATS_STAIRS, 4)
        .define('#', EternalEndBlocks.MYCELION_MIRE_SLATS)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .unlockedBy("has_mycelion_mire_slats", has(EternalEndBlocks.MYCELION_MIRE_SLATS))
        .save(output);

    // spored_log_smoker.json - spored_log_smoker
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SMOKER)
        .define('#', EternalEndBlocks.SPORED_LOG)
        .define('F', Items.FURNACE)
        .pattern(" # ")
        .pattern("#F#")
        .pattern(" # ")
        .unlockedBy("has_spored_log", has(EternalEndBlocks.SPORED_LOG))
        .save(output);

    // void_gateway_stand_noctral_slab.json - void_gateway_stand_noctral_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.VOID_GATEWAY_STAND)
        .define('E', Items.EMERALD)
        .define('N', EternalEndBlocks.NOCTRAL_SLAB)
        .define('S', Items.END_STONE)
        .pattern("NEN")
        .pattern(" S ")
        .pattern("NNN")
        .unlockedBy("has_emerald", has(Items.EMERALD))
        .save(output);

    // whispering_planks_fletching_table.json - whispering_planks_fletching_table
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.FLETCHING_TABLE)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('F', Items.FLINT)
        .pattern("FF")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // fungal_planks_bowl.json - fungal_planks_bowl
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BOWL, 4)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .pattern("# #")
        .pattern(" # ")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // mycelion_mire_slats_slab.json - mycelion_mire_slats_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.MYCELION_MIRE_SLATS_SLAB, 6)
        .define('#', EternalEndBlocks.MYCELION_MIRE_SLATS)
        .pattern("###")
        .unlockedBy("has_mycelion_mire_slats", has(EternalEndBlocks.MYCELION_MIRE_SLATS))
        .save(output);

    // whispering_planks_loom.json - whispering_planks_loom
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LOOM)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('S', Items.STRING)
        .pattern("SS")
        .pattern("##")
        .unlockedBy("has_string", has(Items.STRING))
        .save(output);

    // noctral_bricks_stairs_left.json - noctral_bricks_stairs_left
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.NOCTRAL_BRICKS_STAIRS, 4)
        .define('#', EternalEndBlocks.NOCTRAL_BRICKS)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .unlockedBy("has_noctral_bricks", has(EternalEndBlocks.NOCTRAL_BRICKS))
        .save(output);

    // fungal_slab_barrel.json - fungal_slab_barrel
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BARREL)
        .define('#', EternalEndBlocks.FUNGAL_SLAB)
        .define('P', EternalEndBlocks.FUNGAL_PLANKS)
        .pattern("P#P")
        .pattern("P P")
        .pattern("P#P")
        .unlockedBy("has_fungal_slab", has(EternalEndBlocks.FUNGAL_SLAB))
        .save(output);

    // whispering_planks_bookshelf.json - whispering_planks_bookshelf
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BOOKSHELF)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('B', Items.BOOK)
        .pattern("###")
        .pattern("BBB")
        .pattern("###")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // dark_purpur_wall.json - dark_purpur_wall
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.DARK_PURPUR_WALL, 6)
        .define('#', EternalEndBlocks.DARK_PURPUR_BLOCK)
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_dark_purpur_block", has(EternalEndBlocks.DARK_PURPUR_BLOCK))
        .save(output);

    // whispering_stairs_right.json - whispering_stairs_right
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.WHISPERING_STAIRS, 4)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .pattern("  #")
        .pattern(" ##")
        .pattern("###")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // cryolite_planks_piston.json - cryolite_planks_piston
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PISTON)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('C', Items.COBBLESTONE)
        .define('I', Items.IRON_INGOT)
        .define('R', Items.REDSTONE)
        .pattern("###")
        .pattern("CIC")
        .pattern("CRC")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // whispering_planks_cartography_table.json - whispering_planks_cartography_table
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CARTOGRAPHY_TABLE)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('P', Items.PAPER)
        .pattern("PP")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // chorus_trapdoor.json - chorus_trapdoor
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CHORUS_TRAPDOOR, 2)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // cryolite_slab.json - cryolite_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CRYOLITE_SLAB, 6)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .pattern("###")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // flare_fern_leaf_to_paper.json - flare_fern_leaf_to_paper
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PAPER, 3)
        .define('#', EternalEndItems.FLARE_FERN_LEAF)
        .pattern("###")
        .unlockedBy("has_flare_fern_leaf", has(EternalEndItems.FLARE_FERN_LEAF))
        .save(output);

    // chorus_slab_daylight_sensor.json - chorus_slab_daylight_sensor
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.DAYLIGHT_DETECTOR)
        .define('#', EternalEndBlocks.CHORUS_SLAB)
        .define('G', Items.GLASS)
        .define('Q', Items.QUARTZ)
        .pattern("GGG")
        .pattern("QQQ")
        .pattern("###")
        .unlockedBy("has_chorus_slab", has(EternalEndBlocks.CHORUS_SLAB))
        .save(output);

    // honey_slab_chiseled_bookshelf.json - honey_slab_chiseled_bookshelf
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHISELED_BOOKSHELF)
        .define('#', EternalEndBlocks.HONEY_SLAB)
        .define('P', EternalEndBlocks.HONEY_PLANKS)
        .pattern("PPP")
        .pattern("###")
        .pattern("PPP")
        .unlockedBy("has_honey_slab", has(EternalEndBlocks.HONEY_SLAB))
        .save(output);

    // dark_purpur_tiles_stairs_left.json - dark_purpur_tiles_stairs_left
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.DARK_PURPUR_TILES_STAIRS, 4)
        .define('#', EternalEndBlocks.DARK_PURPUR_TILES)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .unlockedBy("has_dark_purpur_tiles", has(EternalEndBlocks.DARK_PURPUR_TILES))
        .save(output);

    // scorched_slab_chiseled_bookshelf.json - scorched_slab_chiseled_bookshelf
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHISELED_BOOKSHELF)
        .define('#', EternalEndBlocks.SCORCHED_SLAB)
        .define('P', EternalEndBlocks.SCORCHED_PLANKS)
        .pattern("PPP")
        .pattern("###")
        .pattern("PPP")
        .unlockedBy("has_scorched_slab", has(EternalEndBlocks.SCORCHED_SLAB))
        .save(output);

    // chorus_log_soul_campfire.json - chorus_log_soul_campfire
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SOUL_CAMPFIRE)
        .define('#', EternalEndBlocks.CHORUS_LOG)
        .define('C', Items.SOUL_SAND)
        .define('S', Items.STICK)
        .pattern(" S ")
        .pattern("SCS")
        .pattern("###")
        .unlockedBy("has_chorus_log", has(EternalEndBlocks.CHORUS_LOG))
        .save(output);

    // honey_planks_grindstone.json - honey_planks_grindstone
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GRINDSTONE)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('P', Items.STONE_SLAB)
        .define('S', Items.STICK)
        .pattern("SPS")
        .pattern("# #")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // void_gateway_noctral_bricks_slab.json - void_gateway_noctral_bricks_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.VOID_GATEWAY)
        .define('C', EternalEndItems.GOLEM_CORE)
        .define('E', Items.END_STONE)
        .define('N', EternalEndBlocks.NOCTRAL_STONE)
        .define('S', EternalEndBlocks.NOCTRAL_BRICKS_SLAB)
        .define('X', Items.ENDER_EYE)
        .pattern("SSS")
        .pattern("XCX")
        .pattern("EEE")
        .unlockedBy("has_noctral_stone", has(EternalEndBlocks.NOCTRAL_STONE))
        .save(output);

    // fungal_planks_pickaxe.json - fungal_planks_pickaxe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_PICKAXE)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('S', Items.STICK)
        .pattern("###")
        .pattern(" S ")
        .pattern(" S ")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // fungal_log_smoker.json - fungal_log_smoker
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SMOKER)
        .define('#', EternalEndBlocks.FUNGAL_LOG)
        .define('F', Items.FURNACE)
        .pattern(" # ")
        .pattern("#F#")
        .pattern(" # ")
        .unlockedBy("has_fungal_log", has(EternalEndBlocks.FUNGAL_LOG))
        .save(output);

    // dark_purpur_tiles_wall.json - dark_purpur_tiles_wall
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.DARK_PURPUR_TILES_WALL, 6)
        .define('#', EternalEndBlocks.DARK_PURPUR_TILES)
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_dark_purpur_tiles", has(EternalEndBlocks.DARK_PURPUR_TILES))
        .save(output);

    // whispering_wood_log.json - whispering_wood_log
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.WHISPERING_WOOD, 3)
        .define('#', EternalEndBlocks.WHISPERING_LOG)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_whispering_log", has(EternalEndBlocks.WHISPERING_LOG))
        .save(output);

    // scorched_planks_smithing.json - scorched_planks_smithing
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SMITHING_TABLE)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('I', Items.IRON_INGOT)
        .pattern("II")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // honey_planks_sticks.json - honey_planks_sticks
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 4)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .pattern("#")
        .pattern("#")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // spored_planks_fletching_table.json - spored_planks_fletching_table
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.FLETCHING_TABLE)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('F', Items.FLINT)
        .pattern("FF")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // whispering_planks_piston.json - whispering_planks_piston
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PISTON)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('C', Items.COBBLESTONE)
        .define('I', Items.IRON_INGOT)
        .define('R', Items.REDSTONE)
        .pattern("###")
        .pattern("CIC")
        .pattern("CRC")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // spored_planks_tripwire_hook.json - spored_planks_tripwire_hook
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TRIPWIRE_HOOK)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('I', Items.IRON_INGOT)
        .define('S', Items.STICK)
        .pattern("I")
        .pattern("S")
        .pattern("#")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // whispering_wood_wood.json - whispering_wood_wood
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.WHISPERING_LOG, 4)
        .define('#', EternalEndBlocks.WHISPERING_WOOD)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_whispering_wood", has(EternalEndBlocks.WHISPERING_WOOD))
        .save(output);

    // cryolite_planks_grindstone.json - cryolite_planks_grindstone
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GRINDSTONE)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('P', Items.STONE_SLAB)
        .define('S', Items.STICK)
        .pattern("SPS")
        .pattern("# #")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // noctral_slates_stairs_right.json - noctral_slates_stairs_right
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.NOCTRAL_SLATES_STAIRS, 4)
        .define('#', EternalEndBlocks.NOCTRAL_SLATES)
        .pattern("  #")
        .pattern(" ##")
        .pattern("###")
        .unlockedBy("has_noctral_slates", has(EternalEndBlocks.NOCTRAL_SLATES))
        .save(output);

    // noctral_bricks_slab.json - noctral_bricks_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.NOCTRAL_BRICKS_SLAB, 6)
        .define('#', EternalEndBlocks.NOCTRAL_BRICKS)
        .pattern("###")
        .unlockedBy("has_noctral_bricks", has(EternalEndBlocks.NOCTRAL_BRICKS))
        .save(output);

    // spored_slab_barrel.json - spored_slab_barrel
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BARREL)
        .define('#', EternalEndBlocks.SPORED_SLAB)
        .define('P', EternalEndBlocks.SPORED_PLANKS)
        .pattern("P#P")
        .pattern("P P")
        .pattern("P#P")
        .unlockedBy("has_spored_slab", has(EternalEndBlocks.SPORED_SLAB))
        .save(output);

    // chorus_stripped_wood_log.json - chorus_stripped_wood_log
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CHORUS_STRIPPED_WOOD, 3)
        .define('#', EternalEndBlocks.CHORUS_STRIPPED_LOG)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_chorus_stripped_log", has(EternalEndBlocks.CHORUS_STRIPPED_LOG))
        .save(output);

    // chorus_slab_chiseled_bookshelf.json - chorus_slab_chiseled_bookshelf
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHISELED_BOOKSHELF)
        .define('#', EternalEndBlocks.CHORUS_SLAB)
        .define('P', EternalEndBlocks.CHORUS_PLANKS)
        .pattern("PPP")
        .pattern("###")
        .pattern("PPP")
        .unlockedBy("has_chorus_slab", has(EternalEndBlocks.CHORUS_SLAB))
        .save(output);

    // whispering_slab_lectern.json - whispering_slab_lectern
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LECTERN)
        .define('#', EternalEndBlocks.WHISPERING_SLAB)
        .define('B', Items.BOOKSHELF)
        .pattern("###")
        .pattern(" B ")
        .pattern(" # ")
        .unlockedBy("has_whispering_slab", has(EternalEndBlocks.WHISPERING_SLAB))
        .save(output);

    // scorched_slab_daylight_sensor.json - scorched_slab_daylight_sensor
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.DAYLIGHT_DETECTOR)
        .define('#', EternalEndBlocks.SCORCHED_SLAB)
        .define('G', Items.GLASS)
        .define('Q', Items.QUARTZ)
        .pattern("GGG")
        .pattern("QQQ")
        .pattern("###")
        .unlockedBy("has_scorched_slab", has(EternalEndBlocks.SCORCHED_SLAB))
        .save(output);

    // scorched_stairs_left.json - scorched_stairs_left
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SCORCHED_STAIRS, 4)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // fungal_planks_bookshelf.json - fungal_planks_bookshelf
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BOOKSHELF)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('B', Items.BOOK)
        .pattern("###")
        .pattern("BBB")
        .pattern("###")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // chorus_fence_gate.json - chorus_fence_gate
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CHORUS_FENCE_GATE)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('S', Items.STICK)
        .pattern("S#S")
        .pattern("S#S")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // whispering_planks_tripwire_hook.json - whispering_planks_tripwire_hook
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TRIPWIRE_HOOK)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('I', Items.IRON_INGOT)
        .define('S', Items.STICK)
        .pattern("I")
        .pattern("S")
        .pattern("#")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // whispering_fence_gate.json - whispering_fence_gate
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.WHISPERING_FENCE_GATE)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('S', Items.STICK)
        .pattern("S#S")
        .pattern("S#S")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // chorus_planks_pickaxe.json - chorus_planks_pickaxe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_PICKAXE)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('S', Items.STICK)
        .pattern("###")
        .pattern(" S ")
        .pattern(" S ")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // fungal_wood_wood.json - fungal_wood_wood
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.FUNGAL_LOG, 4)
        .define('#', EternalEndBlocks.FUNGAL_WOOD)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_fungal_wood", has(EternalEndBlocks.FUNGAL_WOOD))
        .save(output);

    // scorched_log_soul_campfire.json - scorched_log_soul_campfire
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SOUL_CAMPFIRE)
        .define('#', EternalEndBlocks.SCORCHED_LOG)
        .define('C', Items.SOUL_SAND)
        .define('S', Items.STICK)
        .pattern(" S ")
        .pattern("SCS")
        .pattern("###")
        .unlockedBy("has_scorched_log", has(EternalEndBlocks.SCORCHED_LOG))
        .save(output);

    // scorched_planks_piston.json - scorched_planks_piston
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PISTON)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('C', Items.COBBLESTONE)
        .define('I', Items.IRON_INGOT)
        .define('R', Items.REDSTONE)
        .pattern("###")
        .pattern("CIC")
        .pattern("CRC")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // honey_fence_gate.json - honey_fence_gate
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.HONEY_FENCE_GATE)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('S', Items.STICK)
        .pattern("S#S")
        .pattern("S#S")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // spored_planks_bowl.json - spored_planks_bowl
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BOWL, 4)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .pattern("# #")
        .pattern(" # ")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // honey_fence.json - honey_fence
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.HONEY_FENCE, 3)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('S', Items.STICK)
        .pattern("#S#")
        .pattern("#S#")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // honey_planks_smithing.json - honey_planks_smithing
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SMITHING_TABLE)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('I', Items.IRON_INGOT)
        .pattern("II")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // whispering_log_soul_campfire.json - whispering_log_soul_campfire
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SOUL_CAMPFIRE)
        .define('#', EternalEndBlocks.WHISPERING_LOG)
        .define('C', Items.SOUL_SAND)
        .define('S', Items.STICK)
        .pattern(" S ")
        .pattern("SCS")
        .pattern("###")
        .unlockedBy("has_whispering_log", has(EternalEndBlocks.WHISPERING_LOG))
        .save(output);

    // scorched_planks_bed.json - scorched_planks_bed
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WHITE_BED)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('W', Items.WHITE_WOOL)
        .pattern("WWW")
        .pattern("###")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // mycelion_mire_wall.json - mycelion_mire_wall
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.MYCELION_MIRE_WALL, 6)
        .define('#', EternalEndBlocks.MYCELION_MIRE)
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_mycelion_mire", has(EternalEndBlocks.MYCELION_MIRE))
        .save(output);

    // ametrine_chestplate.json - ametrine_chestplate
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndItems.AMETRINE_CHESTPLATE)
        .define('#', EternalEndItems.AMETRINE_CRYSTAL)
        .pattern("# #")
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_ametrine_crystal", has(EternalEndItems.AMETRINE_CRYSTAL))
        .save(output);

    // honey_planks_shovel.json - honey_planks_shovel
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_SHOVEL)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('S', Items.STICK)
        .pattern("#")
        .pattern("S")
        .pattern("S")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // chorus_planks_smithing.json - chorus_planks_smithing
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SMITHING_TABLE)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('I', Items.IRON_INGOT)
        .pattern("II")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // fungal_planks_grindstone.json - fungal_planks_grindstone
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GRINDSTONE)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('P', Items.STONE_SLAB)
        .define('S', Items.STICK)
        .pattern("SPS")
        .pattern("# #")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // chorus_wood_wood.json - chorus_wood_wood
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CHORUS_LOG, 4)
        .define('#', EternalEndBlocks.CHORUS_WOOD)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_chorus_wood", has(EternalEndBlocks.CHORUS_WOOD))
        .save(output);

    // cryolite_planks_bookshelf.json - cryolite_planks_bookshelf
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BOOKSHELF)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('B', Items.BOOK)
        .pattern("###")
        .pattern("BBB")
        .pattern("###")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // cryolite_planks_axe.json - cryolite_planks_axe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_AXE)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('S', Items.STICK)
        .pattern("##")
        .pattern("#S")
        .pattern(" S")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // chorus_slab_barrel.json - chorus_slab_barrel
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BARREL)
        .define('#', EternalEndBlocks.CHORUS_SLAB)
        .define('P', EternalEndBlocks.CHORUS_PLANKS)
        .pattern("P#P")
        .pattern("P P")
        .pattern("P#P")
        .unlockedBy("has_chorus_slab", has(EternalEndBlocks.CHORUS_SLAB))
        .save(output);

    // scorched_planks_chest.json - scorched_planks_chest
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHEST)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .pattern("###")
        .pattern("# #")
        .pattern("###")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // cryolite_slab_lectern.json - cryolite_slab_lectern
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LECTERN)
        .define('#', EternalEndBlocks.CRYOLITE_SLAB)
        .define('B', Items.BOOKSHELF)
        .pattern("###")
        .pattern(" B ")
        .pattern(" # ")
        .unlockedBy("has_cryolite_slab", has(EternalEndBlocks.CRYOLITE_SLAB))
        .save(output);

    // chorus_slab_lectern.json - chorus_slab_lectern
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LECTERN)
        .define('#', EternalEndBlocks.CHORUS_SLAB)
        .define('B', Items.BOOKSHELF)
        .pattern("###")
        .pattern(" B ")
        .pattern(" # ")
        .unlockedBy("has_chorus_slab", has(EternalEndBlocks.CHORUS_SLAB))
        .save(output);

    // cryolite_stairs_left.json - cryolite_stairs_left
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CRYOLITE_STAIRS, 4)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // honey_planks_sword.json - honey_planks_sword
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_SWORD)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .define('S', Items.STICK)
        .pattern("#")
        .pattern("# ")
        .pattern("S")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // fungal_planks_shovel.json - fungal_planks_shovel
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_SHOVEL)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('S', Items.STICK)
        .pattern("#")
        .pattern("S")
        .pattern("S")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // spored_planks_hoe.json - spored_planks_hoe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_HOE)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('S', Items.STICK)
        .pattern("##")
        .pattern(" S")
        .pattern(" S")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // whispering_slab_daylight_sensor.json - whispering_slab_daylight_sensor
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.DAYLIGHT_DETECTOR)
        .define('#', EternalEndBlocks.WHISPERING_SLAB)
        .define('G', Items.GLASS)
        .define('Q', Items.QUARTZ)
        .pattern("GGG")
        .pattern("QQQ")
        .pattern("###")
        .unlockedBy("has_whispering_slab", has(EternalEndBlocks.WHISPERING_SLAB))
        .save(output);

    // whispering_stairs_left.json - whispering_stairs_left
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.WHISPERING_STAIRS, 4)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // spored_planks_axe.json - spored_planks_axe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_AXE)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('S', Items.STICK)
        .pattern("##")
        .pattern("#S")
        .pattern(" S")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // fungal_planks_beehive.json - fungal_planks_beehive
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BEEHIVE)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('H', Items.HONEYCOMB)
        .pattern("###")
        .pattern("HHH")
        .pattern("###")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // noctral_bricks_wall.json - noctral_bricks_wall
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.NOCTRAL_BRICKS_WALL, 6)
        .define('#', EternalEndBlocks.NOCTRAL_BRICKS)
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_noctral_bricks", has(EternalEndBlocks.NOCTRAL_BRICKS))
        .save(output);

    // cryolite_planks_cartography_table.json - cryolite_planks_cartography_table
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CARTOGRAPHY_TABLE)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('P', Items.PAPER)
        .pattern("PP")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // spored_stairs_right.json - spored_stairs_right
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SPORED_STAIRS, 4)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .pattern("  #")
        .pattern(" ##")
        .pattern("###")
        .unlockedBy("has_spored_planks", has(EternalEndBlocks.SPORED_PLANKS))
        .save(output);

    // scorched_planks_crafting.json - scorched_planks_crafting
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CRAFTING_TABLE)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // fungal_stairs_right.json - fungal_stairs_right
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.FUNGAL_STAIRS, 4)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .pattern("  #")
        .pattern(" ##")
        .pattern("###")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // cryolite_planks_hoe.json - cryolite_planks_hoe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_HOE)
        .define('#', EternalEndBlocks.CRYOLITE_PLANKS)
        .define('S', Items.STICK)
        .pattern("##")
        .pattern(" S")
        .pattern(" S")
        .unlockedBy("has_cryolite_planks", has(EternalEndBlocks.CRYOLITE_PLANKS))
        .save(output);

    // scorched_trapdoor.json - scorched_trapdoor
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SCORCHED_TRAPDOOR, 2)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .pattern("###")
        .pattern("###")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // cryolite_slab_chiseled_bookshelf.json - cryolite_slab_chiseled_bookshelf
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHISELED_BOOKSHELF)
        .define('#', EternalEndBlocks.CRYOLITE_SLAB)
        .define('P', EternalEndBlocks.CRYOLITE_PLANKS)
        .pattern("PPP")
        .pattern("###")
        .pattern("PPP")
        .unlockedBy("has_cryolite_slab", has(EternalEndBlocks.CRYOLITE_SLAB))
        .save(output);

    // chorus_slab_composter.json - chorus_slab_composter
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COMPOSTER)
        .define('#', EternalEndBlocks.CHORUS_SLAB)
        .pattern("# #")
        .pattern("# #")
        .pattern("###")
        .unlockedBy("has_chorus_slab", has(EternalEndBlocks.CHORUS_SLAB))
        .save(output);

    // whispering_door.json - whispering_door
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.WHISPERING_DOOR, 3)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .pattern("##")
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // honey_slab.json - honey_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.HONEY_SLAB, 6)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .pattern("###")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // spored_planks_piston.json - spored_planks_piston
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PISTON)
        .define('#', EternalEndBlocks.SPORED_PLANKS)
        .define('C', Items.COBBLESTONE)
        .define('I', Items.IRON_INGOT)
        .define('R', Items.REDSTONE)
        .pattern("###")
        .pattern("CIC")
        .pattern("CRC")
        .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
        .save(output);

    // spored_stripped_wood_log.json - spored_stripped_wood_log
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.SPORED_STRIPPED_WOOD, 3)
        .define('#', EternalEndBlocks.SPORED_STRIPPED_LOG)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_spored_stripped_log", has(EternalEndBlocks.SPORED_STRIPPED_LOG))
        .save(output);

    // scorched_planks_tripwire_hook.json - scorched_planks_tripwire_hook
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TRIPWIRE_HOOK)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('I', Items.IRON_INGOT)
        .define('S', Items.STICK)
        .pattern("I")
        .pattern("S")
        .pattern("#")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // mycelion_mire_slats_table.json - mycelion_mire_slats_table
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.MYCELION_MIRE_SLATS, 4)
        .define('#', EternalEndBlocks.MYCELION_MIRE)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_mycelion_mire", has(EternalEndBlocks.MYCELION_MIRE))
        .save(output);

    // ender_slime_piston.json - ender_slime_piston
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICKY_PISTON)
        .define('P', Items.PISTON)
        .define('S', EternalEndItems.ENDER_SLIME)
        .pattern("S")
        .pattern("P")
        .unlockedBy("has_ender_slime", has(EternalEndItems.ENDER_SLIME))
        .save(output);

    // whispering_planks_noteblock.json - whispering_planks_noteblock
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NOTE_BLOCK)
        .define('#', EternalEndBlocks.WHISPERING_PLANKS)
        .define('R', Items.REDSTONE)
        .pattern("###")
        .pattern("#R#")
        .pattern("###")
        .unlockedBy("has_whispering_planks", has(EternalEndBlocks.WHISPERING_PLANKS))
        .save(output);

    // fungal_planks_hoe.json - fungal_planks_hoe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_HOE)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('S', Items.STICK)
        .pattern("##")
        .pattern(" S")
        .pattern(" S")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // mycelion_mire_slab.json - mycelion_mire_slab
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.MYCELION_MIRE_SLAB, 6)
        .define('#', EternalEndBlocks.MYCELION_MIRE)
        .pattern("###")
        .unlockedBy("has_mycelion_mire", has(EternalEndBlocks.MYCELION_MIRE))
        .save(output);

    // fungal_planks_axe.json - fungal_planks_axe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_AXE)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .define('S', Items.STICK)
        .pattern("##")
        .pattern("#S")
        .pattern(" S")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // honey_planks_chest.json - honey_planks_chest
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHEST)
        .define('#', EternalEndBlocks.HONEY_PLANKS)
        .pattern("###")
        .pattern("# #")
        .pattern("###")
        .unlockedBy("has_honey_planks", has(EternalEndBlocks.HONEY_PLANKS))
        .save(output);

    // cryolite_wood_wood.json - cryolite_wood_wood
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CRYOLITE_LOG, 4)
        .define('#', EternalEndBlocks.CRYOLITE_WOOD)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_cryolite_wood", has(EternalEndBlocks.CRYOLITE_WOOD))
        .save(output);

    // fungal_planks_sticks.json - fungal_planks_sticks
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 4)
        .define('#', EternalEndBlocks.FUNGAL_PLANKS)
        .pattern("#")
        .pattern("#")
        .unlockedBy("has_fungal_planks", has(EternalEndBlocks.FUNGAL_PLANKS))
        .save(output);

    // chorus_planks_bowl.json - chorus_planks_bowl
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BOWL, 4)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .pattern("# #")
        .pattern(" # ")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // spored_slab_daylight_sensor.json - spored_slab_daylight_sensor
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.DAYLIGHT_DETECTOR)
        .define('#', EternalEndBlocks.SPORED_SLAB)
        .define('G', Items.GLASS)
        .define('Q', Items.QUARTZ)
        .pattern("GGG")
        .pattern("QQQ")
        .pattern("###")
        .unlockedBy("has_spored_slab", has(EternalEndBlocks.SPORED_SLAB))
        .save(output);

    // chorus_fence.json - chorus_fence
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.CHORUS_FENCE, 3)
        .define('#', EternalEndBlocks.CHORUS_PLANKS)
        .define('S', Items.STICK)
        .pattern("#S#")
        .pattern("#S#")
        .unlockedBy("has_chorus_planks", has(EternalEndBlocks.CHORUS_PLANKS))
        .save(output);

    // scorched_planks_sword.json - scorched_planks_sword
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WOODEN_SWORD)
        .define('#', EternalEndBlocks.SCORCHED_PLANKS)
        .define('S', Items.STICK)
        .pattern("#")
        .pattern("# ")
        .pattern("S")
        .unlockedBy("has_scorched_planks", has(EternalEndBlocks.SCORCHED_PLANKS))
        .save(output);

    // fungal_wood_log.json - fungal_wood_log
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.FUNGAL_WOOD, 3)
        .define('#', EternalEndBlocks.FUNGAL_LOG)
        .pattern("##")
        .pattern("##")
        .unlockedBy("has_fungal_log", has(EternalEndBlocks.FUNGAL_LOG))
        .save(output);

    // shovel.json - noctral_stone.shovel
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STONE_SHOVEL)
        .define('A', EternalEndBlocks.NOCTRAL_STONE)
        .define('B', Items.STICK)
        .pattern("A")
        .pattern("B")
        .pattern("B")
        .unlockedBy("has_noctral_stone", has(EternalEndBlocks.NOCTRAL_STONE))
        .save(output);

    // pickaxe.json - noctral_stone.pickaxe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STONE_PICKAXE)
        .define('A', EternalEndBlocks.NOCTRAL_STONE)
        .define('B', Items.STICK)
        .pattern("AAA")
        .pattern(" B ")
        .pattern(" B ")
        .unlockedBy("has_noctral_stone", has(EternalEndBlocks.NOCTRAL_STONE))
        .save(output);

    // sword.json - noctral_stone.sword
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STONE_SWORD)
        .define('A', EternalEndBlocks.NOCTRAL_STONE)
        .define('B', Items.STICK)
        .pattern("A")
        .pattern("A")
        .pattern("B")
        .unlockedBy("has_noctral_stone", has(EternalEndBlocks.NOCTRAL_STONE))
        .save(output);

    // furnace.json - noctral_stone.furnace
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.FURNACE)
        .define('A', EternalEndBlocks.NOCTRAL_STONE)
        .pattern("AAA")
        .pattern("A A")
        .pattern("AAA")
        .unlockedBy("has_noctral_stone", has(EternalEndBlocks.NOCTRAL_STONE))
        .save(output);

    // hoe.json - noctral_stone.hoe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STONE_HOE)
        .define('A', EternalEndBlocks.NOCTRAL_STONE)
        .define('B', Items.STICK)
        .pattern("AA")
        .pattern("B ")
        .pattern("B ")
        .unlockedBy("has_noctral_stone", has(EternalEndBlocks.NOCTRAL_STONE))
        .save(output);

    // axe.json - noctral_stone.axe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STONE_AXE)
        .define('A', EternalEndBlocks.NOCTRAL_STONE)
        .define('B', Items.STICK)
        .pattern("AA")
        .pattern("BA")
        .pattern("B ")
        .unlockedBy("has_noctral_stone", has(EternalEndBlocks.NOCTRAL_STONE))
        .save(output);

    // ingot_to_block.json - ametrine.ingot_to_block
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.AMETRINE_BLOCK)
        .define('E', EternalEndItems.AMETRINE_INGOT)
        .pattern("EEE")
        .pattern("EEE")
        .pattern("EEE")
        .unlockedBy("has_ametrine_ingot", has(EternalEndItems.AMETRINE_INGOT))
        .save(output);

    // shovel.json - ametrine.shovel
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndItems.AMETRINE_SHOVEL)
        .define('A', EternalEndItems.AMETRINE_INGOT)
        .define('B', Items.STICK)
        .pattern("A")
        .pattern("B")
        .pattern("B")
        .unlockedBy("has_ametrine_ingot", has(EternalEndItems.AMETRINE_INGOT))
        .save(output);

    // pickaxe.json - ametrine.pickaxe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndItems.AMETRINE_PICKAXE)
        .define('A', EternalEndItems.AMETRINE_INGOT)
        .define('B', Items.STICK)
        .pattern("AAA")
        .pattern(" B ")
        .pattern(" B ")
        .unlockedBy("has_ametrine_ingot", has(EternalEndItems.AMETRINE_INGOT))
        .save(output);

    // sword.json - ametrine.sword
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndItems.AMETRINE_SWORD)
        .define('A', EternalEndItems.AMETRINE_INGOT)
        .define('B', Items.STICK)
        .pattern("A")
        .pattern("A")
        .pattern("B")
        .unlockedBy("has_ametrine_ingot", has(EternalEndItems.AMETRINE_INGOT))
        .save(output);

    // hoe.json - ametrine.hoe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndItems.AMETRINE_HOE)
        .define('A', EternalEndItems.AMETRINE_INGOT)
        .define('B', Items.STICK)
        .pattern("AA")
        .pattern("B ")
        .pattern("B ")
        .unlockedBy("has_ametrine_ingot", has(EternalEndItems.AMETRINE_INGOT))
        .save(output);

    // axe.json - ametrine.axe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndItems.AMETRINE_AXE)
        .define('A', EternalEndItems.AMETRINE_INGOT)
        .define('B', Items.STICK)
        .pattern("AA")
        .pattern("BA")
        .pattern("B ")
        .unlockedBy("has_ametrine_ingot", has(EternalEndItems.AMETRINE_INGOT))
        .save(output);

    // raw_item_to_raw_block.json - dark_purpur.raw_item_to_raw_block
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.RAW_DARK_PURPURITE_BLOCK)
        .define('I', EternalEndItems.RAW_DARK_PURPURITE)
        .pattern("II")
        .pattern("II")
        .unlockedBy("has_raw_dark_purpurite", has(EternalEndItems.RAW_DARK_PURPURITE))
        .save(output);

    // brick_to_block.json - dark_purpur.brick_to_block
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.DARK_PURPUR_BLOCK)
        .define('B', EternalEndItems.DARK_PURPUR_BRICK)
        .pattern("BB")
        .pattern("BB")
        .unlockedBy("has_dark_purpur_brick", has(EternalEndItems.DARK_PURPUR_BRICK))
        .save(output);

    // ingot_to_block.json - enderite.ingot_to_block
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.ENDERITE_BLOCK)
        .define('E', EternalEndItems.ENDERITE_INGOT)
        .pattern("EEE")
        .pattern("EEE")
        .pattern("EEE")
        .unlockedBy("has_enderite_ingot", has(EternalEndItems.ENDERITE_INGOT))
        .save(output);

    // upgrade_to_upgrade.json - enderite.upgrade_to_upgrade
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndItems.ENDERITE_UPGRADE, 2)
        .define('D', Items.DIAMOND)
        .define('E', Items.END_STONE)
        .define('U', EternalEndItems.ENDERITE_UPGRADE)
        .pattern("DUD")
        .pattern("DED")
        .pattern("DDD")
        .unlockedBy("has_diamond", has(Items.DIAMOND))
        .save(output);

    // brick_to_block.json - viridian.brick_to_block
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.VIRIDIAN_BRICKS)
        .define('B', EternalEndItems.VIRIDIAN_BRICK)
        .pattern("BB")
        .pattern("BB")
        .unlockedBy("has_viridian_brick", has(EternalEndItems.VIRIDIAN_BRICK))
        .save(output);

    // raw_item_to_raw_block.json - purpur.raw_item_to_raw_block
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EternalEndBlocks.RAW_PURPURITE_BLOCK)
        .define('I', EternalEndItems.RAW_PURPURITE)
        .pattern("II")
        .pattern("II")
        .unlockedBy("has_raw_purpurite", has(EternalEndItems.RAW_PURPURITE))
        .save(output);

    // brick_to_block.json - purpur.brick_to_block
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PURPUR_BLOCK)
        .define('B', EternalEndItems.PURPUR_BRICK)
        .pattern("BB")
        .pattern("BB")
        .unlockedBy("has_purpur_brick", has(EternalEndItems.PURPUR_BRICK))
        .save(output);

    // ========== SHAPELESS RECIPES ==========

    // awkward_mushroom_stew_3.json - awkward_mushroom_stew_3
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.AWKWARD_MUSHROOM_STEW)
        .requires(EternalEndBlocks.FRILLTOPS)
        .requires(EternalEndBlocks.FRILLTOPS)
        .requires(Items.BOWL)
        .unlockedBy("has_frilltops", has(EternalEndBlocks.FRILLTOPS))
        .save(output);

    // icelumia.json - icelumia
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SNOWBALL, 2)
        .requires(EternalEndBlocks.ICELUMIA)
        .unlockedBy("has_icelumia", has(EternalEndBlocks.ICELUMIA))
        .save(output);

    // spored_planks_stripped_wood.json - spored_planks_stripped_wood
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.SPORED_PLANKS, 4)
        .requires(EternalEndBlocks.SPORED_STRIPPED_WOOD)
        .unlockedBy("has_spored_stripped_wood", has(EternalEndBlocks.SPORED_STRIPPED_WOOD))
        .save(output);

    // honey_planks_stripped_log.json - honey_planks_stripped_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.HONEY_PLANKS, 4)
        .requires(EternalEndBlocks.HONEY_STRIPPED_LOG)
        .unlockedBy("has_honey_stripped_log", has(EternalEndBlocks.HONEY_STRIPPED_LOG))
        .save(output);

    // whispering_planks_stripped_wood.json - whispering_planks_stripped_wood
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.WHISPERING_PLANKS, 4)
        .requires(EternalEndBlocks.WHISPERING_STRIPPED_WOOD)
        .unlockedBy("has_whispering_stripped_wood", has(EternalEndBlocks.WHISPERING_STRIPPED_WOOD))
        .save(output);

    // verdant_stalk_to_stick.json - verdant_stalk_to_stick
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.STICK, 4)
        .requires(EternalEndBlocks.VERDANT_STALK)
        .unlockedBy("has_verdant_stalk", has(EternalEndBlocks.VERDANT_STALK))
        .save(output);

    // spored_planks_thin_log.json - spored_planks_thin_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.SPORED_PLANKS, 2)
        .requires(EternalEndBlocks.SPORED_THIN_LOG)
        .unlockedBy("has_spored_thin_log", has(EternalEndBlocks.SPORED_THIN_LOG))
        .save(output);

    // spored_planks_wood.json - spored_planks_wood
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.SPORED_PLANKS, 4)
        .requires(EternalEndBlocks.SPORED_WOOD)
        .unlockedBy("has_spored_wood", has(EternalEndBlocks.SPORED_WOOD))
        .save(output);

    // lyric_sprouts.json - lyric_sprouts
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PINK_DYE)
        .requires(EternalEndBlocks.LYRIC_SPROUTS)
        .unlockedBy("has_lyric_sprouts", has(EternalEndBlocks.LYRIC_SPROUTS))
        .save(output);

    // moonflower.json - moonflower
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LIGHT_BLUE_DYE)
        .requires(EternalEndBlocks.MOONFLOWER)
        .unlockedBy("has_moonflower", has(EternalEndBlocks.MOONFLOWER))
        .save(output);

    // ender_slime_magma.json - ender_slime_magma
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MAGMA_CREAM)
        .requires(Items.BLAZE_POWDER)
        .requires(EternalEndItems.ENDER_SLIME)
        .unlockedBy("has_blaze_powder", has(Items.BLAZE_POWDER))
        .save(output);

    // shadow_deer_black.json - shadow_deer_black
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.BLACK_ESSENCE_DRINK)
        .requires(Items.GLASS_BOTTLE)
        .requires(EternalEndItems.BLACK_ESSENCE)
        .unlockedBy("has_glass_bottle", has(Items.GLASS_BOTTLE))
        .save(output);

    // scorched_planks_stripped_wood.json - scorched_planks_stripped_wood
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.SCORCHED_PLANKS, 4)
        .requires(EternalEndBlocks.SCORCHED_STRIPPED_WOOD)
        .unlockedBy("has_scorched_stripped_wood", has(EternalEndBlocks.SCORCHED_STRIPPED_WOOD))
        .save(output);

    // whispering_planks_thin_log.json - whispering_planks_thin_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.WHISPERING_PLANKS, 2)
        .requires(EternalEndBlocks.WHISPERING_THIN_LOG)
        .unlockedBy("has_whispering_thin_log", has(EternalEndBlocks.WHISPERING_THIN_LOG))
        .save(output);

    // awkward_mushroom_stew_2.json - awkward_mushroom_stew_2
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.AWKWARD_MUSHROOM_STEW)
        .requires(EternalEndBlocks.BLOOMLING)
        .requires(EternalEndBlocks.BLOOMLING)
        .requires(Items.BOWL)
        .unlockedBy("has_bloomling", has(EternalEndBlocks.BLOOMLING))
        .save(output);

    // chorus_planks_wood.json - chorus_planks_wood
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.CHORUS_PLANKS, 4)
        .requires(EternalEndBlocks.CHORUS_WOOD)
        .unlockedBy("has_chorus_wood", has(EternalEndBlocks.CHORUS_WOOD))
        .save(output);

    // fungal_planks_thin_log.json - fungal_planks_thin_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.FUNGAL_PLANKS, 2)
        .requires(EternalEndBlocks.FUNGAL_THIN_LOG)
        .unlockedBy("has_fungal_thin_log", has(EternalEndBlocks.FUNGAL_THIN_LOG))
        .save(output);

    // spored_planks_log.json - spored_planks_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.SPORED_PLANKS, 4)
        .requires(EternalEndBlocks.SPORED_LOG)
        .unlockedBy("has_spored_log", has(EternalEndBlocks.SPORED_LOG))
        .save(output);

    // chorus_planks_stripped_wood.json - chorus_planks_stripped_wood
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.CHORUS_PLANKS, 4)
        .requires(EternalEndBlocks.CHORUS_STRIPPED_WOOD)
        .unlockedBy("has_chorus_stripped_wood", has(EternalEndBlocks.CHORUS_STRIPPED_WOOD))
        .save(output);

    // cryolite_planks_log.json - cryolite_planks_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.CRYOLITE_PLANKS, 4)
        .requires(EternalEndBlocks.CRYOLITE_LOG)
        .unlockedBy("has_cryolite_log", has(EternalEndBlocks.CRYOLITE_LOG))
        .save(output);

    // awkward_mushroom_stew_5.json - awkward_mushroom_stew_5
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.AWKWARD_MUSHROOM_STEW)
        .requires(EternalEndBlocks.MEADOWLINGS)
        .requires(EternalEndBlocks.MEADOWLINGS)
        .requires(Items.BOWL)
        .unlockedBy("has_meadowlings", has(EternalEndBlocks.MEADOWLINGS))
        .save(output);

    // scorched_planks_stripped_log.json - scorched_planks_stripped_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.SCORCHED_PLANKS, 4)
        .requires(EternalEndBlocks.SCORCHED_STRIPPED_LOG)
        .unlockedBy("has_scorched_stripped_log", has(EternalEndBlocks.SCORCHED_STRIPPED_LOG))
        .save(output);

    // packed_frozen_jelly.json - packed_frozen_jelly
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.FROZEN_JELLY, 4)
        .requires(EternalEndBlocks.PACKED_FROZEN_JELLY)
        .unlockedBy("has_packed_frozen_jelly", has(EternalEndBlocks.PACKED_FROZEN_JELLY))
        .save(output);

    // fungal_planks_log.json - fungal_planks_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.FUNGAL_PLANKS, 4)
        .requires(EternalEndBlocks.FUNGAL_LOG)
        .unlockedBy("has_fungal_log", has(EternalEndBlocks.FUNGAL_LOG))
        .save(output);

    // cryolite_planks_thin_log.json - cryolite_planks_thin_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.CRYOLITE_PLANKS, 2)
        .requires(EternalEndBlocks.CRYOLITE_THIN_LOG)
        .unlockedBy("has_cryolite_thin_log", has(EternalEndBlocks.CRYOLITE_THIN_LOG))
        .save(output);

    // honey_planks_wood.json - honey_planks_wood
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.HONEY_PLANKS, 4)
        .requires(EternalEndBlocks.HONEY_WOOD)
        .unlockedBy("has_honey_wood", has(EternalEndBlocks.HONEY_WOOD))
        .save(output);

    // book.json - book
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.BOOK)
        .requires(Items.BOOK)
        .requires(Items.ENDER_PEARL)
        .unlockedBy("has_book", has(Items.BOOK))
        .save(output);

    // bloomling.json - bloomling
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GLOWSTONE_DUST, 2)
        .requires(EternalEndBlocks.BLOOMLING)
        .unlockedBy("has_bloomling", has(EternalEndBlocks.BLOOMLING))
        .save(output);

    // awkward_mushroom_stew_4.json - awkward_mushroom_stew_4
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.AWKWARD_MUSHROOM_STEW)
        .requires(EternalEndBlocks.TANGLECAPS)
        .requires(EternalEndBlocks.TANGLECAPS)
        .requires(Items.BOWL)
        .unlockedBy("has_tanglecaps", has(EternalEndBlocks.TANGLECAPS))
        .save(output);

    // cryolite_planks_stripped_log.json - cryolite_planks_stripped_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.CRYOLITE_PLANKS, 4)
        .requires(EternalEndBlocks.CRYOLITE_STRIPPED_LOG)
        .unlockedBy("has_cryolite_stripped_log", has(EternalEndBlocks.CRYOLITE_STRIPPED_LOG))
        .save(output);

    // fungal_planks_wood.json - fungal_planks_wood
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.FUNGAL_PLANKS, 4)
        .requires(EternalEndBlocks.FUNGAL_WOOD)
        .unlockedBy("has_fungal_wood", has(EternalEndBlocks.FUNGAL_WOOD))
        .save(output);

    // awkward_mushroom_stew_8.json - awkward_mushroom_stew_8
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.AWKWARD_MUSHROOM_STEW)
        .requires(EternalEndBlocks.LAYERLOOM)
        .requires(EternalEndBlocks.LAYERLOOM)
        .requires(Items.BOWL)
        .unlockedBy("has_layerloom", has(EternalEndBlocks.LAYERLOOM))
        .save(output);

    // lilecap.json - lilecap
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MAGENTA_DYE)
        .requires(EternalEndBlocks.LILECAP)
        .unlockedBy("has_lilecap", has(EternalEndBlocks.LILECAP))
        .save(output);

    // limecap.json - limecap
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LIME_DYE)
        .requires(EternalEndBlocks.LIMECAP)
        .unlockedBy("has_limecap", has(EternalEndBlocks.LIMECAP))
        .save(output);

    // chorus_planks_log.json - chorus_planks_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.CHORUS_PLANKS, 4)
        .requires(EternalEndBlocks.CHORUS_LOG)
        .unlockedBy("has_chorus_log", has(EternalEndBlocks.CHORUS_LOG))
        .save(output);

    // whispering_planks_wood.json - whispering_planks_wood
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.WHISPERING_PLANKS, 4)
        .requires(EternalEndBlocks.WHISPERING_WOOD)
        .unlockedBy("has_whispering_wood", has(EternalEndBlocks.WHISPERING_WOOD))
        .save(output);

    // whispering_planks_log.json - whispering_planks_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.WHISPERING_PLANKS, 4)
        .requires(EternalEndBlocks.WHISPERING_LOG)
        .unlockedBy("has_whispering_log", has(EternalEndBlocks.WHISPERING_LOG))
        .save(output);

    // fungal_planks_stripped_wood.json - fungal_planks_stripped_wood
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.FUNGAL_PLANKS, 4)
        .requires(EternalEndBlocks.FUNGAL_STRIPPED_WOOD)
        .unlockedBy("has_fungal_stripped_wood", has(EternalEndBlocks.FUNGAL_STRIPPED_WOOD))
        .save(output);

    // honey_planks_log.json - honey_planks_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.HONEY_PLANKS, 4)
        .requires(EternalEndBlocks.HONEY_LOG)
        .unlockedBy("has_honey_log", has(EternalEndBlocks.HONEY_LOG))
        .save(output);

    // shadow_deer_white.json - shadow_deer_white
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.WHITE_ESSENCE_DRINK)
        .requires(Items.GLASS_BOTTLE)
        .requires(EternalEndItems.WHITE_ESSENCE)
        .unlockedBy("has_glass_bottle", has(Items.GLASS_BOTTLE))
        .save(output);

    // awkward_mushroom_stew_7.json - awkward_mushroom_stew_7
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.AWKWARD_MUSHROOM_STEW)
        .requires(EternalEndBlocks.SPRINGBULB)
        .requires(EternalEndBlocks.SPRINGBULB)
        .requires(Items.BOWL)
        .unlockedBy("has_springbulb", has(EternalEndBlocks.SPRINGBULB))
        .save(output);

    // verdant_essence_drink.json - verdant_essence_drink
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.VERDANT_ESSENCE_DRINK)
        .requires(Items.GLASS_BOTTLE)
        .requires(EternalEndItems.VERDANT_ESSENCE)
        .unlockedBy("has_glass_bottle", has(Items.GLASS_BOTTLE))
        .save(output);

    // cryolite_planks_wood.json - cryolite_planks_wood
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.CRYOLITE_PLANKS, 4)
        .requires(EternalEndBlocks.CRYOLITE_WOOD)
        .unlockedBy("has_cryolite_wood", has(EternalEndBlocks.CRYOLITE_WOOD))
        .save(output);

    // tealcap.json - tealcap
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CYAN_DYE)
        .requires(EternalEndBlocks.TEALCAP)
        .unlockedBy("has_tealcap", has(EternalEndBlocks.TEALCAP))
        .save(output);

    // awkward_mushroom_stew_6.json - awkward_mushroom_stew_6
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.AWKWARD_MUSHROOM_STEW)
        .requires(EternalEndBlocks.SPORESPROUT)
        .requires(EternalEndBlocks.SPORESPROUT)
        .requires(Items.BOWL)
        .unlockedBy("has_sporesprout", has(EternalEndBlocks.SPORESPROUT))
        .save(output);

    // scorched_planks_thin_log.json - scorched_planks_thin_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.SCORCHED_PLANKS, 2)
        .requires(EternalEndBlocks.SCORCHED_THIN_LOG)
        .unlockedBy("has_scorched_thin_log", has(EternalEndBlocks.SCORCHED_THIN_LOG))
        .save(output);

    // fungal_planks_stripped_log.json - fungal_planks_stripped_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.FUNGAL_PLANKS, 4)
        .requires(EternalEndBlocks.FUNGAL_STRIPPED_LOG)
        .unlockedBy("has_fungal_stripped_log", has(EternalEndBlocks.FUNGAL_STRIPPED_LOG))
        .save(output);

    // spored_planks_stripped_log.json - spored_planks_stripped_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.SPORED_PLANKS, 4)
        .requires(EternalEndBlocks.SPORED_STRIPPED_LOG)
        .unlockedBy("has_spored_stripped_log", has(EternalEndBlocks.SPORED_STRIPPED_LOG))
        .save(output);

    // cryolite_planks_stripped_wood.json - cryolite_planks_stripped_wood
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.CRYOLITE_PLANKS, 4)
        .requires(EternalEndBlocks.CRYOLITE_STRIPPED_WOOD)
        .unlockedBy("has_cryolite_stripped_wood", has(EternalEndBlocks.CRYOLITE_STRIPPED_WOOD))
        .save(output);

    // scorched_planks_wood.json - scorched_planks_wood
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.SCORCHED_PLANKS, 4)
        .requires(EternalEndBlocks.SCORCHED_WOOD)
        .unlockedBy("has_scorched_wood", has(EternalEndBlocks.SCORCHED_WOOD))
        .save(output);

    // frozen_jelly.json - frozen_jelly
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.PACKED_FROZEN_JELLY)
        .requires(EternalEndBlocks.FROZEN_JELLY)
        .requires(EternalEndBlocks.FROZEN_JELLY)
        .requires(EternalEndBlocks.FROZEN_JELLY)
        .requires(EternalEndBlocks.FROZEN_JELLY)
        .unlockedBy("has_frozen_jelly", has(EternalEndBlocks.FROZEN_JELLY))
        .save(output);

    // honey_planks_thin_log.json - honey_planks_thin_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.HONEY_PLANKS, 2)
        .requires(EternalEndBlocks.HONEY_THIN_LOG)
        .unlockedBy("has_honey_thin_log", has(EternalEndBlocks.HONEY_THIN_LOG))
        .save(output);

    // scorched_planks_log.json - scorched_planks_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.SCORCHED_PLANKS, 4)
        .requires(EternalEndBlocks.SCORCHED_LOG)
        .unlockedBy("has_scorched_log", has(EternalEndBlocks.SCORCHED_LOG))
        .save(output);

    // honey_planks_stripped_wood.json - honey_planks_stripped_wood
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.HONEY_PLANKS, 4)
        .requires(EternalEndBlocks.HONEY_STRIPPED_WOOD)
        .unlockedBy("has_honey_stripped_wood", has(EternalEndBlocks.HONEY_STRIPPED_WOOD))
        .save(output);

    // chorus_planks_thin_log.json - chorus_planks_thin_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.CHORUS_PLANKS, 2)
        .requires(EternalEndBlocks.CHORUS_THIN_LOG)
        .unlockedBy("has_chorus_thin_log", has(EternalEndBlocks.CHORUS_THIN_LOG))
        .save(output);

    // awkward_mushroom_stew_1.json - awkward_mushroom_stew_1
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.AWKWARD_MUSHROOM_STEW)
        .requires(Items.CRIMSON_FUNGUS)
        .requires(Items.CRIMSON_FUNGUS)
        .requires(Items.BOWL)
        .unlockedBy("has_crimson_fungus", has(Items.CRIMSON_FUNGUS))
        .save(output);

    // whispering_planks_stripped_log.json - whispering_planks_stripped_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.WHISPERING_PLANKS, 4)
        .requires(EternalEndBlocks.WHISPERING_STRIPPED_LOG)
        .unlockedBy("has_whispering_stripped_log", has(EternalEndBlocks.WHISPERING_STRIPPED_LOG))
        .save(output);

    // awkward_mushroom_stew_0.json - awkward_mushroom_stew_0
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.AWKWARD_MUSHROOM_STEW)
        .requires(Items.WARPED_FUNGUS)
        .requires(Items.WARPED_FUNGUS)
        .requires(Items.BOWL)
        .unlockedBy("has_warped_fungus", has(Items.WARPED_FUNGUS))
        .save(output);

    // chorus_planks_stripped_log.json - chorus_planks_stripped_log
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndBlocks.CHORUS_PLANKS, 4)
        .requires(EternalEndBlocks.CHORUS_STRIPPED_LOG)
        .unlockedBy("has_chorus_stripped_log", has(EternalEndBlocks.CHORUS_STRIPPED_LOG))
        .save(output);

    // eternal_heart.json - eternal_heart
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.ETERNAL_HEART)
        .requires(EternalEndItems.ENDERMAN_HEART)
        .requires(EternalEndItems.WINGED_ENDERMAN_HEART)
        .requires(EternalEndItems.PALE_ENDERMAN_HEART)
        .requires(EternalEndItems.MOSSY_ENDERMAN_HEART)
        .requires(EternalEndItems.GILDED_ENDERMAN_HEART)
        .requires(EternalEndItems.MYCOTIC_ENDERMAN_HEART)
        .unlockedBy("has_enderman_heart", has(EternalEndItems.ENDERMAN_HEART))
        .save(output);

    // block_to_ingot.json - ametrine.block_to_ingot
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.AMETRINE_INGOT, 9)
        .requires(EternalEndBlocks.AMETRINE_BLOCK)
        .unlockedBy("has_ametrine_block", has(EternalEndBlocks.AMETRINE_BLOCK))
        .save(output);

    // scrap_to_ingot.json - enderite.scrap_to_ingot
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.ENDERITE_INGOT)
        .requires(EternalEndItems.ENDERITE_SCRAP)
        .requires(EternalEndItems.ENDERITE_SCRAP)
        .requires(EternalEndItems.ENDERITE_SCRAP)
        .requires(EternalEndItems.ENDERITE_SCRAP)
        .requires(EternalEndItems.AMETRINE_INGOT)
        .requires(EternalEndItems.AMETRINE_INGOT)
        .requires(EternalEndItems.AMETRINE_INGOT)
        .requires(EternalEndItems.AMETRINE_INGOT)
        .unlockedBy("has_enderite_scrap", has(EternalEndItems.ENDERITE_SCRAP))
        .save(output);

    // shovel.json - enderite.shovel
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.ENDERITE_SHOVEL)
        .requires(EternalEndItems.ENDERITE_UPGRADE)
        .requires(Items.DIAMOND_SHOVEL)
        .requires(EternalEndItems.ENDERITE_INGOT)
        .unlockedBy("has_enderite_upgrade", has(EternalEndItems.ENDERITE_UPGRADE))
        .save(output);

    // leggings.json - enderite.leggings
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.ENDERITE_LEGGINGS)
        .requires(EternalEndItems.ENDERITE_UPGRADE)
        .requires(Items.DIAMOND_LEGGINGS)
        .requires(EternalEndItems.ENDERITE_INGOT)
        .unlockedBy("has_enderite_upgrade", has(EternalEndItems.ENDERITE_UPGRADE))
        .save(output);

    // chestplate.json - enderite.chestplate
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.ENDERITE_CHESTPLATE)
        .requires(EternalEndItems.ENDERITE_UPGRADE)
        .requires(Items.DIAMOND_CHESTPLATE)
        .requires(EternalEndItems.ENDERITE_INGOT)
        .unlockedBy("has_enderite_upgrade", has(EternalEndItems.ENDERITE_UPGRADE))
        .save(output);

    // pickaxe.json - enderite.pickaxe
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.ENDERITE_PICKAXE)
        .requires(EternalEndItems.ENDERITE_UPGRADE)
        .requires(Items.DIAMOND_PICKAXE)
        .requires(EternalEndItems.ENDERITE_INGOT)
        .unlockedBy("has_enderite_upgrade", has(EternalEndItems.ENDERITE_UPGRADE))
        .save(output);

    // sword.json - enderite.sword
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.ENDERITE_SWORD)
        .requires(EternalEndItems.ENDERITE_UPGRADE)
        .requires(Items.DIAMOND_SWORD)
        .requires(EternalEndItems.ENDERITE_INGOT)
        .unlockedBy("has_enderite_upgrade", has(EternalEndItems.ENDERITE_UPGRADE))
        .save(output);

    // helmet.json - enderite.helmet
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.ENDERITE_HELMET)
        .requires(EternalEndItems.ENDERITE_UPGRADE)
        .requires(Items.DIAMOND_HELMET)
        .requires(EternalEndItems.ENDERITE_INGOT)
        .unlockedBy("has_enderite_upgrade", has(EternalEndItems.ENDERITE_UPGRADE))
        .save(output);

    // block_to_ingot.json - enderite.block_to_ingot
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.ENDERITE_INGOT, 9)
        .requires(EternalEndBlocks.ENDERITE_BLOCK)
        .unlockedBy("has_enderite_block", has(EternalEndBlocks.ENDERITE_BLOCK))
        .save(output);

    // boots.json - enderite.boots
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.ENDERITE_BOOTS)
        .requires(EternalEndItems.ENDERITE_UPGRADE)
        .requires(Items.DIAMOND_BOOTS)
        .requires(EternalEndItems.ENDERITE_INGOT)
        .unlockedBy("has_enderite_upgrade", has(EternalEndItems.ENDERITE_UPGRADE))
        .save(output);

    // hoe.json - enderite.hoe
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.ENDERITE_HOE)
        .requires(EternalEndItems.ENDERITE_UPGRADE)
        .requires(Items.DIAMOND_HOE)
        .requires(EternalEndItems.ENDERITE_INGOT)
        .unlockedBy("has_enderite_upgrade", has(EternalEndItems.ENDERITE_UPGRADE))
        .save(output);

    // axe.json - enderite.axe
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EternalEndItems.ENDERITE_AXE)
        .requires(EternalEndItems.ENDERITE_UPGRADE)
        .requires(Items.DIAMOND_AXE)
        .requires(EternalEndItems.ENDERITE_INGOT)
        .unlockedBy("has_enderite_upgrade", has(EternalEndItems.ENDERITE_UPGRADE))
        .save(output);

    // ========== SMELTING RECIPES ==========

    // fungal_stripped_wood_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.FUNGAL_STRIPPED_WOOD), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // scorched_thin_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.SCORCHED_THIN_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // ametrine_geode_rock.json
    oreSmelting(output, List.of(EternalEndBlocks.AMETRINE_GEODE_ROCK), RecipeCategory.MISC, 
        EternalEndItems.AMETRINE_INGOT, 
        0.35f, 200, "furnace");

    // whispering_stripped_wood_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.WHISPERING_STRIPPED_WOOD), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // gilded_venison.json
    oreSmelting(output, List.of(EternalEndItems.GILDED_VENISON), RecipeCategory.MISC, 
        EternalEndItems.COOKED_GILDED_VENISON, 
        0.35f, 200, "furnace");

    // cryolite_stripped_wood_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.CRYOLITE_STRIPPED_WOOD), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // chorus_wood_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.CHORUS_WOOD), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // scorched_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.SCORCHED_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // whispering_thin_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.WHISPERING_THIN_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // scorched_stripped_wood_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.SCORCHED_STRIPPED_WOOD), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // honey_wood_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.HONEY_WOOD), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // spored_thin_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.SPORED_THIN_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // cryolite_stripped_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.CRYOLITE_STRIPPED_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // chorus_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.CHORUS_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // scorched_wood_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.SCORCHED_WOOD), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // honey_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.HONEY_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // whispering_stripped_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.WHISPERING_STRIPPED_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // chorus_thin_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.CHORUS_THIN_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // spored_wood_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.SPORED_WOOD), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // verdant_essence.json
    oreSmelting(output, List.of(EternalEndBlocks.VERDANT_STALK), RecipeCategory.MISC, 
        EternalEndItems.VERDANT_ESSENCE, 
        0.35f, 200, "furnace");

    // cryolite_thin_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.CRYOLITE_THIN_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // spored_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.SPORED_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // honey_stripped_wood_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.HONEY_STRIPPED_WOOD), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // scorched_stripped_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.SCORCHED_STRIPPED_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // cryolite_wood_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.CRYOLITE_WOOD), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // fungal_stripped_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.FUNGAL_STRIPPED_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // spored_stripped_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.SPORED_STRIPPED_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // fungal_thin_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.FUNGAL_THIN_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // chorus_stripped_wood_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.CHORUS_STRIPPED_WOOD), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // dusk_soil_to_glass.json
    oreSmelting(output, List.of(EternalEndBlocks.DUSK_SOIL), RecipeCategory.MISC, 
        Items.GLASS, 
        0.35f, 200, "furnace");

    // fungal_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.FUNGAL_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // fungal_wood_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.FUNGAL_WOOD), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // whispering_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.WHISPERING_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // honey_stripped_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.HONEY_STRIPPED_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // whispering_wood_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.WHISPERING_WOOD), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // chorus_stripped_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.CHORUS_STRIPPED_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // cryolite_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.CRYOLITE_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // spored_stripped_wood_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.SPORED_STRIPPED_WOOD), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // honey_thin_log_to_charcoal.json
    oreSmelting(output, List.of(EternalEndBlocks.HONEY_THIN_LOG), RecipeCategory.MISC, 
        Items.CHARCOAL, 
        0.35f, 200, "furnace");

    // cleanstone.json
    oreSmelting(output, List.of(EternalEndBlocks.NOCTRAL_STONE), RecipeCategory.MISC, 
        Items.STONE, 
        0.35f, 200, "furnace");

    // ore_to_ingot.json
    oreSmelting(output, List.of(EternalEndBlocks.AMETRINE_ORE), RecipeCategory.MISC, 
        EternalEndItems.AMETRINE_INGOT, 
        0.35f, 200, "furnace");

    // raw_item_to_brick.json
    oreSmelting(output, List.of(EternalEndItems.RAW_DARK_PURPURITE), RecipeCategory.MISC, 
        EternalEndItems.DARK_PURPUR_BRICK, 
        0.35f, 200, "furnace");

    // debris_to_scrap.json
    oreSmelting(output, List.of(EternalEndBlocks.ETERNAL_DEBRIS), RecipeCategory.MISC, 
        EternalEndItems.ENDERITE_SCRAP, 
        0.35f, 200, "furnace");

    // raw_item_to_brick.json
    oreSmelting(output, List.of(EternalEndItems.VIRIDIAN_CLUMP), RecipeCategory.MISC, 
        EternalEndItems.VIRIDIAN_BRICK, 
        0.35f, 200, "furnace");

    // raw_item_to_brick.json
    oreSmelting(output, List.of(EternalEndItems.RAW_PURPURITE), RecipeCategory.MISC, 
        EternalEndItems.PURPUR_BRICK, 
        0.35f, 200, "furnace");    }
}
