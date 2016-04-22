package com.clickme.animals.entity.ai;

import com.clickme.animals.entity.passive.EntityBirdBase;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIFlying extends EntityAIBase {
    private EntityBirdBase theEntity;

    public EntityAIFlying(EntityBirdBase entitybird) {
        this.theEntity = entitybird;
        setMutexBits(5);
    }

    public boolean shouldExecute() {
        return this.theEntity.isFlying();
    }

    public boolean continueExecuting() {
        return this.theEntity.isFlying();
    }
}
