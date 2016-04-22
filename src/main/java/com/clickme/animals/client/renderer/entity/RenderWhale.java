package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.client.model.ModelWhale;
import com.clickme.animals.entity.water.EntityWhale;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


@SideOnly(Side.CLIENT)
public class RenderWhale
        extends RenderSwimming {
    private static final ResourceLocation whaleTextures = new ResourceLocation("animals", "textures/entity/whale.png");

    public RenderWhale() {
        super(new ModelWhale(), 3.2F);
    }

    protected void preRenderCallback(EntityWhale entitywhale, float f) {
        GL11.glScalef(8.0F, 8.0F, 8.0F);
    }

    protected ResourceLocation getEntityTextures(EntityWhale entitywhale) {
        return whaleTextures;
    }

    protected void preRenderCallback(EntityLivingBase entitylivingbase, float f) {
        preRenderCallback((EntityWhale) entitylivingbase, f);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTextures((EntityWhale) entity);
    }
}
