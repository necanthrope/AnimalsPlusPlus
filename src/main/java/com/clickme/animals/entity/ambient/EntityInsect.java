package com.clickme.animals.entity.ambient;

import com.clickme.animals.AnimalsPlus;
import com.clickme.animals.entity.passive.EntitySmallMob;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class EntityInsect extends EntitySmallMob implements IAnimals {
    public EntityInsect(World world) {
        super(world);
        getNavigator().setAvoidsWater(true);
    }

    public boolean canBePushed() {
        return false;
    }

    protected void collideWithEntity(Entity entity) {
    }

    protected void collideWithNearbyEntities() {
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ARTHROPOD;
    }

    public boolean allowLeashing() {
        return false;
    }

    protected boolean interact(EntityPlayer entityplayer) {
        return false;
    }

    public boolean getCanSpawnHere() {
    	if(!super.getCanSpawnHere()) {
    	    return false;
        }

        int y = MathHelper.floor_double(this.boundingBox.minY);
        int x = MathHelper.floor_double(this.posX);
        int z = MathHelper.floor_double(this.posZ);
        if (!this.worldObj.canBlockSeeTheSky(x, y, z)) {
            return false;
        }
        return this.worldObj.getWorldInfo().getTerrainType() == net.minecraft.world.WorldType.FLAT ? false : super.getCanSpawnHere();
    }
}

