package com.clickme.animals.entity.water;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySwimming extends EntityLiving implements IAnimals {
    private double swimTargetX;
    private double swimTargetY;
    private double swimTargetZ;
    private Entity targetEntity;
    private boolean isAttacking;
    protected float swimRadius = 4.0F;
    protected float swimRadiusHeight = 4.0F;

    protected boolean isAgressive = false;
    protected int attackInterval = 50;
    protected float attackSpeed = 1.2F;

    protected float swimSpeed = 0.5F;
    protected boolean jumpOnLand = true;

    public EntitySwimming(World world) {
        super(world);
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public boolean isInWater() {
        return this.worldObj.handleMaterialAcceleration(this.boundingBox, Material.water, this);
    }

    public void onUpdate() {
        super.onUpdate();

        if (isInWater()) {
            this.motionY *= 0.1D;
        }
    }

    protected void updateAITasks() {
        super.updateAITasks();

        if (isInWater()) {
            double dx = this.swimTargetX - this.posX;
            double dy = this.swimTargetY - this.posY;
            double dz = this.swimTargetZ - this.posZ;
            double dist = MathHelper.sqrt_double(dx * dx + dy * dy + dz * dz);

            if ((dist < 1.0D) || (dist > 1000.0D)) {
                this.swimTargetX = (this.posX + (this.rand.nextFloat() * 2.0F - 1.0F) * this.swimRadius);
                this.swimTargetY = (this.posY + (this.rand.nextFloat() * 2.0F - 1.0F) * this.swimRadiusHeight);
                this.swimTargetZ = (this.posZ + (this.rand.nextFloat() * 2.0F - 1.0F) * this.swimRadius);
                this.isAttacking = false;
            }

            if (this.worldObj.getBlock(MathHelper.floor_double(this.swimTargetX), MathHelper.floor_double(
                    this.swimTargetY + this.height), MathHelper.floor_double(
                    this.swimTargetZ)).getMaterial() == Material.water) {

                this.motionX += dx / dist * 0.05D * this.swimSpeed;
                this.motionY += dy / dist * 0.1D * this.swimSpeed;
                this.motionZ += dz / dist * 0.05D * this.swimSpeed;
            } else {
                this.swimTargetX = this.posX;
                this.swimTargetY = (this.posY + 0.1D);
                this.swimTargetZ = this.posZ;
            }

            if (this.isAttacking) {
                this.motionX *= this.attackSpeed;
                this.motionY *= this.attackSpeed;
                this.motionZ *= this.attackSpeed;
            }
            if ((this.isAgressive) && (this.rand.nextInt(this.attackInterval) == 0)) {
                this.targetEntity = findPlayerToAttack();
                if ((this.targetEntity != null) && (this.targetEntity.isInWater())) {
                    this.swimTargetX = this.targetEntity.posX;
                    this.swimTargetY = this.targetEntity.posY;
                    this.swimTargetZ = this.targetEntity.posZ;
                    this.isAttacking = true;
                }
            }

            this.renderYawOffset += (-(float) Math.atan2(this.motionX, this.motionZ) * 180.0F / 3.1415927F - this.renderYawOffset) * 0.5F;
            this.rotationYaw = this.renderYawOffset;
            float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationPitch += ((float) Math.atan2(this.motionY, f) * 180.0F / 3.1415927F - this.rotationPitch) * 0.5F;
        } else {
            this.motionX = 0.0D;
            this.motionY -= 0.08D;
            this.motionY *= 0.9800000190734863D;
            this.motionZ = 0.0D;

            if ((this.jumpOnLand) && (this.onGround) && (this.rand.nextInt(30) == 0)) {
                this.motionY = 0.30000001192092896D;
                this.motionX = (-0.4F + this.rand.nextFloat() * 0.8F);
                this.motionZ = (-0.4F + this.rand.nextFloat() * 0.8F);
            }
        }
    }

    protected Entity findPlayerToAttack() {
        net.minecraft.entity.player.EntityPlayer player = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
        return (player != null) && (canEntityBeSeen(player)) ? player : null;
    }

    public void applyEntityCollision(Entity entity) {
        super.applyEntityCollision(entity);

        if ((this.isAgressive) && (this.targetEntity == entity)) {
            attackEntityAsMob(entity);
        }
    }

    public boolean attackEntityAsMob(Entity entity) {
        float f = (float) getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), f);
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public void onEntityUpdate() {
        int air = getAir();
        super.onEntityUpdate();

        if ((isEntityAlive()) && (!isInWater())) {
            air--;
            setAir(air);

            if (getAir() == -20) {
                setAir(0);
                attackEntityFrom(DamageSource.drown, 2.0F);
            }
        } else {
            setAir(300);
        }
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
    }

    public boolean getCanSpawnHere() {
        return this.worldObj.checkNoEntityCollision(this.boundingBox);
    }
}
