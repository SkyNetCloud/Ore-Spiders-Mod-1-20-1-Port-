package dev.subortus.orespiders.item;

import dev.subortus.orespiders.OreSpidersMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OreSpidersMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ORE_SPIDER_TAB = CREATIVE_MODE_TABS.register("ore_spiders_tab",
            ()-> CreativeModeTab.builder().icon(()-> ModItems.COAL_SPIDER_SPAWN_EGG.get().getDefaultInstance())
                    .title(Component.translatable("creativetab.ore_spiders_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.COAL_SPIDER_SPAWN_EGG.get());
                        output.accept(ModItems.QUARTZ_SPIDER_SPAWN_EGG.get());
                        output.accept(ModItems.LAPIS_SPIDER_SPAWN_EGG.get());
                        output.accept(ModItems.REDSTONE_SPIDER_SPAWN_EGG.get());
                        output.accept(ModItems.ENDER_SPIDER_SPAWN_EGG.get());
                        output.accept(ModItems.GOLDEN_SPIDER_SPAWN_EGG.get());
                        output.accept(ModItems.IRON_SPIDER_SPAWN_EGG.get());
                        output.accept(ModItems.EMERALD_SPIDER_SPAWN_EGG.get());
                        output.accept(ModItems.DIAMOND_SPIDER_SPAWN_EGG.get());
                        output.accept(ModItems.OBSIDIAN_SPIDER_SPAWN_EGG.get());
                        output.accept(ModItems.GLOWSTONE_SPIDER_SPAWN_EGG.get());
                        output.accept(ModItems.NETHERITE_SPIDER_SPAWN_EGG.get());

                        output.accept(ModItems.QUEEN_SPIDER_EYE.get());
                        output.accept(ModItems.MYSTERIOUS_POTION.get());
                        output.accept(ModItems.DIAMOND_NUGGET.get());
                        output.accept(ModItems.ORB_WEAVER.get());

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
