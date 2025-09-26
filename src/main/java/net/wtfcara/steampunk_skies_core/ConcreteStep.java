package net.wtfcara.steampunk_skies_core;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
public class ConcreteStep {
    static AttributeModifier modifier = new AttributeModifier(ForgeMod.STEP_HEIGHT_ADDITION.toString(), 0.5f, AttributeModifier.Operation.ADDITION);
    public static void onPlayerTickEvent(TickEvent.PlayerTickEvent event) {
        BlockState block = event.player.getBlockStateOn();
        if(block.is(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "black_concrete")))){
            if(!event.player.getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get()).hasModifier(modifier)){
                event.player.getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get()).addTransientModifier(modifier);
            }
        }
        else{
            if(event.player.getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get()).hasModifier(modifier)) {
                event.player.getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get()).removeModifier(modifier.getId());
            }
        }
    }
}

