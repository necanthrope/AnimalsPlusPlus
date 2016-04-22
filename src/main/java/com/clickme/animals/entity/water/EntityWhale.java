package com.clickme.animals.entity.water;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityWhale extends EntitySwimming {
    public EntityWhale(World world) {
        super(world);
        setSize(10.0F, 4.0F);
        this.swimRadius = 64.0F;
        this.swimRadiusHeight = 8.0F;
        this.swimSpeed = 0.8F;
        this.jumpOnLand = false;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(net.minecraft.entity.SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
    }

    public boolean canBePushed() {
        return false;
    }

    protected String getLivingSound() {
        return "animals:mob.whale.say";
    }

    protected String getHurtSound() {
        return "animals:mob.whale.hurt";
    }

    protected String getDeathSound() {
        return "animals:mob.whale.death";
    }

    protected void dropFewItems(boolean flag, int i) {
        int k = 5 + this.rand.nextInt(15);
        if (i > 0)
            k += this.rand.nextInt(i + 1);
        for (int l = 0; l < k; l++) {
            dropItem(net.minecraft.init.Items.fish, 1);
        }
    }

    protected int getExperiencePoints(EntityPlayer entityplayer) {
        return 10 + this.worldObj.rand.nextInt(10);
    }
}
