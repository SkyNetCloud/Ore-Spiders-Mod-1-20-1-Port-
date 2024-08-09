package dev.subortus.orespiders.entity.mobs.client.renderers.glowstone;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.client.models.all.GlowstoneSpiderModel;
import dev.subortus.orespiders.entity.mobs.server.entities_all.GlowstoneSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GlowstoneSpiderRenderer extends MobRenderer<GlowstoneSpiderEntity, GlowstoneSpiderModel<GlowstoneSpiderEntity>> {
    public GlowstoneSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GlowstoneSpiderModel<>(pContext.bakeLayer(ModModelLayers.GLOWSTONE_SPIDER_LAYER)), 0.5f);
        this.addLayer(new GlowstoneSpiderEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(GlowstoneSpiderEntity pEntity) {
        return new ResourceLocation(OreSpidersMod.MOD_ID, "textures/entity/glowstone/glowstone_spider.png");
    }
}
