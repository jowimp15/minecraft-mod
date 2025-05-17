package com.prueva.mod.world.gen;

import com.prueva.mod.PruevaMod;
import com.prueva.mod.world.ModPlacedFeature;
import com.prueva.mod.world.biome.ModThirstyBiome;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;

public class ModBiomeGen {
    public static void addBiome() {
        BiomeModifications.create(Identifier.of(PruevaMod.MOD_ID, "add_biomes"))
                .add(ModificationPhase.ADDITIONS, BiomeSelectors.includeByKey(ModThirstyBiome.THIRSTY_BIOME_KEY), context ->
                        context.getGenerationSettings().addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeature.THIRSTY_WOOD_PLACED_KEY));
    }
}
