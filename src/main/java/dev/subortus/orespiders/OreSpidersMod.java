package dev.subortus.orespiders;

import com.mojang.logging.LogUtils;
import dev.subortus.orespiders.entity.mobs.client.renderers.coal.CoalSpiderRenderer;
import dev.subortus.orespiders.entity.mobs.client.renderers.diamond.DiamondSpiderRenderer;
import dev.subortus.orespiders.entity.mobs.client.renderers.emerald.EmeraldSpiderRenderer;
import dev.subortus.orespiders.entity.mobs.client.renderers.ender.EnderSpiderRenderer;
import dev.subortus.orespiders.entity.mobs.client.renderers.glowstone.GlowstoneSpiderRenderer;
import dev.subortus.orespiders.entity.mobs.client.renderers.gold.GoldenSpiderRenderer;
import dev.subortus.orespiders.entity.mobs.client.renderers.iron.IronSpiderRenderer;
import dev.subortus.orespiders.entity.mobs.client.renderers.lapis.LapisSpiderRenderer;
import dev.subortus.orespiders.entity.mobs.client.renderers.netherite.NetheriteSpiderRenderer;
import dev.subortus.orespiders.entity.mobs.client.renderers.obsidian.ObsidianSpiderRenderer;
import dev.subortus.orespiders.entity.mobs.client.renderers.quartz.QuartzSpiderRenderer;
import dev.subortus.orespiders.entity.mobs.client.renderers.redstone.RedstoneSpiderRenderer;
import dev.subortus.orespiders.entity.mobs.queen_spider.RegisterQueenSpider;
import dev.subortus.orespiders.entity.mobs.queen_spider.client.renderers.one.QueenOneSpiderRenderer;
import dev.subortus.orespiders.entity.mobs.queen_spider.client.renderers.three.QueenThreeSpiderRenderer;
import dev.subortus.orespiders.entity.mobs.queen_spider.client.renderers.two.QueenTwoSpiderRenderer;
import dev.subortus.orespiders.entity.mobs.queen_spider.client.renderers.zero.QueenZeroSpiderRenderer;
import dev.subortus.orespiders.entity.mobs.server.ModEntities;
import dev.subortus.orespiders.entity.mobs.server.entities_all.*;
import dev.subortus.orespiders.item.ModCreativeModeTab;
import dev.subortus.orespiders.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(OreSpidersMod.MOD_ID)
public class OreSpidersMod
{

    public static final String MOD_ID = "orespiders";

    private static final Logger LOGGER = LogUtils.getLogger();

    public OreSpidersMod(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModCreativeModeTab.register(modEventBus);

        ModEntities.register(modEventBus);
        RegisterQueenSpider.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(()->{
            SpawnPlacements.register(ModEntities.COAL_SPIDER_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
                    CoalSpiderEntity::checkOreSpiderSpawnRules);
            SpawnPlacements.register(ModEntities.EMERALD_SPIDER_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
                    EmeraldSpiderEntity::checkOreSpiderSpawnRules);
            SpawnPlacements.register(ModEntities.DIAMOND_SPIDER_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
                    DiamondSpiderEntity::checkOreSpiderSpawnRules);
            SpawnPlacements.register(ModEntities.IRON_SPIDER_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
                    IronSpiderEntity::checkOreSpiderSpawnRules);
            SpawnPlacements.register(ModEntities.GOLDEN_SPIDER_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
                    GoldenSpiderEntity::checkOreSpiderSpawnRules);
            SpawnPlacements.register(ModEntities.LAPIS_SPIDER_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
                    LapisSpiderEntity::checkOreSpiderSpawnRules);
            SpawnPlacements.register(ModEntities.REDSTONE_SPIDER_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
                    RedstoneSpiderEntity::checkOreSpiderSpawnRules);
            SpawnPlacements.register(ModEntities.ENDER_SPIDER_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
                    EnderSpiderEntity::checkMonsterSpawnRules);
            SpawnPlacements.register(ModEntities.QUARTZ_SPIDER_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
                    QuartzSpiderEntity::checkMonsterSpawnRules);
            SpawnPlacements.register(ModEntities.OBSIDIAN_SPIDER_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
                    ObsidianSpiderEntity::checkObsidianSpiderSpawnRules);
            SpawnPlacements.register(ModEntities.GLOWSTONE_SPIDER_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
                    GlowstoneSpiderEntity::checkMonsterSpawnRules);
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(ModEntities.COAL_SPIDER_ENTITY.get(), CoalSpiderRenderer::new);
            EntityRenderers.register(ModEntities.QUARTZ_SPIDER_ENTITY.get(), QuartzSpiderRenderer::new);
            EntityRenderers.register(ModEntities.LAPIS_SPIDER_ENTITY.get(), LapisSpiderRenderer::new);
            EntityRenderers.register(ModEntities.REDSTONE_SPIDER_ENTITY.get(), RedstoneSpiderRenderer::new);
            EntityRenderers.register(ModEntities.ENDER_SPIDER_ENTITY.get(), EnderSpiderRenderer::new);
            EntityRenderers.register(ModEntities.GOLDEN_SPIDER_ENTITY.get(), GoldenSpiderRenderer::new);
            EntityRenderers.register(ModEntities.IRON_SPIDER_ENTITY.get(), IronSpiderRenderer::new);
            EntityRenderers.register(ModEntities.EMERALD_SPIDER_ENTITY.get(), EmeraldSpiderRenderer::new);
            EntityRenderers.register(ModEntities.DIAMOND_SPIDER_ENTITY.get(), DiamondSpiderRenderer::new);
            EntityRenderers.register(ModEntities.OBSIDIAN_SPIDER_ENTITY.get(), ObsidianSpiderRenderer::new);
            EntityRenderers.register(ModEntities.GLOWSTONE_SPIDER_ENTITY.get(), GlowstoneSpiderRenderer::new);
            EntityRenderers.register(ModEntities.NETHERITE_SPIDER_ENTITY.get(), NetheriteSpiderRenderer::new);

            EntityRenderers.register(RegisterQueenSpider.QUEEN_SPIDER_PHASE_ZERO.get(), QueenZeroSpiderRenderer::new);
            EntityRenderers.register(RegisterQueenSpider.QUEEN_SPIDER_PHASE_ONE.get(), QueenOneSpiderRenderer::new);
            EntityRenderers.register(RegisterQueenSpider.QUEEN_SPIDER_PHASE_TWO.get(), QueenTwoSpiderRenderer::new);
            EntityRenderers.register(RegisterQueenSpider.QUEEN_SPIDER_PHASE_THREE.get(), QueenThreeSpiderRenderer::new);

            EntityRenderers.register(ModEntities.SQPP_POTION.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.ORB_WEAVER_PROJECTILE.get(), ThrownItemRenderer::new);

        }
    }
}
