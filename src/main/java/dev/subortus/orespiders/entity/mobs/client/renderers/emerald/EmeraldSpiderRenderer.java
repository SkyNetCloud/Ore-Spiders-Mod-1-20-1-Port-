package dev.subortus.orespiders.entity.mobs.client.renderers.emerald;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.client.models.all.EmeraldSpiderModel;
import dev.subortus.orespiders.entity.mobs.server.entities_all.EmeraldSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EmeraldSpiderRenderer extends MobRenderer<EmeraldSpiderEntity, EmeraldSpiderModel<EmeraldSpiderEntity>> {
    public EmeraldSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new EmeraldSpiderModel<>(pContext.bakeLayer(ModModelLayers.EMERALD_SPIDER_LAYER)), 0.5f);
        this.addLayer(new EmeraldSpiderEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EmeraldSpiderEntity pEntity) {
        return new ResourceLocation(OreSpidersMod.MOD_ID, "textures/entity/emerald/emerald_spider.png");
    }
}
