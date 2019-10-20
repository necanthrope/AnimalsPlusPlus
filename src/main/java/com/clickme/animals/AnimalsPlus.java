package com.clickme.animals;

import com.clickme.animals.client.renderer.RenderManager;
import com.clickme.animals.event.AnimalsPlusPlusConfig;
import com.clickme.animals.event.EventManager;
import com.google.common.io.ByteStreams;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.DefaultArtifactVersion;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.chunk.Chunk;

@Mod(
        modid = AnimalsPlusConstants.MOD_ID,
        version = AnimalsPlusConstants.MOD_VERSION
)
public class AnimalsPlus {

    private boolean isOutdated = false;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        AnimalsPlusPlusConfig.buildConfig(event);
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        EntityManager.registerEntities();
        EntityManager.registerSpawning();
        EventManager.registerEventListeners();

        if (!event.getSide().isClient()) {
            return;
        }
        RenderManager.registerRenderers();

        checkForPromotions();
        FMLCommonHandler.instance().bus().register(new PlayerEventHandler(this));
    }

    protected void notificatePlayerInChat(EntityPlayer player) {
        if (this.isOutdated) {
            player.addChatMessage(new ChatComponentTranslation("animals.outdated", new Object[0]));
            String updateUrl = "http://goo.gl/JaoWWC";
            ChatComponentText url = new ChatComponentText(updateUrl);
            url.getChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, updateUrl));
            url.getChatStyle().setUnderlined(Boolean.valueOf(true));
            player.addChatMessage(new ChatComponentTranslation("animals.download", new Object[]{url}));
        }
    }

    private void checkForPromotions() {
        new Thread("Animals+ Version Check") {
            public void run() {
                try {
                    URL url = new URL("https://dl.dropboxusercontent.com/u/71419016/an/promotions.json");
                    InputStream input = url.openStream();
                    String data = new String(ByteStreams.toByteArray(input));
                    input.close();

                    Map<String, Object> json = (Map) new Gson().fromJson(data, Map.class);
                    Map<String, String> promos = (Map) json.get("promos");

                    String lat = (String) promos.get("1.7.10-latest");
                    ArtifactVersion current = new DefaultArtifactVersion("1.2.1");

                    if (lat != null) {
                        ArtifactVersion latest = new DefaultArtifactVersion(lat);
                        if (latest.compareTo(current) > 0) {
                            AnimalsPlus.this.isOutdated = true;
                        }
                    }
                } catch (IOException e) {
                } catch (JsonSyntaxException e) {
                }
            }
        }.start();
    }

    public static boolean isEntityOnNatureBlock(Entity entity) {

		int y = MathHelper.floor_double(entity.boundingBox.minY);
		int x = MathHelper.floor_double(entity.posX);
		int z = MathHelper.floor_double(entity.posZ);
		Block location = entity.worldObj.getBlock(x, y, z);

        List<Class<?>> permittedBlocks = new ArrayList<Class<?>>();
		permittedBlocks.add(Blocks.grass.getClass());
		permittedBlocks.add(Blocks.tallgrass.getClass());
		permittedBlocks.add(Blocks.leaves.getClass());
		permittedBlocks.add(Blocks.leaves2.getClass());
        permittedBlocks.add(Blocks.dirt.getClass());
        permittedBlocks.add(Blocks.clay.getClass());
        permittedBlocks.add(Blocks.sand.getClass());
        permittedBlocks.add(Blocks.gravel.getClass());
        permittedBlocks.add(Blocks.log.getClass());
        permittedBlocks.add(Blocks.log2.getClass());
        permittedBlocks.add(Blocks.snow_layer.getClass());

		return (permittedBlocks.contains(location.getClass()));
    }

}
