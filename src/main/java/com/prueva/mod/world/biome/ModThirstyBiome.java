package com.prueva.mod.world.biome;

import com.prueva.mod.PruevaMod;
import com.prueva.mod.world.ModPlacedFeature;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
public class ModThirstyBiome {
    public static final RegistryKey<Biome> THIRSTY_BIOME_KEY = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(PruevaMod.MOD_ID, "thirsty_roots"));

    public static void bootstrapt(Registerable<Biome> context){
        BiomeEffects effects = new BiomeEffects.Builder().grassColor(0xbf0000).foliageColor(0xff8d00).skyColor(0xf60bc9).fogColor(0xf60bc9).waterColor(0x8c0000).waterFogColor(0x670000).build();

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();

        RegistryEntryLookup<PlacedFeature> placedFeaturesRegistry = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntry<PlacedFeature> thirstyTree = placedFeaturesRegistry.getOrThrow(ModPlacedFeature.THIRSTY_WOOD_PLACED_KEY);

        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, thirstyTree);

      SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        Biome biome = new Biome.Builder().precipitation(false).temperature(2.0f).temperatureModifier(Biome.TemperatureModifier.NONE)
                        .downfall(0.0f).effects(effects).spawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();

        context.register(THIRSTY_BIOME_KEY, biome);
    }
}
