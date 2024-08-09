package dev.subortus.orespiders.entity.mobs.client.renderers.netherite;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.client.models.all.EnderSpiderModel;
import dev.subortus.orespiders.entity.mobs.client.models.all.NetheriteSpiderModel;
import dev.subortus.orespiders.entity.mobs.server.entities_all.EnderSpiderEntity;
import dev.subortus.orespiders.entity.mobs.server.entities_all.NetheriteSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class NetheriteSpiderRenderer extends MobRenderer<NetheriteSpiderEntity, NetheriteSpiderModel<NetheriteSpiderEntity>> {
    public NetheriteSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new NetheriteSpiderModel<>(pContext.bakeLayer(ModModelLayers.NETHERITE_SPIDER_LAYER)), 0.5f);
        this.addLayer(new NetheriteSpiderEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(NetheriteSpiderEntity pEntity) {
        return new ResourceLocation(OreSpidersMod.MOD_ID, "textures/entity/netherite/netherite_spider.png");
    }
}
