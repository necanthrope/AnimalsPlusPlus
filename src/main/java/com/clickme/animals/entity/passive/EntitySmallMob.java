package com.clickme.animals.entity.passive;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class EntitySmallMob extends EntityCreature implements IAnimals {
    public EntitySmallMob(World world) {
        super(world);
    }

    public boolean allowLeashing() {
        return false;
    }

    protected boolean interact(EntityPlayer entityplayer) {
        return false;
    }
}

