package com.clickme.animals.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public abstract class RenderSwimming extends RenderLiving {
    public RenderSwimming(ModelBase modelbase, float f) {
        super(modelbase, f);
    }

    protected void rotateCorpse(EntityLivingBase entitylivingbase, float f, float f1, float f2) {
        super.rotateCorpse(entitylivingbase, f, f1, f2);
        float f3 = entitylivingbase.prevRotationPitch + (entitylivingbase.rotationPitch - entitylivingbase.prevRotationPitch) * f2;
        GL11.glRotatef(f3, 1.0F, 0.0F, 0.0F);
    }
}
