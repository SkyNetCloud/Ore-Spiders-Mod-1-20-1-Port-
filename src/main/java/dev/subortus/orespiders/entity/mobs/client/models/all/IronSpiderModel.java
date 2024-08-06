package dev.subortus.orespiders.entity.mobs.client.models.all;

import dev.subortus.orespiders.entity.mobs.server.entities_all.CoalSpiderEntity;
import dev.subortus.orespiders.entity.mobs.server.entities_all.IronSpiderEntity;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelPart;

public class IronSpiderModel<T extends IronSpiderEntity> extends SpiderModel<T> {
    public IronSpiderModel(ModelPart pRoot) {
        super(pRoot);
    }
}
