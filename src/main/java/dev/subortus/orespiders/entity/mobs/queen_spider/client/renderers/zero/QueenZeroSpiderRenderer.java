package dev.subortus.orespiders.entity.mobs.queen_spider.client.renderers.zero;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.client.models.all.CoalSpiderModel;
import dev.subortus.orespiders.entity.mobs.queen_spider.client.models.QueenSpiderModelZero;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseZeroEntity;
import dev.subortus.orespiders.entity.mobs.server.entities_all.CoalSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class QueenZeroSpiderRenderer extends MobRenderer<QueenSpiderPhaseZeroEntity, QueenSpiderModelZero<QueenSpiderPhaseZeroEntity>> {
    public QueenZeroSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new QueenSpiderModelZero<>(pContext.bakeLayer(ModModelLayers.QUEEN_ZERO)), 0.5f);
        this.addLayer(new QueenZeroSpiderEyesLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(QueenSpiderPhaseZeroEntity pEntity) {
        return new ResourceLocation(OreSpidersMod.MOD_ID, "textures/entity/queen/body_queen_phase_0.png");
    }
}
