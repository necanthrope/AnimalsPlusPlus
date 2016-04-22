package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.client.model.ModelFish;
import com.clickme.animals.entity.water.EntityFish;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderFish extends RenderSwimming {
    private static final ResourceLocation codTextures = new ResourceLocation("animals", "textures/entity/fish/cod.png");
    private static final ResourceLocation salmonTextures = new ResourceLocation("animals", "textures/entity/fish/salmon.png");

    public RenderFish() {
        super(new ModelFish(), 0.3F);
    }

    protected ResourceLocation getEntityTextures(EntityFish entityfish) {
        return entityfish.getFishType() == 1 ? salmonTextures : codTextures;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTextures((EntityFish) entity);
    }
}
