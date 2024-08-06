package dev.subortus.orespiders.entity.mobs.client.renderers.obsidian;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.client.models.all.CoalSpiderModel;
import dev.subortus.orespiders.entity.mobs.client.models.all.ObsidianSpiderModel;
import dev.subortus.orespiders.entity.mobs.server.entities_all.CoalSpiderEntity;
import dev.subortus.orespiders.entity.mobs.server.entities_all.ObsidianSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ObsidianSpiderRenderer extends MobRenderer<ObsidianSpiderEntity, ObsidianSpiderModel<ObsidianSpiderEntity>> {
    public ObsidianSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ObsidianSpiderModel<>(pContext.bakeLayer(ModModelLayers.OBSIDIAN_SPIDER_LAYER)), 0.5f);
        this.addLayer(new ObsidianSpiderEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(ObsidianSpiderEntity pEntity) {
        return new ResourceLocation(OreSpidersMod.MOD_ID, "textures/entity/obsidian/obsidian_spider.png");
    }
}
