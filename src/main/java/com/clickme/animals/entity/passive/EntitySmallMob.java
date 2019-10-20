package com.clickme.animals.entity.passive;

import com.clickme.animals.AnimalsPlus;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class EntitySmallMob extends EntityCreature implements IAnimals {

    public boolean isPanicking = false;

    public int maxSpawnedInChunk = 2;

    public EntitySmallMob(World world) {
        super(world);
    }

    public boolean allowLeashing() {
        return false;
    }

    protected boolean interact(EntityPlayer entityplayer) {
        return false;
    }

    public boolean getCanSpawnHere() {
        return AnimalsPlus.isEntityOnNatureBlock(this);
    }

    @Override
    public int getMaxSpawnedInChunk()
    {
        return maxSpawnedInChunk;
    }
}

