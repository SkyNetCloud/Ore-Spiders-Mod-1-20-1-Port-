package dev.subortus.orespiders.entity.mobs.queen_spider.server;

import dev.subortus.orespiders.entity.mobs.queen_spider.RegisterQueenSpider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class QueenSpiderPhaseTwoEntity extends Spider {
    public QueenSpiderPhaseTwoEntity(EntityType<? extends Spider> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    int upTickToHeal = 0;
    int healTicks = 60;

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(4, new QueenOneSpiderAttackGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new SpiderTargetGoal<>(this, Player.class));
        this.targetSelector.addGoal(3, new SpiderTargetGoal<>(this, IronGolem.class));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 100.0D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.6F) // Double Default Spider movement speed.
                .add(Attributes.ATTACK_DAMAGE, 9.0f);
    }

    @Override
    public void tick() {
        super.tick();

        if(this.getHealth() != 100.0D){
            if(this.healTicks <= this.upTickToHeal && !this.level().isClientSide()){
                this.upTickToHeal = 0;
                this.heal(2.5F);
            } else if (this.healTicks <= this.upTickToHeal && this.level().isClientSide()){
                for(int i = 0; i <= 5; i++){
                    this.level().addParticle(ParticleTypes.HEART, true, this.getX() + random.nextInt(-1,2) * (-0.65), this.getY() + 0.5D, this.getZ() + random.nextInt(-1,2) * (-0.65), 0.0D, 0.0D, 0.0D);
                }
                this.upTickToHeal = 0;
            }

            this.upTickToHeal += 1;
        }

        if(this.getHealth() < 25f){
            level().addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, this.getX() + random.nextInt(-1,2), this.getRandomY() + 0.25D,this.getZ() + random.nextInt(-1,2), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
            if(!this.level().isClientSide()){
                QueenSpiderPhaseThreeEntity entity = new QueenSpiderPhaseThreeEntity(RegisterQueenSpider.QUEEN_SPIDER_PHASE_THREE.get(), level());
                entity.setPos(this.getOnPos().getX(),this.getOnPos().getY() + 1,this.getOnPos().getZ());
                level().addFreshEntity(entity);
                this.discard();
            }
        }

    }

    static class QueenOneSpiderAttackGoal extends MeleeAttackGoal {
        public QueenOneSpiderAttackGoal(Spider pSpider) {
            super(pSpider, 1.0D, true);
        }

        @Override
        public boolean canUse() {
            return super.canUse() && !this.mob.isVehicle();
        }

        @Override
        public boolean canContinueToUse() {
            float f = this.mob.getLightLevelDependentMagicValue();
            if (f >= 0.5F && this.mob.getRandom().nextInt(100) == 0) {
                this.mob.setTarget((LivingEntity)null);
                return false;
            } else {
                return super.canContinueToUse();
            }
        }

        @Override
        protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
            double d0 = this.getAttackReachSqr(pEnemy);
            if (pDistToEnemySqr <= d0 && this.getTicksUntilNextAttack() <= 0) {
                this.resetAttackCooldown();
                this.mob.swing(InteractionHand.MAIN_HAND);
                this.mob.doHurtTarget(pEnemy);
                pEnemy.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1, true, true, true));
            }

        }

        @Override
        protected double getAttackReachSqr(LivingEntity pAttackTarget) {
            return (double)(4.0F + pAttackTarget.getBbWidth());
        }
    }

    static class SpiderTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
        public SpiderTargetGoal(Spider pSpider, Class<T> pEntityTypeToTarget) {
            super(pSpider, pEntityTypeToTarget, true);
        }
    }

}
