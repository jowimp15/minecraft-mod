package com.prueva.mod;

import com.prueva.mod.Item.FirstItem;
import com.prueva.mod.Item.ModItemGroup;
import com.prueva.mod.Item.custom.ModArmorEffect;
import com.prueva.mod.PotionsRegister.ModPotionRegister;
import com.prueva.mod.block.BlocksMod;
import com.prueva.mod.component.dataComponentType;
import com.prueva.mod.fluid.FluidRegister;
import com.prueva.mod.world.ModWorldGeneration;
import com.prueva.mod.world.biome.ModThirstyBiome;
import com.prueva.mod.world.gen.ModBiomeGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.potion.Potions;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.prueva.mod.PotionsRegister.ModPotionRegister.CURSED_BLOOD_BOTTLE;

public class PruevaMod implements ModInitializer {
	public static final String MOD_ID = "prueva-mod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.WATER, FirstItem.CLOTTED_BLOOD, Registries.POTION.getEntry(CURSED_BLOOD_BOTTLE));
		});
//		Registry.register(Registries.ITEM, Identifier.of("prueva-mod", "conscious_axe-pickaxe"), FirstItem.CONSCIOUS_AXE_PICKAXE);

		ModWorldGeneration.generateModWorldGen();
		FluidRegister.registerFluid();
		BlocksMod.registerBlocks();
		ModArmorEffect.whenTakeDamageAndIsFullArmor();
		ModPotionRegister.registerModPotions();
		dataComponentType.registerDataComponent();
		FirstItem.registerModItems();
		ModItemGroup.registerItemGroups();
		LOGGER.info("Hello Fabric world!");
	}
}