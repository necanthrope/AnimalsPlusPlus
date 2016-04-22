package com.clickme.animals.event;

import com.clickme.animals.entity.ambient.EntityCricket;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.world.BlockEvent;

/**
 * Created by jtidwell on 11/22/2015.
 */
public class AnimalsPlusPlusEvents {

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onJumpEvent(LivingEvent.LivingJumpEvent event) {

        // Is the entity a cricket?
        if(event.entity.getClass() == EntityCricket.class) {
            Block location = event.entity.worldObj.getBlock(
                    (int) event.entity.posX, (int) event.entity.posY - 1, (int) event.entity.posZ);
            //Is the cricket on tilled earth?
            if (location.getClass() == Blocks.farmland.getClass()) {
                System.out.println("EVENT: " + event.entity);
            }
        }
    }

}
