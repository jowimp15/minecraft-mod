package com.prueva.mod.Item.custom;

import com.mojang.brigadier.LiteralMessage;
import com.prueva.mod.Item.FirstItem;
import com.prueva.mod.PruevaMod;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

import javax.naming.Context;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ModArmorEffect {

    // CHECK ARMOR WHEN IS FULL
    public static boolean isFUllSet(PlayerEntity player){
        ItemStack helmet = player.getInventory().getArmorStack(3);
        ItemStack chestplate  = player.getInventory().getArmorStack(2);
        ItemStack leggings  = player.getInventory().getArmorStack(1);
        ItemStack boots  = player.getInventory().getArmorStack(0);

        return helmet.getItem() == FirstItem.CONSCIOUS_HELMET &&
                chestplate.getItem() == FirstItem.CONSCIOUS_CHESTPLATE &&
                leggings.getItem() == FirstItem.CONSCIOUS_LEGGINGS &&
                boots.getItem() == FirstItem.CONSCIOUS_BOOTS;
    };

    // FOR ADD EXTRA HEARTS
    public static void addHearts(PlayerEntity player){
        EntityAttributeInstance maxHearts = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if(maxHearts != null){
            for(EntityAttributeModifier modifier : maxHearts.getModifiers()){
                if(modifier.getClass().equals(Identifier.of(PruevaMod.MOD_ID, "health_boost")));
                return;
            }
        }
        maxHearts.addPersistentModifier(new EntityAttributeModifier(Identifier.of(PruevaMod.MOD_ID, "health_boost"), 20.0, EntityAttributeModifier.Operation.ADD_VALUE));
    }

    public static void removeHearts(PlayerEntity player){
        EntityAttributeInstance maxHearts = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
            if(maxHearts != null){
                for(EntityAttributeModifier modifier : maxHearts.getModifiers()){
                    Identifier.of(PruevaMod.MOD_ID, "health_boost");
                    maxHearts.removeModifier(modifier);
                    return;
                }
            }

        }

    public static void checkFullArmorSet(PlayerEntity player) {
        if (isFUllSet(player)) {
            addHearts(player);
        } else {
            removeHearts(player);
        }
    }

    // METHOD WHO IS CALLING IN THE INITIALIZE

    private static boolean hasWeapon(PlayerEntity player){
        ItemStack mainHandler = player.getMainHandStack();
        return mainHandler.getItem() == FirstItem.CONSCIOUS_SWORD;
    }


    public static void whenTakeDamageAndIsFullArmor(){
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            for (PlayerEntity player : world.getPlayers()) {
                checkFullArmorSet(player);
            }
        });

        // WHEN TAKE DAMAGE
//        AttackEntityCallback.EVENT.register(((playerEntity, world1, hand, entity1, entityHitResult) -> {
//            if(playerEntity instanceof ServerPlayerEntity player){
//                if (isFUllSet(playerEntity)) {
//                }
//            }
//            return ActionResult.PASS;
//        }));



        // EVENT WHEN ATTAKING
        AttackEntityCallback.EVENT.register((playerEntity, world, hand, entity, entityHitResult) -> {
            if(entity instanceof LivingEntity target){
                if(isFUllSet(playerEntity) && hasWeapon(playerEntity)){
                    float baseDamage = (float) playerEntity.getAttributeValue(net.minecraft.entity.attribute.EntityAttributes.GENERIC_ATTACK_DAMAGE);

                    float lifeStealPercentage = new Random().nextFloat() * 0.3f;
                    float lifeStealAmount = baseDamage * lifeStealPercentage;

                    playerEntity.heal(lifeStealAmount);
                }
            }
            return ActionResult.PASS;
        });

// BUFF OF REGENERATION
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, entity, killedEntity) -> {
            if (entity instanceof PlayerEntity player) {
                if (isFUllSet(player)) {
                    Random random = new Random();
                    if (random.nextFloat() <= 0.4) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60, 2, false, false, true));
                    }
                }
            }
        });
    }

    // FOR REPAIR THE ARMOR
//    public static long lastDamageTake = 0;
//    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//
//    private static void repairArmor(PlayerEntity player){
//        if (!player.getWorld().isClient()) {
//            for(ItemStack armorPiece : player.getInventory().armor){
//                if(armorPiece.getItem() instanceof ArmorItem && armorPiece.getDamage() > 0){
//                    player.sendMessage(Text.literal("La armadura se comieza a reparar"), false);
//                    armorPiece.setDamage(armorPiece.getDamage() -1);
//                }
//            }
//        }
//    }
//    public static void onPlayerDamaged(PlayerEntity player){
//        lastDamageTake = System.currentTimeMillis();
//    }
//    public static void starRepair(PlayerEntity player){
//        scheduler.scheduleAtFixedRate(()->{
//            if(System.currentTimeMillis() - lastDamageTake >= 15000){
//                repairArmor(player);
//                player.sendMessage(Text.literal(""), false);
//            }
//        }, 0,1, TimeUnit.SECONDS);
//    }
}
