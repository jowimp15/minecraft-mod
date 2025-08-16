package com.prueva.mod.datagen;

import com.prueva.mod.Item.FirstItem;
import com.prueva.mod.block.BlocksMod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(BlocksMod.GALIUM_BLOCK);
        addDrop(BlocksMod.CRIMSON_VEINSTONE);
        addDrop(BlocksMod.CLOTTED_STONE);
        addDrop(BlocksMod.BLOODY_ROCKS);
        addDrop(BlocksMod.DRY_BLOODY_ROCKS);
        addDrop(BlocksMod.LIVE_BLOCK);
        addDrop(BlocksMod.THIRSTY_LEAVES);
        addDrop(BlocksMod.THIRSTY_LOG);
        addDrop(BlocksMod.BLOODY_ROCKS_BRICKS);
        addDrop(BlocksMod.CLOTTED_STONE_BRICKS);
        addDrop(BlocksMod.DRY_BLOODY_ROCKS_BRICKS);
        addDrop(BlocksMod.THIRSTY_PLANKS);
        addDrop(BlocksMod.THIRSTY_STAIRS);
        addDrop(BlocksMod.THIRSTY_SLAB, slabDrops(BlocksMod.THIRSTY_SLAB));
        addDrop(BlocksMod.THIRSTY_FENCE);
        addDrop(BlocksMod.THIRSTY_FENCE_GATE);
        addDrop(BlocksMod.THIRSTY_DOOR, doorDrops(BlocksMod.THIRSTY_DOOR));
        addDrop(BlocksMod.THIRSTY_TRAPDOOR);
        addDrop(BlocksMod.THIRSTY_PRESSURE_PLATE);
        addDrop(BlocksMod.THIRSTY_BUTTON);

        addDrop(BlocksMod.DRY_ROOTED_BLOODY_ROCKS, BlocksMod.DRY_BLOODY_ROCKS);
        addDrop(BlocksMod.THIRSTY_GRASS, BlocksMod.DRY_BLOODY_ROCKS);

        addDrop(BlocksMod.GALIUM_ORE, oreDrops(BlocksMod.GALIUM_ORE,FirstItem.RAW_GALIUM));
        addDrop(BlocksMod.FLOWERING_ROOTS, oreDrops(BlocksMod.FLOWERING_ROOTS,FirstItem.LIVE_ROSE));
        addDrop(BlocksMod.STACKED_ROTTEN_REMAINS, oreDrops(BlocksMod.STACKED_ROTTEN_REMAINS,FirstItem.ROTTEN_REMAINS));
    }
}
