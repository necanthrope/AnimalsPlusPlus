package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.client.model.ModelLizard;
import com.clickme.animals.entity.passive.EntityLizard;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderLizard extends RenderLiving {
    private static final ResourceLocation lizardTextures = new ResourceLocation("animals", "textures/entity/lizard.png");

    public RenderLizard() {
        super(new ModelLizard(), 0.5F);
    }

    protected ResourceLocation getEntityTextures(EntityLizard entitylizard) {
        return lizardTextures;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTextures((EntityLizard) entity);
    }
}
