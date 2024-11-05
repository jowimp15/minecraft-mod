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
        addDrop(BlocksMod.AZUFRE_STONE);
        addDrop(BlocksMod.AZUFRE_STONE2);
        addDrop(BlocksMod.AZUFRE_STONE3);
        addDrop(BlocksMod.AZUFRE_STONE4);
        addDrop(BlocksMod.AZUFRE_STONE5);

        addDrop(BlocksMod.GREEN, oreDrops(BlocksMod.GREEN,FirstItem.ORE_GALIUM));
        addDrop(BlocksMod.AZUFRE_STONE6, oreDrops(BlocksMod.AZUFRE_STONE6,FirstItem.LIVE_ROSE));
    }
}
