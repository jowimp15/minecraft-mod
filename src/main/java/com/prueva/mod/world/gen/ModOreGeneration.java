package com.prueva.mod.world.gen;

import com.prueva.mod.world.ModPlacedFeature;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres(){

        // ejemplo de biomas individuales
        //
//        BiomeModifications.addFeature(BiomeSelectors.excludeByKey(BiomeKeys.DESERT), GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeature.GALIUM_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeature.GALIUM_ORE_PLACED_KEY);
    }
}
