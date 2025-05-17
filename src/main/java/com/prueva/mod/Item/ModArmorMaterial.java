package com.prueva.mod.Item;

import com.prueva.mod.PruevaMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterial {

    public static final RegistryEntry<ArmorMaterial> LIVE_ARMOR_MATERIAL = registerArmorMaterial("live_material", ()->
        new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map-> {
            map.put(ArmorItem.Type.BOOTS, 3);
            map.put(ArmorItem.Type.LEGGINGS, 7);
            map.put(ArmorItem.Type.CHESTPLATE, 10);
            map.put(ArmorItem.Type.HELMET, 3);
            map.put(ArmorItem.Type.BODY, 11);
        }), 15, SoundEvents.ITEM_ARMOR_EQUIP_WOLF, () -> Ingredient.ofItems(FirstItem.LIVE_INGOT),
                List.of(new ArmorMaterial.Layer(Identifier.of(PruevaMod.MOD_ID, "live_material"))), 3.0f, 0.1f
        ));

    public static final RegistryEntry<ArmorMaterial> CONSCIOUS_ARMOR_MATERIAL = registerArmorMaterial("conscious_armor", ()->
            new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map-> {
                map.put(ArmorItem.Type.BOOTS, 5);
                map.put(ArmorItem.Type.LEGGINGS, 8);
                map.put(ArmorItem.Type.CHESTPLATE, 12);
                map.put(ArmorItem.Type.HELMET, 5);
                map.put(ArmorItem.Type.BODY, 11);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, () -> Ingredient.ofItems(FirstItem.LIVE_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(PruevaMod.MOD_ID, "conscious_armor"))), 0f, 0f
            ));


    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material){
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(PruevaMod.MOD_ID, name), material.get());
    }

    public static void registerArmor(){}
}
