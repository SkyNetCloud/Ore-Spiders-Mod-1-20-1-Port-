package dev.subortus.orespiders.entity.mobs.queen_spider.client.renderers.two;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.ModModelLayers;
import dev.subortus.orespiders.entity.mobs.queen_spider.client.models.QueenSpiderModelOne;
import dev.subortus.orespiders.entity.mobs.queen_spider.client.models.QueenSpiderModelTwo;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseOneEntity;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseTwoEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class QueenTwoSpiderRenderer extends MobRenderer<QueenSpiderPhaseTwoEntity, QueenSpiderModelTwo<QueenSpiderPhaseTwoEntity>> {
    private static final float SCALE = 1.4F;

    public QueenTwoSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new QueenSpiderModelTwo<>(pContext.bakeLayer(ModModelLayers.QUEEN_TWO)), SCALE * 0.5f);
        this.addLayer(new QueenTwoSpiderEyesLayer<>(this));
    }

    @Override
    protected void scale(QueenSpiderPhaseTwoEntity pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
        pPoseStack.scale(SCALE,SCALE,SCALE);
    }

    @Override
    public ResourceLocation getTextureLocation(QueenSpiderPhaseTwoEntity pEntity) {
        return new ResourceLocation(OreSpidersMod.MOD_ID, "textures/entity/queen/body_queen_phase_2.png");
    }
}
