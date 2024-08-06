package dev.subortus.orespiders.entity.mobs.client.renderers.quartz;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.client.models.all.QuartzSpiderModel;
import dev.subortus.orespiders.entity.mobs.server.entities_all.QuartzSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class QuartzSpiderRenderer extends MobRenderer<QuartzSpiderEntity, QuartzSpiderModel<QuartzSpiderEntity>> {
    public QuartzSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new QuartzSpiderModel<>(pContext.bakeLayer(ModModelLayers.QUARTZ_SPIDER_LAYER)), 0.5f);
        this.addLayer(new QuartzSpiderEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(QuartzSpiderEntity pEntity) {
        return new ResourceLocation(OreSpidersMod.MOD_ID, "textures/entity/quartz/quartz_spider.png");
    }
}
