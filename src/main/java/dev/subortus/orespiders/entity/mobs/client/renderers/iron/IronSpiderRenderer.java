package dev.subortus.orespiders.entity.mobs.client.renderers.iron;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.client.models.all.IronSpiderModel;
import dev.subortus.orespiders.entity.mobs.server.entities_all.IronSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class IronSpiderRenderer extends MobRenderer<IronSpiderEntity, IronSpiderModel<IronSpiderEntity>> {
    public IronSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new IronSpiderModel<>(pContext.bakeLayer(ModModelLayers.IRON_SPIDER_LAYER)), 0.5f);
        this.addLayer(new IronSpiderEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(IronSpiderEntity pEntity) {
        return new ResourceLocation(OreSpidersMod.MOD_ID, "textures/entity/iron/iron_spider.png");
    }
}
