package com.clickme.animals.entity.ambient;

import com.clickme.animals.entity.passive.EntityWingedBug;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMoth extends EntityWingedBug {
    public EntityMoth(World world) {
        super(world);
        setSize(0.5F, 0.2F);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.0D);
    }

    protected boolean isAIEnabled() {
        return true;
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

    public void onLivingUpdate() {
        float brightness = getBrightness(1.0F);

        if (brightness > 0.5F) {
            this.entityAge += 2;
        }

        super.onLivingUpdate();
    }

    public boolean getCanSpawnHere() {
        int y = MathHelper.floor_double(this.boundingBox.minY);
        int x = MathHelper.floor_double(this.posX);
        int z = MathHelper.floor_double(this.posZ);
        int lightValue = this.worldObj.getBlockLightValue(x, y, z);
        return (lightValue < 8) && (super.getCanSpawnHere());
    }
}
