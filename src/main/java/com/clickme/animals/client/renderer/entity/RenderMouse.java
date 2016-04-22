package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.client.model.ModelMouse;
import com.clickme.animals.entity.passive.EntityMouse;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@cpw.mods.fml.relauncher.SideOnly(Side.CLIENT)
public class RenderMouse extends RenderLiving {
    private static final ResourceLocation mouseTextures = new ResourceLocation("animals", "textures/entity/mouse.png");

    public RenderMouse() {
        super(new ModelMouse(), 0.25F);
    }

    protected ResourceLocation getEntityTextures(EntityMouse entitymouse) {
        return mouseTextures;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTextures((EntityMouse) entity);
    }
}
