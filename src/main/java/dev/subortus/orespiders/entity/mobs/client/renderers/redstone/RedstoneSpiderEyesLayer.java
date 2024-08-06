package dev.subortus.orespiders.entity.mobs.client.renderers.redstone;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.all.RedstoneSpiderModel;
import dev.subortus.orespiders.entity.mobs.server.entities_all.RedstoneSpiderEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class RedstoneSpiderEyesLayer<T extends RedstoneSpiderEntity, M extends RedstoneSpiderModel<T>> extends EyesLayer<T, M> {
    private static final RenderType SPIDER_EYES = RenderType.eyes(new ResourceLocation(OreSpidersMod.MOD_ID,"textures/entity/redstone/eyes_redstone.png"));

    public RedstoneSpiderEyesLayer(RenderLayerParent<T, M> p_117507_) {
        super(p_117507_);
    }

    public RenderType renderType() {
        return SPIDER_EYES;
    }
}
