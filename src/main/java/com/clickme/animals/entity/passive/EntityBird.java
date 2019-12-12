package com.clickme.animals.entity.passive;

import java.util.Random;

import com.clickme.animals.entity.ai.EntityAIAvoidScarecrow;
import com.clickme.animals.entity.ai.EntityAIFlying;
import com.clickme.animals.event.AnimalsPlusPlusConfig;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;

import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityBird extends EntityBirdBase {
    private double flightTargetX;
    private double flightTargetY;
    private double flightTargetZ;
    public float wingRotation;
    public float prevWingRotation;
    public float flapSpeed;
    public float prevFlapSpeed;
    public float timeInAir = 1.0F;

    public EntityBird(World world) {
        super(world);
        setSize(0.4F, 0.6F);
        this.tasks.addTask(1, new EntityAIAvoidScarecrow(this, Blocks.skull, 6, 1.5D, 1.0D, 7, 16));
        this.tasks.addTask(0, new EntityAIFlying(this));
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityPlayer.class, 8.0F, 1.0D, 1.4D));
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityOcelot.class, 8.0F, 1.0D, 1.4D));
        this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 4.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
    }

    protected boolean isAIEnabled() {
        return true;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(13, Byte.valueOf((byte) 0));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(6.0D);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }

    public void onLivingUpdate() {

        super.onLivingUpdate();
        this.prevWingRotation = this.wingRotation;
        this.prevFlapSpeed = this.flapSpeed;
        this.flapSpeed = ((float) (this.flapSpeed + (this.onGround ? -1.0D : 1.2D)));

        if (this.flapSpeed < 0.0F) {
            this.flapSpeed = 0.0F;
        }

        if (this.flapSpeed > 1.0F) {
            this.flapSpeed = 1.0F;
        }

        if ((!this.onGround) && (this.timeInAir < 1.0F)) {
            this.timeInAir = 1.0F;
        }

        this.timeInAir = ((float) (this.timeInAir * 0.9D));

        if (isFlying()) {
            this.motionY *= 0.1D;
        } else if ((!this.onGround) && (this.motionY < 0.0D)) {
            this.motionY *= 0.6D;
        }

        this.wingRotation += this.timeInAir * 2.0F;
    }

    protected void updateAITasks() {
        super.updateAITasks();

        if (isFlying()) {
            double d = this.flightTargetX - this.posX;
            double d1 = this.flightTargetY - this.posY;
            double d2 = this.flightTargetZ - this.posZ;
            double d3 = d * d + d1 * d1 + d2 * d2;

            if ((!canBlockBeSeen(this.flightTargetX, this.flightTargetY, this.flightTargetZ)) || (d3 < 1.0D)) {
                setFlying(false);
            } else {
                d3 = MathHelper.sqrt_double(d3);
                this.motionX += d / d3 * 0.05D;
                this.motionY += d1 / d3 * 0.1D;
                this.motionZ += d2 / d3 * 0.05D;
                float f = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / 3.141592653589793D) - 90.0F;
                float f1 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
                this.rotationYaw += f1;
            }
        } else if ((this.rand.nextInt(100) == 0) && (findNewFlightTarget(Material.leaves))) {
            setFlying(true);
        }
    }

    private boolean findNewFlightTarget(Material material) {
        AxisAlignedBB axisalignedbb = this.boundingBox.expand(8.0D, 8.0D, 8.0D);
        int i = MathHelper.floor_double(axisalignedbb.minX);
        int j = MathHelper.floor_double(axisalignedbb.maxX + 1.0D);
        int k = MathHelper.floor_double(axisalignedbb.minY);
        int l = MathHelper.floor_double(axisalignedbb.maxY + 1.0D);
        int i1 = MathHelper.floor_double(axisalignedbb.minZ);
        int j1 = MathHelper.floor_double(axisalignedbb.maxX + 1.0D);

        for (int k1 = i; k1 < j; k1++) {
            for (int l1 = k; l1 < l; l1++) {
                for (int i2 = i1; i2 < j1; i2++) {
                    Block block = this.worldObj.getBlock(k1, l1 - 1, i2);

                    if ((block.getMaterial() == material) && (canBlockBeSeen(k1 + 0.5D, l1 + 0.5D, i2 + 0.5D))) {
                        this.flightTargetX = (k1 + 0.5D);
                        this.flightTargetY = (l1 + 0.5D);
                        this.flightTargetZ = (i2 + 0.5D);
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean canBlockBeSeen(double x, double y, double z) {
        return this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY, this.posZ), Vec3.createVectorHelper(x, y, z)) == null;
    }


    protected void fall(float f) {
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("Type", getBirdType());
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        setBirdType(par1NBTTagCompound.getInteger("Type"));
    }

    protected String getLivingSound() {

        Float light = worldObj.getLightBrightness(
                MathHelper.floor_double(this.posX),
                MathHelper.floor_double(this.posY),
                MathHelper.floor_double(this.posZ));
        float chirpChance = 1.0F - light;
        if(new Random().nextFloat() < chirpChance) {
            return null;
        }


        switch (getBirdType()) {
            default:
                return "animals:mob.bird.jay.say";
            case 0:
                return "animals:mob.bird.crow.say";
            case 1:
                return "animals:mob.bird.cardinal.say";
            case 2:
                return "animals:mob.bird.sparrow.say";

            case 3:
                return "animals:mob.bird.parrot.say";
            case 4:
                return "animals:mob.bird.chickadee.say";
        }

    }

    protected String getHurtSound() {
        switch (getBirdType()) {

            default:
                return "animals:mob.bird.jay.hurt";
            case 0:
                return "animals:mob.bird.crow.hurt";
            case 1:
                return "animals:mob.bird.cardinal.hurt";
            case 2:
                return "animals:mob.bird.sparrow.hurt";
            case 3:
                return "animals:mob.bird.parrot.hurt";
            case 4:
                return "animals:mob.bird.chickadee.hurt";
        }

    }

    protected String getDeathSound() {
        switch (getBirdType()) {
            default:
                return null;
            case 0:
                return "animals:mob.bird.crow.death";
            case 1:
                return "animals:mob.bird.cardinal.death";
        }

    }

    protected void playStepSound(int i, int j, int k, Block block) {
        playSound("mob.chicken.step", 0.15F, 1.0F);
    }

    protected Item getDropItem() {
        return net.minecraft.init.Items.feather;
    }

    public int getBirdType() {
        return this.dataWatcher.getWatchableObjectByte(13);
    }

    public void setBirdType(int i) {
        this.dataWatcher.updateObject(13, Byte.valueOf((byte) i));
    }

    public boolean isOnLadder() {
        return isFlying() ? false : super.isOnLadder();
    }

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData ientitylivingdata) {
        setBirdType(getRNG().nextInt(5));
        return super.onSpawnWithEgg(ientitylivingdata);
    }

    @Override
    public int getMaxSpawnedInChunk()
    {
        return AnimalsPlusPlusConfig.birdSpawnRate;
    }

}

