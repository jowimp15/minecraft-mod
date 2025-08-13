package com.prueva.mod.world;

import com.prueva.mod.PruevaMod;
import com.prueva.mod.block.BlocksMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> GALIUM_ORE_KEY = registerKey("galium_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> THIRSTY_WOOD_KEY = registerKey("thirsty_wood");

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context){
        RuleTest stoneRepaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        List<OreFeatureConfig.Target> overworldGaliumOre = List.of(OreFeatureConfig.createTarget(stoneRepaceables, BlocksMod.GREEN.getDefaultState()));

        register(context, GALIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldGaliumOre, 12));

        register(context, THIRSTY_WOOD_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(BlocksMod.THIRSTY_WOOD),
                new StraightTrunkPlacer(4, 2, 0),

                BlockStateProvider.of(BlocksMod.THIRSTY_LEAVES),
                        new BlobFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(0), 1),

                new TwoLayersFeatureSize(1,0,2)).dirtProvider(BlockStateProvider.of(BlocksMod.DRY_BLOODY_ROCKS)).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){

        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(PruevaMod.MOD_ID, name));
    };

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?,?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?,?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
