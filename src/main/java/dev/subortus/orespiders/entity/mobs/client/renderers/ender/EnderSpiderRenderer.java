package dev.subortus.orespiders.entity.mobs.client.renderers.ender;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.client.models.all.EnderSpiderModel;
import dev.subortus.orespiders.entity.mobs.server.entities_all.EnderSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EnderSpiderRenderer extends MobRenderer<EnderSpiderEntity, EnderSpiderModel<EnderSpiderEntity>> {
    public EnderSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new EnderSpiderModel<>(pContext.bakeLayer(ModModelLayers.ENDER_SPIDER_LAYER)), 0.5f);
        this.addLayer(new EnderSpiderEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EnderSpiderEntity pEntity) {
        return new ResourceLocation(OreSpidersMod.MOD_ID, "textures/entity/ender/ender_spider.png");
    }
}
