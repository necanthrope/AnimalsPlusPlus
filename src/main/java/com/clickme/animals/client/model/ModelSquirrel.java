package com.clickme.animals.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSquirrel extends net.minecraft.client.model.ModelBase {
    private ModelRenderer body;
    private ModelRenderer head;
    private ModelRenderer leg1;
    private ModelRenderer leg2;
    private ModelRenderer leg3;
    private ModelRenderer leg4;
    private ModelRenderer tail1;
    private ModelRenderer tail2;

    public ModelSquirrel() {
        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-2.0F, -1.0F, -5.0F, 4, 3, 7);
        this.body.setRotationPoint(0.0F, 21.0F, 1.0F);
        this.head = new ModelRenderer(this, 18, 12);
        this.head.addBox(-1.5F, -2.0F, -3.0F, 3, 3, 3);
        this.head.setRotationPoint(0.0F, 21.0F, -4.0F);
        this.leg1 = new ModelRenderer(this, 34, 12);
        this.leg1.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 1);
        this.leg1.setRotationPoint(-2.0F, 21.0F, 1.0F);
        this.leg2 = new ModelRenderer(this, 34, 12);
        this.leg2.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 1);
        this.leg2.setRotationPoint(2.0F, 21.0F, 1.0F);
        this.leg3 = new ModelRenderer(this, 30, 12);
        this.leg3.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 1);
        this.leg3.setRotationPoint(-2.0F, 22.0F, -4.0F);
        this.leg4 = new ModelRenderer(this, 30, 12);
        this.leg4.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 1);
        this.leg4.setRotationPoint(2.0F, 22.0F, -4.0F);
        this.tail1 = new ModelRenderer(this, 22, 0);
        this.tail1.addBox(-2.5F, -3.0F, 0.0F, 5, 4, 8);
        this.tail1.setRotationPoint(0.0F, 22.0F, 3.0F);
        this.tail2 = new ModelRenderer(this, 0, 10);
        this.tail2.addBox(-1.5F, -2.0F, 0.0F, 3, 3, 6);
        this.tail2.setRotationPoint(0.0F, 16.0F, 7.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.head.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.leg3.render(f5);
        this.leg4.render(f5);
        this.tail1.render(f5);
        this.tail2.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.head.rotateAngleX = (f4 / 57.295776F);
        this.head.rotateAngleY = (f3 / 57.295776F);
        this.body.rotateAngleX = 0.1047198F;
        this.leg1.rotateAngleX = MathHelper.abs(MathHelper.cos(f * 0.6662F) * 0.6F * f1);
        this.leg2.rotateAngleX = MathHelper.abs(MathHelper.cos(f * 0.6662F + 3.1415927F) * 0.6F * f1);
        this.leg3.rotateAngleX = this.leg1.rotateAngleX;
        this.leg4.rotateAngleX = this.leg2.rotateAngleX;
        this.tail1.rotateAngleX = MathHelper.abs(MathHelper.cos(f * 0.6F) * 1.4F * f1);
        this.tail2.rotationPointY = (21.5F - MathHelper.sin(this.tail1.rotateAngleX) * 8.0F);
        this.tail2.rotationPointZ = (3.0F + MathHelper.cos(this.tail1.rotateAngleX) * 8.0F);
        this.tail2.rotateAngleX = (0.3F - this.tail1.rotateAngleX * 0.4F);
    }
}
