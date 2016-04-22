package com.clickme.animals.entity.water;

import java.util.Random;

import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityFish extends EntitySwimming {
    public EntityFish(World world) {
        super(world);
        setSize(0.4F, 0.3F);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(net.minecraft.entity.SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(13, Byte.valueOf((byte) 0));
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

    protected void dropFewItems(boolean flag, int i) {
        if (this.rand.nextInt(2) == 0) {
            int type = getFishType() == 1 ? 1 : 0;
            entityDropItem(new net.minecraft.item.ItemStack(net.minecraft.init.Items.fish, 1, type), 0.0F);
        }
    }

    public int getFishType() {
        return this.dataWatcher.getWatchableObjectByte(13);
    }

    public void setFishType(int type) {
        this.dataWatcher.updateObject(13, Byte.valueOf((byte) type));
    }

    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setInteger("Type", getFishType());
    }

    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        setFishType(tag.getInteger("Type"));
    }

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        setFishType(getRNG().nextInt(2));
        return data;
    }
}