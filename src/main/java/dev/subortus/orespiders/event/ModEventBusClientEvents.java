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
        event.registerLayerDefinition(ModModelLayers.COAL_SPIDER_LAYER, CoalSpiderModel::createCoalSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.QUARTZ_SPIDER_LAYER, QuartzSpiderModel::createQuartzSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.LAPIS_SPIDER_LAYER, LapisSpiderModel::createLapisSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.REDSTONE_SPIDER_LAYER, RedstoneSpiderModel::createRedstoneSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ENDER_SPIDER_LAYER, EnderSpiderModel::createSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.GOLDEN_SPIDER_LAYER, GoldenSpiderModel::createGoldSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.IRON_SPIDER_LAYER, IronSpiderModel::createIronSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.EMERALD_SPIDER_LAYER, EmeraldSpiderModel::createEmeraldSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.DIAMOND_SPIDER_LAYER, DiamondSpiderModel::createDiamondSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.OBSIDIAN_SPIDER_LAYER, ObsidianSpiderModel::createObsidianSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.GLOWSTONE_SPIDER_LAYER, GlowstoneSpiderModel::createGlowstoneSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.NETHERITE_SPIDER_LAYER, NetheriteSpiderModel::createSpiderBodyLayer);




    }
}
