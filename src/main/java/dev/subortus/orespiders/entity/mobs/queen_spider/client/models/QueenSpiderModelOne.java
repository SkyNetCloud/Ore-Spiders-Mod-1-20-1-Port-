package dev.subortus.orespiders.entity.mobs.queen_spider.client.models;

import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseOneEntity;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseZeroEntity;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelPart;

public class QueenSpiderModelOne<T extends QueenSpiderPhaseOneEntity> extends SpiderModel<T> {
    public QueenSpiderModelOne(ModelPart pRoot) {
        super(pRoot);
    }
}
