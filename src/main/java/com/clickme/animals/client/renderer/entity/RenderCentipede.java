package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.client.model.ModelCentipede;
import com.clickme.animals.entity.ambient.EntityCentipede;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderCentipede extends RenderInsect {
    private static final ResourceLocation centipedeTextures = new ResourceLocation("animals", "textures/entity/centipede.png");

    public RenderCentipede() {
        super(new ModelCentipede(), 0.0F);
    }

    protected ResourceLocation getEntityTextures(EntityCentipede entitycentipede) {
        return centipedeTextures;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTextures((EntityCentipede) entity);
    }
}