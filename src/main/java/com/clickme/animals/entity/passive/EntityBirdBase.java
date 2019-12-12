package com.clickme.animals.entity.passive;

import com.clickme.animals.AnimalsPlus;
import net.minecraft.world.World;

public class EntityBirdBase extends EntitySmallMob {
    private boolean flying;

    public EntityBirdBase(World world) {
        super(world);
    }

    public boolean isFlying() {
        return this.flying;
    }

    public void setFlying(boolean flag) {
        this.flying = flag;
    }

    @Override
    public boolean getCanSpawnHere() {
        if (!super.getCanSpawnHere()) {
            return false;
        }
        return AnimalsPlus.isEntityOnNatureBlock(this);
    }

}