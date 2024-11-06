package com.prueva.mod.datagen;

import com.prueva.mod.Item.FirstItem;
import com.prueva.mod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.FireChargeItem;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TAGS_FUNCTION);

        getOrCreateTagBuilder(ItemTags.SWORDS).add(FirstItem.LIVE_SWORD);
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(FirstItem.LIVE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES).add(FirstItem.LIVE_AXE);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(FirstItem.LIVE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.HOES).add(FirstItem.LIVE_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR).add(FirstItem.LIVE_BOOTS);
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR).add(FirstItem.LIVE_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR).add(FirstItem.LIVE_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR).add(FirstItem.LIVE_HELMET);
    }
}
