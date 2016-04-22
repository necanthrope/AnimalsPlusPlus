package com.clickme.animals.entity.ai;

import com.clickme.animals.entity.passive.EntityPenguin;

import java.util.Random;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.world.World;

public class EntityAIPenguinGlide extends EntityAIBase {
    private EntityPenguin thePenguin;
    private World theWorld;
    private int glidingTick;
    private int glidingTotal;

    public EntityAIPenguinGlide(EntityPenguin penguin) {
        this.thePenguin = penguin;
        this.theWorld = penguin.worldObj;
        setMutexBits(7);
    }

    public boolean shouldExecute() {
        return (!this.thePenguin.isGliding()) && (this.thePenguin.getRNG().nextInt(50) == 0);
    }

    public void startExecuting() {
        this.thePenguin.startGlide();
        this.glidingTotal = (this.glidingTick = 50 + this.thePenguin.getRNG().nextInt(100));
        this.theWorld.setEntityState(this.thePenguin, (byte) 10);
        this.thePenguin.getNavigator().clearPathEntity();
    }

    public void resetTask() {
        this.glidingTotal = (this.glidingTick = 0);
        this.theWorld.setEntityState(this.thePenguin, (byte) 11);
    }

    public boolean continueExecuting() {
        return isGliding();
    }

    public boolean isGliding() {
        return this.glidingTick > 0;
    }

    public float getGlideSpeed() {
        return this.glidingTick / (this.glidingTotal + 1);
    }

    public void updateTask() {
        this.glidingTick -= 1;
    }
}
