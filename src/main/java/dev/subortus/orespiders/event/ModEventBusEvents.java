package dev.subortus.orespiders.event;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.server.ModEntities;
import dev.subortus.orespiders.entity.mobs.server.entities_all.*;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OreSpidersMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.COAL_SPIDER_ENTITY.get(), CoalSpiderEntity.createAttributes().build());
        event.put(ModEntities.QUARTZ_SPIDER_ENTITY.get(), QuartzSpiderEntity.createAttributes().build());
        event.put(ModEntities.LAPIS_SPIDER_ENTITY.get(), LapisSpiderEntity.createAttributes().build());
        event.put(ModEntities.REDSTONE_SPIDER_ENTITY.get(), RedstoneSpiderEntity.createAttributes().build());
        event.put(ModEntities.ENDER_SPIDER_ENTITY.get(), EnderSpiderEntity.createAttributes().build());
        event.put(ModEntities.GOLDEN_SPIDER_ENTITY.get(), GoldenSpiderEntity.createAttributes().build());
        event.put(ModEntities.IRON_SPIDER_ENTITY.get(), IronSpiderEntity.createAttributes().build());
        event.put(ModEntities.EMERALD_SPIDER_ENTITY.get(), EmeraldSpiderEntity.createAttributes().build());
        event.put(ModEntities.DIAMOND_SPIDER_ENTITY.get(), DiamondSpiderEntity.createAttributes().build());
        event.put(ModEntities.OBSIDIAN_SPIDER_ENTITY.get(), ObsidianSpiderEntity.createAttributes().build());
        event.put(ModEntities.GLOWSTONE_SPIDER_ENTITY.get(), GlowstoneSpiderEntity.createAttributes().build());
        event.put(ModEntities.NETHERITE_SPIDER_ENTITY.get(), NetheriteSpiderEntity.createAttributes().build());


    }
}
