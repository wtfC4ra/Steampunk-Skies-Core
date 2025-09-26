package net.wtfcara.steampunk_skies_core.mixin;

import com.simibubi.create.content.kinetics.saw.SawMovementBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SawMovementBehaviour.class)
public class SawMovementBehaviourMixin {
    @Inject(method = "canBreak", at = @At(value = "HEAD"), cancellable = true, remap = false)
    private void mixin(Level world, BlockPos breakingPos, BlockState state, CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(false);
    }
}
