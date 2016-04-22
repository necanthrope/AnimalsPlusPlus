package com.clickme.animals.client.model;

import com.clickme.animals.entity.passive.EntityPenguin;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

@cpw.mods.fml.relauncher.SideOnly(Side.CLIENT)
public class ModelPenguin extends ModelBase {
    private ModelRenderer head;
    private ModelRenderer body;
    private ModelRenderer foot1;
    private ModelRenderer foot2;
    private ModelRenderer wing1;
    private ModelRenderer wing2;

    public ModelPenguin() {
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6);
        this.head.setRotationPoint(0.0F, 11.0F, 0.0F);
        this.head.setTextureOffset(24, 0).addBox(-1.0F, 0.0F, -6.0F, 2, 2, 3);
        this.body = new ModelRenderer(this, 0, 12);
        this.body.addBox(-3.0F, -3.0F, -3.0F, 6, 9, 6);
        this.body.setRotationPoint(0.0F, 17.0F, 0.0F);
        this.foot1 = new ModelRenderer(this, 24, 15);
        this.foot1.addBox(-1.0F, 0.0F, -1.5F, 2, 1, 3);
        this.foot1.setRotationPoint(-1.5F, 23.0F, 0.0F);
        this.foot2 = new ModelRenderer(this, 24, 15);
        this.foot2.addBox(-1.0F, 0.0F, -1.5F, 2, 1, 3);
        this.foot2.setRotationPoint(1.5F, 23.0F, 0.0F);
        this.wing1 = new ModelRenderer(this, 24, 5);
        this.wing1.addBox(-1.0F, 0.0F, -2.0F, 1, 6, 4);
        this.wing1.setRotationPoint(-3.0F, 14.0F, 0.0F);
        this.wing2 = new ModelRenderer(this, 24, 5);
        this.wing2.addBox(0.0F, 0.0F, -2.0F, 1, 6, 4);
        this.wing2.setRotationPoint(3.0F, 14.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.rotateAngleX = (f4 / 57.295776F);
        this.head.rotateAngleY = (f3 / 57.295776F);
        this.head.render(f5);
        this.body.render(f5);
        this.foot1.render(f5);
        this.foot2.render(f5);
        this.wing1.render(f5);
        this.wing2.render(f5);
    }

    public void setLivingAnimations(EntityLivingBase entity, float f, float f1, float f2) {
        EntityPenguin penguin = (EntityPenguin) entity;
        if (penguin.isGliding()) {
            this.head.setRotationPoint(0.0F, 21.0F, -6.0F);
            this.body.setRotationPoint(0.0F, 21.0F, 0.0F);
            this.body.rotateAngleX = 1.5707963F;
            this.wing1.rotateAngleX = (this.wing2.rotateAngleX = 1.5707963F);
            this.wing1.setRotationPoint(-3.0F, 21.0F, -3.0F);
            this.wing2.setRotationPoint(3.0F, 21.0F, -3.0F);
            this.foot1.rotateAngleX = (this.foot2.rotateAngleX = 1.5707963F);
            this.foot1.rotateAngleY = (this.foot2.rotateAngleY = 0.0F);
            this.foot1.rotateAngleZ = 0.2443461F;
            this.foot2.rotateAngleZ = -0.2443461F;
            this.foot1.setRotationPoint(-1.5F, 21.0F, 6.0F);
            this.foot2.setRotationPoint(1.5F, 21.0F, 6.0F);
        } else {
            this.head.setRotationPoint(0.0F, 11.0F, 0.0F);
            this.body.setRotationPoint(0.0F, 17.0F, 0.0F);
            this.body.rotateAngleX = 0.0F;
            this.wing1.rotateAngleX = (this.wing2.rotateAngleX = 0.0F);
            this.wing1.setRotationPoint(-3.0F, 14.0F, 0.0F);
            this.wing2.setRotationPoint(3.0F, 14.0F, 0.0F);
            this.foot1.rotateAngleX = (this.foot2.rotateAngleX = 0.0F);
            this.foot1.rotateAngleZ = (this.foot2.rotateAngleZ = 0.0F);
            this.foot1.rotateAngleY = 0.2443461F;
            this.foot2.rotateAngleY = -0.2443461F;
            this.foot1.setRotationPoint(-1.5F, 23.0F, 0.0F);
            this.foot2.setRotationPoint(1.5F, 23.0F, 0.0F);
        }
    }
}
