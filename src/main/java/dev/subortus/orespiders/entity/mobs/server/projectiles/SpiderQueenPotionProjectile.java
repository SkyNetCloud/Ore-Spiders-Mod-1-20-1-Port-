package dev.subortus.orespiders.entity.mobs.server.projectiles;

import dev.subortus.orespiders.entity.mobs.queen_spider.RegisterQueenSpider;
import dev.subortus.orespiders.entity.mobs.queen_spider.server.QueenSpiderPhaseZeroEntity;
import dev.subortus.orespiders.entity.mobs.server.ModEntities;
import dev.subortus.orespiders.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class SpiderQueenPotionProjectile extends ThrowableItemProjectile {
    public SpiderQueenPotionProjectile(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SpiderQueenPotionProjectile(Level pLevel) {
        super(ModEntities.SQPP_POTION.get(), pLevel);
    }

    public SpiderQueenPotionProjectile(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.SQPP_POTION.get(), livingEntity, pLevel);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        this.level().playSound(this,pResult.getBlockPos(),SoundEvents.SPLASH_POTION_BREAK,SoundSource.PLAYERS, 1.0f, 1.0f);
        if(!this.level().isClientSide()){
            this.level().broadcastEntityEvent(this, ((byte) 3));
            this.level().levelEvent(2002, this.blockPosition(), PotionUtils.getColor(Potions.HARMING));
            QueenSpiderPhaseZeroEntity entity = new QueenSpiderPhaseZeroEntity(RegisterQueenSpider.QUEEN_SPIDER_PHASE_ZERO.get(), level());
            entity.setPos(pResult.getBlockPos().getX(),pResult.getBlockPos().getY() + 1,pResult.getBlockPos().getZ());
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, pResult.getBlockPos(), GameEvent.Context.of(this, this.level().getBlockState(pResult.getBlockPos())));
            level().addFreshEntity(entity);
        }
        this.discard();
    }

    @Override
    public void tick() {
        super.tick();
        this.level().addParticle(ParticleTypes.PORTAL, this.getRandomX(0.5D), this.getRandomY() + 0.25D, this.getRandomZ(0.5D), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.MYSTERIOUS_POTION.get();
    }
}
