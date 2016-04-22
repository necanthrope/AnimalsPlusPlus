package com.clickme.animals.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelBird extends ModelBase {
    private ModelRenderer head;
    private ModelRenderer body;
    private ModelRenderer leg1;
    private ModelRenderer leg2;
    private ModelRenderer wing1;
    private ModelRenderer wing2;
    private ModelRenderer tail;

    public ModelBird() {
        this.head = new ModelRenderer(this, 0, 10);
        this.head.addBox(-1.5F, -3.0F, -2.0F, 3, 3, 3);
        this.head.setRotationPoint(0.0F, 18.0F, -2.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 6);
        this.body.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.leg1 = new ModelRenderer(this, 12, 10);
        this.leg1.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2);
        this.leg1.setRotationPoint(-1.5F, 22.0F, 0.0F);
        this.leg2 = new ModelRenderer(this, 12, 10);
        this.leg2.mirror = true;
        this.leg2.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2);
        this.leg2.setRotationPoint(1.5F, 22.0F, 0.0F);
        this.wing1 = new ModelRenderer(this, 20, 0);
        this.wing1.addBox(-1.0F, 0.0F, 0.0F, 1, 4, 6);
        this.wing1.setRotationPoint(-2.0F, 18.0F, -3.0F);
        this.wing2 = new ModelRenderer(this, 20, 0);
        this.wing2.addBox(0.0F, 0.0F, 0.0F, 1, 4, 6);
        this.wing2.setRotationPoint(2.0F, 18.0F, -3.0F);
        this.tail = new ModelRenderer(this, 16, 10);
        this.tail.addBox(-1.5F, 0.0F, 0.0F, 3, 1, 4);
        this.tail.setRotationPoint(0.0F, 18.0F, 3.0F);
        this.head.setTextureOffset(0, 16).addBox(-0.5F, -1.0F, -4.0F, 1, 1, 2);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head.render(f5);
        this.body.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.wing1.render(f5);
        this.wing2.render(f5);
        this.tail.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.head.rotateAngleX = (f4 / 57.295776F);
        this.head.rotateAngleY = (f3 / 57.295776F);
        this.leg1.rotateAngleX = (MathHelper.cos(f * 0.6662F) * 1.4F * f1);
        this.leg2.rotateAngleX = (MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1);
        this.wing1.rotateAngleZ = f2;
        this.wing2.rotateAngleZ = (-f2);
        this.tail.rotateAngleX = 0.7853982F;
    }
}

