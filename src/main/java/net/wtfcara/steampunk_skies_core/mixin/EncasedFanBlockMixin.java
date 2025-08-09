package net.wtfcara.steampunk_skies_core.mixin;

import com.simibubi.create.content.kinetics.base.DirectionalKineticBlock;

import com.simibubi.create.content.kinetics.fan.EncasedFanBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EncasedFanBlock.class)
public abstract class EncasedFanBlockMixin extends DirectionalKineticBlock {
    public EncasedFanBlockMixin(Properties properties) {
        super(properties);
    }

    @Override
    public SpeedLevel getMinimumRequiredSpeedLevel(){
        return SpeedLevel.MEDIUM;
    }
}
