package dev.subortus.orespiders.entity.mobs.server;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.server.entities_all.*;
import dev.subortus.orespiders.entity.mobs.server.projectiles.OrbWeaverProjectile;
import dev.subortus.orespiders.entity.mobs.server.projectiles.SpiderQueenPotionProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> MOD_ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, OreSpidersMod.MOD_ID);

    public static final RegistryObject<EntityType<CoalSpiderEntity>> COAL_SPIDER_ENTITY =
            MOD_ENTITIES.register("coal_spider", () -> EntityType.Builder.of(CoalSpiderEntity::new, MobCategory.MONSTER)
                    .sized(1.4f,0.9f).build("coal_spider"));

    public static final RegistryObject<EntityType<QuartzSpiderEntity>> QUARTZ_SPIDER_ENTITY =
            MOD_ENTITIES.register("quartz_spider", () -> EntityType.Builder.of(QuartzSpiderEntity::new, MobCategory.MONSTER)
                    .sized(1.4f,0.9f).build("quartz_spider"));

    public static final RegistryObject<EntityType<LapisSpiderEntity>> LAPIS_SPIDER_ENTITY =
            MOD_ENTITIES.register("lapis_spider", () -> EntityType.Builder.of(LapisSpiderEntity::new, MobCategory.MONSTER)
                    .sized(1.4f,0.9f).build("lapis_spider"));

    public static final RegistryObject<EntityType<RedstoneSpiderEntity>> REDSTONE_SPIDER_ENTITY =
            MOD_ENTITIES.register("redstone_spider", () -> EntityType.Builder.of(RedstoneSpiderEntity::new, MobCategory.MONSTER)
                    .sized(1.4f,0.9f).build("redstone_spider"));

    public static final RegistryObject<EntityType<EnderSpiderEntity>> ENDER_SPIDER_ENTITY =
            MOD_ENTITIES.register("ender_spider", () -> EntityType.Builder.of(EnderSpiderEntity::new, MobCategory.MONSTER)
                    .sized(1.4f,0.9f).build("ender_spider"));

    public static final RegistryObject<EntityType<GoldenSpiderEntity>> GOLDEN_SPIDER_ENTITY =
            MOD_ENTITIES.register("gold_spider", () -> EntityType.Builder.of(GoldenSpiderEntity::new, MobCategory.MONSTER)
                    .sized(1.4f,0.9f).build("gold_spider"));

    public static final RegistryObject<EntityType<IronSpiderEntity>> IRON_SPIDER_ENTITY =
            MOD_ENTITIES.register("iron_spider", () -> EntityType.Builder.of(IronSpiderEntity::new, MobCategory.MONSTER)
                    .sized(1.4f,0.9f).build("iron_spider"));

    public static final RegistryObject<EntityType<EmeraldSpiderEntity>> EMERALD_SPIDER_ENTITY =
            MOD_ENTITIES.register("emerald_spider", () -> EntityType.Builder.of(EmeraldSpiderEntity::new, MobCategory.MONSTER)
                    .sized(1.4f,0.9f).build("emerald_spider"));

    public static final RegistryObject<EntityType<DiamondSpiderEntity>> DIAMOND_SPIDER_ENTITY =
            MOD_ENTITIES.register("diamond_spider", () -> EntityType.Builder.of(DiamondSpiderEntity::new, MobCategory.MONSTER)
                    .sized(1.4f,0.9f).build("diamond_spider"));

    public static final RegistryObject<EntityType<ObsidianSpiderEntity>> OBSIDIAN_SPIDER_ENTITY =
            MOD_ENTITIES.register("obsidian_spider", () -> EntityType.Builder.of(ObsidianSpiderEntity::new, MobCategory.MONSTER)
                    .sized(1.4f,0.9f).build("obsidian_spider"));

    public static final RegistryObject<EntityType<SpiderQueenPotionProjectile>> SQPP_POTION =
            MOD_ENTITIES.register("spider_queen_projectile_potion", () -> EntityType.Builder.<SpiderQueenPotionProjectile>of(SpiderQueenPotionProjectile::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("spider_queen_projectile_potion"));
    public static final RegistryObject<EntityType<OrbWeaverProjectile>> ORB_WEAVER_PROJECTILE =
            MOD_ENTITIES.register("orb_weaver_projectile", () -> EntityType.Builder.<OrbWeaverProjectile>of(OrbWeaverProjectile::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("orb_weaver_projectile"));

    public static void register(IEventBus eventBus){
        MOD_ENTITIES.register(eventBus);
    }
}
