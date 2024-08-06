package dev.subortus.orespiders.entity.mobs.queen_spider.client.renderers.one;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.queen_spider.client.models.QueenSpiderModelOne;
import dev.subortus.orespiders.entity.mobs.queen_spider.client.models.QueenSpiderModelZero;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseOneEntity;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseZeroEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class QueenOneSpiderRenderer extends MobRenderer<QueenSpiderPhaseOneEntity, QueenSpiderModelOne<QueenSpiderPhaseOneEntity>> {
    private static final float SCALE = 1.7F;

    public QueenOneSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new QueenSpiderModelOne<>(pContext.bakeLayer(ModModelLayers.QUEEN_ONE)), SCALE * 0.5f);
        this.addLayer(new QueenOneSpiderEyesLayer<>(this));
    }

    @Override
    protected void scale(QueenSpiderPhaseOneEntity pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
        pPoseStack.scale(SCALE,SCALE,SCALE);
    }

    @Override
    public ResourceLocation getTextureLocation(QueenSpiderPhaseOneEntity pEntity) {
        return new ResourceLocation(OreSpidersMod.MOD_ID, "textures/entity/queen/body_queen_phase_1.png");
    }
}
