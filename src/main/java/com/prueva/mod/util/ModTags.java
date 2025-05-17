package com.prueva.mod.util;

import com.prueva.mod.PruevaMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> TAGS_FUNCTION = createTag("tags_function_blocks");
        public static final  TagKey<Block> INCORRECT_FOR_GALIUM_TOOL = createTag("incorrect_galium_tool");
        public static final  TagKey<Block> NEEDS_GALIUM_TOOL = createTag("incorrect_galium_tool");
        public static final  TagKey<Block> INCORRECT_FOR_LIVE_TOOL = createTag("incorrect_live_tool");
        public static final  TagKey<Block> NEEDS_LIVE_TOOL = createTag("incorrect_galium_tool");
        public static final  TagKey<Block> INCORRECT_FOR_CONSCIOUS_TOOL = createTag("incorrect_conscious_tool");
        public static final  TagKey<Block> NEEDS_CONSCIOUS_TOOL = createTag("incorrect_conscious_tool");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(PruevaMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TAGS_FUNCTION = createTag("tags_function_items");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(PruevaMod.MOD_ID, name));
        }
    }
}
