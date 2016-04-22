package com.clickme.animals.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelWhale extends ModelBase {
    private ModelRenderer body1;
    private ModelRenderer body2;
    private ModelRenderer body3;
    private ModelRenderer flipper1;
    private ModelRenderer flipper2;
    private ModelRenderer fluke1;
    private ModelRenderer fluke2;

    public ModelWhale() {
        this.body1 = new ModelRenderer(this, 0, 0);
        this.body1.addBox(-4.5F, -12.0F, -4.0F, 9, 12, 8);
        this.body1.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.body2 = new ModelRenderer(this, 34, 0);
        this.body2.addBox(-3.5F, 0.0F, -3.5F, 7, 8, 7);
        this.body2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body3 = new ModelRenderer(this, 0, 20);
        this.body3.addBox(-3.0F, 8.0F, -3.0F, 6, 6, 6);
        this.body3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.flipper1 = new ModelRenderer(this, 34, 15);
        this.flipper1.addBox(-8.0F, 0.0F, 0.0F, 8, 1, 4);
        this.flipper1.setRotationPoint(-4.5F, -4.5F, -1.0F);
        this.flipper2 = new ModelRenderer(this, 34, 15);
        this.flipper2.addBox(0.0F, 0.0F, 0.0F, 8, 1, 4);
        this.flipper2.setRotationPoint(4.5F, -4.5F, -1.0F);
        this.fluke1 = new ModelRenderer(this, 24, 20);
        this.fluke1.addBox(-10.0F, 0.0F, 0.0F, 10, 2, 5);
        this.fluke1.setRotationPoint(-3.0F, 10.0F, 1.0F);
        this.fluke2 = new ModelRenderer(this, 24, 20);
        this.fluke2.addBox(0.0F, 0.0F, 0.0F, 10, 2, 5);
        this.fluke2.setRotationPoint(3.0F, 10.0F, 1.0F);
        this.body1.addChild(this.body2);
        this.body1.addChild(this.flipper1);
        this.body1.addChild(this.flipper2);
        this.body2.addChild(this.body3);
        this.body3.addChild(this.fluke1);
        this.body3.addChild(this.fluke2);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body1.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.body1.rotateAngleX = 1.5707964F;
        this.body2.rotateAngleX = (MathHelper.sin(f2 * 0.15F) * 0.2F);
        this.body3.rotateAngleX = (MathHelper.sin(f2 * 0.15F) * 0.3F);
        this.flipper1.rotateAngleX = -1.3613565F;
        this.flipper1.rotateAngleY = -0.31415927F;
        this.flipper1.rotateAngleZ = -0.2094395F;
        this.flipper2.rotateAngleX = this.flipper1.rotateAngleX;
        this.flipper2.rotateAngleY = (-this.flipper1.rotateAngleY);
        this.flipper2.rotateAngleZ = (-this.flipper1.rotateAngleZ);
        this.fluke1.rotateAngleX = -1.5707964F;
        this.fluke1.rotateAngleY = (MathHelper.sin(f2 * 0.15F) * 0.4F);
        this.fluke1.rotateAngleZ = -0.5235988F;
        this.fluke2.rotateAngleX = this.fluke1.rotateAngleX;
        this.fluke2.rotateAngleY = (-this.fluke1.rotateAngleY);
        this.fluke2.rotateAngleZ = (-this.fluke1.rotateAngleZ);
    }
}
