package com.clickme.animals.client.model;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@cpw.mods.fml.relauncher.SideOnly(Side.CLIENT)
public class ModelPiranha extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer beck;
    private ModelRenderer tail;

    public ModelPiranha() {
        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-1.0F, -1.0F, -3.0F, 2, 4, 6);
        this.body.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.beck = new ModelRenderer(this, 0, 10);
        this.beck.addBox(-2.0F, 0.0F, -4.0F, 4, 3, 4);
        this.beck.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.tail = new ModelRenderer(this, 16, 0);
        this.tail.addBox(0.0F, -2.0F, 0.0F, 1, 6, 4);
        this.tail.setRotationPoint(0.0F, 20.0F, 3.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.beck.render(f5);
        this.tail.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.beck.rotateAngleX = MathHelper.abs(MathHelper.sin(f2 * 0.2F) * 0.6F);
        this.tail.rotateAngleY = (MathHelper.cos(f * 0.6662F) * 2.0F * f1);
    }
}
