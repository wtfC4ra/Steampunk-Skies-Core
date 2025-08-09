package net.wtfcara.steampunk_skies_core.mixin;

import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.content.kinetics.mixer.MechanicalMixerBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MechanicalMixerBlock.class)
public abstract class MechanicalMixerBlockMixin extends KineticBlock {

    public MechanicalMixerBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "getMinimumRequiredSpeedLevel", at = @At(value = "HEAD"), remap = false, cancellable = true)
    private void SpeedLevelMixin(CallbackInfoReturnable cir){
        cir.setReturnValue(SpeedLevel.FAST);
    }
}
