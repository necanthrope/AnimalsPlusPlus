package com.clickme.animals.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelFish extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer fin;

    public ModelFish() {
        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 8);
        this.body.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.fin = new ModelRenderer(this, 24, 0);
        this.fin.addBox(0.0F, -3.0F, 0.0F, 0, 6, 4);
        this.fin.setRotationPoint(0.0F, 22.0F, 4.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.fin.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.fin.rotateAngleY = (MathHelper.cos(f * 0.6662F) * 2.0F * f1);
    }
}
