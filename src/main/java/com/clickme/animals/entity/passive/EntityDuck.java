package com.clickme.animals.entity.passive;

import com.clickme.animals.AnimalsPlus;
import net.minecraft.world.World;

public class EntityDuck extends net.minecraft.entity.passive.EntityChicken {
    public EntityDuck(World world) {
        super(world);
    }

    protected String getLivingSound() {
        return "animals:mob.duck.say";
    }

    protected String getHurtSound() {
        return "animals:mob.duck.hurt";
    }

    protected String getDeathSound() {
        return "animals:mob.duck.hurt";
    }

    public boolean getCanSpawnHere() {
        if (!super.getCanSpawnHere()) {
            return false;
        }
        return AnimalsPlus.isEntityOnNatureBlock(this);
    }

}