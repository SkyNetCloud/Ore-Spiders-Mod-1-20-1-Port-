package dev.subortus.orespiders.entity.mobs.queen_spider.client.renderers.three;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.queen_spider.client.models.QueenSpiderModelThree;
import dev.subortus.orespiders.entity.mobs.queen_spider.client.models.QueenSpiderModelTwo;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseThreeEntity;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseTwoEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class QueenThreeSpiderRenderer extends MobRenderer<QueenSpiderPhaseThreeEntity, QueenSpiderModelThree<QueenSpiderPhaseThreeEntity>> {
    private static final float SCALE = 0.7F;

    public QueenThreeSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new QueenSpiderModelThree<>(pContext.bakeLayer(ModModelLayers.QUEEN_THREE)), SCALE * 0.5f);
        this.addLayer(new QueenThreeSpiderEyesLayer<>(this));
    }

    @Override
    protected void scale(QueenSpiderPhaseThreeEntity pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
        pPoseStack.scale(SCALE,SCALE,SCALE);
    }

    @Override
    public ResourceLocation getTextureLocation(QueenSpiderPhaseThreeEntity pEntity) {
        return new ResourceLocation(OreSpidersMod.MOD_ID, "textures/entity/queen/body_queen_phase_3.png");
    }
}
