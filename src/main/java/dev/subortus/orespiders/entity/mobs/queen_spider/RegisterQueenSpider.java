package dev.subortus.orespiders.entity.mobs.queen_spider;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseOneEntity;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseThreeEntity;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseTwoEntity;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseZeroEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegisterQueenSpider {
    public static final DeferredRegister<EntityType<?>> QUEEN =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, OreSpidersMod.MOD_ID);

    public static final RegistryObject<EntityType<QueenSpiderPhaseZeroEntity>> QUEEN_SPIDER_PHASE_ZERO =
            QUEEN.register("queen_spider_phase_zero", () -> EntityType.Builder.of(QueenSpiderPhaseZeroEntity::new, MobCategory.MONSTER)
                    .sized(1.4f,0.9f).build("queen_spider_phase_zero"));

    public static final RegistryObject<EntityType<QueenSpiderPhaseOneEntity>> QUEEN_SPIDER_PHASE_ONE =
            QUEEN.register("queen_spider_phase_one", () -> EntityType.Builder.of(QueenSpiderPhaseOneEntity::new, MobCategory.MONSTER)
                    .sized(1.4f,0.9f).build("queen_spider_phase_one"));

    public static final RegistryObject<EntityType<QueenSpiderPhaseTwoEntity>> QUEEN_SPIDER_PHASE_TWO =
            QUEEN.register("queen_spider_phase_two", () -> EntityType.Builder.of(QueenSpiderPhaseTwoEntity::new, MobCategory.MONSTER)
                    .sized(1.4f,0.9f).build("queen_spider_phase_two"));

    public static final RegistryObject<EntityType<QueenSpiderPhaseThreeEntity>> QUEEN_SPIDER_PHASE_THREE =
            QUEEN.register("queen_spider_phase_three", () -> EntityType.Builder.of(QueenSpiderPhaseThreeEntity::new, MobCategory.MONSTER)
                    .sized(1.4f,0.9f).build("queen_spider_phase_three"));

    public static void register(IEventBus eventBus){
        QUEEN.register(eventBus);
    }
}
