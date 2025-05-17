package com.prueva.mod.world;

import com.prueva.mod.world.gen.ModBiomeGen;
import com.prueva.mod.world.gen.ModOreGeneration;
import com.prueva.mod.world.gen.ModTreeGeneration;

public class ModWorldGeneration {

    public static void generateModWorldGen(){
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
        ModBiomeGen.addBiome();
    }
}
