package com.prueva.mod.Item.custom;

import com.prueva.mod.component.dataComponentType;
import com.prueva.mod.util.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class ChiselItem extends Item {
    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();

        if(context.getWorld() != null && !context.getWorld().isClient()){
            if(!world.getBlockState(pos).isIn(ModTags.Blocks.TAGS_FUNCTION)){

                context.getWorld().setBlockState(pos, Blocks.DIAMOND_BLOCK.getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                context.getStack().set(dataComponentType.CORDENATE, context.getBlockPos());
            }


            return  ActionResult.SUCCESS;
        }

        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.prueva-mod.chisel_item.tooltip"));

            if(stack.get(dataComponentType.CORDENATE) != null){
                tooltip.add(Text.literal("Posicion: " + stack.get(dataComponentType.CORDENATE)));
            }


        super.appendTooltip(stack, context, tooltip, type);
    }
}
