package com.prueva.mod.block.custom;

import com.prueva.mod.PruevaMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PortalBlock extends Block {

    public PortalBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient){
            if(player instanceof ServerPlayerEntity serverPlayer){

                Identifier dimensionId = Identifier.of(PruevaMod.MOD_ID, "blood_dimension");

                ServerWorld targetrWord = serverPlayer.getServer().getWorld(RegistryKey.of(RegistryKeys.WORLD, dimensionId));

                if(targetrWord != null){
                    serverPlayer.teleport(targetrWord, pos.getX(), pos.getY() + 1, pos.getZ(), serverPlayer.getYaw(), serverPlayer.getPitch());
                    player.sendMessage(Text.of("Bienvenido a la dimension papuh"), true);
                }else{
                    player.sendMessage(Text.of("NO"), true);
                }
            }
        }
        return ActionResult.SUCCESS;
    }

}
