package com.prueva.mod;

import com.prueva.mod.Item.FirstItem;
import com.prueva.mod.Item.ModItemGroup;
import com.prueva.mod.block.BlocksMod;
import com.prueva.mod.component.dataComponentType;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PruevaMod implements ModInitializer {
	public static final String MOD_ID = "prueva-mod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		dataComponentType.registerDataComponent();
		FirstItem.registerModItems();
		ModItemGroup.registerItemGroups();
		BlocksMod.registerModBlock();
		LOGGER.info("Hello Fabric world!");

	}
}