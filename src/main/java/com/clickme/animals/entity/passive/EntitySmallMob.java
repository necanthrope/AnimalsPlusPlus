package com.clickme.animals.entity.passive;

import com.clickme.animals.AnimalsPlus;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class EntitySmallMob extends EntityCreature implements IAnimals {

    public boolean isPanicking = false;

    public EntitySmallMob(World world) {
        super(world);
    }

    public boolean allowLeashing() {
        return false;
    }

    protected boolean interact(EntityPlayer entityplayer) {
        return false;
    }

    @Override
    public boolean getCanSpawnHere() {
        if (!super.getCanSpawnHere()) {
            return false;
        }
        return AnimalsPlus.isEntityOnNatureBlock(this);
    }

}

