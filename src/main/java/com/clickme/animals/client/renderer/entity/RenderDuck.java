package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.entity.passive.EntityDuck;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


@SideOnly(Side.CLIENT)
public class RenderDuck
        extends RenderLiving {
    private static final ResourceLocation duckTextures = new ResourceLocation("animals", "textures/entity/duck.png");

    public RenderDuck(ModelBase model, float shadow) {
        super(model, shadow);
    }

    protected void preRenderCallback(EntityLivingBase entitylivingbase, float f) {
        GL11.glScalef(0.8F, 0.8F, 0.8F);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return duckTextures;
    }

    protected float handleRotationFloat(EntityDuck duck, float f) {
        float f1 = duck.field_70888_h + (duck.field_70886_e - duck.field_70888_h) * f;
        float f2 = duck.field_70884_g + (duck.destPos - duck.field_70884_g) * f;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    protected float handleRotationFloat(EntityLivingBase duck, float f) {
        return handleRotationFloat((EntityDuck) duck, f);
    }
}