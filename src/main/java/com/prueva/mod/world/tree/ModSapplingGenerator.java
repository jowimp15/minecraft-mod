package com.prueva.mod.world.tree;

import com.prueva.mod.PruevaMod;
import com.prueva.mod.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSapplingGenerator {
    public static final SaplingGenerator THIRSTY_WOOD = new SaplingGenerator(PruevaMod.MOD_ID + ":driftwood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.THIRSTY_WOOD_KEY), Optional.empty());
}
