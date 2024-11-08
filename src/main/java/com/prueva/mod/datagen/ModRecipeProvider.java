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

import static com.prueva.mod.PotionsRegister.ModPotionRegister.CURSED_BLOOD_BOTTLE;

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, FirstItem.ORB_LIFE)
                .pattern("BBB")
                .pattern("BRB")
                .pattern("BBB")
                .input('B', FirstItem.CLOTTED_BLOOD)
                .criterion(hasItem(FirstItem.CLOTTED_BLOOD), conditionsFromItem(FirstItem.CLOTTED_BLOOD))
                .input('R', FirstItem.LIVE_ROSE)
                .criterion(hasItem(FirstItem.LIVE_ROSE), conditionsFromItem(FirstItem.LIVE_ROSE))
                .offerTo(recipeExporter);

        //CONSCIOUS-----

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, FirstItem.CONSCIOUS_HELMET)
                .pattern("CAC")
                .pattern("L L")
                .pattern("   ")
                .input('C', FirstItem.RIPPING_HORN)
                .criterion(hasItem(FirstItem.RIPPING_HORN), conditionsFromItem(FirstItem.RIPPING_HORN))
                .input('A', FirstItem.LIVE_HELMET)
                .criterion(hasItem(FirstItem.LIVE_HELMET), conditionsFromItem(FirstItem.LIVE_HELMET))
                .input('L', FirstItem.LIVE_ROSE)
                .criterion(hasItem(FirstItem.LIVE_INGOT), conditionsFromItem(FirstItem.LIVE_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, FirstItem.CONSCIOUS_CHESTPLATE)
                .pattern("L L")
                .pattern("GPG")
                .pattern("LCL")
                .input('L', FirstItem.LIVE_INGOT)
                .criterion(hasItem(FirstItem.LIVE_INGOT), conditionsFromItem(FirstItem.LIVE_INGOT))
                .input('G', FirstItem.CURSED_FANG)
                .criterion(hasItem(FirstItem.CURSED_FANG), conditionsFromItem(FirstItem.CURSED_FANG))
                .input('P', FirstItem.LIVE_CHESTPLATE)
                .criterion(hasItem(FirstItem.LIVE_CHESTPLATE), conditionsFromItem(FirstItem.LIVE_CHESTPLATE))
                .input('C', FirstItem.LIVING_HEART)
                .criterion(hasItem(FirstItem.LIVING_HEART), conditionsFromItem(FirstItem.LIVING_HEART))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, FirstItem.CONSCIOUS_LEGGINGS)
                .pattern("LPL")
                .pattern("H H")
                .pattern("L L")
                .input('L', FirstItem.LIVE_INGOT)
                .criterion(hasItem(FirstItem.LIVE_INGOT), conditionsFromItem(FirstItem.LIVE_INGOT))
                .input('H', FirstItem.STRONGE_BONE)
                .criterion(hasItem(FirstItem.STRONGE_BONE), conditionsFromItem(FirstItem.STRONGE_BONE))
                .input('P', FirstItem.LIVE_LEGGINGS)
                .criterion(hasItem(FirstItem.LIVE_LEGGINGS), conditionsFromItem(FirstItem.LIVE_LEGGINGS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, FirstItem.CONSCIOUS_BOOTS)
                .pattern("   ")
                .pattern("L L")
                .pattern("LBL")
                .input('B', FirstItem.LIVE_BOOTS)
                .criterion(hasItem(FirstItem.LIVE_BOOTS), conditionsFromItem(FirstItem.LIVE_BOOTS))
                .input('L', FirstItem.LIVE_INGOT)
                .criterion(hasItem(FirstItem.LIVE_INGOT), conditionsFromItem(FirstItem.LIVE_INGOT))
                .offerTo(recipeExporter);

        // -------------------

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, FirstItem.LIVING_HEART)
                .pattern(" C ")
                .pattern("CHC")
                .pattern(" O ")
                .input('C', FirstItem.CURSED_MEAT)
                .criterion(hasItem(FirstItem.CURSED_MEAT), conditionsFromItem(FirstItem.CURSED_MEAT))
                .input('H', FirstItem.DEMONIC_HEART)
                .criterion(hasItem(FirstItem.DEMONIC_HEART), conditionsFromItem(FirstItem.DEMONIC_HEART))
                .input('O', FirstItem.ORB_LIFE)
                .criterion(hasItem(FirstItem.ORB_LIFE), conditionsFromItem(FirstItem.ORB_LIFE))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, FirstItem.CURSED_MEAT, 1)
                .input(FirstItem.ROTTEN_REMAINS)
                .criterion(hasItem(FirstItem.ROTTEN_REMAINS), conditionsFromItem(FirstItem.ROTTEN_REMAINS))
                .input(FirstItem.CLOTTED_BLOOD)
                .criterion(hasItem(FirstItem.CLOTTED_BLOOD), conditionsFromItem(FirstItem.CLOTTED_BLOOD))
                .input(Items.PORKCHOP)
                .criterion(hasItem(Items.PORKCHOP), conditionsFromItem(Items.PORKCHOP))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, FirstItem.GALIUM_INGOT, 9)
                .input(BlocksMod.GALIUM_BLOCK)
                .criterion(hasItem(BlocksMod.GALIUM_BLOCK), conditionsFromItem(BlocksMod.GALIUM_BLOCK))
                .offerTo(recipeExporter);
    }


}
