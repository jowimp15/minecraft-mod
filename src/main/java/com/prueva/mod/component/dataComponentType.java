package com.prueva.mod.component;

import com.prueva.mod.PruevaMod;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.function.UnaryOperator;

public class dataComponentType {

    public static final ComponentType<BlockPos> CORDENATE = register("cordenate", builder -> builder.codec(BlockPos.CODEC));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderUnaryOperator){
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(PruevaMod.MOD_ID, name), builderUnaryOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponent(){

    }
}
