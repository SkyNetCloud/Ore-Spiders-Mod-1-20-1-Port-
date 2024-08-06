package dev.subortus.orespiders.event;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.client.models.all.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OreSpidersMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.COAL_SPIDER_LAYER, CoalSpiderModel::createSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.QUARTZ_SPIDER_LAYER, QuartzSpiderModel::createSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.LAPIS_SPIDER_LAYER, LapisSpiderModel::createSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.REDSTONE_SPIDER_LAYER, RedstoneSpiderModel::createSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ENDER_SPIDER_LAYER, EnderSpiderModel::createSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.GOLDEN_SPIDER_LAYER, GoldenSpiderModel::createSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.IRON_SPIDER_LAYER, IronSpiderModel::createSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.EMERALD_SPIDER_LAYER, EmeraldSpiderModel::createSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.DIAMOND_SPIDER_LAYER, DiamondSpiderModel::createSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.OBSIDIAN_SPIDER_LAYER, ObsidianSpiderModel::createSpiderBodyLayer);




    }
}
