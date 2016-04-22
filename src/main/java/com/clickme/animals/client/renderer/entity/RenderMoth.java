package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.entity.ambient.EntityMoth;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderMoth extends RenderButterfly {
    private static final ResourceLocation mothTextures = new ResourceLocation("animals", "textures/entity/moth.png");

    protected ResourceLocation getMothTextures(EntityMoth entity) {
        return mothTextures;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return getMothTextures((EntityMoth) entity);
    }
}
