package net.wtfcara.steampunk_skies_core.item;

import net.minecraftforge.registries.RegistryObject;
import net.wtfcara.steampunk_skies_core.SteampunkSkiesCore;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SteampunkSkiesCore.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE_CORUNDUM = ITEMS.register("sapphire_corundum",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY_CORUNDUM = ITEMS.register("ruby_corundum",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMERY_CORUNDUM = ITEMS.register("emery_corundum",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
