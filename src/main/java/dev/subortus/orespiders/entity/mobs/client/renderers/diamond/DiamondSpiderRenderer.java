package dev.subortus.orespiders.entity.mobs.client.renderers.diamond;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.client.models.all.CoalSpiderModel;
import dev.subortus.orespiders.entity.mobs.client.models.all.DiamondSpiderModel;
import dev.subortus.orespiders.entity.mobs.server.entities_all.CoalSpiderEntity;
import dev.subortus.orespiders.entity.mobs.server.entities_all.DiamondSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DiamondSpiderRenderer extends MobRenderer<DiamondSpiderEntity, DiamondSpiderModel<DiamondSpiderEntity>> {
    public DiamondSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DiamondSpiderModel<>(pContext.bakeLayer(ModModelLayers.DIAMOND_SPIDER_LAYER)), 0.5f);
        this.addLayer(new DiamondSpiderEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(DiamondSpiderEntity pEntity) {
        return new ResourceLocation(OreSpidersMod.MOD_ID, "textures/entity/diamond/diamond_spider.png");
    }
}
