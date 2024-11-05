package com.prueva.mod.datagen;

import com.prueva.mod.Item.FirstItem;
import com.prueva.mod.block.BlocksMod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;

import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> GALIUM_INGOT = List.of(FirstItem.ORE_GALIUM);

        offerSmelting(recipeExporter, GALIUM_INGOT, RecipeCategory.MISC, FirstItem.GALIUM_INGOT, 1, 200, "galium_ingot");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlocksMod.GALIUM_BLOCK)
                .pattern("GGG")
                .pattern("GGG")
                .pattern("GGG")
                .input('G',FirstItem.GALIUM_INGOT)
                .criterion(hasItem(FirstItem.GALIUM_INGOT), conditionsFromItem(FirstItem.GALIUM_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, FirstItem.HECHIZO)
                .pattern(" D ")
                .pattern(" B ")
                .pattern(" B ")
                .input('D', Items.DIAMOND_BLOCK)
                .criterion(hasItem(Items.DIAMOND_BLOCK), conditionsFromItem(Items.DIAMOND_BLOCK))
                .input('B', Items.BLAZE_ROD)
                .criterion(hasItem(Items.BLAZE_ROD), conditionsFromItem(Items.BLAZE_ROD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, FirstItem.GALIUM_SWORD)
                .pattern(" G ")
                .pattern(" G ")
                .pattern(" S ")
                .input('S', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .input('G', FirstItem.GALIUM_INGOT)
                .criterion(hasItem(FirstItem.GALIUM_INGOT), conditionsFromItem(FirstItem.GALIUM_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, FirstItem.LIVE_INGOT)
                .pattern("GGG")
                .pattern("GOI")
                .pattern("III")
                .input('I', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .input('G', Items.NETHERITE_SCRAP)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .input('O', FirstItem.ORB_LIFE)
                .criterion(hasItem(FirstItem.ORB_LIFE), conditionsFromItem(FirstItem.ORB_LIFE))
                .offerTo(recipeExporter);

//        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, FirstItem.ORB_LIFE)
//                .pattern("BBB")
//                .pattern("BRB")
//                .pattern("BBB")
//                .input('B', FirstItem.CURSED_BLOOD_BOTTLE)
//                .criterion(hasItem(FirstItem.CURSED_BLOOD_BOTTLE), conditionsFromItem(FirstItem.CURSED_BLOOD_BOTTLE))
//                .input('R', FirstItem.LIVE_ROSE)
//                .criterion(hasItem(FirstItem.LIVE_ROSE), conditionsFromItem(FirstItem.LIVE_ROSE))
//                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, FirstItem.GALIUM_INGOT, 9)
                .input(BlocksMod.GALIUM_BLOCK)
                .criterion(hasItem(BlocksMod.GALIUM_BLOCK), conditionsFromItem(BlocksMod.GALIUM_BLOCK))
                .offerTo(recipeExporter);
    }


}
