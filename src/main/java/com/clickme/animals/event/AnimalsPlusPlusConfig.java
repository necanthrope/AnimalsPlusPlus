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

    public static int centipedeSpawnRate;
    public static int cricketSpawnRate;
    public static int butterflySpawnRate;
    public static int mothSpawnRate;
    public static int fishSpawnRate;
    public static int tropiFishSpawnRate;
    public static int anglerSpawnRate;
    public static int mantaRaySpawnRate;
    public static int whaleSpawnRate;
    public static int snakeSpawnRate;
    public static int lizardSpawnRate;
    public static int mouseSpawnRate;
    public static int birdSpawnRate;
    public static int duckSpawnRate;
    public static int penguinSpawnRate;
    public static int piranhaSpawnRate;
    public static int sharkSpawnRate;

    public static final String CATEGORY_SPAWN_CHANCE = "spawn chance";
    public static final String CATEGORY_SPAWN_RATE = "spawn rate";
    public static int DEFAULT_MAX_SPAWNED_IN_CHUNK = 4;

    public static final String MAX_CENTIPEDE_PER_CHUNK = "max_centipede_per_chunk";
    public static final String MAX_CRICKET_PER_CHUNK = "max_cricket_per_chunk";
    public static final String MAX_BUTTERFLY_PER_CHUNK = "max_butterfly_per_chunk";
    public static final String MAX_MOTH_PER_CHUNK = "max_moth_per_chunk";
    public static final String MAX_FISH_PER_CHUNK = "max_fish_per_chunk";
    public static final String MAX_TROPI_FISH_PER_CHUNK = "max_tropi_fish_per_chunk";
    public static final String MAX_ANGLER_PER_CHUNK = "max_angler_per_chunk";
    public static final String MAX_MANTA_RAY_PER_CHUNK = "max_manta_ray_per_chunk";
    public static final String MAX_WHALE_PER_CHUNK = "max_whale_per_chunk";
    public static final String MAX_SNAKE_PER_CHUNK = "max_snake_per_chunk";
    public static final String MAX_LIZARD_PER_CHUNK = "max_lizard_per_chunk";
    public static final String MAX_MOUSE_PER_CHUNK = "max_mouse_per_chunk";
    public static final String MAX_BIRD_PER_CHUNK = "max_bird_per_chunk";
    public static final String MAX_DUCK_PER_CHUNK = "max_duck_per_chunk";
    public static final String MAX_PENGUIN_PER_CHUNK = "max_penguin_per_chunk";
    public static final String MAX_PIRANHA_PER_CHUNK = "max_piranha_per_chunk";
    public static final String MAX_SHARK_PER_CHUNK = "max_shark_per_chunk";

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


        String centipedeSpawnRateComment = "Max per chunk of centipedes that will spawn.";
        String cricketSpawnRateComment = "Max per chunk of crickets that will spawn.";
        String butterflySpawnRateComment = "Max per chunk of butterflies that will spawn.";
        String mothSpawnRateComment = "Max per chunk of moths that will spawn.";
        String fishSpawnRateComment = "Max per chunk of fish that will spawn.";
        String tropiFishSpawnRateComment = "Max per chunk of tropical fish that will spawn.";
        String anglerSpawnRateComment = "Max per chunk of angler that will spawn.";
        String mantaRaySpawnRateComment = "Max per chunk of manta rays that will spawn.";
        String whaleSpawnRateComment = "Max per chunk of whales that will spawn.";
        String snakeSpawnRateComment = "Max per chunk of snakes that will spawn.";
        String lizardSpawnRateComment = "Max per chunk of lizard that will spawn.";
        String mouseSpawnRateComment = "Max per chunk of mice that will spawn.";
        String birdSpawnRateComment = "Max per chunk of birds that will spawn.";
        String duckSpawnRateComment = "Max per chunk of ducks that will spawn.";
        String penguinSpawnRateComment = "Max per chunk of penguins that will spawn.";
        String piranhaSpawnRateComment = "Max per chunk of piranha that will spawn.";
        String sharkSpawnRateComment = "Max per chunk of sharks that will spawn.";

        centipedeSpawnRate = config.get(CATEGORY_SPAWN_RATE, MAX_CENTIPEDE_PER_CHUNK,
                DEFAULT_MAX_SPAWNED_IN_CHUNK, centipedeSpawnRateComment).getInt();
        cricketSpawnRate = config.get(CATEGORY_SPAWN_RATE, MAX_CRICKET_PER_CHUNK,
                DEFAULT_MAX_SPAWNED_IN_CHUNK, cricketSpawnRateComment).getInt();
        butterflySpawnRate = config.get(CATEGORY_SPAWN_RATE, MAX_BUTTERFLY_PER_CHUNK,
                DEFAULT_MAX_SPAWNED_IN_CHUNK, butterflySpawnRateComment).getInt();
        mothSpawnRate = config.get(CATEGORY_SPAWN_RATE, MAX_MOTH_PER_CHUNK,
                DEFAULT_MAX_SPAWNED_IN_CHUNK, mothSpawnRateComment).getInt();
        fishSpawnRate = config.get(CATEGORY_SPAWN_RATE, MAX_FISH_PER_CHUNK,
                DEFAULT_MAX_SPAWNED_IN_CHUNK, fishSpawnRateComment).getInt();
        tropiFishSpawnRate = config.get(CATEGORY_SPAWN_RATE, MAX_TROPI_FISH_PER_CHUNK,
                DEFAULT_MAX_SPAWNED_IN_CHUNK, tropiFishSpawnRateComment).getInt();
        anglerSpawnRate = config.get(CATEGORY_SPAWN_RATE, MAX_ANGLER_PER_CHUNK,
                DEFAULT_MAX_SPAWNED_IN_CHUNK, anglerSpawnRateComment).getInt();
        mantaRaySpawnRate = config.get(CATEGORY_SPAWN_RATE, MAX_MANTA_RAY_PER_CHUNK,
                DEFAULT_MAX_SPAWNED_IN_CHUNK, mantaRaySpawnRateComment).getInt();
        whaleSpawnRate = config.get(CATEGORY_SPAWN_RATE, MAX_WHALE_PER_CHUNK,
                DEFAULT_MAX_SPAWNED_IN_CHUNK, whaleSpawnRateComment).getInt();
        snakeSpawnRate = config.get(CATEGORY_SPAWN_RATE, MAX_SNAKE_PER_CHUNK,
                DEFAULT_MAX_SPAWNED_IN_CHUNK, snakeSpawnRateComment).getInt();
        lizardSpawnRate = config.get(CATEGORY_SPAWN_RATE, MAX_LIZARD_PER_CHUNK,
                DEFAULT_MAX_SPAWNED_IN_CHUNK, lizardSpawnRateComment).getInt();
        mouseSpawnRate = config.get(CATEGORY_SPAWN_RATE, MAX_MOUSE_PER_CHUNK,
                DEFAULT_MAX_SPAWNED_IN_CHUNK, mouseSpawnRateComment).getInt();
        birdSpawnRate = config.get(CATEGORY_SPAWN_RATE, MAX_BIRD_PER_CHUNK,
                DEFAULT_MAX_SPAWNED_IN_CHUNK, birdSpawnRateComment).getInt();
        duckSpawnRate = config.get(CATEGORY_SPAWN_RATE, MAX_DUCK_PER_CHUNK,
                DEFAULT_MAX_SPAWNED_IN_CHUNK, duckSpawnRateComment).getInt();
        penguinSpawnRate = config.get(CATEGORY_SPAWN_RATE, MAX_PENGUIN_PER_CHUNK,
                DEFAULT_MAX_SPAWNED_IN_CHUNK, penguinSpawnRateComment).getInt();
        piranhaSpawnRate = config.get(CATEGORY_SPAWN_RATE, MAX_PIRANHA_PER_CHUNK,
                DEFAULT_MAX_SPAWNED_IN_CHUNK, piranhaSpawnRateComment).getInt();
        sharkSpawnRate = config.get(CATEGORY_SPAWN_RATE, MAX_SHARK_PER_CHUNK,
                DEFAULT_MAX_SPAWNED_IN_CHUNK, sharkSpawnRateComment).getInt();

        config.addCustomCategoryComment(CATEGORY_SPAWN_RATE, "All values are integers 1-4. Setting higher than 4 can cause lag.");

        config.save();

    }

}
