package com.prueva.mod.Item;

import com.prueva.mod.PruevaMod;
import com.prueva.mod.block.BlocksMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup GALIUMS = Registry.register(Registries.ITEM_GROUP, Identifier.of(PruevaMod.MOD_ID, "galium_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(FirstItem.BROKEN_SWORD))
                    .displayName(Text.translatable("itemgroup.prueva-mod.galium_items"))
                    .entries(((displayContext, entries) -> {

                        // blocks
                        entries.add(BlocksMod.GREEN);
                        entries.add(BlocksMod.GALIUM_BLOCK);
                        entries.add(BlocksMod.LAMPBLOCK);
                        entries.add(BlocksMod.CRIMSON_VEINSTONE);
                        entries.add(BlocksMod.CLOTTED_STONE);
                        entries.add(BlocksMod.BLOODY_ROCKS);
                        entries.add(BlocksMod.DRY_BLOODY_ROCKS);
                        entries.add(BlocksMod.DRY_ROOTED_BLOODY_ROCKS);
                        entries.add(BlocksMod.FLOWERING_ROOTS);
                        entries.add(BlocksMod.STACKED_ROTTEN_REMAINS);
                        entries.add(BlocksMod.THIRSTY_GRASS);
                        entries.add(BlocksMod.LIVE_BLOCK);
                        entries.add(BlocksMod.THIRSTY_LEAVES);
                        entries.add(BlocksMod.THIRSTY_WOOD);
                        entries.add(BlocksMod.BLOOD_LIQUID);
                        entries.add(BlocksMod.THIRSTY_SAPLING);

                        // items
                        entries.add(FirstItem.BROKEN_SWORD);
                        entries.add(FirstItem.ORE_GALIUM);
                        entries.add(FirstItem.HECHIZO);
                        entries.add(FirstItem.GALIUM_INGOT);
                        entries.add(FirstItem.GALIUM_SWORD);
                        entries.add(FirstItem.LIVE_ROSE);
                        entries.add(FirstItem.LIVE_INGOT);
                        entries.add(FirstItem.ORB_LIFE);
                        entries.add(FirstItem.CLOTTED_BLOOD);
                        entries.add(FirstItem.LIVE_HOE);
                        entries.add(FirstItem.LIVE_PICKAXE);
                        entries.add(FirstItem.LIVE_AXE);
                        entries.add(FirstItem.LIVE_SHOVEL);
                        entries.add(FirstItem.LIVE_SWORD);
                        entries.add(FirstItem.CURSED_FANG);
                        entries.add(FirstItem.DEMONIC_CLAWS);
                        entries.add(FirstItem.LIVE_BOOTS);
                        entries.add(FirstItem.LIVE_HELMET);
                        entries.add(FirstItem.LIVE_LEGGINGS);
                        entries.add(FirstItem.LIVE_CHESTPLATE);
                        entries.add(FirstItem.CONSCIOUS_BOOTS);
                        entries.add(FirstItem.CONSCIOUS_CHESTPLATE);
                        entries.add(FirstItem.CONSCIOUS_HELMET);
                        entries.add(FirstItem.CONSCIOUS_LEGGINGS);
                        entries.add(FirstItem.CONSCIOUS_SWORD);
                        entries.add(FirstItem.CONSCIOUS_AXE_PICKAXE);
                        entries.add(FirstItem.RIPPING_HORN);
                        entries.add(FirstItem.CURSED_MEAT);
                        entries.add(FirstItem.DEMONIC_HEART);
                        entries.add(FirstItem.STRONGE_BONE);
                        entries.add(FirstItem.LIVING_HEART);
                        entries.add(FirstItem.ROTTEN_REMAINS);
                    }))

                    .build());

    public static void registerItemGroups(){

    }

}
