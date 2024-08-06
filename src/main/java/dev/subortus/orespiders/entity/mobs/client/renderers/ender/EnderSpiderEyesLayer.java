package dev.subortus.orespiders.entity.mobs.client.renderers.ender;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.entity.mobs.client.models.all.EnderSpiderModel;
import dev.subortus.orespiders.entity.mobs.server.entities_all.EnderSpiderEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class EnderSpiderEyesLayer<T extends EnderSpiderEntity, M extends EnderSpiderModel<T>> extends EyesLayer<T, M> {
    private static final RenderType SPIDER_EYES = RenderType.eyes(new ResourceLocation(OreSpidersMod.MOD_ID,"textures/entity/ender/eyes_ender.png"));

    public EnderSpiderEyesLayer(RenderLayerParent<T, M> p_117507_) {
        super(p_117507_);
    }

    public RenderType renderType() {
        return SPIDER_EYES;
    }
}
