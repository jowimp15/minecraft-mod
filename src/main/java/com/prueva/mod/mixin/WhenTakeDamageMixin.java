package com.prueva.mod.mixin;

import com.prueva.mod.Item.custom.ModArmorEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class WhenTakeDamageMixin {

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void onDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir){
        if((Object) this instanceof ServerPlayerEntity player){
            if(ModArmorEffect.isFUllSet(player)){
//                player.sendMessage(Text.literal("¡Has recibido daño!"), false);
//                 ModArmorEffect.onPlayerDamaged(player);
//                 ModArmorEffect.starRepair(player);
            }
        }
    }

}
