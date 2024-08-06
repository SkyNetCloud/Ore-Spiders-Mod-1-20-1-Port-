package dev.subortus.orespiders.entity.mobs.client.renderers.lapis;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.all.LapisSpiderModel;
import dev.subortus.orespiders.entity.mobs.server.entities_all.LapisSpiderEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class LapisSpiderEyesLayer<T extends LapisSpiderEntity, M extends LapisSpiderModel<T>> extends EyesLayer<T, M> {
    private static final RenderType SPIDER_EYES = RenderType.eyes(new ResourceLocation(OreSpidersMod.MOD_ID,"textures/entity/lapis/eyes_lapis.png"));

    public LapisSpiderEyesLayer(RenderLayerParent<T, M> p_117507_) {
        super(p_117507_);
    }

    public RenderType renderType() {
        return SPIDER_EYES;
    }
}
