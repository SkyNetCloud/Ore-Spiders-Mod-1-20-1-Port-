package dev.subortus.orespiders.entity.mobs.queen_spider.server;

import dev.subortus.orespiders.entity.mobs.queen_spider.RegisterQueenSpider;
import dev.subortus.orespiders.entity.mobs.server.ModEntities;
import dev.subortus.orespiders.entity.mobs.server.entities_all.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;
import java.util.List;
import java.util.Random;

public class QueenSpiderPhaseOneEntity extends Spider {

    private int upTickToSpawn = 0;
    private int numberSpawned= 0;

    public QueenSpiderPhaseOneEntity(EntityType<? extends Spider> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

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
                .add(Attributes.MAX_HEALTH, 198.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.6F) // Double Default Spider movement speed.
                .add(Attributes.ATTACK_DAMAGE, 9.0f);
    }

    @Override
    public void tick() {
        super.tick();
        if(!(numberSpawned >= 5)){ // Would have liked to use something more efficient then if if if if but forge is being stupid and refuses to let me.
            if(this.getTarget() != null && !this.level().isClientSide()){
                int spawnTicks = 240;
                if(spawnTicks <= upTickToSpawn){
                    upTickToSpawn = 0;
                    int theNum = random.nextInt(0,9);
                    switch(theNum){
                        case 0:{
                            CoalSpiderEntity entity = new CoalSpiderEntity(ModEntities.COAL_SPIDER_ENTITY.get(), this.level());
                            entity.setPos(summonCoords());
                            this.level().addFreshEntity(entity);
                            numberSpawned += 1;
                            break;
                        }
                        case 1: {
                            QuartzSpiderEntity entity = new QuartzSpiderEntity(ModEntities.QUARTZ_SPIDER_ENTITY.get(), this.level());
                            entity.setPos(summonCoords());
                            this.level().addFreshEntity(entity);
                            numberSpawned += 1;
                        }
                        case 2:{
                            LapisSpiderEntity entity = new LapisSpiderEntity(ModEntities.LAPIS_SPIDER_ENTITY.get(), this.level());
                            entity.setPos(summonCoords());
                            this.level().addFreshEntity(entity);
                            numberSpawned += 1;
                            break;
                        }
                        case 3:{
                            RedstoneSpiderEntity entity = new RedstoneSpiderEntity(ModEntities.REDSTONE_SPIDER_ENTITY.get(), this.level());
                            entity.setPos(summonCoords());
                            this.level().addFreshEntity(entity);
                            numberSpawned += 1;
                        }
                        case 4:{
                            EnderSpiderEntity entity = new EnderSpiderEntity(ModEntities.ENDER_SPIDER_ENTITY.get(), this.level());
                            entity.setPos(summonCoords());
                            this.level().addFreshEntity(entity);
                            numberSpawned += 1;
                            break;
                        }
                        case 5:{
                            GoldenSpiderEntity entity = new GoldenSpiderEntity(ModEntities.GOLDEN_SPIDER_ENTITY.get(), this.level());
                            entity.setPos(summonCoords());
                            this.level().addFreshEntity(entity);
                            numberSpawned += 1;
                        }
                        case 6:{
                            IronSpiderEntity entity = new IronSpiderEntity(ModEntities.IRON_SPIDER_ENTITY.get(), this.level());
                            entity.setPos(summonCoords());
                            this.level().addFreshEntity(entity);
                            numberSpawned += 1;
                            break;
                        }
                        case 7:{
                            EmeraldSpiderEntity entity = new EmeraldSpiderEntity(ModEntities.EMERALD_SPIDER_ENTITY.get(), this.level());
                            entity.setPos(summonCoords());
                            this.level().addFreshEntity(entity);
                            numberSpawned += 1;
                        }
                        case 8:{
                            DiamondSpiderEntity entity = new DiamondSpiderEntity(ModEntities.DIAMOND_SPIDER_ENTITY.get(), this.level());
                            entity.setPos(summonCoords());
                            this.level().addFreshEntity(entity);
                            numberSpawned += 1;
                            break;
                        }
                        case 9:{
                            ObsidianSpiderEntity entity = new ObsidianSpiderEntity(ModEntities.OBSIDIAN_SPIDER_ENTITY.get(), this.level());
                            entity.setPos(summonCoords());
                            this.level().addFreshEntity(entity);
                            numberSpawned += 1;
                        }
                        default:{
                            CoalSpiderEntity entity = new CoalSpiderEntity(ModEntities.COAL_SPIDER_ENTITY.get(), this.level());
                            entity.setPos(summonCoords());
                            this.level().addFreshEntity(entity);
                            numberSpawned += 1;
                            break;
                        }
                    }
                } else {
                    upTickToSpawn += 1;
                }
            }
        }
        if(this.getHealth() <= 100){
            level().addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, this.getRandomX(0.5D), this.getRandomY() + 0.25D, this.getRandomZ(0.5D), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
            if(!this.level().isClientSide()){
                QueenSpiderPhaseTwoEntity entity = new QueenSpiderPhaseTwoEntity(RegisterQueenSpider.QUEEN_SPIDER_PHASE_TWO.get(), level());
                entity.setPos(this.getOnPos().getX(),this.getOnPos().getY() + 1,this.getOnPos().getZ());
                level().addFreshEntity(entity);
                this.discard();
            }
        }

    }

    public Vec3 summonCoords(){
        Vec3 pos = new Vec3(this.getOnPos().getX() + random.nextInt(-4,4),this.getOnPos().getY() + 1,this.getOnPos().getZ()+ random.nextInt(-4,4));
        return pos;
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
            return 4.0F + pAttackTarget.getBbWidth();
        }
    }

    static class SpiderTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
        public SpiderTargetGoal(Spider pSpider, Class<T> pEntityTypeToTarget) {
            super(pSpider, pEntityTypeToTarget, true);
        }
    }

}
