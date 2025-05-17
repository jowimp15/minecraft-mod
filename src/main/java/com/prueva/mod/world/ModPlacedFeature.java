package com.prueva.mod.world;

import com.prueva.mod.PruevaMod;
import com.prueva.mod.block.BlocksMod;
import com.prueva.mod.world.gen.ModOrePlacement;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BlockFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeature {
    public static final RegistryKey<PlacedFeature> GALIUM_ORE_PLACED_KEY = registerKey("galium_ore_placed");
    public static final RegistryKey<PlacedFeature> THIRSTY_WOOD_PLACED_KEY = registerKey("thirsty_wood_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context,GALIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GALIUM_ORE_KEY),
                ModOrePlacement.modifierWidthCount(14, HeightRangePlacementModifier.uniform(YOffset.fixed(-80),YOffset.fixed(80))));

        register(
                context,
                THIRSTY_WOOD_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.THIRSTY_WOOD_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(8,1f,3), BlocksMod.THIRSTY_SAPLING)
        );
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(PruevaMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
