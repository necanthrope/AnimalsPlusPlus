package com.clickme.animals.entity.passive;

import com.clickme.animals.entity.ai.EntityAIPenguinGlide;
import com.clickme.animals.event.AnimalsPlusPlusConfig;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.init.Items;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityPenguin extends EntitySmallMob {
    private boolean isGliding;
    private float glideVecX;
    private float glideVecZ;
    private float glideSpeed;
    private EntityAIPenguinGlide penguinGlideAi = new EntityAIPenguinGlide(this);

    public EntityPenguin(World world) {
        super(world);
        setSize(0.5F, 1.0F);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(2, new EntityAIWander(this, 0.8D));

        this.tasks.addTask(4, new EntityAIWatchClosest(this, net.minecraft.entity.player.EntityPlayer.class, 8.0F));
    }

    protected void updateAITasks() {
        this.isGliding = this.penguinGlideAi.isGliding();
        this.glideSpeed = this.penguinGlideAi.getGlideSpeed();
        super.updateAITasks();
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.isGliding) {
            if (!this.worldObj.isRemote) {
                this.motionX = (this.glideVecX * this.glideSpeed);
                this.motionZ = (this.glideVecZ * this.glideSpeed);
            }
            this.rotationYaw = ((float) Math.atan2(this.motionX, this.motionZ));
        }
    }

    public boolean isGliding() {
        return this.isGliding;
    }

    public void startGlide() {
        this.isGliding = true;
        float random = this.rand.nextFloat() * 3.1415927F * 2.0F;
        this.glideVecX = (MathHelper.cos(random) * 0.2F);
        this.glideVecZ = (MathHelper.sin(random) * 0.2F);
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte code) {
        if (code == 10)
            this.isGliding = true;
        if (code == 11) {
            this.isGliding = false;
        } else {
            super.handleHealthUpdate(code);
        }
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    protected String getLivingSound() {
        return "animals:mob.penguin.say";
    }

    protected String getHurtSound() {
        return "animals:mob.penguin.hurt";
    }

    protected String getDeathSound() {
        return null;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    protected void dropFewItems(boolean flag, int i) {
        int k = 1 + this.rand.nextInt(2);
        if (i > 0)
            k += this.rand.nextInt(i + 1);
        for (int l = 0; l < k; l++) {
            dropItem(Items.fish, 1);
        }
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
    }

    @Override
    public int getMaxSpawnedInChunk()
    {
        return AnimalsPlusPlusConfig.penguinSpawnRate;
    }
}
