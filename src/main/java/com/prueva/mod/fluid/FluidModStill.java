package com.prueva.mod.fluid;

import com.prueva.mod.Item.FirstItem;
import com.prueva.mod.block.BlocksMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.util.shape.VoxelShapes;

public class FluidModStill extends FlowableFluid {
    public static final IntProperty LEVEL = Properties.LEVEL_1_8;

    @Override
    public Fluid getFlowing() {
        return FluidRegister.FLOWING_FLUID;
    }

    @Override
    public Fluid getStill() {
        return FluidRegister.STILL_FLUID;
    }

    @Override
    protected boolean isInfinite(World world) {
        return false;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        if (world instanceof ServerWorld serverWorld) {
            Block.dropStacks(state, serverWorld, pos);
        }
    }
    @Override
    protected int getMaxFlowDistance(WorldView world) {
        return 8;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView world) {
        return 1;
    }

    @Override
    public Item getBucketItem() {
        return FirstItem.BLOOD_BUCKET;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return state.getFluid() == fluid;
    }

    @Override
    public int getTickRate(WorldView world) {
        return 5;
    }

    @Override
    protected float getBlastResistance() {
        return 100.0F;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return null;
//                BlocksMod.BLOOD_LIQUID.getDefaultState().with(FluidBlock.LEVEL, state.get(LEVEL));
    }

    @Override
    public boolean isStill(FluidState state) {
        return state.getFluid() == this;
    }

    @Override
    public int getLevel(FluidState state) {
        return 8 - state.get(LEVEL);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
        super.appendProperties(builder);
        builder.add(LEVEL);
    }

    @Override
    public VoxelShape getShape(FluidState state, BlockView world, BlockPos pos) {
        return VoxelShapes.cuboid(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
    }
}
