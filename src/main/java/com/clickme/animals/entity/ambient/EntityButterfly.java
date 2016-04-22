package com.clickme.animals.entity.ambient;

import com.clickme.animals.entity.passive.EntityWingedBug;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityButterfly extends EntityWingedBug {
    public EntityButterfly(World world) {
        super(world);
        setSize(0.5F, 0.2F);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.0D);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(13, Byte.valueOf((byte) 0));
    }

    protected boolean isAIEnabled() {
        return true;
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

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("Type", getButterflyType());
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        setButterflyType(par1NBTTagCompound.getInteger("Type"));
    }

    public int getButterflyType() {
        return this.dataWatcher.getWatchableObjectByte(13);
    }

    public void setButterflyType(int i) {
        this.dataWatcher.updateObject(13, Byte.valueOf((byte) i));
    }

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData ientitylivingdata) {
        setButterflyType(getRNG().nextInt(2));
        return super.onSpawnWithEgg(ientitylivingdata);
    }
}