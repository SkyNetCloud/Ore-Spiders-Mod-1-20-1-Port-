package dev.subortus.orespiders.entity.mobs.client.renderers.glowstone;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.all.CoalSpiderModel;
import dev.subortus.orespiders.entity.mobs.client.models.all.GlowstoneSpiderModel;
import dev.subortus.orespiders.entity.mobs.server.entities_all.CoalSpiderEntity;
import dev.subortus.orespiders.entity.mobs.server.entities_all.GlowstoneSpiderEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class GlowstoneSpiderEyesLayer<T extends GlowstoneSpiderEntity, M extends GlowstoneSpiderModel<T>> extends EyesLayer<T, M> {
    private static final RenderType SPIDER_EYES = RenderType.eyes(new ResourceLocation(OreSpidersMod.MOD_ID,"textures/entity/glowstone/eyes_glowstone.png"));

    public GlowstoneSpiderEyesLayer(RenderLayerParent<T, M> p_117507_) {
        super(p_117507_);
    }

    public RenderType renderType() {
        return SPIDER_EYES;
    }
}
