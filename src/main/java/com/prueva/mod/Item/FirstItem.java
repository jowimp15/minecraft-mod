package com.prueva.mod.Item;

import com.prueva.mod.Item.custom.ChiselItem;
import com.prueva.mod.PruevaMod;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class FirstItem {

    // NOLMAL ITEMS
    public static final Item BROKEN_SWORD = registerItem("broken_sword", new Item(new Item.Settings()));
    public static final Item ORE_GALIUM = registerItem("ore_galium", new Item(new Item.Settings()));
    public static final Item GALIUM_INGOT = registerItem("galium_ingot", new Item(new Item.Settings()));
    public static final Item LIVE_ROSE = registerItem("live_rose", new Item(new Item.Settings()));
    public static final Item LIVE_INGOT = registerItem("live_ingot", new Item(new Item.Settings()));
    public static final Item ORB_LIFE = registerItem("orb_life", new Item(new Item.Settings()));
    public static final Item CLOTTED_BLOOD = registerItem("clotted_blood", new Item(new Item.Settings()));
    public static final Item CURSED_FANG = registerItem("cursed_fang", new Item(new Item.Settings()));
    public static final Item DEMONIC_CLAWS = registerItem("demonic_claws", new Item(new Item.Settings()));

    // CHISEL ITEMS
    public static final Item HECHIZO = registerItem("hechizo", new ChiselItem(new Item.Settings().maxDamage(25)));

    // TOOL items
    public static final Item GALIUM_SWORD = registerItem("galium_sword", new SwordItem(modTools.GALIUM, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(modTools.GALIUM,5,-3.0F))));
    public static final Item LIVE_SWORD = registerItem("live_sword", new SwordItem(modTools.LIVE_MATERIAL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(modTools.LIVE_MATERIAL,3,-2.4F))));
    public static final Item LIVE_SHOVEL = registerItem("live_shovel", new ShovelItem(modTools.LIVE_MATERIAL, new Item.Settings().fireproof().attributeModifiers(ShovelItem.createAttributeModifiers(modTools.LIVE_MATERIAL, 1.6F, -3.0F))));
    public static final Item LIVE_PICKAXE = registerItem("live_pickaxe", new PickaxeItem(modTools.LIVE_MATERIAL, new Item.Settings().fireproof().attributeModifiers(ShovelItem.createAttributeModifiers(modTools.LIVE_MATERIAL,  1.1F, -2.8F))));
    public static final Item LIVE_AXE = registerItem("live_axe", new AxeItem(modTools.LIVE_MATERIAL, new Item.Settings().fireproof().attributeModifiers(ShovelItem.createAttributeModifiers(modTools.LIVE_MATERIAL,  5.3F, -3.0F))));
    public static final Item LIVE_HOE = registerItem("live_hoe", new HoeItem(modTools.LIVE_MATERIAL, new Item.Settings().fireproof().attributeModifiers(ShovelItem.createAttributeModifiers(modTools.LIVE_MATERIAL,  -3.0F, 0.0F))));

    public static final Item NETHERITE_HELMET = registerItem(
            "netherite_helmet",
            new ArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37)))
    );
    public static final Item NETHERITE_CHESTPLATE = registerItem(
            "netherite_chestplate",
            new ArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37)))
    );
    public static final Item NETHERITE_LEGGINGS = registerItem(
            "netherite_leggings",
            new ArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37)))
    );
    public static final Item NETHERITE_BOOTS = registerItem(
            "netherite_boots",
            new ArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.BOOTS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37)))
    );



//
    // POTION
//    public static final Item CURSED_BLOOD_BOTTLE = new PotionItem(new Item.Settings().maxCount(8));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(PruevaMod.MOD_ID, name), item);
    };

    public static void registerModItems(){

    };
};
