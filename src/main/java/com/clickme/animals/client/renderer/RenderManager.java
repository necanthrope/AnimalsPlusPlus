package com.clickme.animals.client.renderer;

import com.clickme.animals.client.renderer.entity.*;


import com.clickme.animals.entity.ambient.EntityButterfly;
import com.clickme.animals.entity.ambient.EntityCentipede;
import com.clickme.animals.entity.ambient.EntityCricket;
import com.clickme.animals.entity.ambient.EntityMoth;
import com.clickme.animals.entity.passive.EntityBird;
import com.clickme.animals.entity.passive.EntityDuck;
import com.clickme.animals.entity.passive.EntityLizard;
import com.clickme.animals.entity.passive.EntityMouse;
import com.clickme.animals.entity.passive.EntityPenguin;
import com.clickme.animals.entity.passive.EntitySnake;
import com.clickme.animals.entity.passive.EntitySquirrel;
import com.clickme.animals.entity.water.EntityAngler;
import com.clickme.animals.entity.water.EntityFish;
import com.clickme.animals.entity.water.EntityMantaRay;
import com.clickme.animals.entity.water.EntityPiranha;
import com.clickme.animals.entity.water.EntityShark;
import com.clickme.animals.entity.water.EntityTropiFish;
import com.clickme.animals.entity.water.EntityWhale;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelChicken;

@SideOnly(Side.CLIENT)
public class RenderManager {
    public static void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityCentipede.class, new RenderCentipede());
        RenderingRegistry.registerEntityRenderingHandler(EntityCricket.class, new RenderCricket());
        RenderingRegistry.registerEntityRenderingHandler(EntityButterfly.class, new RenderButterfly());
        RenderingRegistry.registerEntityRenderingHandler(EntityMoth.class, new RenderMoth());
        RenderingRegistry.registerEntityRenderingHandler(EntityFish.class, new RenderFish());
        RenderingRegistry.registerEntityRenderingHandler(EntityTropiFish.class, new RenderTropiFish());
        RenderingRegistry.registerEntityRenderingHandler(EntityAngler.class, new RenderAngler());
        RenderingRegistry.registerEntityRenderingHandler(EntityMantaRay.class, new RenderMantaRay());
        RenderingRegistry.registerEntityRenderingHandler(EntityWhale.class, new RenderWhale());
        RenderingRegistry.registerEntityRenderingHandler(EntitySnake.class, new RenderSnake());
        RenderingRegistry.registerEntityRenderingHandler(EntityLizard.class, new RenderLizard());
        RenderingRegistry.registerEntityRenderingHandler(EntityMouse.class, new RenderMouse());
        RenderingRegistry.registerEntityRenderingHandler(EntityBird.class, new RenderBird());
        RenderingRegistry.registerEntityRenderingHandler(EntityDuck.class, new RenderDuck(new ModelChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySquirrel.class, new RenderSquirrel());
        RenderingRegistry.registerEntityRenderingHandler(EntityPenguin.class, new RenderPenguin());
        RenderingRegistry.registerEntityRenderingHandler(EntityPiranha.class, new RenderPiranha());
        RenderingRegistry.registerEntityRenderingHandler(EntityShark.class, new RenderShark());
    }
}
