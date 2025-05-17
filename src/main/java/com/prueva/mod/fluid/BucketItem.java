package com.prueva.mod.fluid;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;

public class BucketItem extends Item {

    private final Fluid fluid;

    public BucketItem(Fluid fluid, Item.Settings settings) {
        super(settings);
        this.fluid = fluid;
    }
}
