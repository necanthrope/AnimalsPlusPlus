package com.clickme.animals.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class ModelCentipede extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer legs;

    public ModelCentipede() {
        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-1.0F, -6.0F, 0.0F, 2, 12, 1);
        this.body.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.legs = new ModelRenderer(this, 6, 0);
        this.legs.addBox(-3.0F, -8.0F, 0.0F, 6, 14, 0);
        this.legs.setRotationPoint(0.0F, 24.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        float f6 = 1.5707964F;
        this.body.rotateAngleX = f6;
        this.legs.rotateAngleX = f6;
        this.body.render(f5);
        this.legs.render(f5);
    }
}

