package com.clickme.animals.entity.passive;

import com.clickme.animals.event.AnimalsPlusPlusConfig;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.world.World;

public class EntityLizard extends EntitySmallMob {
    public EntityLizard(World world) {
        super(world);
        setSize(0.8F, 0.3F);
        getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new net.minecraft.entity.ai.EntityAIWander(this, 1.0D));
        this.tasks.addTask(2, new net.minecraft.entity.ai.EntityAIWatchClosest(this, net.minecraft.entity.player.EntityPlayer.class, 6.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return null;
    }

    protected String getDeathSound() {
        return null;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
    }

    @Override
    public int getMaxSpawnedInChunk()
    {
        return AnimalsPlusPlusConfig.lizardSpawnRate;
    }
}