package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.client.model.ModelCricket;
import com.clickme.animals.entity.ambient.EntityCricket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderCricket extends RenderInsect {
    private static final ResourceLocation cricketTextures = new ResourceLocation("animals", "textures/entity/cricket.png");

    public RenderCricket() {
        super(new ModelCricket(), 0.3F);
    }

    protected ResourceLocation getEntityTextures(EntityCricket entitycricket) {
        return cricketTextures;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTextures((EntityCricket) entity);
    }
}