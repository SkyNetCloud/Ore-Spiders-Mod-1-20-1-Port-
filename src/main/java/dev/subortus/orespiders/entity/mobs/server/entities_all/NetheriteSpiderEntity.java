package dev.subortus.orespiders.entity.mobs.server.entities_all;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;


public class NetheriteSpiderEntity extends Spider {
    public NetheriteSpiderEntity(EntityType<? extends Spider> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(4, new NetheriteSpiderAttackGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new SpiderTargetGoal<>(this, Player.class));
        this.targetSelector.addGoal(3, new SpiderTargetGoal<>(this, IronGolem.class));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 70.0D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.2F) // Default Spider movement speed - 0.1
                .add(Attributes.ATTACK_DAMAGE, 9.0f)
                .add(Attributes.FOLLOW_RANGE, 20)  // Default Spider follow range + 4
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0f);
    }

    public static boolean checkNetheriteSpiderSpawnRules(EntityType<? extends Monster> pType, ServerLevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        boolean nearNetherite = pLevel.getBlockStates(new AABB(-7.5,-7.5,-7.5,7.5,7.5,7.5)).anyMatch(blockState -> blockState.is(Blocks.ANCIENT_DEBRIS));
        if (nearNetherite){
            return checkMobSpawnRules(pType, pLevel, pSpawnType, pPos, pRandom);
        } else {
            return false;
        }
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource pSource, int pLooting, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pSource, pLooting, pRecentlyHit);
        if(!this.level().isClientSide()){
            int ranNum = random.nextInt(2);
            int ammountToDrop = random.nextInt(3);
            int ammountToDropWithlootEnchant = pLooting * ammountToDrop;
            if(pLooting == 0){
                if(ranNum == 1){
                    int i = 0;
                    while(i <= ammountToDrop) {
                        this.spawnAtLocation(Items.NETHERITE_SCRAP);
                        i++;
                    }
                }
            } else {
                int i = 0;
                while(i > ammountToDropWithlootEnchant) {
                    this.spawnAtLocation(Items.NETHERITE_SCRAP);
                    i++;
                }
            }
            this.spawnAtLocation(Items.NETHERITE_SCRAP);
        }
    }

    static class NetheriteSpiderAttackGoal extends MeleeAttackGoal {
        public NetheriteSpiderAttackGoal(Spider pSpider) {
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
                pEnemy.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 200, 1, true, true, true));
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
