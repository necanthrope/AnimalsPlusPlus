package com.clickme.animals.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelMantaRay extends ModelBase {
    private ModelRenderer body1;
    private ModelRenderer body2;
    private ModelRenderer lobe1;
    private ModelRenderer lobe2;
    private ModelRenderer wing1;
    private ModelRenderer wing2;
    private ModelRenderer outerWing1;
    private ModelRenderer outerWing2;
    private ModelRenderer tail;

    public ModelMantaRay() {
        this.body1 = new ModelRenderer(this, 0, 0);
        this.body1.addBox(-5.0F, -6.0F, -1.0F, 10, 12, 3);
        this.body1.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.body2 = new ModelRenderer(this, 22, 16);
        this.body2.addBox(-3.0F, 0.0F, 0.0F, 6, 1, 4);
        this.body2.setRotationPoint(0.0F, 22.0F, 6.0F);
        this.lobe1 = new ModelRenderer(this, 22, 21);
        this.lobe1.addBox(-2.0F, 0.0F, -4.0F, 2, 1, 4);
        this.lobe1.setRotationPoint(-3.0F, 23.0F, -6.0F);
        this.lobe2 = new ModelRenderer(this, 22, 21);
        this.lobe2.mirror = true;
        this.lobe2.addBox(0.0F, 0.0F, -4.0F, 2, 1, 4);
        this.lobe2.setRotationPoint(3.0F, 23.0F, -6.0F);
        this.wing1 = new ModelRenderer(this, 26, 0);
        this.wing1.addBox(-8.0F, 0.0F, -4.0F, 8, 1, 8);
        this.wing1.setRotationPoint(-5.0F, 21.0F, 0.0F);
        this.wing2 = new ModelRenderer(this, 26, 0);
        this.wing2.mirror = true;
        this.wing2.addBox(0.0F, 0.0F, -4.0F, 8, 1, 8);
        this.wing2.setRotationPoint(5.0F, 21.0F, 0.0F);
        this.outerWing1 = new ModelRenderer(this, 26, 9);
        this.outerWing1.addBox(-14.0F, 0.0F, -3.0F, 6, 1, 6);
        this.outerWing1.setRotationPoint(-5.0F, 21.0F, 0.0F);
        this.outerWing2 = new ModelRenderer(this, 26, 9);
        this.outerWing2.mirror = true;
        this.outerWing2.addBox(8.0F, 0.0F, -3.0F, 6, 1, 6);
        this.outerWing2.setRotationPoint(5.0F, 21.0F, 0.0F);
        this.tail = new ModelRenderer(this, 0, 15);
        this.tail.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 10);
        this.tail.setRotationPoint(0.0F, 22.0F, 10.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body1.render(f5);
        this.body2.render(f5);
        this.lobe1.render(f5);
        this.lobe2.render(f5);
        this.wing1.render(f5);
        this.wing2.render(f5);
        this.outerWing1.render(f5);
        this.outerWing2.render(f5);
        this.tail.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.body1.rotateAngleX = 1.5707964F;
        this.wing1.rotateAngleZ = (MathHelper.cos(f2 * 0.1F) * 0.8F);
        this.wing2.rotateAngleZ = (-this.wing1.rotateAngleZ);
        this.outerWing1.rotateAngleZ = (MathHelper.cos(f2 * 0.1F) * 1.0F);
        this.outerWing2.rotateAngleZ = (-this.outerWing1.rotateAngleZ);
        this.tail.rotateAngleY = (MathHelper.cos(f * 0.4F) * 1.2F * f1);
    }
}
