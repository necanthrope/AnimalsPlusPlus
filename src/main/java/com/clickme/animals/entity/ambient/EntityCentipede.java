package com.clickme.animals.entity.ambient;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.world.World;

public class EntityCentipede extends EntityInsect {
    public EntityCentipede(World world) {
        super(world);
        setSize(0.6F, 0.2F);
        getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new net.minecraft.entity.ai.EntityAIWander(this, 1.0D));
    }

    protected boolean isAIEnabled() {
        return true;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(6.0D);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
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

    protected void playStepSound(int i, int j, int k, int l) {
        playSound("mob.silverfish.step", 0.15F, 1.0F);
    }
}
