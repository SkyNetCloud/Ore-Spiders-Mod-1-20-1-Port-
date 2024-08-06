package dev.subortus.orespiders.entity.mobs.queen_spider.client.models;

import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseZeroEntity;
import dev.subortus.orespiders.entity.mobs.server.entities_all.CoalSpiderEntity;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelPart;

public class QueenSpiderModelZero<T extends QueenSpiderPhaseZeroEntity> extends SpiderModel<T> {
    public QueenSpiderModelZero(ModelPart pRoot) {
        super(pRoot);
    }
}
