package com.clickme.animals.client.model;

import com.clickme.animals.entity.passive.EntitySnake;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSnake extends net.minecraft.client.model.ModelBase {
    private ModelRenderer head;
    private ModelRenderer tongue;
    private ModelRenderer tail;

    public ModelSnake() {
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-1.5F, -1.0F, -2.0F, 3, 2, 4);
        this.head.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.tongue = new ModelRenderer(this, 14, 0);
        this.tongue.addBox(-1.5F, 0.0F, -3.0F, 3, 1, 3);
        this.tongue.setRotationPoint(0.0F, 23.0F, -2.0F);
        this.tail = new ModelRenderer(this, 0, 6);
        this.tail.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 4);
        this.tail.setRotationPoint(0.0F, 23.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        EntitySnake snake = (EntitySnake) entity;

        this.head.render(f5);

        this.tongue.rotateAngleX = (MathHelper.sin(f2 * 5.0F) * 0.2F);
        this.tongue.render(f5);

        float xpos = 0.0F;
        float zpos = 2.0F;

        for (int i = 0; i < snake.snakeLenght; i++) {
            this.tail.rotationPointX = xpos;
            this.tail.rotationPointZ = zpos;

            float rot = snake.getRotationForPart(i) * 3.1415927F / 180.0F;
            this.tail.rotateAngleY = rot;

            this.tail.render(f5);

            xpos += MathHelper.sin(rot) * 4.0F;
            zpos += MathHelper.cos(rot) * 4.0F;
        }
    }
}
