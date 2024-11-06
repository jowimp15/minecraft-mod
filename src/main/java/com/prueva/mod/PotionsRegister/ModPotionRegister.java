package com.prueva.mod.PotionsRegister;

import com.prueva.mod.PruevaMod;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotionRegister {

    public static final Potion CURSED_BLOOD_BOTTLE = registerPotion();

    private static Potion registerPotion(){
        return Registry.register(Registries.POTION, Identifier.of(PruevaMod.MOD_ID, "cursed_blood_bottle"),
                new Potion(
                        new StatusEffectInstance(StatusEffects.WITHER, 150, 2),
                        new StatusEffectInstance(StatusEffects.HUNGER, 300, 2)
                ));
    }

    public static void registerModPotions() {
    }
}


