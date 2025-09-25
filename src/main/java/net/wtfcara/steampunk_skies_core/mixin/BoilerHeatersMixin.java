package net.wtfcara.steampunk_skies_core.mixin;

import com.simibubi.create.content.fluids.tank.BoilerHeaters;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BoilerHeaters.class)
public abstract class BoilerHeatersMixin {
    @Inject(method = "registerDefaults", at = @At(value = "HEAD"), cancellable = true)
    private static void registerDefaults(CallbackInfo ci){
        ci.cancel();
    }
}
