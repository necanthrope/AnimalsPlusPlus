package com.clickme.animals.client.model;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@cpw.mods.fml.relauncher.SideOnly(Side.CLIENT)
public class ModelAngler extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer beck;
    private ModelRenderer rod;
    private ModelRenderer fin1;
    private ModelRenderer fin2;
    private ModelRenderer tail;

    public ModelAngler() {
        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-2.0F, -4.0F, -5.0F, 4, 6, 10);
        this.body.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.beck = new ModelRenderer(this, 0, 16);
        this.beck.addBox(-3.0F, -4.0F, -8.0F, 6, 4, 8);
        this.beck.setRotationPoint(0.0F, 24.0F, 3.0F);
        this.rod = new ModelRenderer(this, 28, 7);
        this.rod.addBox(0.0F, -4.0F, -5.0F, 0, 4, 5);
        this.rod.setRotationPoint(0.0F, 18.0F, -4.0F);
        this.fin1 = new ModelRenderer(this, 28, 10);
        this.fin1.addBox(-4.0F, 0.0F, 0.0F, 4, 0, 2);
        this.fin1.setRotationPoint(-2.0F, 23.0F, 3.0F);
        this.fin2 = new ModelRenderer(this, 28, 10);
        this.fin2.mirror = true;
        this.fin2.addBox(0.0F, 0.0F, 0.0F, 4, 0, 2);
        this.fin2.setRotationPoint(2.0F, 23.0F, 3.0F);
        this.tail = new ModelRenderer(this, 28, 0);
        this.tail.addBox(0.0F, -3.0F, 0.0F, 0, 6, 4);
        this.tail.setRotationPoint(0.0F, 20.0F, 5.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.beck.render(f5);
        this.rod.render(f5);
        this.fin1.render(f5);
        this.fin2.render(f5);
        this.tail.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.beck.rotateAngleX = MathHelper.abs(MathHelper.sin(f2 * 0.2F) * 0.6F);
        this.fin1.rotateAngleX = 0.3926991F;
        this.fin1.rotateAngleY = 0.3926991F;
        this.fin1.rotateAngleZ = -0.3926991F;
        this.fin2.rotateAngleX = 0.3926991F;
        this.fin2.rotateAngleY = -0.3926991F;
        this.fin2.rotateAngleZ = 0.3926991F;
        this.tail.rotateAngleY = (MathHelper.cos(f * 0.6662F) * 2.0F * f1);
    }
}
