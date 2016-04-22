package com.clickme.animals.client.renderer.entity;

import com.clickme.animals.client.model.ModelSnake;
import com.clickme.animals.entity.passive.EntitySnake;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderSnake extends RenderLiving {
    private static final ResourceLocation snakeBrownTextures = new ResourceLocation("animals", "textures/entity/snake/brown.png");

    private static final ResourceLocation snakeGreenTextures = new ResourceLocation("animals", "textures/entity/snake/green.png");

    private static final ResourceLocation snakeRedTextures = new ResourceLocation("animals", "textures/entity/snake/red.png");

    public RenderSnake() {
        super(new ModelSnake(), 0.0F);
    }

    protected ResourceLocation getEntityTextures(EntitySnake snake) {
        switch (snake.getSnakeType()) {
            default:
                return snakeBrownTextures;
            case 0:
                return snakeRedTextures;
            case 1:
                return snakeGreenTextures;
        }

    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTextures((EntitySnake) entity);
    }
}
