package com.clickme.animals.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelButterfly extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer wing1;
    private ModelRenderer wing2;

    public ModelButterfly() {
        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-0.5F, 0.0F, -3.0F, 1, 1, 6);
        this.body.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.wing1 = new ModelRenderer(this, 6, 0);
        this.wing1.addBox(-4.0F, 0.0F, -4.0F, 4, 1, 8);
        this.wing1.setRotationPoint(-0.5F, 23.0F, 0.0F);
        this.wing2 = new ModelRenderer(this, 6, 0);
        this.wing2.mirror = true;
        this.wing2.addBox(0.0F, 0.0F, -4.0F, 4, 1, 8);
        this.wing2.setRotationPoint(0.5F, 23.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.wing1.render(f5);
        this.wing2.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.body.rotateAngleX = 0.0F;
        this.wing1.rotateAngleZ = MathHelper.cos(f2 + 3.1415927F);
        this.wing2.rotateAngleZ = MathHelper.cos(f2);
    }
}
