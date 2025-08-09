package net.wtfcara.steampunk_skies_core.mixin;

import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.content.kinetics.fan.EncasedFanBlockEntity;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static java.lang.Math.abs;

@Mixin(EncasedFanBlockEntity.class)
public abstract class EncasedFanBlockEntityMixin{
    @Shadow
    protected boolean updateAirFlow;
    /***
    @Inject(method = "getAirFlowDirection", at = @At(value = "HEAD"), remap = false, cancellable = true)
    private void mixin(CallbackInfoReturnable cir) {
        var fan = (EncasedFanBlockEntity) (Object) this;
        float speed = fan.getSpeed();
        if (abs(speed)<32) {
            cir.setReturnValue(null);
        }
    }
    ***/
    @Inject(method = "tick", at = @At(value = "FIELD", target = "Lcom/simibubi/create/content/kinetics/fan/EncasedFanBlockEntity;entitySearchCooldown:I"), remap = false, cancellable = true)
    private void tickMixin(CallbackInfo ci){
        var fan = (EncasedFanBlockEntity) (Object) this;
        if (abs(fan.getSpeed()) < 32){
            ci.cancel();
        }
    }
}
