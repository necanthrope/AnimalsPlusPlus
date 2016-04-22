package com.clickme.animals.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelMouse extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer tail;

    public ModelMouse() {
        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-1.5F, -2.0F, -1.0F, 3, 3, 4);
        this.body.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.tail = new ModelRenderer(this, 0, 7);
        this.tail.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 5);
        this.tail.setRotationPoint(0.0F, 23.0F, 3.0F);
        this.body.setTextureOffset(10, 0).addBox(-1.5F, -1.0F, -3.0F, 3, 2, 2);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.tail.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.tail.rotateAngleY = (MathHelper.cos(f * 0.6662F) * 2.0F * f1);
    }
}
