package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.entity.water.EntityTropiFish;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


@SideOnly(Side.CLIENT)
public class RenderTropiFish
        extends RenderFish {
    private static final ResourceLocation clownfishTextures = new ResourceLocation("animals", "textures/entity/fish/clownfish.png");

    private static final ResourceLocation blueTangTextures = new ResourceLocation("animals", "textures/entity/fish/blue_tang.png");

    private static final ResourceLocation yellowTangTextures = new ResourceLocation("animals", "textures/entity/fish/yellow_tang.png");

    private static final ResourceLocation damselfishTextures = new ResourceLocation("animals", "textures/entity/fish/damselfish.png");

    private static final ResourceLocation grammaTextures = new ResourceLocation("animals", "textures/entity/fish/gramma.png");

    public RenderTropiFish() {
        this.shadowSize *= 0.7F;
    }

    protected void preRenderCallback(EntityTropiFish entitytropfish, float f) {
        GL11.glScalef(0.7F, 0.7F, 0.7F);
    }

    protected ResourceLocation getEntityTextures(EntityTropiFish entitytropfish) {
        switch (entitytropfish.getFishType()) {
            default:
                return clownfishTextures;
            case 0:
                return grammaTextures;
            case 1:
                return blueTangTextures;
            case 2:
                return yellowTangTextures;
            case 3:
                return damselfishTextures;
        }

    }


    protected void preRenderCallback(EntityLivingBase entitylivingbase, float f) {
        preRenderCallback((EntityTropiFish) entitylivingbase, f);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTextures((EntityTropiFish) entity);
    }
}
