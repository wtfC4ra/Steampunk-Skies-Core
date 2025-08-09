package net.wtfcara.steampunk_skies_core.mixin;

import com.simibubi.create.content.kinetics.crusher.CrushingWheelControllerBlock;
import com.simibubi.create.content.kinetics.crusher.CrushingWheelControllerBlockEntity;
import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.infrastructure.config.AllConfigs;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CrushingWheelControllerBlock.class)
public abstract class CrushingWheelControllerBlockMixin implements IBE<CrushingWheelControllerBlockEntity> {
    @Inject(method = "checkEntityForProcessing", at = @At(value = "HEAD"), remap = false, cancellable = true)
    private void checkEntityMixin(Level worldIn, BlockPos pos, Entity entityIn, CallbackInfo ci){
        CrushingWheelControllerBlockEntity be = getBlockEntity(worldIn, pos);
        if(be == null){
            ci.cancel();
        }
        System.out.println(be.crushingspeed*50);
        if(be.crushingspeed*50 < AllConfigs.server().kinetics.mediumSpeed.get()){
            System.out.println("wheels too slow!");
            ci.cancel();
        }
    }
}
