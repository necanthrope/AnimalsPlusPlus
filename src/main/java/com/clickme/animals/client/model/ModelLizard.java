package com.clickme.animals.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.MathHelper;

public class ModelLizard extends net.minecraft.client.model.ModelBase {
    private ModelRenderer head;
    private ModelRenderer body;
    private ModelRenderer leg1;
    private ModelRenderer leg2;
    private ModelRenderer leg3;
    private ModelRenderer leg4;
    private ModelRenderer tail;

    public ModelLizard() {
        this.head = new ModelRenderer(this, 0, 15);
        this.head.addBox(-2.0F, -1.0F, -4.0F, 4, 2, 4);
        this.head.setRotationPoint(0.0F, 22.0F, -6.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-2.0F, -2.0F, -6.0F, 4, 3, 12);
        this.body.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.leg1 = new ModelRenderer(this, 0, 21);
        this.leg1.addBox(-0.5F, 0.0F, -0.5F, 1, 5, 1);
        this.leg1.setRotationPoint(-2.0F, 22.0F, 4.0F);
        this.leg2 = new ModelRenderer(this, 0, 21);
        this.leg2.addBox(-0.5F, 0.0F, -0.5F, 1, 5, 1);
        this.leg2.setRotationPoint(2.0F, 22.0F, 4.0F);
        this.leg3 = new ModelRenderer(this, 0, 21);
        this.leg3.addBox(-0.5F, 0.0F, -0.5F, 1, 5, 1);
        this.leg3.setRotationPoint(-2.0F, 22.0F, -4.0F);
        this.leg4 = new ModelRenderer(this, 0, 21);
        this.leg4.addBox(-0.5F, 0.0F, -0.5F, 1, 5, 1);
        this.leg4.setRotationPoint(2.0F, 22.0F, -4.0F);
        this.tail = new ModelRenderer(this, 4, 15);
        this.tail.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 12);
        this.tail.setRotationPoint(0.0F, 22.0F, 6.0F);
    }

    public void render(net.minecraft.entity.Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head.render(f5);
        this.body.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.leg3.render(f5);
        this.leg4.render(f5);
        this.tail.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, net.minecraft.entity.Entity entity) {
        this.head.rotateAngleX = (f4 / 57.295776F);
        this.head.rotateAngleY = (f3 / 57.295776F);
        this.leg1.rotateAngleX = (MathHelper.cos(f * 0.6662F) * 1.8F * f1);
        this.leg1.rotateAngleZ = 1.2566371F;
        this.leg2.rotateAngleX = (-MathHelper.cos(f * 0.6662F) * 1.8F * f1);
        this.leg2.rotateAngleZ = -1.2566371F;
        this.leg3.rotateAngleX = (-MathHelper.cos(f * 0.6662F) * 1.8F * f1);
        this.leg3.rotateAngleZ = 1.2566371F;
        this.leg4.rotateAngleX = (MathHelper.cos(f * 0.6662F) * 1.8F * f1);
        this.leg4.rotateAngleZ = -1.2566371F;
        this.tail.rotateAngleY = (MathHelper.cos(f * 0.6662F) * 1.8F * f1);
    }
}

