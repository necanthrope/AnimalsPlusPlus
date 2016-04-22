package com.clickme.animals.entity.water;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityPiranha extends EntitySwimming {
    public EntityPiranha(World world) {
        super(world);
        setSize(0.4F, 0.4F);
        this.isAgressive = true;
        this.swimSpeed = 0.8F;
        this.attackSpeed = 1.1F;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(6.0D);
        getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
    }

    public void onUpdate() {
        if ((!this.worldObj.isRemote) && (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL)) {
            setDead();
        }
        super.onUpdate();
    }

    protected Entity findPlayerToAttack() {
        net.minecraft.entity.player.EntityPlayer player = (net.minecraft.entity.player.EntityPlayer) super.findPlayerToAttack();
        if (player != null) {
            return player;
        }
        AxisAlignedBB area = this.boundingBox.expand(16.0D, 6.0D, 16.0D);

        Entity fish = this.worldObj.findNearestEntityWithinAABB(EntityFish.class, area, this);
        if (fish != null) {
            return fish;
        }
        return this.worldObj.findNearestEntityWithinAABB(net.minecraft.entity.passive.EntityAnimal.class, area, this);
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
