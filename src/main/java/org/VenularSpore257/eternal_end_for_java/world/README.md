# World Generation - Eternal End for Java

This directory contains the world generation system for the Eternal End mod, including biomes, features, and structures.

## Directory Structure

```
world/
├── ModBiomes.java           # Biome definitions and properties
├── ModFeatures.java         # Feature configurations (trees, ores)
└── ModStructures.java       # Structure documentation and keys
```

## Biomes

The mod adds 18 new biomes to the End dimension, organized into 6 categories:

### Gilded Biomes (3)
- **gilded_fields** - Golden grassy plains
- **gilded_ridge** - Hilly golden terrain
- **gilded_woods** - Dense chorus forest

### Normal Biomes (2)
- **normal_forest** - Standard End forest
- **normal_wasteland** - Barren End landscape

### Prism Biomes (5)
- **prism_default** - Colorful prismarine terrain
- **prism_forest** - Prismarine forest
- **prism_peaks** - Mountainous formations
- **prism_pillars** - Tall pillar formations
- **prism_ponds** - Water-filled landscape

### Shadow Biome (1)
- **shadow_fold** - Dark mysterious forest

### Sporelight Biomes (4)
- **sporelight_fungal_forest** - Fungal mushroom forest
- **sporelight_mixed_forest** - Mixed fungal and spore trees
- **sporelight_spored_forest** - Spore-dominated forest
- **sporelight_void_islands** - Floating fungal islands

### Verdant Biomes (3)
- **verdant_glade** - Green End highlands
- **verdant_grove** - Dense green forest
- **verdant_spike_islands** - Spiky green islands

## Features

### Trees (7 Types)
Each of the 7 wood types has a configured tree feature:
- **Chorus Tree** - Gilded biomes
- **Cryolite Tree** - Prism biomes
- **Fungal Tree** - Sporelight fungal forests
- **Whispering Tree** - Shadow biome
- **Honey Tree** - Verdant biomes
- **Scorched Tree** - Wasteland areas
- **Spored Tree** - Sporelight spored forests

### Ores (4 Types)
- **Ametrine Ore** - Overworld (stone/deepslate)
- **Purpurite Ore** - End dimension
- **Viridian Ore** - End dimension
- **Dark Purpurite Ore** - End dimension

### Vegetation
- End grass patches (multiple variants)
- End flower patches (multiple variants)
- Special flowers (flare_fern, frostbloom, etc.)

## Structures

The mod includes 190 structure variants from the Bedrock addon:

### Village Structures
- Gilded villages (8 variants)
- Normal villages (6 variants)
- Prism villages (6 variants)
- Shadow villages (8 variants)
- Sporelight villages (4 variants)

### Dungeon Structures
- Hanging dungeons (4 variants)
- Hanging mineshafts (5 variants)
- Normal mines (6 variants)

### Ruin Structures
- Hanging ruins (4 variants)
- Normal ruins (4 variants)
- Shipwrecks (4 variants)
- Verdant ruins (4 variants)

### Tree Structures
- Big trees (7 types, 33 variants total)
- Small trees (various)

### Terrain Features
- Hills (35 variants across 3 types)
- Islands (18 variants across 2 types)
- Plato formations (4 variants)

### Special Structures
- Shadow Arena (1 + 6 parts)
- Sporelight Ship (1)
- Geodes (4 variants)

## Usage

### Adding Biomes to the End

To add Eternal End biomes to the End dimension, a biome modifier JSON is required:

**Location:** `src/main/resources/data/eternal_end_for_java/neoforge/biome_modifier/`

```json
{
  "type": "neoforge:add_features",
  "biomes": [
    "eternal_end_for_java:gilded_fields",
    ...
  ],
  "features": "minecraft:the_end",
  "step": "surface"
}
```

### Generating Biome Data

Run the data generator to create biome JSON files:

```bash
./gradlew runData
```

Generated files will be in:
- `src/main/generated/data/eternal_end_for_java/worldgen/biome/`
- `src/main/generated/data/eternal_end_for_java/worldgen/configured_feature/`
- `src/main/generated/data/eternal_end_for_java/worldgen/placed_feature/`

### Structure Conversion

.mcstructure files must be converted to .nbt format:

1. **In-game method (recommended):**
   - Load Bedrock world
   - Use structure block to export
   - Place in `src/main/resources/data/eternal_end_for_java/structures/`

2. **External tools:**
   - Amulet Editor
   - MCCToolChest
   - Custom conversion scripts

## Configuration

### Tree Spawning

Trees spawn automatically in forest biomes based on biome classification:
- `ModBiomes.FOREST_BIOMES` - List of forest biomes
- Tree types mapped via `ModBiomes.TreeFeatures`

### Ore Generation

Ores configured in `ModFeatures` with specific spawn rules:
- Y-level ranges
- Vein sizes
- Spawn attempts per chunk
- Target blocks (stone, deepslate, end_stone)

### Structure Spawning

Structure spawning configured via structure set JSONs:
- Spacing (distance between structures)
- Separation (minimum distance to prevent overlap)
- Biome restrictions
- Salt values for randomization

## Biome Properties

### Fog Colors

Each biome has a unique fog color:
- Gilded: Golden tones (0xC9A862, 0xD4B87A)
- Normal: Gray tones (0x808080, 0x606060)
- Prism: Blue-purple tones (0x7A8BC9 - 0x6A7BB9)
- Shadow: Dark blue (0x1A1A2E)
- Sporelight: Purple tones (0x4A3A5A, 0x5A4A6A)
- Verdant: Green tones (0x5A8B5A, 0x6B9B6B)

### Surface Blocks

- Gilded: `gilded_endral`
- Normal: `end_stone`
- Prism: `eclipsed_endral`
- Shadow: `mycelion_endral`
- Sporelight: `mycelion_endral`
- Verdant: `verdant_endral`

### Mob Spawning

All biomes spawn Endermen by default. Additional spawns can be configured per biome in the spawn settings.

## Testing

### Checklist

- [ ] All biomes spawn in outer End islands
- [ ] Fog colors match biome theme
- [ ] Trees spawn in forest biomes
- [ ] Ores generate at correct Y levels
- [ ] Grass and flowers spawn on surface
- [ ] Structures spawn in correct biomes
- [ ] No crash on world load
- [ ] Performance is acceptable

### Commands

```bash
# Locate biomes
/locate biome eternal_end_for_java:gilded_fields

# Locate structures (when implemented)
/locate structure eternal_end_for_java:gilded_village

# Test world generation
./gradlew runClient
```

## Future Development

1. Convert all 190 .mcstructure files to .nbt
2. Create structure set JSONs for spawning
3. Configure biome weights for End dimension
4. Add custom tree growers for saplings
5. Implement surface builders
6. Add custom noise settings
7. Configure carvers (caves, canyons)

## References

- Bedrock Biome Markers: `/mcaddon_extracted/Eternal End Add-On By Panascais BP/blocks/*_biome_marker.json`
- Bedrock Structures: `/mcaddon_extracted/Eternal End Add-On by Panascais BP/structures/panascais_end/`
- NeoForge Documentation: https://neoforged.neoforge.io/
- Vanilla Biomes: `net.minecraft.data.worldgen.biome.VanillaBiomes`

## Status

**Phase:** 5 - World Generation
**Status:** ALPHA - Foundation complete
**Completion:** ~60% (biomes and features done, structures pending conversion)
