package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.client.model.ModelMantaRay;
import com.clickme.animals.entity.water.EntityMantaRay;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderMantaRay extends RenderSwimming {
    private static final ResourceLocation mantaRayTextures = new ResourceLocation("animals", "textures/entity/mantaray.png");

    public RenderMantaRay() {
        super(new ModelMantaRay(), 0.3F);
    }

    protected ResourceLocation getEntityTextures(EntityMantaRay entitymantaray) {
        return mantaRayTextures;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTextures((EntityMantaRay) entity);
    }
}
