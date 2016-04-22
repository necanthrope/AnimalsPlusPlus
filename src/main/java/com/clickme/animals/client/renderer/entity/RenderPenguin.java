package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.client.model.ModelPenguin;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


@SideOnly(Side.CLIENT)
public class RenderPenguin
        extends RenderLiving {
    private static final ResourceLocation penguinTextures = new ResourceLocation("animals", "textures/entity/penguin.png");

    public RenderPenguin() {
        super(new ModelPenguin(), 0.3F);
    }

    protected void rotateCorpse(EntityLivingBase entity, float f, float f1, float f2) {
        super.rotateCorpse(entity, f, f1, f2);
        if (entity.limbSwingAmount >= 0.01D) {
            float f3 = 4.0F;
            float f4 = entity.limbSwing - entity.limbSwingAmount * (1.0F - f2) + 6.0F;
            float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
            GL11.glRotatef(10.0F * f5, 0.0F, 0.0F, 1.0F);
        }
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return penguinTextures;
    }
}

