 package com.clickme.animals.entity.water;

 import java.util.Random;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.ai.attributes.IAttributeInstance;
 import net.minecraft.init.Items;
 import net.minecraft.util.AxisAlignedBB;
 import net.minecraft.util.MathHelper;
 import net.minecraft.world.EnumDifficulty;
 import net.minecraft.world.World;

 public class EntityAngler extends EntitySwimming
 {
   public EntityAngler(World world)
   {
     super(world);
     setSize(0.5F, 0.4F);
     this.isAgressive = true;
     this.swimRadius = 8.0F;
     this.swimSpeed = 0.7F;
   }

   protected void applyEntityAttributes()
   {
     super.applyEntityAttributes();
     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(12.0D);
     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
   }

   public void onUpdate()
   {
     if ((!this.worldObj.isRemote) && (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL)) {
       setDead();
     }
     super.onUpdate();
   }

   protected net.minecraft.entity.Entity findPlayerToAttack()
   {
     net.minecraft.entity.player.EntityPlayer player = (net.minecraft.entity.player.EntityPlayer)super.findPlayerToAttack();
     if (player != null) {
       return player;
     }
     AxisAlignedBB area = this.boundingBox.expand(16.0D, 6.0D, 16.0D);
     return this.worldObj.findNearestEntityWithinAABB(EntityFish.class, area, this);
   }

   protected String getLivingSound()
   {
     return null;
   }

   protected String getHurtSound()
   {
     return null;
   }

   protected String getDeathSound()
   {
     return null;
   }

   protected void dropFewItems(boolean flag, int i)
   {
     int j = this.rand.nextInt(3) + this.rand.nextInt(1 + i);

     for (int k = 0; k < j; k++) {
       dropItem(Items.glowstone_dust, 1);
     }
   }

   protected boolean isValidLightLevel() {
     int i = MathHelper.floor_double(this.posX);
     int j = MathHelper.floor_double(this.posY);
     int k = MathHelper.floor_double(this.posZ);
     return this.worldObj.getBlockLightValue(i, j, k) <= 6;
   }

   public boolean getCanSpawnHere()
   {
     return (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) && (isValidLightLevel()) && (super.getCanSpawnHere());
   }
 }
