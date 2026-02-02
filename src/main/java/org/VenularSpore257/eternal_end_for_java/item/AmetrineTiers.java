package org.VenularSpore257.eternal_end_for_java.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;
import java.util.Set;

/**
 * Tool and armor tiers for Eternal End mod.
 * Based on the Bedrock addon values.
 */
public enum AmetrineTiers implements Tier {
    // Ametrine Tier - Between Iron and Diamond
    AMETRINE(3, 502, 6.5f, 2.0f, 14, () -> Ingredient.of(Items.GOLD_INGOT)),

    // Cryolite Tier - Similar to Diamond
    CRYOLITE(3, 1561, 8.0f, 3.0f, 10, () -> Ingredient.of(Items.DIAMOND)),

    // Noctral Tier - Between Diamond and Netherite
    NOCTRAL(4, 2031, 9.0f, 4.0f, 15, () -> Ingredient.of(Items.DIAMOND)),

    // Enderite Tier - Above Netherite
    ENDERITE(5, 2500, 10.0f, 5.0f, 18, () -> Ingredient.of(Items.NETHERITE_INGOT)),

    // Viridian Tier - Special tier
    VIRIDIAN(2, 250, 6.0f, 1.5f, 12, () -> Ingredient.of(Items.IRON_INGOT)),

    // Purpurite Tier - End stone tier
    PURPURITE(2, 350, 6.0f, 1.0f, 8, () -> Ingredient.of(Items.IRON_INGOT));

    private final int level;
    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    AmetrineTiers(int level, int uses, float speed, float attackDamageBonus, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    public int getUses() {
        return uses;
    }

    public float getSpeed() {
        return speed;
    }

    public float getAttackDamageBonus() {
        return attackDamageBonus;
    }

    public int getLevel() {
        return level;
    }

    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
    }
}
