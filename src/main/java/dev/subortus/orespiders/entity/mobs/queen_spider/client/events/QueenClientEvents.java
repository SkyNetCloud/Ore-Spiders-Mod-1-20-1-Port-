package dev.subortus.orespiders.entity.mobs.queen_spider.client.events;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.queen_spider.client.models.QueenSpiderModelOne;
import dev.subortus.orespiders.entity.mobs.queen_spider.client.models.QueenSpiderModelThree;
import dev.subortus.orespiders.entity.mobs.queen_spider.client.models.QueenSpiderModelTwo;
import dev.subortus.orespiders.entity.mobs.queen_spider.client.models.QueenSpiderModelZero;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OreSpidersMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class QueenClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.QUEEN_ZERO, QueenSpiderModelZero::createZeroSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.QUEEN_ONE, QueenSpiderModelOne::createOneSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.QUEEN_TWO, QueenSpiderModelTwo::createTwoSpiderBodyLayer);
        event.registerLayerDefinition(ModModelLayers.QUEEN_THREE, QueenSpiderModelThree::createThreeSpiderBodyLayer);
    }
}
