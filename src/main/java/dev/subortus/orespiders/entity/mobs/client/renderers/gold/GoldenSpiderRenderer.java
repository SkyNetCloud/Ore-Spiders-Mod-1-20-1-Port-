package dev.subortus.orespiders.entity.mobs.client.renderers.gold;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.client.models.all.CoalSpiderModel;
import dev.subortus.orespiders.entity.mobs.client.models.all.GoldenSpiderModel;
import dev.subortus.orespiders.entity.mobs.server.entities_all.CoalSpiderEntity;
import dev.subortus.orespiders.entity.mobs.server.entities_all.GoldenSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GoldenSpiderRenderer extends MobRenderer<GoldenSpiderEntity, GoldenSpiderModel<GoldenSpiderEntity>> {
    public GoldenSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GoldenSpiderModel<>(pContext.bakeLayer(ModModelLayers.GOLDEN_SPIDER_LAYER)), 0.5f);
        this.addLayer(new GoldenSpiderEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(GoldenSpiderEntity pEntity) {
        return new ResourceLocation(OreSpidersMod.MOD_ID, "textures/entity/gold/gold_spider.png");
    }
}
