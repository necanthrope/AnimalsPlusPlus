package com.clickme.animals.entity.ambient;

import com.clickme.animals.entity.ai.EntityAIAvoidScarecrow;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class EntityCricket extends EntityInsect {
    private int lastChirpTime;
    private float soundPitch;

    public EntityCricket(World world) {
        super(world);
        setSize(0.5F, 0.3F);
        getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAIAvoidScarecrow(this, Blocks.pumpkin, 6, 1.5D, 1.0D, 7, 16));
        this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityPlayer.class, 4.0F, 1.0D, 1.5D));
        this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
        this.soundPitch = (0.2F * (this.rand.nextFloat() - this.rand.nextFloat()));
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();


        if ((this.onGround) && (this.lastChirpTime++ >= 30)) {
            Float light = worldObj.getLightBrightness(
                    MathHelper.floor_double(this.posX),
                    MathHelper.floor_double(this.posY),
                    MathHelper.floor_double(this.posZ));
            float chirpChance = 1.0F - light;
            if(new Random().nextFloat() < chirpChance) {
                this.lastChirpTime = 0;
                playSound("animals:mob.cricket.chirp", 1.0F, 1.0F + this.soundPitch);
            }
        }
    }

    protected void updateAITasks() {
        super.updateAITasks();

        this.isJumping = (((this.onGround) && (Math.abs(this.motionX) > 0.01D)) || (Math.abs(this.motionZ) > 0.01D));
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

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(6.0D);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
    }

    public boolean getCanSpawnHere() {
        int y = MathHelper.floor_double(this.boundingBox.minY);
        int x = MathHelper.floor_double(this.posX);
        int z = MathHelper.floor_double(this.posZ);
        Block location = this.worldObj.getBlock(x, y, z);
        return (location.getClass() != Blocks.farmland.getClass());
    }
}
