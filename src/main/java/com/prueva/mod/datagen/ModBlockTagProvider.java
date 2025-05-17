package com.prueva.mod.datagen;

import com.prueva.mod.block.BlocksMod;
import com.prueva.mod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(BlocksMod.GALIUM_BLOCK)
                .add(BlocksMod.GREEN)
                .add(BlocksMod.AZUFRE_STONE)
                .add(BlocksMod.AZUFRE_STONE2)
                .add(BlocksMod.AZUFRE_STONE3)
                .add(BlocksMod.AZUFRE_STONE4)
                .add(BlocksMod.AZUFRE_STONE5)
                .add(BlocksMod.AZUFRE_STONE6)
                .add(BlocksMod.AZUFRE_STONE7)
                .add(BlocksMod.AZUFRE_STONE8)
                .add(BlocksMod.LIVE_BLOCK);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(BlocksMod.THIRSTY_WOOD);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(BlocksMod.GALIUM_BLOCK)
                .add(BlocksMod.GREEN)
                .add(BlocksMod.AZUFRE_STONE6);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(BlocksMod.AZUFRE_STONE)
                .add(BlocksMod.AZUFRE_STONE2)
                .add(BlocksMod.AZUFRE_STONE)
                .add(BlocksMod.AZUFRE_STONE2)
                .add(BlocksMod.AZUFRE_STONE3)
                .add(BlocksMod.AZUFRE_STONE4)
                .add(BlocksMod.AZUFRE_STONE5)
                .add(BlocksMod.AZUFRE_STONE7)
                .add(BlocksMod.LIVE_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.TAGS_FUNCTION)
                .add(BlocksMod.GALIUM_BLOCK)
                .add(Blocks.DIAMOND_BLOCK)
                .add(Blocks.CHEST)
                .add(Blocks.FURNACE);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_LIVE_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_CONSCIOUS_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_LIVE_TOOL).addTag(BlockTags.NEEDS_DIAMOND_TOOL);
        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_GALIUM_TOOL).addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }


}
