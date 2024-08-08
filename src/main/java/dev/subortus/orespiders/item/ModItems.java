package dev.subortus.orespiders.item;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.server.ModEntities;
import dev.subortus.orespiders.item.custom.OrbWeaverItem;
import dev.subortus.orespiders.item.custom.SpiderQueenPotionItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> MOD_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OreSpidersMod.MOD_ID);

    public static final RegistryObject<Item> COAL_SPIDER_SPAWN_EGG = MOD_ITEMS.register("coal_spider_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.COAL_SPIDER_ENTITY,0xa000000,0x222222,new Item.Properties()));

    public static final RegistryObject<Item> QUARTZ_SPIDER_SPAWN_EGG = MOD_ITEMS.register("quartz_spider_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.QUARTZ_SPIDER_ENTITY, 0xa000000, 0x8a8982, new Item.Properties()));

    public static final RegistryObject<Item> LAPIS_SPIDER_SPAWN_EGG = MOD_ITEMS.register("lapis_spider_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.LAPIS_SPIDER_ENTITY, 0xa000000, 0x007bff, new Item.Properties()));

    public static final RegistryObject<Item> REDSTONE_SPIDER_SPAWN_EGG = MOD_ITEMS.register("redstone_spider_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.REDSTONE_SPIDER_ENTITY, 0xa000000, 0xc01e03, new Item.Properties()));

    public static final RegistryObject<Item> ENDER_SPIDER_SPAWN_EGG = MOD_ITEMS.register("ender_spider_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.ENDER_SPIDER_ENTITY, 0xa000000, 0x9b71cf, new Item.Properties()));

    public static final RegistryObject<Item> GOLDEN_SPIDER_SPAWN_EGG = MOD_ITEMS.register("gold_spider_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GOLDEN_SPIDER_ENTITY, 0xa000000, 0xc5b358, new Item.Properties()));

    public static final RegistryObject<Item> IRON_SPIDER_SPAWN_EGG = MOD_ITEMS.register("iron_spider_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.IRON_SPIDER_ENTITY, 0xa000000, 0x636363, new Item.Properties()));

    public static final RegistryObject<Item> EMERALD_SPIDER_SPAWN_EGG = MOD_ITEMS.register("emerald_spider_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.EMERALD_SPIDER_ENTITY, 0xa000000, 0xabe781, new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_SPIDER_SPAWN_EGG = MOD_ITEMS.register("diamond_spider_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.DIAMOND_SPIDER_ENTITY, 0xa000000, 0xb9e3ea, new Item.Properties()));

    public static final RegistryObject<Item> OBSIDIAN_SPIDER_SPAWN_EGG = MOD_ITEMS.register("obsidian_spider_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.OBSIDIAN_SPIDER_ENTITY, 0xa000000, 0x7106aa, new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_NUGGET = MOD_ITEMS.register("diamond_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> QUEEN_SPIDER_EYE = MOD_ITEMS.register("queen_spider_eye",
            () -> new Item(new Item.Properties().food(
                    new FoodProperties.Builder().effect(
                            new MobEffectInstance(MobEffects.POISON, 200, 3, true, true, true
                    ), 1.0f).build())));

    public static final RegistryObject<Item> MYSTERIOUS_POTION = MOD_ITEMS.register("potion_queen_spider",
            () -> new SpiderQueenPotionItem(new Item.Properties()));

    public static final RegistryObject<Item> ORB_WEAVER = MOD_ITEMS.register("orb_weaver",
            () -> new OrbWeaverItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ORB_WEAVER_PROJECTILE = MOD_ITEMS.register("orb_weaver_projectile",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        MOD_ITEMS.register(eventBus);
    }
}
