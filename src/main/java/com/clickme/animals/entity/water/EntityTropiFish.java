package com.clickme.animals.entity.water;

import java.util.Random;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityTropiFish extends EntityFish {
    public EntityTropiFish(World world) {
        super(world);
        setSize(0.3F, 0.2F);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(6.0D);
    }

    protected void dropFewItems(boolean flag, int i) {
        if (this.rand.nextInt(4) == 0) {
            entityDropItem(new net.minecraft.item.ItemStack(net.minecraft.init.Items.fish, 1, 2), 0.0F);
        }
    }

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData ientitylivingdata) {
        setFishType(getRNG().nextInt(5));
        return ientitylivingdata;
    }
}
