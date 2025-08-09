package net.wtfcara.steampunk_skies_core.mixin;

import com.simibubi.create.content.kinetics.crafter.MechanicalCrafterBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static java.lang.Math.abs;

@Mixin(MechanicalCrafterBlockEntity.class)
public class MechanicalCrafterBlockEntityMixin {
    @Inject(method = "tick", at = @At(value = "FIELD", target = "Lcom/simibubi/create/content/kinetics/crafter/MechanicalCrafterBlockEntity;phase:Lcom/simibubi/create/content/kinetics/crafter/MechanicalCrafterBlockEntity$Phase;"), remap = false, cancellable = true)
    private void tickMixin(CallbackInfo ci){
        var crafter = (MechanicalCrafterBlockEntity)(Object)(this);
        if (abs(crafter.getSpeed()) < 1){
            ci.cancel();
        }
    }
}
