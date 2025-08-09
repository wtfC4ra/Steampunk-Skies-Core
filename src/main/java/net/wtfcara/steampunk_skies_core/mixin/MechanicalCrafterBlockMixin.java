package net.wtfcara.steampunk_skies_core.mixin;

import com.simibubi.create.content.kinetics.base.HorizontalKineticBlock;
import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.content.kinetics.crafter.MechanicalCrafterBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MechanicalCrafterBlock.class)
public abstract class MechanicalCrafterBlockMixin extends HorizontalKineticBlock {
    public MechanicalCrafterBlockMixin(Properties properties) {
        super(properties);
    }

    @Override
    public IRotate.SpeedLevel getMinimumRequiredSpeedLevel(){
        return IRotate.SpeedLevel.SLOW;
    }
}
