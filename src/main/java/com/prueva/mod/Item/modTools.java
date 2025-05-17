package com.prueva.mod.Item;

import com.google.common.base.Suppliers;
import com.prueva.mod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum modTools implements ToolMaterial {
//    NETHERITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 4.0F, 15, () -> Ingredient.ofItems(Items.NETHERITE_INGOT));
    GALIUM(ModTags.Blocks.INCORRECT_FOR_GALIUM_TOOL, 7000, 10.0f, 20.5f,10, () ->Ingredient.ofItems(FirstItem.GALIUM_INGOT)),
    LIVE_MATERIAL(ModTags.Blocks.INCORRECT_FOR_LIVE_TOOL, 2277, 11.0f, 5.0f, 10, () ->Ingredient.ofItems(FirstItem.LIVE_INGOT)),
    CONSCIOUS_MATERIAL(ModTags.Blocks.INCORRECT_FOR_CONSCIOUS_TOOL, 2500, 13.0f, 7.0f, 6, () ->Ingredient.ofItems(FirstItem.LIVE_INGOT));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    private modTools(
            final TagKey<Block> inverseTag,
            final int itemDurability,
            final float miningSpeed,
            final float attackDamage,
            final int enchantability,
            final Supplier<Ingredient> repairIngredient
    ) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
