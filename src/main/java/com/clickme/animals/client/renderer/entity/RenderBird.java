package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.client.model.ModelBird;
import com.clickme.animals.entity.passive.EntityBird;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderBird extends RenderLiving {
    private static final ResourceLocation jayTextures = new ResourceLocation("animals", "textures/entity/bird/jay.png");
    private static final ResourceLocation cardinalTextures = new ResourceLocation("animals", "textures/entity/bird/cardinal.png");
    private static final ResourceLocation sparrowTextures = new ResourceLocation("animals", "textures/entity/bird/sparrow.png");
    private static final ResourceLocation parrotTextures = new ResourceLocation("animals", "textures/entity/bird/parrot.png");
    private static final ResourceLocation chickadeeTextures = new ResourceLocation("animals", "textures/entity/bird/chickadee.png");
    private static final ResourceLocation crowTextures = new ResourceLocation("animals", "textures/entity/bird/crow.png");

    public RenderBird() {
        super(new ModelBird(), 0.3F);
    }

    protected ResourceLocation getEntityTextures(EntityBird entitybird) {
        switch (entitybird.getBirdType()) {
            default:
                return jayTextures;
            case 0:
                return crowTextures;
            case 1:
                return cardinalTextures;
            case 2:
                return sparrowTextures;
            case 3:
                return parrotTextures;
            case 4:
                return chickadeeTextures;
        }

    }

    protected float handleRotationFloat(EntityBird entitybird, float f) {
        float f1 = entitybird.prevWingRotation + (entitybird.wingRotation - entitybird.prevWingRotation) * f;
        float f2 = entitybird.prevFlapSpeed + (entitybird.flapSpeed - entitybird.prevFlapSpeed) * f;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    protected float handleRotationFloat(EntityLivingBase entitylivingbase, float f) {
        return handleRotationFloat((EntityBird) entitylivingbase, f);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTextures((EntityBird) entity);
    }
}