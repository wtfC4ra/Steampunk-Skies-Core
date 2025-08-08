package net.wtfcara.steampunk_skies_core.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.wtfcara.steampunk_skies_core.SteampunkSkiesCore;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SteampunkSkiesCore.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CORUNDUM_TAB = CREATIVE_MODE_TABS.register("corundum_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE_CORUNDUM.get()))
                .title(Component.translatable("creativetab.corundum_tab"))
                .displayItems((pParameters, pOutput) -> {
                    pOutput.accept(ModItems.SAPPHIRE_CORUNDUM.get());
                    pOutput.accept(ModItems.RUBY_CORUNDUM.get());
                    pOutput.accept(ModItems.EMERY_CORUNDUM.get());
                })
                .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
