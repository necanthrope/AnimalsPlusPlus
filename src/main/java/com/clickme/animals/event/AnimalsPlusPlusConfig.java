package com.clickme.animals.event;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by jtidwell on 11/24/2015.
 */
public class AnimalsPlusPlusConfig {

    public static int centipedeSpawnChance;
    public static int cricketSpawnChance;
    public static int butterflySpawnChance;
    public static int mothSpawnChance;
    public static int fishSpawnChance;
    public static int tropiFishSpawnChance;
    public static int anglerSpawnChance;
    public static int mantaRaySpawnChance;
    public static int whaleSpawnChance;
    public static int snakeSpawnChance;
    public static int lizardSpawnChance;
    public static int mouseSpawnChance;
    public static int birdSpawnChance;
    public static int duckSpawnChance;
    public static int penguinSpawnChance;
    public static int piranhaSpawnChance;
    public static int sharkSpawnChance;

    public static final String CATEGORY_SPAWN_CHANCE = "spawn chance";

    public static void buildConfig(FMLPreInitializationEvent event) {

        String centipedeSpawnComment = "Chance that centipedes will spawn.";
        String cricketSpawnComment = "Chance that crickets will spawn.";
        String butterflySpawnComment = "Chance that butterflies will spawn.";
        String mothSpawnComment = "Chance that moths will spawn.";
        String fishSpawnComment = "Chance that fish will spawn.";
        String tropiFishSpawnComment = "Chance that tropical fish will spawn.";
        String anglerSpawnComment = "Chance that angler will spawn.";
        String mantaRaySpawnComment = "Chance that manta rays will spawn.";
        String whaleSpawnComment = "Chance that whales will spawn.";
        String snakeSpawnComment = "Chance that snakes will spawn.";
        String lizardSpawnComment = "Chance that lizard will spawn.";
        String mouseSpawnComment = "Chance that mice will spawn.";
        String birdSpawnComment = "Chance that birds will spawn.";
        String duckSpawnComment = "Chance that ducks will spawn.";
        String penguinSpawnComment = "Chance that penguins will spawn.";
        String piranhaSpawnComment = "Chance that piranha will spawn.";
        String sharkSpawnComment = "Chance that sharks will spawn.";

        Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        centipedeSpawnChance = config.get(CATEGORY_SPAWN_CHANCE, "centipedeSpawnChance",
                3, centipedeSpawnComment).getInt();
        cricketSpawnChance = config.get(CATEGORY_SPAWN_CHANCE, "cricketSpawnChance",
                3, cricketSpawnComment).getInt();
        butterflySpawnChance = config.get(CATEGORY_SPAWN_CHANCE, "butterflySpawnChance",
                4, butterflySpawnComment).getInt();
        mothSpawnChance = config.get(CATEGORY_SPAWN_CHANCE, "mothSpawnChance",
                4, mothSpawnComment).getInt();
        fishSpawnChance = config.get(CATEGORY_SPAWN_CHANCE, "fishSpawnChance",
                12, fishSpawnComment).getInt();
        tropiFishSpawnChance = config.get(CATEGORY_SPAWN_CHANCE, "tropiFishSpawnChance",
                12, tropiFishSpawnComment).getInt();
        anglerSpawnChance = config.get(CATEGORY_SPAWN_CHANCE, "anglerSpawnChance",
                8, anglerSpawnComment).getInt();
        mantaRaySpawnChance = config.get(CATEGORY_SPAWN_CHANCE, "mantaRaySpawnChance",
                4, mantaRaySpawnComment).getInt();
        whaleSpawnChance = config.get(CATEGORY_SPAWN_CHANCE, "whaleSpawnChance",
                1, whaleSpawnComment).getInt();
        snakeSpawnChance = config.get(CATEGORY_SPAWN_CHANCE, "snakeSpawnChance",
                60, snakeSpawnComment).getInt();
        lizardSpawnChance = config.get(CATEGORY_SPAWN_CHANCE, "lizardSpawnChance",
                60, lizardSpawnComment).getInt();
        mouseSpawnChance = config.get(CATEGORY_SPAWN_CHANCE, "mouseSpawnChance",
                100, mouseSpawnComment).getInt();
        birdSpawnChance = config.get(CATEGORY_SPAWN_CHANCE, "birdSpawnChance",
                100, birdSpawnComment).getInt();
        duckSpawnChance = config.get(CATEGORY_SPAWN_CHANCE, "duckSpawnChance",
                100, duckSpawnComment).getInt();
        penguinSpawnChance = config.get(CATEGORY_SPAWN_CHANCE, "penguinSpawnChance",
                100, penguinSpawnComment).getInt();
        piranhaSpawnChance = config.get(CATEGORY_SPAWN_CHANCE, "piranhaSpawnChance",
                12, piranhaSpawnComment).getInt();
        sharkSpawnChance = config.get(CATEGORY_SPAWN_CHANCE, "sharkSpawnChance",
                4, sharkSpawnComment).getInt();

        config.addCustomCategoryComment(CATEGORY_SPAWN_CHANCE, "All chances are percentage values.");

        config.save();

    }

}
