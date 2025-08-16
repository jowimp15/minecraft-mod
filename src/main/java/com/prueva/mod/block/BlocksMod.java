package com.prueva.mod.block;

import com.prueva.mod.PruevaMod;
import com.prueva.mod.block.custom.LampBlock;
import com.prueva.mod.block.custom.ModSaplingBlock;
import com.prueva.mod.block.custom.PortalBlock;
import com.prueva.mod.world.tree.ModSapplingGenerator;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class BlocksMod {

    public static final Block GALIUM_ORE = registerBlock("galium_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2,5),AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block GALIUM_BLOCK = registerBlock("galium_block", new Block(AbstractBlock.Settings.create().strength(5f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block LAMPBLOCK = registerBlock("lamp", new LampBlock(AbstractBlock.Settings.create().strength(0.5f).requiresTool().luminance(state -> state.get(LampBlock.CLICKED) ? 15 : 0)));
    public static final Block LIVE_BLOCK = registerBlock("live_block", new Block(AbstractBlock.Settings.create().strength(5f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block CRIMSON_VEINSTONE = registerBlock("crimson_veinstone", new Block(AbstractBlock.Settings.create().strength(2.5f).requiresTool()));
    public static final Block CLOTTED_STONE = registerBlock("clotted_stone", new Block(AbstractBlock.Settings.create().strength(2.5f).requiresTool()));
    public static final Block BLOODY_ROCKS = registerBlock("bloody_rocks", new Block(AbstractBlock.Settings.create().strength(2.5f).requiresTool()));
    public static final Block DRY_BLOODY_ROCKS = registerBlock("dry_bloody_rocks", new Block(AbstractBlock.Settings.create().strength(2.5f).requiresTool()));
    public static final Block DRY_ROOTED_BLOODY_ROCKS = registerBlock("dry_rooted_bloody_rocks", new Block(AbstractBlock.Settings.create().strength(2.5f).requiresTool()));
    public static final Block FLOWERING_ROOTS = registerBlock("flowering_roots", new ExperienceDroppingBlock(UniformIntProvider.create(3,5), AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block STACKED_ROTTEN_REMAINS = registerBlock("stacked_rotten_remains", new Block(AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block THIRSTY_GRASS = registerBlock("thirsty_grass", new Block(AbstractBlock.Settings.create().strength(2.5f).requiresTool()));
    public static final Block THIRSTY_LEAVES = registerBlock("thirsty_leaves", new Block(AbstractBlock.Settings.create().strength(1f).sounds(BlockSoundGroup.WART_BLOCK)));
    public static final Block BLOODY_ROCKS_BRICKS = registerBlock("bloody_rocks_bricks", new Block(AbstractBlock.Settings.create().strength(2.5f)));
    public static final Block DRY_BLOODY_ROCKS_BRICKS = registerBlock("dry_bloody_rocks_bricks", new Block(AbstractBlock.Settings.create().strength(2.5f)));
    public static final Block CLOTTED_STONE_BRICKS = registerBlock("clotted_stone_bricks", new Block(AbstractBlock.Settings.create().strength(2.5f)));
    public static final Block THIRSTY_PLANKS = registerBlock("thirsty_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block BLOOD_LIQUID = registerBlock("blood_liquid", new PortalBlock(AbstractBlock.Settings.create().strength(100.0F)));

    public static final Block THIRSTY_SAPLING = registerBlock("thirsty_sapling", new ModSaplingBlock(ModSapplingGenerator.THIRSTY_WOOD, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING), BlocksMod.THIRSTY_GRASS));
//    public static final Block BLOOD_LIQUID = registerBlock("blood_liquid",
//            new FluidBlock((FlowableFluid) FluidRegister.STILL_FLUID,
//                    AbstractBlock.Settings.copy(Blocks.WATER).noCollision().strength(100.0F)));


    // NON-BLOCKS
    public static final Block THIRSTY_STAIRS = registerBlock("thirsty_stairs", new StairsBlock(THIRSTY_PLANKS.getDefaultState(), AbstractBlock.Settings.create().strength(2.0f).requiresTool()));
    public static final Block THIRSTY_SLAB = registerBlock("thirsty_slab", new SlabBlock(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));
    public static final Block THIRSTY_FENCE = registerBlock("thirsty_fence", new FenceBlock(AbstractBlock.Settings.create().strength(2.0f).requiresTool()));
    public static final Block THIRSTY_FENCE_GATE = registerBlock("thirsty_fence_gate", new FenceBlock(AbstractBlock.Settings.create().strength(2.0f)));
    public static final Block THIRSTY_DOOR = registerBlock("thirsty_door", new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(2.0f).nonOpaque()));
    public static final Block THIRSTY_TRAPDOOR = registerBlock("thirsty_trapdoor", new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(2.0f).nonOpaque()));
    public static final Block THIRSTY_PRESSURE_PLATE = registerBlock("thirsty_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(0.5f)));
    public static final Block THIRSTY_BUTTON = registerBlock("thirsty_button", new ButtonBlock(BlockSetType.OAK, 30, AbstractBlock.Settings.create().strength(0.5f)));

    // COLUMN BLOCK
    public static final Block THIRSTY_LOG = new ModBlockColumn(AbstractBlock.Settings.copy(Blocks.OAK_LOG));
//    public static final Block THIRSTY_WOOD = new ModBlockColumn(AbstractBlock.Settings.copy(Blocks.OAK_WOOD));
//    public static final Block STRIPPED_THIRSTY_LOG = new ModBlockColumn(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG));
//    public static final Block STRIPPED_THIRSTY_WOOD = new ModBlockColumn(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD));




    // CLASS
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(PruevaMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(PruevaMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings())
                );
    }

    public static void registerBlocks() {
        Registry.register(Registries.BLOCK, Identifier.of(PruevaMod.MOD_ID, "thirsty_wood"), THIRSTY_LOG);
        Registry.register(Registries.ITEM, Identifier.of(PruevaMod.MOD_ID, "thirsty_wood"), new BlockItem(THIRSTY_LOG, new Item.Settings()));
    }

}
