package dev.subortus.orespiders.entity.mobs.queen_spider.client.renderers.one;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.queen_spider.client.models.QueenSpiderModelOne;
import dev.subortus.orespiders.entity.mobs.queen_spider.client.models.QueenSpiderModelZero;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseOneEntity;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseZeroEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class QueenOneSpiderEyesLayer<T extends QueenSpiderPhaseOneEntity, M extends QueenSpiderModelOne<T>> extends EyesLayer<T, M> {
    private static final RenderType SPIDER_EYES = RenderType.eyes(new ResourceLocation(OreSpidersMod.MOD_ID,"textures/entity/queen/eyes_queen_phase_1.png"));

    public QueenOneSpiderEyesLayer(RenderLayerParent<T, M> p_117507_) {
        super(p_117507_);
    }

    public RenderType renderType() {
        return SPIDER_EYES;
    }
}
