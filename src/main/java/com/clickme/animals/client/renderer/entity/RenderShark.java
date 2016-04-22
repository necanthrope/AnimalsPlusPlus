package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.client.model.ModelShark;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


@SideOnly(Side.CLIENT)
public class RenderShark
        extends RenderSwimming {
    private static final ResourceLocation sharkTextures = new ResourceLocation("animals", "textures/entity/shark.png");

    public RenderShark() {
        super(new ModelShark(), 0.3F);
    }

    protected void preRenderCallback(EntityLivingBase entity, float f) {
        GL11.glScalef(1.4F, 1.4F, 1.4F);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return sharkTextures;
    }
}
