package com.clickme.animals.entity.passive;

import java.util.Random;

import com.clickme.animals.event.AnimalsPlusPlusConfig;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntitySnake extends EntitySmallMob {
    public int snakeLenght = 12;

    public float[] ringBuffer = new float[32];
    public int ringBufferIndex = -1;
    private float slitherAnimTime;

    public EntitySnake(World world) {
        super(world);
        setSize(1.4F, 0.2F);

        getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new net.minecraft.entity.ai.EntityAIAttackOnCollide(this, 1.5D, true));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.targetTasks.addTask(1, new net.minecraft.entity.ai.EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, net.minecraft.entity.player.EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityMouse.class, 0, false));
    }

    protected boolean isAIEnabled() {
        return true;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(12.0D);
        getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(4.0D);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(13, Byte.valueOf((byte) 0));
    }

    public float getRotationForPart(int part) {
        return this.ringBuffer[(this.ringBufferIndex - part & 0xF)] - this.rotationYaw;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.ringBufferIndex < 0) {
            for (int i = 0; i < this.ringBuffer.length; i++) {
                this.ringBuffer[i] = this.rotationYaw;
                this.ringBuffer[i] += MathHelper.sin(this.slitherAnimTime * 1.0F) * 80.0F;
                this.slitherAnimTime += 1.0F;
            }
            this.ringBufferIndex += 1;
        }

        if ((this.posX != this.prevPosX) || (this.posY != this.prevPosY) || (this.posZ != this.prevPosZ)) {
            if (++this.ringBufferIndex == this.ringBuffer.length) {
                this.ringBufferIndex = 0;
            }
            this.ringBuffer[this.ringBufferIndex] = this.rotationYaw;

            this.ringBuffer[this.ringBufferIndex] += MathHelper.sin(this.slitherAnimTime * 1.0F) * 80.0F;
            this.slitherAnimTime += 1.0F;
        }
    }

    public boolean attackEntityAsMob(Entity entity) {
        if (entity.attackEntityFrom(net.minecraft.util.DamageSource.causeMobDamage(this), 4.0F)) {
            if ((entity instanceof EntityLivingBase)) {
                byte lenght = 5;

                if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                    lenght = 15;
                } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                    lenght = 25;
                }

                ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.poison.id, lenght * 20, 0));
            }

            return true;
        }
        return false;
    }


    protected float getSoundVolume() {
        return 0.2F;
    }

    protected String getLivingSound() {
        return "animals:mob.snake.hiss";
    }

    protected String getHurtSound() {
        return "animals:mob.snake.hurt";
    }

    protected String getDeathSound() {
        return "animals:mob.snake.death";
    }

    public boolean isPotionApplicable(PotionEffect potion) {
        return potion.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(potion);
    }

    public int getSnakeType() {
        return this.dataWatcher.getWatchableObjectByte(13);
    }

    public void setSnakeType(int type) {
        this.dataWatcher.updateObject(13, Byte.valueOf((byte) type));
    }

    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setInteger("Type", getSnakeType());
    }

    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        setSnakeType(tag.getInteger("Type"));
    }

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        setSnakeType(getRNG().nextInt(3));
        return data;
    }

    @Override
    public int getMaxSpawnedInChunk()
    {
        return AnimalsPlusPlusConfig.snakeSpawnRate;
    }
}
