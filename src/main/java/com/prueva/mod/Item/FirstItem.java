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

    public static final Item RIPPING_HORN= registerItem("ripping_horn", new Item(new Item.Settings()));
    public static final Item CURSED_MEAT= registerItem("cursed_meat", new Item(new Item.Settings()));
    public static final Item DEMONIC_HEART = registerItem("demonic_heart", new Item(new Item.Settings()));
    public static final Item STRONGE_BONE = registerItem("stronge_bone", new Item(new Item.Settings()));
    public static final Item LIVING_HEART = registerItem("living_heart", new Item(new Item.Settings()));
    public static final Item ROTTEN_REMAINS = registerItem("rotten_remains", new Item(new Item.Settings()));

    // CHISEL ITEMS
    public static final Item HECHIZO = registerItem("hechizo", new ChiselItem(new Item.Settings().maxDamage(25)));

    // TOOL items
    public static final Item GALIUM_SWORD = registerItem("galium_sword", new SwordItem(modTools.GALIUM, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(modTools.GALIUM,5,-3.0F))));
    public static final Item LIVE_SWORD = registerItem("live_sword", new SwordItem(modTools.LIVE_MATERIAL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(modTools.LIVE_MATERIAL,3,-2.4F))));
    public static final Item LIVE_SHOVEL = registerItem("live_shovel", new ShovelItem(modTools.LIVE_MATERIAL, new Item.Settings().fireproof().attributeModifiers(ShovelItem.createAttributeModifiers(modTools.LIVE_MATERIAL, 1.6F, -3.0F))));
    public static final Item LIVE_PICKAXE = registerItem("live_pickaxe", new PickaxeItem(modTools.LIVE_MATERIAL, new Item.Settings().fireproof().attributeModifiers(PickaxeItem.createAttributeModifiers(modTools.LIVE_MATERIAL,  1.1F, -2.8F))));
    public static final Item LIVE_AXE = registerItem("live_axe", new AxeItem(modTools.LIVE_MATERIAL, new Item.Settings().fireproof().attributeModifiers(AxeItem.createAttributeModifiers(modTools.LIVE_MATERIAL,  5.3F, -3.0F))));
    public static final Item LIVE_HOE = registerItem("live_hoe", new HoeItem(modTools.LIVE_MATERIAL, new Item.Settings().fireproof().attributeModifiers(HoeItem.createAttributeModifiers(modTools.LIVE_MATERIAL,  -3.0F, 0.0F))));

    // ARMOR
        public static final Item LIVE_HELMET = registerItem(
            "live_helmet",
            new ArmorItem(ModArmorMaterial.LIVE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(40)))
    );
    public static final Item LIVE_CHESTPLATE = registerItem(
            "live_chestplate",
            new ArmorItem(ModArmorMaterial.LIVE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(40)))
    );
    public static final Item LIVE_LEGGINGS = registerItem(
            "live_leggings",
            new ArmorItem(ModArmorMaterial.LIVE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(40)))
    );
    public static final Item LIVE_BOOTS = registerItem(
            "live_boots",
            new ArmorItem(ModArmorMaterial.LIVE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(30)))
    );


    public static final Item CONSCIOUS_HELMET = registerItem(
            "conscious_helmet",
            new ArmorItem(ModArmorMaterial.CONSCIOUS_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(30)))
    );
    public static final Item CONSCIOUS_CHESTPLATE = registerItem(
            "conscious_chestplate",
            new ArmorItem(ModArmorMaterial.CONSCIOUS_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(30)))
    );
    public static final Item CONSCIOUS_LEGGINGS = registerItem(
            "conscious_leggings",
            new ArmorItem(ModArmorMaterial.CONSCIOUS_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(30)))
    );
    public static final Item CONSCIOUS_BOOTS = registerItem(
            "conscious_boots",
            new ArmorItem(ModArmorMaterial.CONSCIOUS_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(30)))
    );

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(PruevaMod.MOD_ID, name), item);
    };

    public static void registerModItems(){
    };
};
