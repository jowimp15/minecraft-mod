package com.prueva.mod.datagen;

import com.prueva.mod.Item.FirstItem;
import com.prueva.mod.block.BlocksMod;
import com.prueva.mod.block.custom.LampBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.GALIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.GALIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.CRIMSON_VEINSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.CLOTTED_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.BLOODY_ROCKS);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.DRY_BLOODY_ROCKS);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.DRY_ROOTED_BLOODY_ROCKS);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.FLOWERING_ROOTS);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.STACKED_ROTTEN_REMAINS);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.THIRSTY_GRASS);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.LIVE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.THIRSTY_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.BLOODY_ROCKS_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.DRY_BLOODY_ROCKS_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.CLOTTED_STONE_BRICKS);

        // SET GENERATORS
        BlockStateModelGenerator.BlockTexturePool thirstyPool =  blockStateModelGenerator.registerCubeAllModelTexturePool(BlocksMod.THIRSTY_PLANKS);
        thirstyPool.stairs(BlocksMod.THIRSTY_STAIRS);
        thirstyPool.slab(BlocksMod.THIRSTY_SLAB);
        thirstyPool.fence(BlocksMod.THIRSTY_FENCE);
        thirstyPool.fenceGate(BlocksMod.THIRSTY_FENCE_GATE);
        thirstyPool.pressurePlate(BlocksMod.THIRSTY_PRESSURE_PLATE);
        thirstyPool.button(BlocksMod.THIRSTY_BUTTON);

        blockStateModelGenerator.registerDoor(BlocksMod.THIRSTY_DOOR);
        blockStateModelGenerator.registerTrapdoor(BlocksMod.THIRSTY_TRAPDOOR);


        // SAPLINGS
        blockStateModelGenerator.registerTintableCrossBlockState(BlocksMod.THIRSTY_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
//      blockStateModelGenerator.registerSimpleCubeAll(BlocksMod.BLOOD_LIQUID);


        // LIGHT
        Identifier lamspOff = TexturedModel.CUBE_ALL.upload(BlocksMod.LAMPBLOCK, blockStateModelGenerator.modelCollector);
        Identifier lampOn = blockStateModelGenerator.createSubModel(BlocksMod.LAMPBLOCK, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(BlocksMod.LAMPBLOCK)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(LampBlock.CLICKED, lampOn, lamspOff)));

        blockStateModelGenerator.registerLog(BlocksMod.THIRSTY_LOG).log(BlocksMod.THIRSTY_LOG);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(FirstItem.BROKEN_SWORD, Models.GENERATED);
        itemModelGenerator.register(FirstItem.GALIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(FirstItem.HECHIZO, Models.HANDHELD);
        itemModelGenerator.register(FirstItem.RAW_GALIUM, Models.GENERATED);
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
