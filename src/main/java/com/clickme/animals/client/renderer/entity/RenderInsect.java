package com.clickme.animals.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLivingBase;

@SideOnly(Side.CLIENT)
public abstract class RenderInsect extends RenderLiving {
    public RenderInsect(ModelBase modelbase, float f) {
        super(modelbase, f);
    }

    protected float getDeathMaxRotation(EntityLivingBase entitylivingbase) {
        return 180.0F;
    }
}

