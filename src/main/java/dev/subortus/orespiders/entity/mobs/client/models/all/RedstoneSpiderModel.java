package dev.subortus.orespiders.entity.mobs.client.models.all;

import dev.subortus.orespiders.entity.mobs.server.entities_all.CoalSpiderEntity;
import dev.subortus.orespiders.entity.mobs.server.entities_all.RedstoneSpiderEntity;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelPart;

public class RedstoneSpiderModel<T extends RedstoneSpiderEntity> extends SpiderModel<T> {
    public RedstoneSpiderModel(ModelPart pRoot) {
        super(pRoot);
    }
}
