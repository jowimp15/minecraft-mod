package com.prueva.mod.fluid;

import net.minecraft.fluid.Fluid;

public class FluidModFlowing extends FluidModStill {

    @Override
    public Fluid getFlowing(){
        return this;
    }
}
