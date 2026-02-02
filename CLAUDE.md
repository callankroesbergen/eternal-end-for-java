# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Eternal End for Java is a NeoForge mod converting the "Eternal End Add-On by Panascais" from Minecraft Bedrock Edition to Java Edition 1.21.1.

**Source Scale:** 261 blocks, 185 items, 46 entities, 28 structures, 400+ recipes, ~618KB of server-side JavaScript

**Target:** NeoForge mod for Minecraft 1.21.1 (Java 21)

**Current Status:** ALPHA (1.0-ALPHA) - Registration framework complete, moving into implementation phase

## Quick Start

```bash
# Build the mod
./gradlew build

# Run development client (for testing)
./gradlew runClient

# Run development server
./gradlew runServer

# Generate data (recipes, loot tables, tags, etc.)
./gradlew runData

# Generate IDE run configurations
./gradlew genIntellijRuns
```

**Requirements:**
- Java 21
- Minecraft 1.21.1
- NeoForge 21.1.219
- Mod ID: `eternal_end_for_java`
- Package: `org.VenularSpore257.eternal_end_for_java`

## What's Already Done

✅ **Project Structure** - Package structure created under `org.VenularSpore257.eternal_end_for_java`

✅ **Block Registration** - All 261 blocks registered in `EternalEndBlocks.java`
- Ores, storage blocks, 7 wood types (chorus, cryolite, fungal, whispering, honey, scorched, spored)
- Stone variants (noctral, viridian, dark purpur, mycelion mire)
- Endral biome stones (eclipsed, frosted, gilded, mycelion, verdant)
- Grasses, flowers, mushrooms, lily pads, vegetation
- Special blocks (void dragon egg, gateway, cloud, etc.)
- Spawners (10 types)
- Biome markers (15 types, no item form)

✅ **Item Registration** - All 185 items registered in `EternalEndItems.java`
- Materials (ingots, gems, essences, hearts)
- Tools (swords, pickaxes, axes, shovels, hoes for 6 tiers)
- Armor (helmets, chestplates, leggings, boots)
- Food items
- Special items (void totem, bottled souls)
- Spawn eggs (all mobs and villagers)

✅ **Tool/Armor Tiers** - `AmetrineTiers.java` defines 6 tiers:
- VIRIDIAN (Iron level) → AMETRINE → PURPURITE → CRYOLITE (Diamond) → NOCTRAL → ENDERITE (above Netherite)

✅ **Entity Types** - All 46 entity types registered in `EternalEndEntities.java` (using null suppliers - need implementation)

✅ **Creative Tabs** - 7 organized tabs in `ModCreativeTabs.java`

✅ **Textures** - Extracted from RP to `src/main/resources/assets/eternal_end_for_java/textures/block/`

✅ **Language File** - Complete `en_us.json` with all names, descriptions, subtitles

✅ **Build System** - Gradle with NeoForge plugin configured

## What Needs To Be Done (In Order)

### Phase 1: Blockstates & Models (CURRENT TASK)
**Location:** `src/main/resources/assets/eternal_end_for_java/`

All 261 blocks need:
1. `blockstates/{block_name}.json` - Defines which models to use for block states
2. `models/block/{block_name}.json` - 3D model definition with texture references
3. `models/item/{block_name}.json` - Item appearance (usually references block model)

**Texture paths** use namespace format: `eternal_end_for_java:block/{texture_path}`

**Block categories requiring different JSON structures:**
- Simple cubes (ores, storage blocks, stones) - use `minecraft:block/cube_all`
- Stairs - need inner_left, inner_right, outer_left, outer_right, straight models
- Slabs - need top, bottom, double slab variants
- Fences - post and side variants
- Fence gates - open/closed, wall/post variants
- Doors - left/right, open/closed, top/bottom hinges
- Trapdoors - open/closed, top/bottom, half variants
- Walls - post, side, tall variants
- Logs - axis variants (x, y, z)
- Pillars - axis variants

**Wood types and texture mappings:**
```
wood/{type}/log.png → {type}_log
wood/{type}/log_top.png → {type}_log top texture
wood/{type}/planks.png → {type}_planks
wood/{type}/leaves.png → {type}_leaves
wood/{type}/sapling.png → {type}_sapling
wood/{type}/door.png → {type}_door bottom
wood/{type}/door_l.png → {type}_door left
wood/{type}/door_u.png → {type}_door top
wood/{type}/trapdoor.png → {type}_trapdoor
```

### Phase 2: Entity Classes
Create actual entity behavior classes in `src/main/java/org/VenularSpore257/eternal_end_for_java/entity/`

**Void Dragon** (`VoidDragon.java`) - Most complex, needs:
- 5+ phases with state machine (statue, circle, shoot, catch, death)
- Custom AI goals for each phase
- Flight mechanics
- Player mounting logic
- Boss health bar (600 HP in final phase)

**Other entities** need:
- Hostile mobs: extend `Monster` or appropriate vanilla class
- Passive/neutral: extend `Animal` or `PathfinderMob`
- Villagers: extend `Villager` or create custom merchant
- Projectiles: extend `ThrowableProjectile` or `AbstractArrow`

### Phase 3: Item Models
Create `models/item/{item_name}.json` for all 185 items that aren't blocks.

### Phase 4: Data Generation
Create `src/main/java/org/VenularSpore257/eternal_end_for_java/data/`:
- `ModRecipeProvider.java` - 400+ recipes (shaped, shapeless, smelting, smithing)
- `ModLootTableProvider.java` - Block and entity loot tables
- `ModBlockTagProvider.java` - Block tags (mining levels, etc.)
- `ModItemTagProvider.java` - Item tags

### Phase 5: World Generation
Create `src/main/java/org/VenularSpore257/eternal_end_for_java/world/`:
- `ModBiomes.java` - Register End biomes (sporelight void islands, prism peaks, etc.)
- `ModFeatures.java` - Tree features, ore placements
- `ModStructures.java` - Convert 28 `.mcstructure` files to `.nbt` format

### Phase 6: JavaScript to Java Events
Convert ~618KB of server-side JavaScript to event handlers in `src/main/java/org/VenularSpore257/eternal_end_for_java/event/`:
- `ServerEvents.java` - Entity spawn conditions, player interactions, damage handling
- Entity spawn logic (biome-specific spawning rules)
- Custom interactions (right-click behaviors)

### Phase 7: Client-side
- Entity renderers (models, animations)
- Block color handlers (for foliage, etc.)
- Particle definitions
- Sound definitions and registrations

## Architecture Patterns

### DeferredRegister Pattern
All registrations use NeoForge's deferred register system:

```java
public static final DeferredRegister.Blocks BLOCKS =
    DeferredRegister.createBlocks(MODID);

public static final DeferredBlock<Block> MY_BLOCK = BLOCKS.register("my_block",
    () -> new Block(BlockBehaviour.Properties.of()));

public static void register(IEventBus bus) {
    BLOCKS.register(bus);
}
```

### Block Registration Helpers
`EternalEndBlocks.java` provides helper methods:

```java
registerSimpleBlock("name", PROPERTIES)      // Cube blocks
registerStairs("name", baseBlock)            // Stairs
registerSlab("name", baseBlock)              // Slabs
registerFence("name", baseBlock)             // Fences
registerFenceGate("name", baseBlock)         // Fence gates
registerDoor("name", baseBlock)              // Doors
registerTrapdoor("name", baseBlock)          // Trapdoors
registerNoItem("name", PROPERTIES)           // No item form
```

### Seven Wood Types
Each has identical pattern:
- `chorus`, `cryolite`, `fungal`, `whispering`, `honey`, `scorched`, `spored`
- Variants: log, wood, stripped_log, stripped_wood, thin_log, planks, leaves, sapling
- Derivatives: stairs, slab, fence, fence_gate, door, trapdoor

### Creative Tabs Organization
- `building_blocks` - All blocks (icon: chorus_planks)
- `materials` - Ingots, gems, essences, hearts (icon: ametrine_ingot)
- `tools` - All tools (icon: ametrine_sword)
- `armor` - All armor (icon: ametrine_chestplate)
- `food` - Food and drinks (icon: eternal_heart)
- `special` - Void totem, dragon egg, bottled souls (icon: void_totem)
- `spawn_eggs` - All spawn eggs (icon: frostling_spawn_egg)

## Source Material

**Bedrock Addon:** `Eternal-End-1-1-Addon-MCPE-1.21.mcaddon` (unextracted)

**Textures:** Extracted to `src/main/resources/assets/eternal_end_for_java/textures/`

**Texture Structure:**
```
textures/block/
├── ore/           # ametrine, purpurite, viridian, etc.
├── stone/         # dark_purpur, noctral, viridian, mycelion_mire
├── wood/          # 7 wood types with subdirs
├── grass/         # Various grass types
├── biome/         # gilded, normal, prism, shadow, spore, verdant
└── [various .png files]  # Special blocks
```

**To extract the addon:**
1. Rename `.mcaddon` to `.zip`
2. Extract to temporary location
3. Behavior pack: Contains entity definitions, recipes, scripts (main.js ~618KB)
4. Resource pack: Contains textures, models, sounds, animations

## Common Mistakes to Avoid

1. **Forward references** - Can't reference blocks/items in their own constructors (use suppliers)
2. **Tier interface** - Must implement `getIncorrectBlocksForDrops()` (use `BlockTags.INCORRECT_FOR_NETHERITE_TOOL`)
3. **Door constructor** - NeoForge 1.21 requires: `new DoorBlock(baseBlock, BlockSetType...)`
4. **Entity suppliers** - Currently using `() -> null` - must implement before testing
5. **Texture paths** - Always use `eternal_end_for_java:block/...` not relative paths
6. **Blockstates format** - Different from Bedrock's geometry JSONs

## Reference Bedrock Files (when extracted)

- `manifest.json` - Mod metadata
- `entities/` - Entity definitions (convert to Java entity classes)
- `recipes/` - Recipe definitions (convert to data generators)
- `scripts/main.js` - 618KB of server-side logic (convert to event handlers)
- `structures/` - `.mcstructure` files (convert to `.nbt`)
