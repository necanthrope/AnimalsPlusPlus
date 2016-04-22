package com.clickme.animals.entity.water;

import net.minecraft.world.World;

public class EntityMantaRay extends EntitySwimming {
    public EntityMantaRay(World world) {
        super(world);
        setSize(0.8F, 0.3F);
        this.swimRadius = 16.0F;
        this.swimSpeed = 0.6F;
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

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(net.minecraft.entity.SharedMonsterAttributes.maxHealth).setBaseValue(16.0D);
    }
}
