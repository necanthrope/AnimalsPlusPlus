package com.clickme.animals.event;

import com.clickme.animals.AnimalsPlusConstants;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by jtidwell on 11/22/2015.
 */
public class EventManager {

    public static void registerEventListeners() {
        System.out.println("Registering event listeners.");
        MinecraftForge.EVENT_BUS.register(new AnimalsPlusPlusEvents());
    }

}
