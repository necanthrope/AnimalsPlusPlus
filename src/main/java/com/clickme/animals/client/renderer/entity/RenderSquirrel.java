package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.client.model.ModelSquirrel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;


@SideOnly(Side.CLIENT)
public class RenderSquirrel
        extends RenderLiving {
    private static final ResourceLocation squirrelTextures = new ResourceLocation("animals", "textures/entity/squirrel.png");

    public RenderSquirrel() {
        super(new ModelSquirrel(), 0.2F);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return squirrelTextures;
    }
}
