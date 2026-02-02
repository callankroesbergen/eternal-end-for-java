package org.VenularSpore257.eternal_end_for_java;

import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.VenularSpore257.eternal_end_for_java.block.EndLayerBlock;
import org.VenularSpore257.eternal_end_for_java.item.ModBlockItem;

import java.util.function.Supplier;

/**
 * Registry for all Eternal End blocks.
 * 261 blocks total from the Bedrock addon.
 */
public class EternalEndBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Eternal_end_for_java.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Eternal_end_for_java.MODID);

    // Helper properties
    private static final BlockBehaviour.Properties STONE = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_GRAY).strength(1.5f, 6.0f).requiresCorrectToolForDrops();
    private static final BlockBehaviour.Properties END_STONE = BlockBehaviour.Properties.of()
            .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).strength(3.0f, 9.0f);
    private static final BlockBehaviour.Properties WOOD = BlockBehaviour.Properties.of()
            .mapColor(MapColor.WOOD).strength(2.0f).ignitedByLava();
    private static final BlockBehaviour.Properties PLANKS = BlockBehaviour.Properties.of()
            .mapColor(MapColor.WOOD).strength(2.0f, 3.0f).ignitedByLava();
    private static final BlockBehaviour.Properties LEAVES = BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT).strength(0.2f).noCollission().ignitedByLava();
    private static final BlockBehaviour.Properties SAPLING = BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT).noCollission().noOcclusion().instabreak();
    private static final BlockBehaviour.Properties ORE_IRON = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_GRAY).strength(3.0f, 3.0f).requiresCorrectToolForDrops();
    private static final BlockBehaviour.Properties ORE = BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_GRAY).strength(3.0f, 3.0f);
    private static final BlockBehaviour.Properties GRASS = BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT).strength(0.6f).noCollission();
    private static final BlockBehaviour.Properties VEGETATION = BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT).strength(0.0f).noCollission().replaceable();

    // ========== ORES ==========
    public static final DeferredBlock<Block> AMETRINE_ORE = registerSimpleBlock("ametrine_ore", STONE);
    public static final DeferredBlock<Block> AMETRINE_ORE_DEEPSLATE = registerSimpleBlock("ametrine_ore_deepslate", STONE);
    public static final DeferredBlock<Block> DARK_PURPURITE_ORE = registerSimpleBlock("dark_purpurite_ore", END_STONE);
    public static final DeferredBlock<Block> PURPURITE_ORE = registerSimpleBlock("purpurite_ore", END_STONE);
    public static final DeferredBlock<Block> VIRIDIAN_ORE = registerSimpleBlock("viridian_ore", END_STONE);

    // End Stone Ores
    public static final DeferredBlock<Block> END_STONE_IRON_ORE = registerSimpleBlock("end_stone_iron_ore", END_STONE);
    public static final DeferredBlock<Block> END_STONE_GOLD_ORE = registerSimpleBlock("end_stone_gold_ore", END_STONE);
    public static final DeferredBlock<Block> END_STONE_COPPER_ORE = registerSimpleBlock("end_stone_copper_ore", END_STONE);
    public static final DeferredBlock<Block> END_STONE_LAPIS_ORE = registerSimpleBlock("end_stone_lapis_ore", END_STONE);
    public static final DeferredBlock<Block> END_STONE_REDSTONE_ORE = registerSimpleBlock("end_stone_redstone_ore", END_STONE);
    public static final DeferredBlock<Block> END_STONE_DIAMOND_ORE = registerSimpleBlock("end_stone_diamond_ore", END_STONE);
    public static final DeferredBlock<Block> END_STONE_EMERALD_ORE = registerSimpleBlock("end_stone_emerald_ore", END_STONE);
    public static final DeferredBlock<Block> END_STONE_QUARTZ_ORE = registerSimpleBlock("end_stone_quartz_ore", END_STONE);

    // Raw Ore Blocks
    public static final DeferredBlock<Block> RAW_PURPURITE_BLOCK = registerSimpleBlock("raw_purpurite_block", STONE);
    public static final DeferredBlock<Block> RAW_DARK_PURPURITE_BLOCK = registerSimpleBlock("raw_dark_purpurite_block", STONE);

    // ========== STORAGE BLOCKS ==========
    public static final DeferredBlock<Block> AMETRINE_BLOCK = registerSimpleBlock("ametrine_block", STONE);
    public static final DeferredBlock<Block> ENDERITE_BLOCK = registerSimpleBlock("enderite_block", STONE);
    public static final DeferredBlock<Block> DARK_PURPUR_BLOCK = registerSimpleBlock("dark_purpur_block", STONE);
    public static final DeferredBlock<Block> DARK_PURPUR_PILLAR = registerPillarBlock("dark_purpur_pillar", STONE);
    public static final DeferredBlock<Block> DARK_PURPUR_TILES = registerSimpleBlock("dark_purpur_tiles", STONE);

    // Ametrine Crystal
    public static final DeferredBlock<Block> AMETRINE_CRYSTAL = registerSimpleBlock("ametrine_crystal",
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(1.5f).sound(SoundType.AMETHYST));
    public static final DeferredBlock<Block> AMETRINE_GEODE = registerSimpleBlock("ametrine_geode", STONE);
    public static final DeferredBlock<Block> AMETRINE_GEODE_ROCK = registerSimpleBlock("ametrine_geode_rock", STONE);

    // ========== CHORUS WOOD ==========
    public static final DeferredBlock<Block> CHORUS_LOG = registerPillarBlock("chorus_log", WOOD);
    public static final DeferredBlock<Block> CHORUS_WOOD = registerPillarBlock("chorus_wood", WOOD);
    public static final DeferredBlock<Block> CHORUS_STRIPPED_LOG = registerPillarBlock("chorus_stripped_log", WOOD);
    public static final DeferredBlock<Block> CHORUS_STRIPPED_WOOD = registerPillarBlock("chorus_stripped_wood", WOOD);
    public static final DeferredBlock<Block> CHORUS_THIN_LOG = registerPillarBlock("chorus_thin_log", WOOD);
    public static final DeferredBlock<Block> CHORUS_PLANKS = registerSimpleBlock("chorus_planks", PLANKS);
    public static final DeferredBlock<Block> CHORUS_LEAVES = registerSimpleBlock("chorus_leaves", LEAVES);
    public static final DeferredBlock<Block> CHORUS_SAPLING = registerSimpleBlock("chorus_sapling", SAPLING);
    public static final DeferredBlock<Block> CHORAL_SPIRE = registerSimpleBlock("choral_spire", VEGETATION);

    // Chorus Wood Derivatives
    public static final DeferredBlock<Block> CHORUS_STAIRS = registerStairs("chorus_stairs", CHORUS_PLANKS);
    public static final DeferredBlock<Block> CHORUS_SLAB = registerSlab("chorus_slab", CHORUS_PLANKS);
    public static final DeferredBlock<Block> CHORUS_FENCE = registerFence("chorus_fence", CHORUS_PLANKS);
    public static final DeferredBlock<Block> CHORUS_FENCE_GATE = registerFenceGate("chorus_fence_gate", CHORUS_PLANKS);
    public static final DeferredBlock<Block> CHORUS_DOOR = registerDoor("chorus_door", CHORUS_PLANKS);
    public static final DeferredBlock<Block> CHORUS_TRAPDOOR = registerTrapdoor("chorus_trapdoor", CHORUS_PLANKS);

    // ========== CRYOLITE WOOD ==========
    public static final DeferredBlock<Block> CRYOLITE_LOG = registerPillarBlock("cryolite_log", WOOD);
    public static final DeferredBlock<Block> CRYOLITE_WOOD = registerPillarBlock("cryolite_wood", WOOD);
    public static final DeferredBlock<Block> CRYOLITE_STRIPPED_LOG = registerPillarBlock("cryolite_stripped_log", WOOD);
    public static final DeferredBlock<Block> CRYOLITE_STRIPPED_WOOD = registerPillarBlock("cryolite_stripped_wood", WOOD);
    public static final DeferredBlock<Block> CRYOLITE_THIN_LOG = registerPillarBlock("cryolite_thin_log", WOOD);
    public static final DeferredBlock<Block> CRYOLITE_PLANKS = registerSimpleBlock("cryolite_planks", PLANKS);
    public static final DeferredBlock<Block> CRYOLITE_LEAVES = registerSimpleBlock("cryolite_leaves", LEAVES);
    public static final DeferredBlock<Block> CRYOLITE_SAPLING = registerBlock("cryolite_sapling",
            () -> new FlowerBlock(net.minecraft.world.effect.MobEffects.SATURATION, 0.1f, SAPLING), SAPLING);
    public static final DeferredBlock<Block> HANGING_CRYOLITE_LEAVES = registerSimpleBlock("hanging_cryolite_leaves", LEAVES);

    // Cryolite Wood Derivatives
    public static final DeferredBlock<Block> CRYOLITE_STAIRS = registerStairs("cryolite_stairs", CRYOLITE_PLANKS);
    public static final DeferredBlock<Block> CRYOLITE_SLAB = registerSlab("cryolite_slab", CRYOLITE_PLANKS);
    public static final DeferredBlock<Block> CRYOLITE_FENCE = registerFence("cryolite_fence", CRYOLITE_PLANKS);
    public static final DeferredBlock<Block> CRYOLITE_FENCE_GATE = registerFenceGate("cryolite_fence_gate", CRYOLITE_PLANKS);
    public static final DeferredBlock<Block> CRYOLITE_DOOR = registerDoor("cryolite_door", CRYOLITE_PLANKS);
    public static final DeferredBlock<Block> CRYOLITE_TRAPDOOR = registerTrapdoor("cryolite_trapdoor", CRYOLITE_PLANKS);

    // ========== FUNGAL WOOD ==========
    public static final DeferredBlock<Block> FUNGAL_LOG = registerPillarBlock("fungal_log", WOOD);
    public static final DeferredBlock<Block> FUNGAL_WOOD = registerPillarBlock("fungal_wood", WOOD);
    public static final DeferredBlock<Block> FUNGAL_STRIPPED_LOG = registerPillarBlock("fungal_stripped_log", WOOD);
    public static final DeferredBlock<Block> FUNGAL_STRIPPED_WOOD = registerPillarBlock("fungal_stripped_wood", WOOD);
    public static final DeferredBlock<Block> FUNGAL_THIN_LOG = registerPillarBlock("fungal_thin_log", WOOD);
    public static final DeferredBlock<Block> FUNGAL_PLANKS = registerSimpleBlock("fungal_planks", PLANKS);
    public static final DeferredBlock<Block> FUNGAL_LEAVES = registerSimpleBlock("fungal_leaves", LEAVES);
    public static final DeferredBlock<Block> FUNGAL_LEAVES_SLAB = registerSlab("fungal_leaves_slab", FUNGAL_PLANKS);
    public static final DeferredBlock<Block> FUNGAL_SAPLING = registerBlock("fungal_sapling",
            () -> new FlowerBlock(net.minecraft.world.effect.MobEffects.SATURATION, 0.1f, SAPLING), SAPLING);

    // Fungal Wood Derivatives
    public static final DeferredBlock<Block> FUNGAL_STAIRS = registerStairs("fungal_stairs", FUNGAL_PLANKS);
    public static final DeferredBlock<Block> FUNGAL_SLAB = registerSlab("fungal_slab", FUNGAL_PLANKS);
    public static final DeferredBlock<Block> FUNGAL_FENCE = registerFence("fungal_fence", FUNGAL_PLANKS);
    public static final DeferredBlock<Block> FUNGAL_FENCE_GATE = registerFenceGate("fungal_fence_gate", FUNGAL_PLANKS);
    public static final DeferredBlock<Block> FUNGAL_DOOR = registerDoor("fungal_door", FUNGAL_PLANKS);
    public static final DeferredBlock<Block> FUNGAL_TRAPDOOR = registerTrapdoor("fungal_trapdoor", FUNGAL_PLANKS);

    // ========== WHISPERING WOOD ==========
    public static final DeferredBlock<Block> WHISPERING_LOG = registerPillarBlock("whispering_log", WOOD);
    public static final DeferredBlock<Block> WHISPERING_WOOD = registerPillarBlock("whispering_wood", WOOD);
    public static final DeferredBlock<Block> WHISPERING_STRIPPED_LOG = registerPillarBlock("whispering_stripped_log", WOOD);
    public static final DeferredBlock<Block> WHISPERING_STRIPPED_WOOD = registerPillarBlock("whispering_stripped_wood", WOOD);
    public static final DeferredBlock<Block> WHISPERING_THIN_LOG = registerPillarBlock("whispering_thin_log", WOOD);
    public static final DeferredBlock<Block> WHISPERING_PLANKS = registerSimpleBlock("whispering_planks", PLANKS);
    public static final DeferredBlock<Block> WHISPERING_LEAVES = registerSimpleBlock("whispering_leaves", LEAVES);
    public static final DeferredBlock<Block> HANGING_WHISPERING_LEAVES = registerSimpleBlock("hanging_whispering_leaves", LEAVES);
    public static final DeferredBlock<Block> WHISPERING_SAPLING = registerBlock("whispering_sapling",
            () -> new FlowerBlock(net.minecraft.world.effect.MobEffects.SATURATION, 0.1f, SAPLING), SAPLING);

    // Whispering Wood Derivatives
    public static final DeferredBlock<Block> WHISPERING_STAIRS = registerStairs("whispering_stairs", WHISPERING_PLANKS);
    public static final DeferredBlock<Block> WHISPERING_SLAB = registerSlab("whispering_slab", WHISPERING_PLANKS);
    public static final DeferredBlock<Block> WHISPERING_FENCE = registerFence("whispering_fence", WHISPERING_PLANKS);
    public static final DeferredBlock<Block> WHISPERING_FENCE_GATE = registerFenceGate("whispering_fence_gate", WHISPERING_PLANKS);
    public static final DeferredBlock<Block> WHISPERING_DOOR = registerDoor("whispering_door", WHISPERING_PLANKS);
    public static final DeferredBlock<Block> WHISPERING_TRAPDOOR = registerTrapdoor("whispering_trapdoor", WHISPERING_PLANKS);

    // ========== HONEY WOOD ==========
    public static final DeferredBlock<Block> HONEY_LOG = registerPillarBlock("honey_log", WOOD);
    public static final DeferredBlock<Block> HONEY_WOOD = registerPillarBlock("honey_wood", WOOD);
    public static final DeferredBlock<Block> HONEY_STRIPPED_LOG = registerPillarBlock("honey_stripped_log", WOOD);
    public static final DeferredBlock<Block> HONEY_STRIPPED_WOOD = registerPillarBlock("honey_stripped_wood", WOOD);
    public static final DeferredBlock<Block> HONEY_THIN_LOG = registerPillarBlock("honey_thin_log", WOOD);
    public static final DeferredBlock<Block> HONEY_PLANKS = registerSimpleBlock("honey_planks", PLANKS);
    public static final DeferredBlock<Block> HONEY_LEAVES = registerSimpleBlock("honey_leaves", LEAVES);
    public static final DeferredBlock<Block> HONEY_SAPLING = registerBlock("honey_sapling",
            () -> new FlowerBlock(net.minecraft.world.effect.MobEffects.SATURATION, 0.1f, SAPLING), SAPLING);

    // Honey Wood Derivatives
    public static final DeferredBlock<Block> HONEY_STAIRS = registerStairs("honey_stairs", HONEY_PLANKS);
    public static final DeferredBlock<Block> HONEY_SLAB = registerSlab("honey_slab", HONEY_PLANKS);
    public static final DeferredBlock<Block> HONEY_FENCE = registerFence("honey_fence", HONEY_PLANKS);
    public static final DeferredBlock<Block> HONEY_FENCE_GATE = registerFenceGate("honey_fence_gate", HONEY_PLANKS);
    public static final DeferredBlock<Block> HONEY_DOOR = registerDoor("honey_door", HONEY_PLANKS);
    public static final DeferredBlock<Block> HONEY_TRAPDOOR = registerTrapdoor("honey_trapdoor", HONEY_PLANKS);

    // ========== SCORCHED WOOD ==========
    public static final DeferredBlock<Block> SCORCHED_LOG = registerPillarBlock("scorched_log", WOOD);
    public static final DeferredBlock<Block> SCORCHED_WOOD = registerPillarBlock("scorched_wood", WOOD);
    public static final DeferredBlock<Block> SCORCHED_STRIPPED_LOG = registerPillarBlock("scorched_stripped_log", WOOD);
    public static final DeferredBlock<Block> SCORCHED_STRIPPED_WOOD = registerPillarBlock("scorched_stripped_wood", WOOD);
    public static final DeferredBlock<Block> SCORCHED_THIN_LOG = registerPillarBlock("scorched_thin_log", WOOD);
    public static final DeferredBlock<Block> SCORCHED_PLANKS = registerSimpleBlock("scorched_planks", PLANKS);
    public static final DeferredBlock<Block> SCORCHED_LEAVES = registerSimpleBlock("scorched_leaves", LEAVES);
    public static final DeferredBlock<Block> SCORCHED_SAPLING = registerBlock("scorched_sapling",
            () -> new FlowerBlock(net.minecraft.world.effect.MobEffects.SATURATION, 0.1f, SAPLING), SAPLING);

    // Scorched Wood Derivatives
    public static final DeferredBlock<Block> SCORCHED_STAIRS = registerStairs("scorched_stairs", SCORCHED_PLANKS);
    public static final DeferredBlock<Block> SCORCHED_SLAB = registerSlab("scorched_slab", SCORCHED_PLANKS);
    public static final DeferredBlock<Block> SCORCHED_FENCE = registerFence("scorched_fence", SCORCHED_PLANKS);
    public static final DeferredBlock<Block> SCORCHED_FENCE_GATE = registerFenceGate("scorched_fence_gate", SCORCHED_PLANKS);
    public static final DeferredBlock<Block> SCORCHED_DOOR = registerDoor("scorched_door", SCORCHED_PLANKS);
    public static final DeferredBlock<Block> SCORCHED_TRAPDOOR = registerTrapdoor("scorched_trapdoor", SCORCHED_PLANKS);

    // ========== SPORED WOOD ==========
    public static final DeferredBlock<Block> SPORED_LOG = registerPillarBlock("spored_log", WOOD);
    public static final DeferredBlock<Block> SPORED_WOOD = registerPillarBlock("spored_wood", WOOD);
    public static final DeferredBlock<Block> SPORED_STRIPPED_LOG = registerPillarBlock("spored_stripped_log", WOOD);
    public static final DeferredBlock<Block> SPORED_STRIPPED_WOOD = registerPillarBlock("spored_stripped_wood", WOOD);
    public static final DeferredBlock<Block> SPORED_THIN_LOG = registerPillarBlock("spored_thin_log", WOOD);
    public static final DeferredBlock<Block> SPORED_PLANKS = registerSimpleBlock("spored_planks", PLANKS);
    public static final DeferredBlock<Block> SPORED_LEAVES = registerSimpleBlock("spored_leaves", LEAVES);
    public static final DeferredBlock<Block> SPORED_LEAVES_SLAB = registerSlab("spored_leaves_slab", SPORED_PLANKS);
    public static final DeferredBlock<Block> SPORED_SAPLING = registerBlock("spored_sapling",
            () -> new FlowerBlock(net.minecraft.world.effect.MobEffects.SATURATION, 0.1f, SAPLING), SAPLING);

    // Spored Wood Derivatives
    public static final DeferredBlock<Block> SPORED_STAIRS = registerStairs("spored_stairs", SPORED_PLANKS);
    public static final DeferredBlock<Block> SPORED_SLAB = registerSlab("spored_slab", SPORED_PLANKS);
    public static final DeferredBlock<Block> SPORED_FENCE = registerFence("spored_fence", SPORED_PLANKS);
    public static final DeferredBlock<Block> SPORED_FENCE_GATE = registerFenceGate("spored_fence_gate", SPORED_PLANKS);
    public static final DeferredBlock<Block> SPORED_DOOR = registerDoor("spored_door", SPORED_PLANKS);
    public static final DeferredBlock<Block> SPORED_TRAPDOOR = registerTrapdoor("spored_trapdoor", SPORED_PLANKS);

    // ========== NOCTRAL STONE ==========
    public static final DeferredBlock<Block> NOCTRAL_STONE = registerSimpleBlock("noctral_stone", STONE);
    public static final DeferredBlock<Block> NOCTRAL_STONE_SEDIMENT = registerSimpleBlock("noctral_stone_sediment", STONE);

    // Noctral Bricks
    public static final DeferredBlock<Block> NOCTRAL_BRICKS = registerSimpleBlock("noctral_bricks_stone", STONE);
    public static final DeferredBlock<Block> NOCTRAL_BRICKS_STAIRS = registerStairs("noctral_bricks_stairs", NOCTRAL_BRICKS);
    public static final DeferredBlock<Block> NOCTRAL_BRICKS_SLAB = registerSlab("noctral_bricks_slab", NOCTRAL_BRICKS);
    public static final DeferredBlock<Block> NOCTRAL_BRICKS_WALL = registerWall("noctral_bricks_wall");

    // Noctral Slates
    public static final DeferredBlock<Block> NOCTRAL_SLATES = registerSimpleBlock("noctral_slates_stone", STONE);
    public static final DeferredBlock<Block> NOCTRAL_SLATES_STAIRS = registerStairs("noctral_slates_stairs", NOCTRAL_SLATES);
    public static final DeferredBlock<Block> NOCTRAL_SLATES_SLAB = registerSlab("noctral_slates_slab", NOCTRAL_SLATES);
    public static final DeferredBlock<Block> NOCTRAL_SLATES_WALL = registerWall("noctral_slates_wall");

    // Noctral Pillar
    public static final DeferredBlock<Block> NOCTRAL_PILLAR = registerPillarBlock("noctral_pillar", STONE);

    // Noctral Derivatives
    public static final DeferredBlock<Block> NOCTRAL_STAIRS = registerStairs("noctral_stairs", NOCTRAL_STONE);
    public static final DeferredBlock<Block> NOCTRAL_SLAB = registerSlab("noctral_slab", NOCTRAL_STONE);
    public static final DeferredBlock<Block> NOCTRAL_WALL = registerWall("noctral_wall");

    // ========== VIRIDIAN STONE ==========
    public static final DeferredBlock<Block> VIRIDIAN_PILLAR = registerPillarBlock("viridian_pillar", STONE);
    public static final DeferredBlock<Block> CHISELED_VIRIDIAN = registerSimpleBlock("chiseled_viridian", STONE);
    public static final DeferredBlock<Block> VIRIDIAN_BRICKS = registerSimpleBlock("viridian_bricks", STONE);

    public static final DeferredBlock<Block> VIRIDIAN_STAIRS = registerStairs("viridian_stairs", VIRIDIAN_BRICKS);
    public static final DeferredBlock<Block> VIRIDIAN_SLAB = registerSlab("viridian_slab", VIRIDIAN_BRICKS);
    public static final DeferredBlock<Block> VIRIDIAN_WALL = registerWall("viridian_wall");

    // ========== DARK PURPUR ==========
    public static final DeferredBlock<Block> PURPUR_WALL = registerWall("purpur_wall");

    public static final DeferredBlock<Block> DARK_PURPUR_STAIRS = registerStairs("dark_purpur_stairs", DARK_PURPUR_BLOCK);
    public static final DeferredBlock<Block> DARK_PURPUR_SLAB = registerSlab("dark_purpur_slab", DARK_PURPUR_BLOCK);
    public static final DeferredBlock<Block> DARK_PURPUR_WALL = registerWall("dark_purpur_wall");

    public static final DeferredBlock<Block> DARK_PURPUR_TILES_STAIRS = registerStairs("dark_purpur_tiles_stairs", DARK_PURPUR_TILES);
    public static final DeferredBlock<Block> DARK_PURPUR_TILES_SLAB = registerSlab("dark_purpur_tiles_slab", DARK_PURPUR_TILES);
    public static final DeferredBlock<Block> DARK_PURPUR_TILES_WALL = registerWall("dark_purpur_tiles_wall");

    // ========== MYCELION MIRE ==========
    public static final DeferredBlock<Block> MYCELION_MIRE = registerSimpleBlock("mycelion_mire", STONE);
    public static final DeferredBlock<Block> MYCELION_MIRE_WALL = registerWall("mycelion_mire_wall");
    public static final DeferredBlock<Block> MYCELION_MIRE_SLAB = registerSlab("mycelion_mire_slab", MYCELION_MIRE);
    public static final DeferredBlock<Block> MYCELION_MIRE_STAIRS = registerStairs("mycelion_mire_stairs", MYCELION_MIRE);

    public static final DeferredBlock<Block> MYCELION_MIRE_SLATS = registerSimpleBlock("mycelion_mire_slats", PLANKS);
    public static final DeferredBlock<Block> MYCELION_MIRE_SLATS_STAIRS = registerStairs("mycelion_mire_slats_stairs", MYCELION_MIRE_SLATS);
    public static final DeferredBlock<Block> MYCELION_MIRE_SLATS_SLAB = registerSlab("mycelion_mire_slats_slab", MYCELION_MIRE_SLATS);
    public static final DeferredBlock<Block> MYCELION_MIRE_SLATS_WALL = registerWall("mycelion_mire_slats_wall");
    public static final DeferredBlock<Block> MYCELION_MIRE_SEDIMENT = registerSimpleBlock("mycelion_mire_sediment", STONE);

    // ========== ENDRAL BLOCKS (Biome Stones) ==========
    public static final DeferredBlock<Block> ECLIPSED_ENDRAL = registerSimpleBlock("eclipsed_endral", END_STONE);
    public static final DeferredBlock<Block> ECLIPSED_ENDRAL_LAYER = BLOCKS.register("eclipsed_endral_layer",
            () -> new EndLayerBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    .strength(0.1f)
                    .sound(SoundType.SNOW))
    );
    public static final DeferredBlock<Block> COARSE_ECLIPSED_ENDRAL = registerSimpleBlock("coarse_eclipsed_endral", END_STONE);

    public static final DeferredBlock<Block> FROSTED_ENDRAL = registerSimpleBlock("frosted_endral", END_STONE);
    public static final DeferredBlock<Block> FROSTED_ENDRAL_LAYER = BLOCKS.register("frosted_endral_layer",
            () -> new EndLayerBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SNOW)
                    .strength(0.1f)
                    .sound(SoundType.SNOW))
    );
    public static final DeferredBlock<Block> COARSE_FROSTED_ENDRAL = registerSimpleBlock("coarse_frosted_endral", END_STONE);

    public static final DeferredBlock<Block> GILDED_ENDRAL = registerSimpleBlock("gilded_endral", END_STONE);
    public static final DeferredBlock<Block> GILDED_ENDRAL_LAYER = BLOCKS.register("gilded_endral_layer",
            () -> new EndLayerBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.GOLD)
                    .strength(0.1f)
                    .sound(SoundType.SNOW))
    );
    public static final DeferredBlock<Block> COARSE_GILDED_ENDRAL = registerSimpleBlock("coarse_gilded_endral", END_STONE);

    public static final DeferredBlock<Block> MYCELION_ENDRAL = registerSimpleBlock("mycelion_endral", END_STONE);
    public static final DeferredBlock<Block> MYCELION_ENDRAL_LAYER = BLOCKS.register("mycelion_endral_layer",
            () -> new EndLayerBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN)
                    .strength(0.1f)
                    .sound(SoundType.SNOW))
    );
    public static final DeferredBlock<Block> COARSE_MYCELION_ENDRAL = registerSimpleBlock("coarse_mycelion_endral", END_STONE);

    public static final DeferredBlock<Block> VERDANT_ENDRAL = registerSimpleBlock("verdant_endral", END_STONE);
    public static final DeferredBlock<Block> VERDANT_ENDRAL_LAYER = BLOCKS.register("verdant_endral_layer",
            () -> new EndLayerBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .strength(0.1f)
                    .sound(SoundType.SNOW))
    );
    public static final DeferredBlock<Block> COARSE_VERDANT_ENDRAL = registerSimpleBlock("coarse_verdant_endral", END_STONE);

    // ========== SOILS ==========
    public static final DeferredBlock<Block> DUSK_SOIL = registerSimpleBlock("dusk_soil", BlockBehaviour.Properties.of()
            .mapColor(MapColor.DIRT).strength(0.5f));
    public static final DeferredBlock<Block> DUSK_SOIL_SEDIMENT = registerSimpleBlock("dusk_soil_sediment", BlockBehaviour.Properties.of()
            .mapColor(MapColor.DIRT).strength(0.5f));

    // ========== GRASS TYPES ==========
    public static final DeferredBlock<Block> FLARE_GRASS = registerSimpleBlock("flare_grass", GRASS);
    public static final DeferredBlock<Block> GOLDEN_VOID_GRASS = registerSimpleBlock("golden_void_grass", GRASS);
    public static final DeferredBlock<Block> VIOLITE_VOID_GRASS = registerSimpleBlock("violite_void_grass", GRASS);
    public static final DeferredBlock<Block> GILDED_GRASS = registerSimpleBlock("gilded_grass", GRASS);
    public static final DeferredBlock<Block> SCORCHED_GRASS = registerSimpleBlock("scorched_grass", GRASS);
    public static final DeferredBlock<Block> STARGLOW_GRASS = registerSimpleBlock("starglow_grass", GRASS);
    public static final DeferredBlock<Block> FROSTSPIKE_GRASS = registerSimpleBlock("frostspike_grass", GRASS);
    public static final DeferredBlock<Block> GLOWTIDE_GRASS = registerSimpleBlock("glowtide_grass", GRASS);
    public static final DeferredBlock<Block> CURLWHISP_GRASS = registerSimpleBlock("curlwhisp_grass", GRASS);
    public static final DeferredBlock<Block> ORB_GRASS = registerSimpleBlock("orb_grass", GRASS);
    public static final DeferredBlock<Block> SPIRAL_GRASS = registerSimpleBlock("spiral_grass", GRASS);
    public static final DeferredBlock<Block> TWINBLADE_GRASS = registerSimpleBlock("twinblade_grass", GRASS);
    public static final DeferredBlock<Block> BEAD_GRASS = registerSimpleBlock("bead_grass", GRASS);
    public static final DeferredBlock<Block> BLADE_GRASS = registerSimpleBlock("blade_grass", GRASS);
    public static final DeferredBlock<Block> FLATHEAD_GRASS = registerSimpleBlock("flathead_grass", GRASS);

    // ========== FLOWERS & VEGETATION ==========
    public static final DeferredBlock<Block> FLARE_FERN = registerSimpleBlock("flare_fern", VEGETATION);
    public static final DeferredBlock<Block> FROSTBLOOM = registerSimpleBlock("frostbloom", VEGETATION);
    public static final DeferredBlock<Block> FRILLTOPS = registerSimpleBlock("frilltops", VEGETATION);
    public static final DeferredBlock<Block> LOTUS_BLOOM = registerSimpleBlock("lotus_bloom", VEGETATION);
    public static final DeferredBlock<Block> MOONFLOWER = registerSimpleBlock("moonflower", VEGETATION);
    public static final DeferredBlock<Block> MISTVEIL_BLOOM = registerSimpleBlock("mistveil_bloom", VEGETATION);
    public static final DeferredBlock<Block> SPRINGBULB = registerSimpleBlock("springbulb", VEGETATION);
    public static final DeferredBlock<Block> WICKED_WISTERIA = registerSimpleBlock("wicked_wisteria", VEGETATION);
    public static final DeferredBlock<Block> SHADOW_WISTERIA = registerSimpleBlock("shadow_wisteria", VEGETATION);
    public static final DeferredBlock<Block> VIOLET_WISTERIA = registerSimpleBlock("violite_wisteria", VEGETATION);
    public static final DeferredBlock<Block> VERDANT_STALK = registerSimpleBlock("verdant_stalk", VEGETATION);
    public static final DeferredBlock<Block> SUNSILK_LACE = registerSimpleBlock("sunsilk_lace", VEGETATION);
    public static final DeferredBlock<Block> AURACREST = registerSimpleBlock("auracrest", VEGETATION);
    public static final DeferredBlock<Block> ICELUMIA = registerSimpleBlock("icelumia", VEGETATION);
    public static final DeferredBlock<Block> LAYERLOOM = BLOCKS.register("layerloom",
            () -> new EndLayerBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SNOW)
                    .strength(0.1f)
                    .sound(SoundType.MOSS_CARPET))
    );
    public static final DeferredBlock<Block> VERDANT_SPIKE = registerSimpleBlock("verdant_spike", VEGETATION);

    // ========== MUSHROOMS ==========
    public static final DeferredBlock<Block> BLOOMLING = registerSimpleBlock("bloomling", VEGETATION);
    public static final DeferredBlock<Block> TANGLECAPS = registerSimpleBlock("tanglecaps", VEGETATION);
    public static final DeferredBlock<Block> MEADOWLINGS = registerSimpleBlock("meadowlings", VEGETATION);
    public static final DeferredBlock<Block> LYRIC_SPROUTS = registerSimpleBlock("lyric_sprouts", VEGETATION);
    public static final DeferredBlock<Block> SPORESPROUT = registerSimpleBlock("sporesprout", VEGETATION);

    // ========== LILY PADS ==========
    public static final DeferredBlock<Block> LILECAP = registerSimpleBlock("lilecap", VEGETATION);
    public static final DeferredBlock<Block> LIMECAP = registerSimpleBlock("limecap", VEGETATION);
    public static final DeferredBlock<Block> TEALCAP = registerSimpleBlock("tealcap", VEGETATION);
    public static final DeferredBlock<Block> GLEAMFLOAT = registerSimpleBlock("gleamfloat", VEGETATION);

    // ========== VINES ==========
    public static final DeferredBlock<Block> MOON_BERRY_VINES = registerSimpleBlock("moon_berry_vines", VEGETATION);
    public static final DeferredBlock<Block> SPORE_ALGAE = registerSimpleBlock("spore_algae", VEGETATION);

    // ========== SPECIAL BLOCKS ==========
    public static final DeferredBlock<Block> VOID_DRAGON_EGG = registerBlock("void_dragon_egg",
            () -> new DragonEggBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .strength(3.0f)
                    .lightLevel((state) -> 1)
                    .pushReaction(PushReaction.DESTROY)),
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(3.0f));

    public static final DeferredBlock<Block> VOID_DRAGON_HEAD = registerSimpleBlock("void_dragon_head",
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(1.0f));

    public static final DeferredBlock<Block> VOID_GATEWAY = registerSimpleBlock("void_gateway",
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .strength(-1.0f)
                    .lightLevel((state) -> 9)
                    .noLootTable());

    public static final DeferredBlock<Block> VOID_GATEWAY_STAND = registerSimpleBlock("void_gateway_stand",
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .strength(1.5f));

    public static final DeferredBlock<Block> CLOUD = registerSimpleBlock("cloud",
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SNOW)
                    .strength(0.2f)
                    .noCollission());

    public static final DeferredBlock<Block> FROZEN_JELLY = registerSimpleBlock("frozen_jelly",
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.ICE)
                    .strength(0.5f)
                    .friction(0.98f));

    public static final DeferredBlock<Block> PACKED_FROZEN_JELLY = registerSimpleBlock("packed_frozen_jelly",
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.ICE)
                    .strength(0.5f)
                    .friction(0.98f));

    public static final DeferredBlock<Block> ICE_SPIKE = registerSimpleBlock("ice_spike",
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.ICE)
                    .strength(0.5f));

    public static final DeferredBlock<Block> GILDED_ROCK = registerSimpleBlock("gilded_rock", STONE);
    public static final DeferredBlock<Block> ETERNAL_DEBRIS = registerSimpleBlock("eternal_debris", STONE);

    // ========== SPAWNERS ==========
    public static final DeferredBlock<Block> FROSTLING_SPAWNER = registerSimpleBlock("frostling_spawner",
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(5.0f));
    public static final DeferredBlock<Block> SHULKER_SPAWNER = registerSimpleBlock("shulker_spawner",
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(5.0f));
    public static final DeferredBlock<Block> VILLAGER_SPAWNER = registerSimpleBlock("villager_spawner",
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(5.0f));
    public static final DeferredBlock<Block> MOBSPAWNER_SPAWNER = registerSimpleBlock("mobspawner_spawner",
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(5.0f));
    public static final DeferredBlock<Block> DUNGEON_CHEST_SPAWNER = registerSimpleBlock("dungeon_chest_spawner",
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(5.0f));
    public static final DeferredBlock<Block> BREWINGSTAND_SPAWNER = registerSimpleBlock("brewingstand_spawner",
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(5.0f));
    public static final DeferredBlock<Block> BOOKSHELF_SPAWNER = registerSimpleBlock("bookshelf_spawner",
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(5.0f));
    public static final DeferredBlock<Block> POT_SPAWNER = registerSimpleBlock("pot_spawner",
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(5.0f));
    public static final DeferredBlock<Block> VILLAGE_CHEST_SPAWNER = registerSimpleBlock("village_chest_spawner",
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(5.0f));
    public static final DeferredBlock<Block> ENDERBOSS_ARENA_SPAWNER = registerSimpleBlock("endboss_arena_spawner",
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(5.0f));

    // ========== BIOME MARKERS (No Item) ==========
    public static final DeferredBlock<Block> GILDED_FIELDS_BIOME_MARKER = registerNoItem("gilded_fields_biome_marker");
    public static final DeferredBlock<Block> GILDED_RIDGE_BIOME_MARKER = registerNoItem("gilded_ridge_biome_marker");
    public static final DeferredBlock<Block> GILDED_WOODS_BIOME_MARKER = registerNoItem("gilded_woods_biome_marker");
    public static final DeferredBlock<Block> NORMAL_FOREST_BIOME_MARKER = registerNoItem("normal_forest_biome_marker");
    public static final DeferredBlock<Block> NORMAL_WASTELAND_BIOME_MARKER = registerNoItem("normal_wasteland_biome_marker");
    public static final DeferredBlock<Block> PRISM_DEFAULT_BIOME_MARKER = registerNoItem("prism_default_biome_marker");
    public static final DeferredBlock<Block> PRISM_FOREST_BIOME_MARKER = registerNoItem("prism_forest_biome_marker");
    public static final DeferredBlock<Block> PRISM_PEAKS_BIOME_MARKER = registerNoItem("prism_peaks_biome_marker");
    public static final DeferredBlock<Block> PRISM_PILLARS_BIOME_MARKER = registerNoItem("prism_pillars_biome_marker");
    public static final DeferredBlock<Block> PRISM_PONDS_BIOME_MARKER = registerNoItem("prism_ponds_biome_marker");
    public static final DeferredBlock<Block> SHADOW_FOLD_BIOME_MARKER = registerNoItem("shadow_fold_biome_marker");
    public static final DeferredBlock<Block> SPORELIGHT_FUNGAL_FOREST_BIOME_MARKER = registerNoItem("sporelight_fungal_forest_biome_marker");
    public static final DeferredBlock<Block> SPORELIGHT_MIXED_FOREST_BIOME_MARKER = registerNoItem("sporelight_mixed_forest_biome_marker");
    public static final DeferredBlock<Block> SPORELIGHT_SPORED_FOREST_BIOME_MARKER = registerNoItem("sporelight_spored_forest_biome_marker");
    public static final DeferredBlock<Block> SPORELIGHT_VOID_ISLANDS_BIOME_MARKER = registerNoItem("sporelight_void_islands_biome_marker");
    public static final DeferredBlock<Block> VERDANT_GLADE_BIOME_MARKER = registerNoItem("verdant_glade_biome_marker");
    public static final DeferredBlock<Block> VERDANT_GROVE_BIOME_MARKER = registerNoItem("verdant_grove_biome_marker");
    public static final DeferredBlock<Block> VERDANT_SPIKE_ISLANDS_BIOME_MARKER = registerNoItem("verdant_spike_islands_biome_marker");

    // ========== MISC ==========
    public static final DeferredBlock<Block> VIOLA_SPECKLE = registerSimpleBlock("viola_speckle", VEGETATION);
    public static final DeferredBlock<Block> GILDED_WHEAT = registerSimpleBlock("gilded_wheat", VEGETATION);

    // ========== HELPER METHODS ==========

    public static DeferredBlock<Block> registerSimpleBlock(String name, BlockBehaviour.Properties properties) {
        DeferredBlock<Block> block = BLOCKS.register(name, () -> new Block(properties));
        ITEMS.register(name, () -> new ModBlockItem(block, new Item.Properties()));
        return block;
    }

    public static DeferredBlock<Block> registerPillarBlock(String name, BlockBehaviour.Properties properties) {
        DeferredBlock<Block> block = BLOCKS.register(name, () -> new RotatedPillarBlock(properties));
        ITEMS.register(name, () -> new ModBlockItem(block, new Item.Properties()));
        return block;
    }

    public static DeferredBlock<Block> registerBlock(String name, Supplier<Block> blockSupplier, BlockBehaviour.Properties properties) {
        DeferredBlock<Block> block = BLOCKS.register(name, blockSupplier);
        ITEMS.registerSimpleBlockItem(name, block);
        return block;
    }

    public static DeferredBlock<Block> registerNoItem(String name) {
        return BLOCKS.register(name, () -> new Block(BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_BLACK)
                .noCollission()
                .noOcclusion()));
    }

    public static DeferredBlock<Block> registerStairs(String name, DeferredBlock<Block> baseBlock) {
        DeferredBlock<Block> stairs = BLOCKS.register(name, () -> new StairBlock(
                baseBlock.get().defaultBlockState(),
                BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0f).ignitedByLava()));
        ITEMS.registerSimpleBlockItem(name, stairs);
        return stairs;
    }

    public static DeferredBlock<Block> registerSlab(String name, DeferredBlock<Block> baseBlock) {
        DeferredBlock<Block> slab = BLOCKS.register(name, () -> new SlabBlock(
                BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0f).ignitedByLava()));
        ITEMS.registerSimpleBlockItem(name, slab);
        return slab;
    }

    public static DeferredBlock<Block> registerFence(String name, DeferredBlock<Block> baseBlock) {
        DeferredBlock<Block> fence = BLOCKS.register(name, () -> new FenceBlock(
                BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0f).ignitedByLava()));
        ITEMS.registerSimpleBlockItem(name, fence);
        return fence;
    }

    public static DeferredBlock<Block> registerFenceGate(String name, DeferredBlock<Block> baseBlock) {
        DeferredBlock<Block> fenceGate = BLOCKS.register(name, () -> new FenceGateBlock(
                net.minecraft.world.level.block.state.properties.WoodType.OAK,
                BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0f).ignitedByLava()));
        ITEMS.registerSimpleBlockItem(name, fenceGate);
        return fenceGate;
    }

    public static DeferredBlock<Block> registerDoor(String name, DeferredBlock<Block> baseBlock) {
        DeferredBlock<Block> door = BLOCKS.register(name, () -> new DoorBlock(
                net.minecraft.world.level.block.state.properties.BlockSetType.OAK,
                BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0f).ignitedByLava().noOcclusion()));
        ITEMS.registerSimpleBlockItem(name, door);
        return door;
    }

    public static DeferredBlock<Block> registerTrapdoor(String name, DeferredBlock<Block> baseBlock) {
        DeferredBlock<Block> trapdoor = BLOCKS.register(name, () -> new TrapDoorBlock(
                net.minecraft.world.level.block.state.properties.BlockSetType.OAK,
                BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0f).ignitedByLava().noOcclusion()));
        ITEMS.registerSimpleBlockItem(name, trapdoor);
        return trapdoor;
    }

    public static DeferredBlock<Block> registerWall(String name) {
        return BLOCKS.register(name, () -> new WallBlock(BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE).strength(2.0f)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
