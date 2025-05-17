package com.prueva.mod.world.gen;

import com.prueva.mod.world.ModPlacedFeature;
import com.prueva.mod.world.biome.ModThirstyBiome;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModThirstyBiome.THIRSTY_BIOME_KEY),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeature.THIRSTY_WOOD_PLACED_KEY);
    }
}
