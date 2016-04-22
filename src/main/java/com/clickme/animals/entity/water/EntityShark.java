package com.clickme.animals.entity.water;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityShark extends EntitySwimming {
    public EntityShark(World world) {
        super(world);
        setSize(2.0F, 0.7F);
        this.isAgressive = true;
        this.swimRadius = 16.0F;
        this.swimSpeed = 0.9F;
        this.attackInterval = 30;
        this.jumpOnLand = false;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
        getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
    }

    public void onUpdate() {
        if ((!this.worldObj.isRemote) && (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL)) {
            setDead();
        }

        super.onUpdate();
    }

    protected Entity findPlayerToAttack() {
        AxisAlignedBB area = this.boundingBox.expand(16.0D, 16.0D, 16.0D);

        EntityPlayer player = (EntityPlayer) super.findPlayerToAttack();
        if (player != null) {
            return player;
        }
        Entity fish = this.worldObj.findNearestEntityWithinAABB(EntityFish.class, area, this);
        if (fish != null) {
            return fish;
        }
        return this.worldObj.findNearestEntityWithinAABB(EntityAnimal.class, area, this);
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return null;
    }

    protected String getDeathSound() {
        return null;
    }

    public boolean getCanSpawnHere() {
        return (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) && (super.getCanSpawnHere());
    }
}
