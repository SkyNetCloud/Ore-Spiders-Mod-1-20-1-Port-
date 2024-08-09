package dev.subortus.orespiders.entity.mobs.client.models.all;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.subortus.orespiders.entity.mobs.server.entities_all.CoalSpiderEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class CoalSpiderModel<T extends CoalSpiderEntity> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart rightHindLeg;
    private final ModelPart leftHindLeg;
    private final ModelPart rightMiddleHindLeg;
    private final ModelPart leftMiddleHindLeg;
    private final ModelPart rightMiddleFrontLeg;
    private final ModelPart leftMiddleFrontLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart leftFrontLeg;
    private final ModelPart crystals;
    private final ModelPart extra_crystal;

    public CoalSpiderModel(ModelPart pRoot) {
        this.root = pRoot;
        this.head = pRoot.getChild("head");
        this.rightHindLeg = pRoot.getChild("right_hind_leg");
        this.leftHindLeg = pRoot.getChild("left_hind_leg");
        this.rightMiddleHindLeg = pRoot.getChild("right_middle_hind_leg");
        this.leftMiddleHindLeg = pRoot.getChild("left_middle_hind_leg");
        this.rightMiddleFrontLeg = pRoot.getChild("right_middle_front_leg");
        this.leftMiddleFrontLeg = pRoot.getChild("left_middle_front_leg");
        this.rightFrontLeg = pRoot.getChild("right_front_leg");
        this.leftFrontLeg = pRoot.getChild("left_front_leg");
        this.crystals = pRoot.getChild("crystals");
        this.extra_crystal = pRoot.getChild("extra_crystal");
    }

    public static LayerDefinition createCoalSpiderBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        int i = 15;
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 4).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 15.0F, -3.0F));
        partdefinition.addOrReplaceChild("body0", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 15.0F, 0.0F));
        partdefinition.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(0, 12).addBox(-5.0F, -4.0F, -6.0F, 10.0F, 8.0F, 12.0F), PartPose.offset(0.0F, 15.0F, 9.0F));
        CubeListBuilder cubelistbuilder = CubeListBuilder.create().texOffs(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F);
        CubeListBuilder cubelistbuilder1 = CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F);
        partdefinition.addOrReplaceChild("right_hind_leg", cubelistbuilder, PartPose.offset(-4.0F, 15.0F, 2.0F));
        partdefinition.addOrReplaceChild("left_hind_leg", cubelistbuilder1, PartPose.offset(4.0F, 15.0F, 2.0F));
        partdefinition.addOrReplaceChild("right_middle_hind_leg", cubelistbuilder, PartPose.offset(-4.0F, 15.0F, 1.0F));
        partdefinition.addOrReplaceChild("left_middle_hind_leg", cubelistbuilder1, PartPose.offset(4.0F, 15.0F, 1.0F));
        partdefinition.addOrReplaceChild("right_middle_front_leg", cubelistbuilder, PartPose.offset(-4.0F, 15.0F, 0.0F));
        partdefinition.addOrReplaceChild("left_middle_front_leg", cubelistbuilder1, PartPose.offset(4.0F, 15.0F, 0.0F));
        partdefinition.addOrReplaceChild("right_front_leg", cubelistbuilder, PartPose.offset(-4.0F, 15.0F, -1.0F));
        partdefinition.addOrReplaceChild("left_front_leg", cubelistbuilder1, PartPose.offset(4.0F, 15.0F, -1.0F));

        PartDefinition crystals = partdefinition.addOrReplaceChild("crystals", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 11.0F, 12.0F, -0.4215F, -0.3614F, 0.1572F));
                                                                                                                                                    // -0.1768
        PartDefinition crystal_medium = crystals.addOrReplaceChild("crystal_medium", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.18F, 6.1913F, -14.4268F, 1.5646F, 0.4399F, 1.4134F));

        PartDefinition cube_r1 = crystal_medium.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(56, 26).addBox(1.2031F, -0.3929F, -1.6133F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.55F, 1.3F, 1.95F, -3.1416F, 1.2217F, 2.8798F));

        PartDefinition cube_r2 = crystal_medium.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(56, 26).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8F, 0.3F, 1.95F, 0.6109F, 1.0036F, -0.2618F));

        PartDefinition cube_r3 = crystal_medium.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(56, 26).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 4.05F, 0.45F, 0.0F, 0.0F, -0.0436F));

        PartDefinition cube_r4 = crystal_medium.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(56, 26).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8F, 0.8F, 1.2F, 0.0F, 0.0F, -0.0436F));

        PartDefinition cube_r5 = crystal_medium.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(56, 26).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.55F, 4.05F, -0.05F, 0.0F, 0.0F, -0.0436F));

        PartDefinition cube_r6 = crystal_medium.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(56, 26).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, 4.55F, 0.7F, 0.0F, 0.0F, -0.0436F));

        PartDefinition cube_r7 = crystal_medium.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(53, 24).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -0.25F, 0.4355F, 0.9036F, 0.6443F));

        PartDefinition cube_r8 = crystal_medium.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(53, 25).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -0.0876F, -0.0869F, 0.2258F));

        PartDefinition cube_r9 = crystal_medium.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(53, 21).addBox(-2.0F, -5.0F, 0.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.4F, -1.0F, 0.0F, 0.0F, -0.2182F));

        PartDefinition crystal_large = crystals.addOrReplaceChild("crystal_large", CubeListBuilder.create(), PartPose.offset(1.0F, 0.0F, 0.0F));

        PartDefinition cube_r10 = crystal_large.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(48, 22).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -0.25F, 0.4355F, 0.9036F, 0.6443F));

        PartDefinition cube_r11 = crystal_large.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(48, 23).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -0.0876F, -0.0869F, 0.2258F));

        PartDefinition cube_r12 = crystal_large.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(48, 21).addBox(-3.0F, -5.0F, -1.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.4F, -1.0F, 0.0F, 0.0F, -0.2182F));

        PartDefinition extra_crystal = partdefinition.addOrReplaceChild("extra_crystal", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r13 = extra_crystal.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(48, 28).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, -6.0F, 3.15F, 0.42F, 0.3516F, -0.4516F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    public ModelPart root() {
        return this.root;
    }

    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
        float f = ((float)Math.PI / 4F);
        this.rightHindLeg.zRot = (-(float)Math.PI / 4F);
        this.leftHindLeg.zRot = ((float)Math.PI / 4F);
        this.rightMiddleHindLeg.zRot = -0.58119464F;
        this.leftMiddleHindLeg.zRot = 0.58119464F;
        this.rightMiddleFrontLeg.zRot = -0.58119464F;
        this.leftMiddleFrontLeg.zRot = 0.58119464F;
        this.rightFrontLeg.zRot = (-(float)Math.PI / 4F);
        this.leftFrontLeg.zRot = ((float)Math.PI / 4F);
        float f1 = -0.0F;
        float f2 = ((float)Math.PI / 8F);
        this.rightHindLeg.yRot = ((float)Math.PI / 4F);
        this.leftHindLeg.yRot = (-(float)Math.PI / 4F);
        this.rightMiddleHindLeg.yRot = ((float)Math.PI / 8F);
        this.leftMiddleHindLeg.yRot = (-(float)Math.PI / 8F);
        this.rightMiddleFrontLeg.yRot = (-(float)Math.PI / 8F);
        this.leftMiddleFrontLeg.yRot = ((float)Math.PI / 8F);
        this.rightFrontLeg.yRot = (-(float)Math.PI / 4F);
        this.leftFrontLeg.yRot = ((float)Math.PI / 4F);
        float f3 = -(Mth.cos(pLimbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * pLimbSwingAmount;
        float f4 = -(Mth.cos(pLimbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * pLimbSwingAmount;
        float f5 = -(Mth.cos(pLimbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * pLimbSwingAmount;
        float f6 = -(Mth.cos(pLimbSwing * 0.6662F * 2.0F + ((float)Math.PI * 1.5F)) * 0.4F) * pLimbSwingAmount;
        float f7 = Math.abs(Mth.sin(pLimbSwing * 0.6662F + 0.0F) * 0.4F) * pLimbSwingAmount;
        float f8 = Math.abs(Mth.sin(pLimbSwing * 0.6662F + (float)Math.PI) * 0.4F) * pLimbSwingAmount;
        float f9 = Math.abs(Mth.sin(pLimbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * pLimbSwingAmount;
        float f10 = Math.abs(Mth.sin(pLimbSwing * 0.6662F + ((float)Math.PI * 1.5F)) * 0.4F) * pLimbSwingAmount;
        this.rightHindLeg.yRot += f3;
        this.leftHindLeg.yRot += -f3;
        this.rightMiddleHindLeg.yRot += f4;
        this.leftMiddleHindLeg.yRot += -f4;
        this.rightMiddleFrontLeg.yRot += f5;
        this.leftMiddleFrontLeg.yRot += -f5;
        this.rightFrontLeg.yRot += f6;
        this.leftFrontLeg.yRot += -f6;
        this.rightHindLeg.zRot += f7;
        this.leftHindLeg.zRot += -f7;
        this.rightMiddleHindLeg.zRot += f8;
        this.leftMiddleHindLeg.zRot += -f8;
        this.rightMiddleFrontLeg.zRot += f9;
        this.leftMiddleFrontLeg.zRot += -f9;
        this.rightFrontLeg.zRot += f10;
        this.leftFrontLeg.zRot += -f10;
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        super.renderToBuffer(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);

        crystals.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
        extra_crystal.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }
}
