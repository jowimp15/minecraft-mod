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
        addDrop(BlocksMod.THIRSTY_WOOD);

        addDrop(BlocksMod.DRY_ROOTED_BLOODY_ROCKS, BlocksMod.DRY_BLOODY_ROCKS);
        addDrop(BlocksMod.THIRSTY_GRASS, BlocksMod.DRY_BLOODY_ROCKS);

        addDrop(BlocksMod.GREEN, oreDrops(BlocksMod.GREEN,FirstItem.ORE_GALIUM));
        addDrop(BlocksMod.FLOWERING_ROOTS, oreDrops(BlocksMod.FLOWERING_ROOTS,FirstItem.LIVE_ROSE));
        addDrop(BlocksMod.STACKED_ROTTEN_REMAINS, oreDrops(BlocksMod.STACKED_ROTTEN_REMAINS,FirstItem.ROTTEN_REMAINS));
    }
}
