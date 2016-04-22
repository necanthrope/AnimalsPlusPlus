 package com.clickme.animals.client.model;

 import java.awt.Color;
 import java.awt.Graphics;
 import java.awt.image.BufferedImage;
 import java.io.PrintStream;
 import java.util.ArrayList;
 import java.util.Iterator;
 import java.util.List;
 import net.minecraft.client.model.ModelBox;
 import net.minecraft.client.model.ModelRenderer;
 import net.minecraft.util.MathHelper;

 public class ImageGenerator
 {
   private static final int WIDTH = 64;
   private static final int HEIGHT = 32;

   private class Region
   {
     public int x1;
     public int y1;
     public int x2;
     public int y2;

     public Region(int x1, int y1, int x2, int y2)
     {
       this.x1 = x1;
       this.y1 = y1;
       this.x2 = x2;
       this.y2 = y2;
     }

     public void move(int xo, int yo) {
       this.x1 += xo;
       this.y1 += yo;
       this.x2 += xo;
       this.y2 += yo;
     }

     public boolean overlaps(Region r2, int xo, int yo) {
       if (r2.x2 + xo <= this.x1)
         return false;
       if (r2.y2 + yo <= this.y1)
         return false;
       if (r2.x1 + xo >= this.x2)
         return false;
       if (r2.y1 + yo >= this.y2)
         return false;
       return true;
     }


     public void render(Graphics g) { g.fillRect(this.x1, this.y1, this.x2 - this.x1, this.y2 - this.y1); }
   }

   private class UnfoldedCube {
     public int x;
     public int y;
     public ImageGenerator.Region[] cubeRegions = new ImageGenerator.Region[6];
     public String id;
     public int width;
     public int height;

     public UnfoldedCube(ModelBox cube) { int xs = MathHelper.ceiling_float_int(cube.posX2 - cube.posX1);
       int ys = MathHelper.ceiling_float_int(cube.posY2 - cube.posY1);
       int zs = MathHelper.ceiling_float_int(cube.posZ2 - cube.posZ1);

       this.width = (xs * 2 + zs * 2);
       this.height = (zs + ys);

       this.id = cube.field_78247_g;

       this.cubeRegions[0] = new ImageGenerator.Region(0, zs, zs, zs + ys);
       this.cubeRegions[1] = new ImageGenerator.Region(zs, zs, zs + xs, zs + ys);
       this.cubeRegions[2] = new ImageGenerator.Region(zs + xs, zs, zs + xs + zs, zs + ys);
       this.cubeRegions[3] = new ImageGenerator.Region(zs + xs + zs, zs, zs + xs + zs + xs, zs + ys);
       this.cubeRegions[4] = new ImageGenerator.Region(zs, 0, zs + xs, zs);
       this.cubeRegions[5] = new ImageGenerator.Region(zs + xs, 0, zs + xs * 2, zs);
     }

     public boolean fits(int x, int y) {
       for (int i = 0; i < 6; i++) {
         if (!ImageGenerator.this.isFree(this.cubeRegions[i], x, y))
           return false;
       }
       return true;
     }

     public void place(int x, int y) {
       this.x = x;
       this.y = y;
       for (int i = 0; i < 6; i++) {
         this.cubeRegions[i].move(x, y);
         ImageGenerator.this.occupiedRegions.add(this.cubeRegions[i]);
       }
     }

     public void render(Graphics g) {
       float hue = (float)Math.random();
       g.setColor(new Color(Color.HSBtoRGB(hue, 1.0F, 0.7F)));
       this.cubeRegions[5].render(g);
       g.setColor(new Color(Color.HSBtoRGB(hue, 1.0F, 1.0F)));
       this.cubeRegions[4].render(g);
       g.setColor(new Color(Color.HSBtoRGB(hue, 1.0F, 0.9F)));
       this.cubeRegions[1].render(g);
       this.cubeRegions[3].render(g);
       g.setColor(new Color(Color.HSBtoRGB(hue, 1.0F, 0.8F)));
       this.cubeRegions[0].render(g);
       this.cubeRegions[2].render(g);
     }
   }

   private List<Region> occupiedRegions = new ArrayList();

   private boolean isFree(Region region, int xo, int yo) {
     if (region.x1 + xo < 0)
       return false;
     if (region.y1 + yo < 0)
       return false;
     if (region.x2 + xo > 64)
       return false;
     if (region.y2 + yo > 32) {
       return false;
     }
     for (int i = 0; i < this.occupiedRegions.size(); i++) {
       if (((Region)this.occupiedRegions.get(i)).overlaps(region, xo, yo)) {
         return false;
       }
     }
     return true;
   }

   public void generateImage(List<ModelRenderer> parts)
   {
     List<ModelBox> cubes = new ArrayList();
     for (ModelRenderer mp : parts) {
       getCubes(mp, cubes);
     }

     java.util.Collections.sort(cubes, new java.util.Comparator<ModelBox>()
     {
       public int compare(ModelBox c0, ModelBox c1) {
         int xs = MathHelper.ceiling_float_int(c0.posX2 - c0.posX1);
         int ys = MathHelper.ceiling_float_int(c0.posY2 - c0.posY1);
         int zs = MathHelper.ceiling_float_int(c0.posZ2 - c0.posZ1);

         int ww0 = xs * 2 + zs * 2;
         int hh0 = zs + ys;

         xs = MathHelper.ceiling_float_int(c1.posX2 - c1.posX1);
         ys = MathHelper.ceiling_float_int(c1.posY2 - c1.posY1);
         zs = MathHelper.ceiling_float_int(c1.posZ2 - c1.posZ1);

         int ww1 = xs * 2 + zs * 2;
         int hh1 = zs + ys;

         if (ww0 * hh0 < ww1 * hh1)
           return 1;
         if (ww0 * hh0 > ww1 * hh1) {
           return -1;
         }

         return 0;
       }

     });
     List<UnfoldedCube> unfolded = new ArrayList();
     for (ModelBox cube : cubes) {
       UnfoldedCube uc = new UnfoldedCube(cube);

       boolean placed = false;
       label181:
       for (int y = 0; y < 32 - uc.height; y++) {
         for (int x = 0; x < 64 - uc.width; x++) {
           if (uc.fits(x, y)) {
             uc.place(x, y);
             placed = true;
             break label181;
           }
         }
       }
       if (!placed) {
         System.out.println("Failed to place " + uc.id);
       } else {
         unfolded.add(uc);
       }
     }
     BufferedImage img = new BufferedImage(64, 32, 2);
     Graphics g = img.getGraphics();
     System.out.println("----------------");
     for (UnfoldedCube uc : unfolded) {
       System.out.println("setMapTex(\"" + uc.id + "\", " + uc.x + ", " + uc.y + ");");
       uc.render(g);
     }
     try {
       javax.imageio.ImageIO.write(img, "png", new java.io.File("output.png"));
     } catch (java.io.IOException e) {
       e.printStackTrace();
     }
   }

   public void getCubes(ModelRenderer mp, List<ModelBox> cubeList) {
     for (ModelBox cube : (List<ModelBox>)mp.cubeList) {
        if (cube.field_78247_g != null) {
           Iterator i$ = cubeList.iterator();
           label127:
                    for (;;) {
                        if (!i$.hasNext()) break label127;
                        ModelBox otherCube = (ModelBox)i$.next();
           if ((otherCube.field_78247_g != null) &&
             (otherCube.field_78247_g.equals(cube.field_78247_g))) {
             System.out.println("Duplicate " + cube.field_78247_g);
             break;
           }
         }
       }

       cubeList.add(cube);
     }
   }

   public static void main(String[] args) { new ImageGenerator().generateImage(new net.minecraft.client.model.ModelDragon(0.0F).boxList); }
 }