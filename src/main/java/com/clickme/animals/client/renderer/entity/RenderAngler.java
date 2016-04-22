package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.client.model.ModelAngler;
import com.clickme.animals.entity.water.EntityAngler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


@SideOnly(Side.CLIENT)
public class RenderAngler extends RenderSwimming {
    private static final ResourceLocation anglerLightsTextures = new ResourceLocation("animals", "textures/entity/angler/angler_lights.png");
    private static final ResourceLocation anglerTextures = new ResourceLocation("animals", "textures/entity/angler/angler.png");

    public RenderAngler() {
        super(new ModelAngler(), 0.3F);
        setRenderPassModel(new ModelAngler());
    }

    protected int shouldRenderPass(EntityAngler entityanglerfish, int i, float f) {
        if (i != 0) {
            return -1;
        }


        bindTexture(anglerLightsTextures);
        GL11.glEnable(3042);
        GL11.glBlendFunc(1, 1);

        if (entityanglerfish.isInvisible()) {
            GL11.glDepthMask(false);
        } else {
            GL11.glDepthMask(true);
        }

        char c0 = 61680;
        int j = c0 % 65536;
        int k = c0 / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0F, k / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        return 1;
    }


    protected ResourceLocation getEntityTextures(EntityAngler entityanglerfish) {
        return anglerTextures;
    }

    protected int shouldRenderPass(EntityLivingBase entitylivingbase, int i, float f) {
        return shouldRenderPass((EntityAngler) entitylivingbase, i, f);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTextures((EntityAngler) entity);
    }
}
