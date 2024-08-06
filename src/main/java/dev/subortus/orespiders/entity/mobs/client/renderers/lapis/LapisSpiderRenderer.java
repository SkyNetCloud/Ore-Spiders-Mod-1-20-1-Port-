package dev.subortus.orespiders.entity.mobs.client.renderers.lapis;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.client.models.all.LapisSpiderModel;
import dev.subortus.orespiders.entity.mobs.server.entities_all.LapisSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LapisSpiderRenderer extends MobRenderer<LapisSpiderEntity, LapisSpiderModel<LapisSpiderEntity>> {
    public LapisSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new LapisSpiderModel<>(pContext.bakeLayer(ModModelLayers.LAPIS_SPIDER_LAYER)), 0.5f);
        this.addLayer(new LapisSpiderEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(LapisSpiderEntity pEntity) {
        return new ResourceLocation(OreSpidersMod.MOD_ID, "textures/entity/lapis/lapis_spider.png");
    }
}
