package com.prueva.mod.block;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class ModBlockColumn extends Block {
public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;

        public ModBlockColumn(Settings settings) {
            super(settings);
            this.setDefaultState(this.getStateManager().getDefaultState().with(AXIS, Direction.Axis.Y));
        }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(AXIS, ctx.getSide().getAxis());
    }
}


