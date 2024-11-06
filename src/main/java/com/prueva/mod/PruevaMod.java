package com.prueva.mod;

import com.prueva.mod.Item.FirstItem;
import com.prueva.mod.Item.ModItemGroup;
import com.prueva.mod.PotionsRegister.ModPotionRegister;
import com.prueva.mod.block.BlocksMod;
import com.prueva.mod.component.dataComponentType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
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

		ModPotionRegister.registerModPotions();
		dataComponentType.registerDataComponent();
		FirstItem.registerModItems();
		ModItemGroup.registerItemGroups();
		BlocksMod.registerModBlock();
		LOGGER.info("Hello Fabric world!");

	}
}