package dev.subortus.orespiders.entity.mobs.queen_spider.client.events;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.queen_spider.RegisterQueenSpider;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseOneEntity;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseThreeEntity;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseTwoEntity;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseZeroEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OreSpidersMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class QueenAttributeGenerators {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(RegisterQueenSpider.QUEEN_SPIDER_PHASE_ZERO.get(), QueenSpiderPhaseZeroEntity.createAttributes().build());
        event.put(RegisterQueenSpider.QUEEN_SPIDER_PHASE_ONE.get(), QueenSpiderPhaseOneEntity.createAttributes().build());
        event.put(RegisterQueenSpider.QUEEN_SPIDER_PHASE_TWO.get(), QueenSpiderPhaseTwoEntity.createAttributes().build());
        event.put(RegisterQueenSpider.QUEEN_SPIDER_PHASE_THREE.get(), QueenSpiderPhaseThreeEntity.createAttributes().build());



    }

}
