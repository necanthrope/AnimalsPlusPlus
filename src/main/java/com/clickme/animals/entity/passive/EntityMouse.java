package com.clickme.animals.entity.passive;

import com.clickme.animals.event.AnimalsPlusPlusConfig;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.world.World;

public class EntityMouse extends EntitySmallMob {
    public EntityMouse(World world) {
        super(world);
        setSize(0.4F, 0.2F);
        getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new net.minecraft.entity.ai.EntityAIPanic(this, 1.4D));
        this.tasks.addTask(2, new net.minecraft.entity.ai.EntityAIWander(this, 1.0D));
    }

    protected float getSoundVolume() {
        return 0.1F;
    }

    protected String getLivingSound() {
        return "mob.bat.idle";
    }

    protected String getHurtSound() {
        return "mob.bat.hurt";
    }

    protected String getDeathSound() {
        return "mob.bat.death";
    }

    protected boolean isAIEnabled() {
        return true;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.0D);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
    }

    @Override
    public int getMaxSpawnedInChunk()
    {
        return AnimalsPlusPlusConfig.mouseSpawnRate;
    }
}
