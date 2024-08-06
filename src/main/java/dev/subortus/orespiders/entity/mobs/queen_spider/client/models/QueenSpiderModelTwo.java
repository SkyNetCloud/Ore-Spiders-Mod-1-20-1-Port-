package dev.subortus.orespiders.entity.mobs.queen_spider.client.models;

import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseOneEntity;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseTwoEntity;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelPart;

public class QueenSpiderModelTwo<T extends QueenSpiderPhaseTwoEntity> extends SpiderModel<T> {
    public QueenSpiderModelTwo(ModelPart pRoot) {
        super(pRoot);
    }
}
