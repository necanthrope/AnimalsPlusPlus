 package com.clickme.animals;

 import cpw.mods.fml.common.eventhandler.SubscribeEvent;
 import cpw.mods.fml.common.gameevent.PlayerEvent;
 import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
 import net.minecraft.client.Minecraft;

 public class PlayerEventHandler
 {
   private AnimalsPlus animalsPlus;

   public PlayerEventHandler(AnimalsPlus mod)
   {
     this.animalsPlus = mod;
   }

   @SubscribeEvent
   public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
     Minecraft mc = Minecraft.getMinecraft();
     this.animalsPlus.notificatePlayerInChat(event.player);
   }
 }
