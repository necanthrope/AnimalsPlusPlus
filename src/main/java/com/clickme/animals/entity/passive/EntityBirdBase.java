package com.clickme.animals.entity.passive;

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
}