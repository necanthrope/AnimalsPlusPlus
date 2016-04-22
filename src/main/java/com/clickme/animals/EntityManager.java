package com.clickme.animals;

import com.clickme.animals.entity.ambient.EntityButterfly;
import com.clickme.animals.entity.ambient.EntityCentipede;
import com.clickme.animals.entity.ambient.EntityCricket;
import com.clickme.animals.entity.ambient.EntityMoth;
import com.clickme.animals.entity.passive.*;
import com.clickme.animals.entity.water.EntityAngler;
import com.clickme.animals.entity.water.EntityFish;
import com.clickme.animals.entity.water.EntityMantaRay;
import com.clickme.animals.entity.water.EntityPiranha;
import com.clickme.animals.entity.water.EntityShark;
import com.clickme.animals.entity.water.EntityTropiFish;
import com.clickme.animals.entity.water.EntityWhale;
import com.clickme.animals.event.AnimalsPlusPlusConfig;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class EntityManager {

    private static Boolean twilightForestInstalled = false;
    private static ArrayList<BiomeGenBase> temperateTwilightBiomes = new ArrayList<BiomeGenBase>();
    private static ArrayList<BiomeGenBase> coldTwilightBiomes = new ArrayList<BiomeGenBase>();
    private static ArrayList<BiomeGenBase> aquaticTwilightBiomes = new ArrayList<BiomeGenBase>();

    public static void registerSpawning() {

        detectTwilightForest();

        ArrayList<BiomeGenBase> centipedeSpawns = new ArrayList<BiomeGenBase>(
                Arrays.asList(BiomeGenBase.forest, BiomeGenBase.forestHills,
                        BiomeGenBase.swampland, BiomeGenBase.birchForest,
                        BiomeGenBase.birchForestHills, BiomeGenBase.roofedForest,
                        BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills,
                        BiomeGenBase.jungle, BiomeGenBase.jungleHills,
                        BiomeGenBase.jungleEdge));
        if (twilightForestInstalled)
            centipedeSpawns.addAll(temperateTwilightBiomes);

        EntityRegistry.addSpawn(EntityCentipede.class, AnimalsPlusPlusConfig.centipedeSpawnChance, 1, 3, EnumCreatureType.ambient,
                centipedeSpawns.toArray(new BiomeGenBase[centipedeSpawns.size()]));
        /*
        EntityRegistry.addSpawn(EntityCentipede.class, 3, 1, 3, EnumCreatureType.ambient,
                BiomeGenBase.forest, BiomeGenBase.forestHills,
                BiomeGenBase.swampland, BiomeGenBase.birchForest,
                BiomeGenBase.birchForestHills, BiomeGenBase.roofedForest, BiomeGenBase.megaTaiga,
                BiomeGenBase.megaTaigaHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills,
                BiomeGenBase.jungleEdge);
                */





        ArrayList<BiomeGenBase> cricketSpawns = new ArrayList<BiomeGenBase>(
                Arrays.asList(
                        BiomeGenBase.plains, BiomeGenBase.swampland, BiomeGenBase.jungle,
                        BiomeGenBase.jungleHills, BiomeGenBase.jungleEdge, BiomeGenBase.savanna,
                        BiomeGenBase.savannaPlateau
                ));
        if (twilightForestInstalled)
            cricketSpawns.addAll(temperateTwilightBiomes);

        EntityRegistry.addSpawn(EntityCricket.class, AnimalsPlusPlusConfig.cricketSpawnChance, 3, 5, EnumCreatureType.ambient,
                cricketSpawns.toArray(new BiomeGenBase[cricketSpawns.size()]));
        /*
        EntityRegistry.addSpawn(EntityCricket.class, 3, 3, 5, EnumCreatureType.ambient,
                BiomeGenBase.plains, BiomeGenBase.swampland, BiomeGenBase.jungle,
                BiomeGenBase.jungleHills, BiomeGenBase.jungleEdge, BiomeGenBase.savanna,
                BiomeGenBase.savannaPlateau);
                */





        ArrayList<BiomeGenBase> butterflySpawns = new ArrayList<BiomeGenBase>(
                Arrays.asList(
                        BiomeGenBase.plains, BiomeGenBase.swampland, BiomeGenBase.jungle,
                        BiomeGenBase.jungleHills, BiomeGenBase.jungleEdge, BiomeGenBase.savanna,
                        BiomeGenBase.savannaPlateau
                ));
        if (twilightForestInstalled)
            butterflySpawns.addAll(temperateTwilightBiomes);

        EntityRegistry.addSpawn(EntityButterfly.class, AnimalsPlusPlusConfig.butterflySpawnChance, 1, 3, EnumCreatureType.ambient,
                butterflySpawns.toArray(new BiomeGenBase[butterflySpawns.size()]));
        /*
        EntityRegistry.addSpawn(EntityButterfly.class, 4, 1, 3, EnumCreatureType.ambient,
                BiomeGenBase.plains, BiomeGenBase.swampland, BiomeGenBase.jungle,
                BiomeGenBase.jungleHills, BiomeGenBase.jungleEdge, BiomeGenBase.savanna,
                BiomeGenBase.savannaPlateau);
                */





        ArrayList<BiomeGenBase> mothSpawns = new ArrayList<BiomeGenBase>(
                Arrays.asList(
                        BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland,
                        BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.birchForest,
                        BiomeGenBase.birchForestHills, BiomeGenBase.roofedForest, BiomeGenBase.megaTaiga,
                        BiomeGenBase.megaTaigaHills
                ));
        if (twilightForestInstalled)
            mothSpawns.addAll(temperateTwilightBiomes);

        EntityRegistry.addSpawn(EntityMoth.class, AnimalsPlusPlusConfig.mothSpawnChance, 1, 3, EnumCreatureType.ambient,
                mothSpawns.toArray(new BiomeGenBase[mothSpawns.size()]));
        /*
        EntityRegistry.addSpawn(EntityMoth.class, 4, 1, 3, EnumCreatureType.ambient,
                BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland,
                BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.birchForest,
                BiomeGenBase.birchForestHills, BiomeGenBase.roofedForest, BiomeGenBase.megaTaiga,
                BiomeGenBase.megaTaigaHills);
                */





        ArrayList<BiomeGenBase> fishSpawns = new ArrayList<BiomeGenBase>(
                Arrays.asList(
                        BiomeGenBase.ocean, BiomeGenBase.river, BiomeGenBase.frozenOcean,
                        BiomeGenBase.frozenRiver, BiomeGenBase.deepOcean
                        //, BiomeGenBase.swampland
                ));
        if (twilightForestInstalled)
            fishSpawns.addAll(aquaticTwilightBiomes);

        EntityRegistry.addSpawn(EntityFish.class, AnimalsPlusPlusConfig.tropiFishSpawnChance, 1, 3, EnumCreatureType.ambient,
                fishSpawns.toArray(new BiomeGenBase[fishSpawns.size()]));
        /*
        EntityRegistry.addSpawn(EntityFish.class, 12, 2, 4, EnumCreatureType.waterCreature,
                BiomeGenBase.ocean, BiomeGenBase.river, BiomeGenBase.frozenOcean,
                BiomeGenBase.frozenRiver, BiomeGenBase.deepOcean, BiomeGenBase.swampland);
                */





        ArrayList<BiomeGenBase> tropiFishSpawns = new ArrayList<BiomeGenBase>(
                Arrays.asList(
                        BiomeGenBase.river, BiomeGenBase.ocean, BiomeGenBase.deepOcean//,
                        //BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.jungleEdge,
                        //BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.desert,
                        //BiomeGenBase.desertHills
                ));
        if (twilightForestInstalled)
            tropiFishSpawns.addAll(aquaticTwilightBiomes);


        EntityRegistry.addSpawn(EntityTropiFish.class, AnimalsPlusPlusConfig.tropiFishSpawnChance, 3, 7, EnumCreatureType.ambient,
                tropiFishSpawns.toArray(new BiomeGenBase[tropiFishSpawns.size()]));
        /*
        EntityRegistry.addSpawn(EntityTropiFish.class, 12, 3, 7, EnumCreatureType.waterCreature,
                BiomeGenBase.river, BiomeGenBase.ocean, BiomeGenBase.deepOcean,
                BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.jungleEdge,
                BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.desert,
                BiomeGenBase.desertHills);
                */





        ArrayList<BiomeGenBase> anglerSpawns = new ArrayList<BiomeGenBase>(
                Arrays.asList(
                        BiomeGenBase.deepOcean, BiomeGenBase.swampland
                ));

        EntityRegistry.addSpawn(EntityAngler.class, AnimalsPlusPlusConfig.anglerSpawnChance, 1, 2, EnumCreatureType.ambient,
                anglerSpawns.toArray(new BiomeGenBase[anglerSpawns.size()]));
        /*
        EntityRegistry.addSpawn(EntityAngler.class, 8, 1, 2, EnumCreatureType.waterCreature,
                BiomeGenBase.deepOcean, BiomeGenBase.swampland);
                */





        ArrayList<BiomeGenBase> mantaSpawns = new ArrayList<BiomeGenBase>(
                Arrays.asList(
                        BiomeGenBase.ocean, BiomeGenBase.deepOcean//, BiomeGenBase.swampland
                ));
        if (twilightForestInstalled)
            mantaSpawns.addAll(aquaticTwilightBiomes);

        EntityRegistry.addSpawn(EntityMantaRay.class, AnimalsPlusPlusConfig.mantaRaySpawnChance, 1, 1, EnumCreatureType.ambient,
                mantaSpawns.toArray(new BiomeGenBase[mantaSpawns.size()]));
        /*
        EntityRegistry.addSpawn(EntityMantaRay.class, 4, 1, 1, EnumCreatureType.waterCreature,
                BiomeGenBase.ocean, BiomeGenBase.deepOcean, BiomeGenBase.swampland);
                */





        ArrayList<BiomeGenBase> whaleSpawns = new ArrayList<BiomeGenBase>(
                Arrays.asList(
                        BiomeGenBase.deepOcean
                ));

        EntityRegistry.addSpawn(EntityWhale.class, AnimalsPlusPlusConfig.whaleSpawnChance, 1, 1, EnumCreatureType.ambient,
                whaleSpawns.toArray(new BiomeGenBase[whaleSpawns.size()]));
        /*
        EntityRegistry.addSpawn(EntityWhale.class, 1, 1, 1, EnumCreatureType.waterCreature,
                BiomeGenBase.deepOcean);
                */





        ArrayList<BiomeGenBase> snakeSpawns = new ArrayList<BiomeGenBase>(
                Arrays.asList(
                        BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.jungleEdge,
                        BiomeGenBase.swampland, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau,
                        BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.mesa,
                        BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F
                ));
        if (twilightForestInstalled)
            snakeSpawns.addAll(temperateTwilightBiomes);

        EntityRegistry.addSpawn(EntitySnake.class, AnimalsPlusPlusConfig.snakeSpawnChance, 1, 2, EnumCreatureType.ambient,
                snakeSpawns.toArray(new BiomeGenBase[snakeSpawns.size()]));
        /*
        EntityRegistry.addSpawn(EntitySnake.class, 60, 1, 1, EnumCreatureType.creature,
                BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.jungleEdge,
                BiomeGenBase.swampland, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau,
                BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.mesa,
                BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F);
                */





        ArrayList<BiomeGenBase> lizardSpawns = new ArrayList<BiomeGenBase>(
                Arrays.asList(
                        BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.jungleEdge,
                        BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.desert,
                        BiomeGenBase.desertHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau,
                        BiomeGenBase.mesaPlateau_F
                ));
        if (twilightForestInstalled)
            lizardSpawns.addAll(temperateTwilightBiomes);

        EntityRegistry.addSpawn(EntityLizard.class, AnimalsPlusPlusConfig.lizardSpawnChance, 1, 2, EnumCreatureType.ambient,
                lizardSpawns.toArray(new BiomeGenBase[lizardSpawns.size()]));
        /*
        EntityRegistry.addSpawn(EntityLizard.class, 60, 1, 2, EnumCreatureType.creature,
                BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.jungleEdge,
                BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.desert,
                BiomeGenBase.desertHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau,
                BiomeGenBase.mesaPlateau_F);
                */





        ArrayList<BiomeGenBase> mouseSpawns = new ArrayList<BiomeGenBase>(
                Arrays.asList(
                        BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.birchForest,
                        BiomeGenBase.birchForestHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills
                ));
        if (twilightForestInstalled)
            mouseSpawns.addAll(temperateTwilightBiomes);

        EntityRegistry.addSpawn(EntityMouse.class, AnimalsPlusPlusConfig.mouseSpawnChance, 2, 5, EnumCreatureType.ambient,
                mouseSpawns.toArray(new BiomeGenBase[mouseSpawns.size()]));
        /*
        EntityRegistry.addSpawn(EntityMouse.class, 100, 2, 5, EnumCreatureType.creature,
                BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.birchForest,
                BiomeGenBase.birchForestHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills);
                */





        ArrayList<BiomeGenBase> birdSpawns = new ArrayList<BiomeGenBase>(
                Arrays.asList(
                        BiomeGenBase.plains, BiomeGenBase.forest, BiomeGenBase.forestHills,
                        BiomeGenBase.swampland, BiomeGenBase.jungle, BiomeGenBase.jungleHills,
                        BiomeGenBase.jungleEdge, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills,
                        BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills
                ));
        if (twilightForestInstalled)
            birdSpawns.addAll(temperateTwilightBiomes);

        EntityRegistry.addSpawn(EntityBird.class, AnimalsPlusPlusConfig.birdSpawnChance, 1, 3, EnumCreatureType.ambient,
                birdSpawns.toArray(new BiomeGenBase[birdSpawns.size()]));
        /*
        EntityRegistry.addSpawn(EntityBird.class, 100, 1, 3, EnumCreatureType.creature,
                BiomeGenBase.plains, BiomeGenBase.forest, BiomeGenBase.forestHills,
                BiomeGenBase.swampland, BiomeGenBase.jungle, BiomeGenBase.jungleHills,
                BiomeGenBase.jungleEdge, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills,
                BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills);
                */





        ArrayList<BiomeGenBase> duckSpawns = new ArrayList<BiomeGenBase>(
                Arrays.asList(
                        BiomeGenBase.river, BiomeGenBase.swampland
                ));
        if (twilightForestInstalled)
            duckSpawns.addAll(temperateTwilightBiomes);

        EntityRegistry.addSpawn(EntityDuck.class, AnimalsPlusPlusConfig.duckSpawnChance, 2, 3, EnumCreatureType.ambient,
                duckSpawns.toArray(new BiomeGenBase[duckSpawns.size()]));
        /*
        EntityRegistry.addSpawn(EntityDuck.class, 100, 2, 3, EnumCreatureType.creature,
                BiomeGenBase.river, BiomeGenBase.swampland);
                */





        ArrayList<BiomeGenBase> penguinSpawns = new ArrayList<BiomeGenBase>(
                Arrays.asList(
                        BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.frozenRiver,
                        BiomeGenBase.frozenOcean, BiomeGenBase.icePlains, BiomeGenBase.iceMountains
                ));
        if (twilightForestInstalled)
            penguinSpawns.addAll(coldTwilightBiomes);

        EntityRegistry.addSpawn(EntityPenguin.class, AnimalsPlusPlusConfig.penguinSpawnChance, 3, 5, EnumCreatureType.ambient,
                penguinSpawns.toArray(new BiomeGenBase[penguinSpawns.size()]));
        /*
        EntityRegistry.addSpawn(EntityPenguin.class, 100, 3, 5, EnumCreatureType.creature,
                BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.frozenRiver,
                BiomeGenBase.frozenOcean, BiomeGenBase.icePlains, BiomeGenBase.iceMountains);
                */






        ArrayList<BiomeGenBase> piranhaSpawns = new ArrayList<BiomeGenBase>(
                Arrays.asList(
                        BiomeGenBase.river, BiomeGenBase.jungle, BiomeGenBase.jungleHills,
                        BiomeGenBase.jungleEdge, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau,
                        BiomeGenBase.desert, BiomeGenBase.desertHills
                ));
        if (twilightForestInstalled)
            piranhaSpawns.addAll(aquaticTwilightBiomes);

        EntityRegistry.addSpawn(EntityPiranha.class, AnimalsPlusPlusConfig.piranhaSpawnChance, 4, 7, EnumCreatureType.ambient,
                piranhaSpawns.toArray(new BiomeGenBase[piranhaSpawns.size()]));
        /*
        EntityRegistry.addSpawn(EntityPiranha.class, 12, 4, 7, EnumCreatureType.waterCreature,
                BiomeGenBase.river, BiomeGenBase.jungle, BiomeGenBase.jungleHills,
                BiomeGenBase.jungleEdge, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau,
                BiomeGenBase.desert, BiomeGenBase.desertHills);
                */






        ArrayList<BiomeGenBase> sharkSpawns = new ArrayList<BiomeGenBase>(
                Arrays.asList(
                        BiomeGenBase.ocean, BiomeGenBase.deepOcean
                ));

        EntityRegistry.addSpawn(EntityShark.class, AnimalsPlusPlusConfig.sharkSpawnChance, 1, 3, EnumCreatureType.ambient,
                sharkSpawns.toArray(new BiomeGenBase[sharkSpawns.size()]));
        /*
        EntityRegistry.addSpawn(EntityShark.class, 4, 1, 3, EnumCreatureType.waterCreature,
                BiomeGenBase.ocean, BiomeGenBase.deepOcean);
                */
    }

    public static void registerEntities() {
        EntityRegistry.registerGlobalEntityID(EntityCentipede.class, "Centipede", EntityRegistry.findGlobalUniqueEntityId(), 15708256, 5848090);

        EntityRegistry.registerGlobalEntityID(EntityCricket.class, "Cricket", EntityRegistry.findGlobalUniqueEntityId(), 8343842, 2100236);

        EntityRegistry.registerGlobalEntityID(EntityButterfly.class, "Butterfly", EntityRegistry.findGlobalUniqueEntityId(), 15493137, 721666);

        EntityRegistry.registerGlobalEntityID(EntityMoth.class, "Moth", EntityRegistry.findGlobalUniqueEntityId(), 13614758, 6704950);

        EntityRegistry.registerGlobalEntityID(EntityFish.class, "Fish", EntityRegistry.findGlobalUniqueEntityId(), 6928807, 6057867);

        EntityRegistry.registerGlobalEntityID(EntityTropiFish.class, "TropicalFish", EntityRegistry.findGlobalUniqueEntityId(), 15887623, 15725300);

        EntityRegistry.registerGlobalEntityID(EntityAngler.class, "Angler", EntityRegistry.findGlobalUniqueEntityId(), 5397296, 15392616);

        EntityRegistry.registerGlobalEntityID(EntityMantaRay.class, "MantaRay", EntityRegistry.findGlobalUniqueEntityId(), 1052965, 14474460);

        EntityRegistry.registerGlobalEntityID(EntityWhale.class, "Whale", EntityRegistry.findGlobalUniqueEntityId(), 12772830, 8497600);

        EntityRegistry.registerGlobalEntityID(EntitySnake.class, "Snake", EntityRegistry.findGlobalUniqueEntityId(), 7096116, 14531977);

        EntityRegistry.registerGlobalEntityID(EntityLizard.class, "Lizard", EntityRegistry.findGlobalUniqueEntityId(), 13815232, 8219967);

        EntityRegistry.registerGlobalEntityID(EntityMouse.class, "Mouse", EntityRegistry.findGlobalUniqueEntityId(), 5986381, 15902877);

        EntityRegistry.registerGlobalEntityID(EntityBird.class, "Bird", EntityRegistry.findGlobalUniqueEntityId(), 4934535, 15910160);

        EntityRegistry.registerGlobalEntityID(EntityDuck.class, "Duck", EntityRegistry.findGlobalUniqueEntityId(), 4413191, 13155998);

        EntityRegistry.registerGlobalEntityID(EntityPenguin.class, "Pinguin", EntityRegistry.findGlobalUniqueEntityId(), 1066089, 13948116);

        EntityRegistry.registerGlobalEntityID(EntityPiranha.class, "Piranha", EntityRegistry.findGlobalUniqueEntityId(), 2829109, 14634030);

        EntityRegistry.registerGlobalEntityID(EntityShark.class, "Shark", EntityRegistry.findGlobalUniqueEntityId(), 11053224, 7631988);
    }


    private static void detectTwilightForest() {
        if (Loader.isModLoaded("TwilightForest")) {
            twilightForestInstalled = true;
            System.out.println("Twilight Forest detected.  Adding animal spawns to biomes.");

            try {
                Class<?> tfBiomeBase = Class.forName("twilightforest.biomes.TFBiomeBase");

                Field fieldTwilightForest = tfBiomeBase.getDeclaredField("twilightForest");
                temperateTwilightBiomes.add((BiomeGenBase) fieldTwilightForest.get(null));

                Field fieldTwilightForest2 = tfBiomeBase.getDeclaredField("twilightForest2");
                temperateTwilightBiomes.add((BiomeGenBase) fieldTwilightForest2.get(null));

                Field fieldHighlands = tfBiomeBase.getDeclaredField("highlands");
                temperateTwilightBiomes.add((BiomeGenBase) fieldHighlands.get(null));

                Field fieldMushrooms = tfBiomeBase.getDeclaredField("mushrooms");
                temperateTwilightBiomes.add((BiomeGenBase) fieldMushrooms.get(null));

                Field fieldTfSwamp = tfBiomeBase.getDeclaredField("tfSwamp");
                temperateTwilightBiomes.add((BiomeGenBase) fieldTfSwamp.get(null));

                Field fieldStream = tfBiomeBase.getDeclaredField("stream");
                temperateTwilightBiomes.add((BiomeGenBase) fieldStream.get(null));

                Field fieldClearing = tfBiomeBase.getDeclaredField("clearing");
                temperateTwilightBiomes.add((BiomeGenBase) fieldClearing.get(null));

                Field fieldOakSavanna = tfBiomeBase.getDeclaredField("oakSavanna");
                temperateTwilightBiomes.add((BiomeGenBase) fieldOakSavanna.get(null));

                Field fieldLightedForest = tfBiomeBase.getDeclaredField("lightedForest");
                temperateTwilightBiomes.add((BiomeGenBase) fieldLightedForest.get(null));

                Field fieldDeepMushrooms = tfBiomeBase.getDeclaredField("deepMushrooms");
                temperateTwilightBiomes.add((BiomeGenBase) fieldDeepMushrooms.get(null));

                Field fieldDarkForest = tfBiomeBase.getDeclaredField("darkForest");
                temperateTwilightBiomes.add((BiomeGenBase) fieldDarkForest.get(null));

                Field fieldDarkForestCenter = tfBiomeBase.getDeclaredField("darkForestCenter");
                temperateTwilightBiomes.add((BiomeGenBase) fieldDarkForestCenter.get(null));

                Field fieldEnchantedForest = tfBiomeBase.getDeclaredField("enchantedForest");
                temperateTwilightBiomes.add((BiomeGenBase) fieldEnchantedForest.get(null));

                Field fieldFireSwamp = tfBiomeBase.getDeclaredField("fireSwamp");
                temperateTwilightBiomes.add((BiomeGenBase) fieldFireSwamp.get(null));

                Field fieldHighlandsCenter = tfBiomeBase.getDeclaredField("highlandsCenter");
                temperateTwilightBiomes.add((BiomeGenBase) fieldHighlandsCenter.get(null));

                Field fieldThornlands = tfBiomeBase.getDeclaredField("thornlands");
                temperateTwilightBiomes.add((BiomeGenBase) fieldThornlands.get(null));


                Field fieldTfSnow = tfBiomeBase.getDeclaredField("tfSnow");
                coldTwilightBiomes.add((BiomeGenBase) fieldTfSnow.get(null));

                Field fieldGlacier = tfBiomeBase.getDeclaredField("glacier");
                coldTwilightBiomes.add((BiomeGenBase) fieldGlacier.get(null));


                Field fieldTfLake = tfBiomeBase.getDeclaredField("tfLake");
                aquaticTwilightBiomes.add((BiomeGenBase) fieldTfLake.get(null));

                /*
                temperateTwilightBiomes.add(TFBiomeBase.twilightForest);
                temperateTwilightBiomes.add(TFBiomeBase.twilightForest2);
                temperateTwilightBiomes.add(TFBiomeBase.highlands);
                temperateTwilightBiomes.add(TFBiomeBase.mushrooms);
                temperateTwilightBiomes.add(TFBiomeBase.tfSwamp);
                temperateTwilightBiomes.add(TFBiomeBase.stream);
                temperateTwilightBiomes.add(TFBiomeBase.clearing);
                temperateTwilightBiomes.add(TFBiomeBase.oakSavanna);
                temperateTwilightBiomes.add(TFBiomeBase.lightedForest);
                temperateTwilightBiomes.add(TFBiomeBase.deepMushrooms);
                temperateTwilightBiomes.add(TFBiomeBase.darkForest);
                temperateTwilightBiomes.add(TFBiomeBase.darkForestCenter);
                temperateTwilightBiomes.add(TFBiomeBase.enchantedForest);
                temperateTwilightBiomes.add(TFBiomeBase.fireSwamp);
                temperateTwilightBiomes.add(TFBiomeBase.highlandsCenter);
                temperateTwilightBiomes.add(TFBiomeBase.thornlands);

                coldTwilightBiomes.add(TFBiomeBase.tfSnow);
                coldTwilightBiomes.add(TFBiomeBase.glacier);

                aquaticTwilightBiomes.add(TFBiomeBase.tfLake);
                 */
            }
            catch (Exception e) {
                System.out.println("Twilight Forest not detected by Animals Plus!");
            }

        }

    }
}
