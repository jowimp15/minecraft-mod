package com.prueva.mod.datagen;

import com.prueva.mod.Item.FirstItem;
import com.prueva.mod.block.BlocksMod;
import com.prueva.mod.block.custom.LampBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.GREEN);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.GALIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.AZUFRE_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.AZUFRE_STONE2);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.AZUFRE_STONE3);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.AZUFRE_STONE4);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.AZUFRE_STONE5);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.AZUFRE_STONE6);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.AZUFRE_STONE7);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.AZUFRE_STONE8);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.LIVE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.THIRSTY_LEAVES);

        blockStateModelGenerator.registerTintableCrossBlockState(BlocksMod.THIRSTY_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
//      blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.BLOOD_LIQUID);


        Identifier lamspOff = TexturedModel.CUBE_ALL.upload(BlocksMod.LAMPBLOCK, blockStateModelGenerator.modelCollector);
        Identifier lampOn = blockStateModelGenerator.createSubModel(BlocksMod.LAMPBLOCK, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(BlocksMod.LAMPBLOCK)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(LampBlock.CLICKED, lampOn, lamspOff)));

        blockStateModelGenerator.registerLog(BlocksMod.THIRSTY_WOOD).log(BlocksMod.THIRSTY_WOOD);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(FirstItem.BROKEN_SWORD, Models.GENERATED);
        itemModelGenerator.register(FirstItem.GALIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(FirstItem.HECHIZO, Models.HANDHELD);
        itemModelGenerator.register(FirstItem.ORE_GALIUM, Models.GENERATED);
        itemModelGenerator.register(FirstItem.GALIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(FirstItem.LIVE_INGOT, Models.GENERATED);
        itemModelGenerator.register(FirstItem.ORB_LIFE, Models.GENERATED);
        itemModelGenerator.register(FirstItem.CLOTTED_BLOOD, Models.GENERATED);
        itemModelGenerator.register(FirstItem.CURSED_FANG, Models.GENERATED);
        itemModelGenerator.register(FirstItem.DEMONIC_CLAWS, Models.GENERATED);
        itemModelGenerator.register(FirstItem.LIVE_AXE, Models.HANDHELD);
        itemModelGenerator.register(FirstItem.LIVE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(FirstItem.LIVE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(FirstItem.LIVE_HOE, Models.HANDHELD);
        itemModelGenerator.register(FirstItem.LIVE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(FirstItem.CONSCIOUS_SWORD, Models.HANDHELD);
        itemModelGenerator.register(FirstItem.CONSCIOUS_AXE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(FirstItem.RIPPING_HORN, Models.GENERATED);
        itemModelGenerator.register(FirstItem.CURSED_MEAT, Models.GENERATED);
        itemModelGenerator.register(FirstItem.DEMONIC_HEART, Models.GENERATED);
        itemModelGenerator.register(FirstItem.STRONGE_BONE, Models.GENERATED);
        itemModelGenerator.register(FirstItem.LIVING_HEART, Models.GENERATED);
        itemModelGenerator.register(FirstItem.ROTTEN_REMAINS, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) FirstItem.LIVE_BOOTS);
        itemModelGenerator.registerArmor((ArmorItem) FirstItem.LIVE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) FirstItem.LIVE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) FirstItem.LIVE_HELMET);

        itemModelGenerator.registerArmor((ArmorItem) FirstItem.CONSCIOUS_BOOTS);
        itemModelGenerator.registerArmor((ArmorItem) FirstItem.CONSCIOUS_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) FirstItem.CONSCIOUS_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) FirstItem.CONSCIOUS_HELMET);

        itemModelGenerator.register(BlocksMod.THIRSTY_SAPLING.asItem(), Models.GENERATED);
    }
}
