package com.clickme.animals.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelShark
        extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer head;
    private ModelRenderer beck;
    private ModelRenderer tail;
    private ModelRenderer fin1;
    private ModelRenderer fin2;
    private ModelRenderer backFin;
    private ModelRenderer tailFin1;
    private ModelRenderer tailFin2;

    public ModelShark() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-3.0F, -4.0F, -9.0F, 6, 8, 18);
        this.body.setRotationPoint(0.0F, 20.0F, 0.0F);

        this.head = new ModelRenderer(this, 0, 26);
        this.head.addBox(-4.0F, -8.0F, -12.0F, 8, 8, 12);
        this.head.setRotationPoint(0.0F, 21.0F, -9.0F);

        this.beck = new ModelRenderer(this, 0, 46);
        this.beck.addBox(-3.0F, 0.0F, -10.0F, 6, 3, 10);
        this.beck.setRotationPoint(0.0F, 21.0F, -9.0F);

        this.tail = new ModelRenderer(this, 36, 0);
        this.tail.addBox(-2.0F, -3.0F, 0.0F, 4, 6, 10);
        this.tail.setRotationPoint(0.0F, 20.0F, 9.0F);

        this.fin1 = new ModelRenderer(this, 36, 52);
        this.fin1.addBox(-1.0F, 0.0F, -1.0F, 1, 4, 8);
        this.fin1.setRotationPoint(-2.0F, 21.0F, -3.0F);
        this.fin1.rotateAngleX = -0.2792527F;
        this.fin1.rotateAngleY = -0.2792527F;
        this.fin1.rotateAngleZ = 0.418879F;

        this.fin2 = new ModelRenderer(this, 36, 52);
        this.fin2.addBox(0.0F, 0.0F, -1.0F, 1, 4, 8);
        this.fin2.setRotationPoint(2.0F, 21.0F, -3.0F);
        this.fin2.rotateAngleX = -0.2792527F;
        this.fin2.rotateAngleY = 0.2792527F;
        this.fin2.rotateAngleZ = -0.418879F;

        this.backFin = new ModelRenderer(this, 52, 39);
        this.backFin.addBox(0.0F, -8.0F, 0.0F, 1, 8, 5);
        this.backFin.setRotationPoint(0.0F, 16.0F, -3.0F);
        this.backFin.rotateAngleX = -0.5585054F;

        this.tailFin1 = new ModelRenderer(this, 54, 52);
        this.tailFin1.addBox(-0.5F, -13.0F, 5.0F, 1, 8, 4);
        this.tailFin1.setRotationPoint(0.0F, 20.0F, 9.0F);
        this.tailFin1.rotateAngleX = -0.5585054F;

        this.tailFin2 = new ModelRenderer(this, 54, 52);
        this.tailFin2.addBox(-0.5F, 3.0F, 5.0F, 1, 8, 4);
        this.tailFin2.setRotationPoint(0.0F, 20.0F, 9.0F);
        this.tailFin2.rotateAngleX = 0.5585054F;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        float scale = 0.625F;
        GL11.glPushMatrix();
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(0.0F, 12.6F * f5, -5.4F * f5);
        this.head.render(f5);
        this.beck.render(f5);
        GL11.glPopMatrix();

        this.body.render(f5);
        this.tail.render(f5);
        this.fin1.render(f5);
        this.fin2.render(f5);
        this.backFin.render(f5);
        this.tailFin1.render(f5);
        this.tailFin2.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.beck.rotateAngleX = (MathHelper.abs(MathHelper.sin(f2 * 0.07F) * 0.6F) * f1);
        this.tail.rotateAngleY = (MathHelper.cos(f * 0.6662F) * 0.5F * f1);
        this.tailFin1.rotateAngleY = (this.tailFin2.rotateAngleY = this.tail.rotateAngleY * 1.4F);
    }
}
