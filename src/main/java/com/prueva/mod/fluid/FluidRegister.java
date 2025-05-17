package com.prueva.mod.fluid;

import com.prueva.mod.PruevaMod;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class FluidRegister {
    public static final Fluid STILL_FLUID = new FluidModStill();
    public static final Fluid FLOWING_FLUID = new FluidModFlowing();

    public static void registerFluid(){
        registerFluids("still_blood", STILL_FLUID);
        registerFluids("flowing_blood", FLOWING_FLUID);
    }

    private static void registerFluids(String name, Fluid fluid){
        Registry.register(Registries.FLUID, Identifier.of(PruevaMod.MOD_ID, name),fluid);
    }
}
