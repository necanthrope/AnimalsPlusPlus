package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.client.model.ModelPiranha;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderPiranha extends RenderSwimming {
    private static final ResourceLocation piranhaTextures = new ResourceLocation("animals", "textures/entity/piranha.png");

    public RenderPiranha() {
        super(new ModelPiranha(), 0.3F);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return piranhaTextures;
    }
}
