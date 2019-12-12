package com.clickme.animals.entity.passive;

import java.util.Random;

import com.clickme.animals.AnimalsPlus;
import com.clickme.animals.entity.ambient.EntityInsect;
import net.minecraft.util.ChunkCoordinates;

public abstract class EntityWingedBug extends EntityInsect {
    private ChunkCoordinates currentFlightTarget;

    public EntityWingedBug(net.minecraft.world.World world) {
        super(world);
    }

    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6D;
    }

    protected void updateAITasks() {
        super.updateAITasks();

        if ((this.currentFlightTarget != null) && (
                (!this.worldObj.isAirBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY,
                        this.currentFlightTarget.posZ)) ||
                        (this.currentFlightTarget.posY < 1) ||
                        (this.currentFlightTarget.posY > this.worldObj.getHeightValue(this.currentFlightTarget.posX,
                                this.currentFlightTarget.posZ) + 5))) {
            this.currentFlightTarget = null;
        }

        if ((this.currentFlightTarget == null) || (this.rand.nextInt(30) == 0) ||
                (this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 4.0F)) {

            this.currentFlightTarget = new ChunkCoordinates((int) this.posX + this.rand.nextInt(7) -
                    this.rand.nextInt(7), (int) this.posY + this.rand.nextInt(6) - 2, (int) this.posZ +
                    this.rand.nextInt(7) - this.rand.nextInt(7));
        }


        double d = this.currentFlightTarget.posX + 0.5D - this.posX;
        double d1 = this.currentFlightTarget.posY + 0.5D - this.posY;
        double d2 = this.currentFlightTarget.posZ + 0.5D - this.posZ;
        this.motionX += (Math.signum(d) * 0.5D - this.motionX) * 0.1D;
        this.motionY += (Math.signum(d1) * 0.7D - this.motionY) * 0.1D;
        this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.1D;
        float f = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / 3.141592653589793D) - 90.0F;
        float f1 = net.minecraft.util.MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
        this.moveForward = 0.5F;
        this.rotationYaw += f1;
    }

    protected void fall(float f) {
    }

    protected void updateFallState(double d, boolean flag) {
    }

    @Override
    public boolean getCanSpawnHere() {
        if (!super.getCanSpawnHere()) {
            return false;
        }
        return AnimalsPlus.isEntityOnNatureBlock(this);
    }
}