package dev.subortus.orespiders.entity.mobs.client.models.all;

import dev.subortus.orespiders.entity.mobs.server.entities_all.EnderSpiderEntity;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelPart;

public class EnderSpiderModel<T extends EnderSpiderEntity> extends SpiderModel<T> {
    public EnderSpiderModel(ModelPart pRoot) {
        super(pRoot);
    }
}
