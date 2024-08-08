package dev.subortus.orespiders.entity.mobs.server.projectiles;

import dev.subortus.orespiders.entity.mobs.server.ModEntities;
import dev.subortus.orespiders.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class OrbWeaverProjectile extends ThrowableItemProjectile {
    public OrbWeaverProjectile(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public OrbWeaverProjectile(Level pLevel, LivingEntity pShooter) {
        super(ModEntities.ORB_WEAVER_PROJECTILE.get(), pShooter, pLevel);
    }

    public OrbWeaverProjectile(Level pLevel, double pX, double pY, double pZ) {
        super(EntityType.SNOWBALL, pX, pY, pZ, pLevel);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        if(!this.level().isClientSide()){
            this.level().broadcastEntityEvent(this, (byte)3);
            this.level().setBlock(this.blockPosition(),Blocks.COBWEB.defaultBlockState(),3);
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if(!this.level().isClientSide()){
            this.level().broadcastEntityEvent(this, (byte)3);
            int rand = random.nextInt(0, 2);
            if(rand == 0 && this.level().getBlockState(pResult.getEntity().getOnPos()).is(Blocks.AIR)){ // Stop this block from destroying bedrock.
                this.level().setBlock(pResult.getEntity().getOnPos(),Blocks.COBWEB.defaultBlockState(),3);
            } else if (rand == 1 && this.level().getBlockState(pResult.getEntity().getOnPos().above(1)).is(Blocks.AIR)){
                this.level().setBlock(pResult.getEntity().getOnPos().above(1),Blocks.COBWEB.defaultBlockState(),3);
            }
            this.discard();
        }
    }

    @Override
    public void tick() {
        super.tick();
        this.level().addParticle(ParticleTypes.PORTAL, this.getRandomX(0.5D), this.getRandomY() + 0.25D, this.getRandomZ(0.5D), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.ORB_WEAVER_PROJECTILE.get();
    }
}
