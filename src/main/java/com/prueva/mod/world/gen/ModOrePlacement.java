package com.prueva.mod.world.gen;

import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModOrePlacement {

    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heighModifier){
        return List.of(countModifier, SquarePlacementModifier.of(), heighModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifierWidthCount(int count, PlacementModifier heightModifier){
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    public static List<PlacementModifier> modifierWidthRarity(int chance, PlacementModifier heightModifier){
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}
