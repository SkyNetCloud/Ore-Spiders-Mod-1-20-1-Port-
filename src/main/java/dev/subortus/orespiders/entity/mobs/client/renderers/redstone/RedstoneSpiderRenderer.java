package dev.subortus.orespiders.entity.mobs.client.renderers.redstone;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.client.models.all.QuartzSpiderModel;
import dev.subortus.orespiders.entity.mobs.client.models.all.RedstoneSpiderModel;
import dev.subortus.orespiders.entity.mobs.server.entities_all.QuartzSpiderEntity;
import dev.subortus.orespiders.entity.mobs.server.entities_all.RedstoneSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RedstoneSpiderRenderer extends MobRenderer<RedstoneSpiderEntity, RedstoneSpiderModel<RedstoneSpiderEntity>> {
    public RedstoneSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RedstoneSpiderModel<>(pContext.bakeLayer(ModModelLayers.REDSTONE_SPIDER_LAYER)), 0.5f);
        this.addLayer(new RedstoneSpiderEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(RedstoneSpiderEntity pEntity) {
        return new ResourceLocation(OreSpidersMod.MOD_ID, "textures/entity/redstone/redstone_spider.png");
    }
}
