package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.client.model.ModelButterfly;
import com.clickme.animals.entity.ambient.EntityButterfly;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderButterfly extends RenderInsect {
    private static final ResourceLocation orangeButterflyTextures =
            new ResourceLocation("animals", "textures/entity/butterfly/orange.png");

    private static final ResourceLocation blueButterflyTextures =
            new ResourceLocation("animals", "textures/entity/butterfly/blue.png");

    public RenderButterfly() {
        super(new ModelButterfly(), 0.2F);
    }

    protected ResourceLocation getEntityTextures(EntityButterfly entitybutterfly) {
        return entitybutterfly.getButterflyType() == 1 ? blueButterflyTextures : orangeButterflyTextures;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTextures((EntityButterfly) entity);
    }
}
