package net.wtfcara.steampunk_skies_core.mixin;

import com.simibubi.create.content.kinetics.base.RotatedPillarKineticBlock;
import com.simibubi.create.content.kinetics.crusher.CrushingWheelBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CrushingWheelBlock.class)
public abstract class CrushingWheelBlockMixin extends RotatedPillarKineticBlock {
    public CrushingWheelBlockMixin(Properties properties) {
        super(properties);
    }

    @Override
    public SpeedLevel getMinimumRequiredSpeedLevel(){
        return SpeedLevel.FAST;
    }
}
