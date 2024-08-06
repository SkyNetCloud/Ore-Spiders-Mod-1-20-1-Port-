package dev.subortus.orespiders.entity.mobs.client.renderers.coal;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.client.models.all.CoalSpiderModel;
import dev.subortus.orespiders.entity.mobs.server.entities_all.CoalSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CoalSpiderRenderer extends MobRenderer<CoalSpiderEntity, CoalSpiderModel<CoalSpiderEntity>> {
    public CoalSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CoalSpiderModel<>(pContext.bakeLayer(ModModelLayers.COAL_SPIDER_LAYER)), 0.5f);
        this.addLayer(new CoalSpiderEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(CoalSpiderEntity pEntity) {
        return new ResourceLocation(OreSpidersMod.MOD_ID, "textures/entity/coal/coal_spider.png");
    }
}
