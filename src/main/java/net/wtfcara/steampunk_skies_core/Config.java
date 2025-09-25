package net.wtfcara.steampunk_skies_core;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = SteampunkSkiesCore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.ConfigValue<Float> TNT_STRENGTH = BUILDER
            .comment("Explosion Power of TNT")
            .define("tnt_strength", 10.0f);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static float tnt_strength;
    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        tnt_strength = TNT_STRENGTH.get();
    }
}
