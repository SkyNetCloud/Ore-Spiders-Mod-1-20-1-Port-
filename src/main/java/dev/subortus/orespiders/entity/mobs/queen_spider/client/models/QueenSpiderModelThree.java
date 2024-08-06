package dev.subortus.orespiders.entity.mobs.queen_spider.client.models;

import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseOneEntity;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseThreeEntity;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelPart;

public class QueenSpiderModelThree<T extends QueenSpiderPhaseThreeEntity> extends SpiderModel<T> {
    public QueenSpiderModelThree(ModelPart pRoot) {
        super(pRoot);
    }
}
