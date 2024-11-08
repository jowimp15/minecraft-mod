package com.prueva.mod.block;

import com.prueva.mod.PruevaMod;
import com.prueva.mod.block.custom.LampBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class BlocksMod {

    public static final Block GREEN = registerBlock("green", new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
            AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block GALIUM_BLOCK = registerBlock("galium_block", new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block LAMPBLOCK = registerBlock("lamp", new LampBlock(AbstractBlock.Settings.create().strength(0.5f).requiresTool().luminance(state -> state.get(LampBlock.CLICKED) ? 15 : 0)));
    public static final Block LIVE_BLOCK = registerBlock("live_block", new Block(AbstractBlock.Settings.create().strength(1f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block AZUFRE_STONE = registerBlock("azufre_stone", new Block(AbstractBlock.Settings.create().strength(1f).requiresTool()));
    public static final Block AZUFRE_STONE2 = registerBlock("azufre_stone2", new Block(AbstractBlock.Settings.create().strength(1f).requiresTool()));
    public static final Block AZUFRE_STONE3 = registerBlock("azufre_stone3", new Block(AbstractBlock.Settings.create().strength(1f).requiresTool()));
    public static final Block AZUFRE_STONE4 = registerBlock("azufre_stone4", new Block(AbstractBlock.Settings.create().strength(1f).requiresTool()));
    public static final Block AZUFRE_STONE5 = registerBlock("azufre_stone5", new Block(AbstractBlock.Settings.create().strength(2).requiresTool()));
    public static final Block AZUFRE_STONE6 = registerBlock("azufre_stone6", new ExperienceDroppingBlock(UniformIntProvider.create(3,5),
            AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block AZUFRE_STONE7 = registerBlock("azufre_stone7", new Block(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(PruevaMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){

        Registry.register(Registries.ITEM, Identifier.of(PruevaMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings())
                );
    }

    public static void registerModBlock(){

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
           entries.add(BlocksMod.GREEN);
        });
    }

}
