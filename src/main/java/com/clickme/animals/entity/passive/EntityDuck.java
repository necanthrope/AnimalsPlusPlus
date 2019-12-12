package com.clickme.animals.entity.passive;

import com.clickme.animals.AnimalsPlus;
import com.clickme.animals.event.AnimalsPlusPlusConfig;
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

    @Override
    public boolean getCanSpawnHere() {
        if (!super.getCanSpawnHere()) {
            return false;
        }
        return AnimalsPlus.isEntityOnNatureBlock(this);
    }

    @Override
    public int getMaxSpawnedInChunk()
    {
        return AnimalsPlusPlusConfig.duckSpawnRate;
    }

}