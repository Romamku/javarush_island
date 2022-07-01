package ru.javarush.island.game;

import ru.javarush.island.location.RandomHelper;
import ru.javarush.island.model.animals.type.CreatureType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameSettings {

    private static final GameSettings setting = new GameSettings();

    public static GameSettings getSetting() {
        return setting;
    }

    private Map<CreatureType, double[]> animalCharacteristics() {
        Map<CreatureType, double[]> animalCharacteristics = new HashMap<>() {{
            put(CreatureType.BEAR,          new double[]{   500,      5,   2,     80});
            put(CreatureType.BOA,           new double[]{    15,     30,   1,      3});
            put(CreatureType.EAGLE,         new double[]{     6,     20,   3,      1});
            put(CreatureType.FOX,           new double[]{     8,     30,   2,      2});
            put(CreatureType.WOLF,          new double[]{    50,     30,   3,      8});
            put(CreatureType.BOAR,          new double[]{   400,     50,   2,     50});
            put(CreatureType.BUFFALO,       new double[]{   700,     10,   3,    100});
            put(CreatureType.CATERPILLAR,   new double[]{  0.01,   1000,   0,      0});
            put(CreatureType.DEER,          new double[]{   300,     20,   4,     50});
            put(CreatureType.DUCK,          new double[]{     1,    200,   4,   0.15});
            put(CreatureType.GOAT,          new double[]{    60,    140,   3,     10});
            put(CreatureType.HORSE,         new double[]{   400,     20,   4,     60});
            put(CreatureType.MOUSE,         new double[]{  0.05,    500,   1,   0.01});
            put(CreatureType.RABBIT,        new double[]{     2,    150,   2,   0.45});
            put(CreatureType.SHEEP,         new double[]{    70,    140,   3,     15});
            put(CreatureType.GRASS,         new double[]{     1,    200,   0,      0});

        }};
        return animalCharacteristics;
    }

    public double GetMaxWeight(CreatureType type) {
        return animalCharacteristics().getOrDefault(type, null)[0];
    }

    public double GetMaxAmount(CreatureType type) {
        return animalCharacteristics().getOrDefault(type, null)[1];
    }

    public double GetMaxMovementSpeed(CreatureType type) {
        return animalCharacteristics().getOrDefault(type, null)[2];
    }

    public double GetMaxAmountOfFoodToFeed(CreatureType type) {
        return animalCharacteristics().getOrDefault(type, null)[3];
    }

    private Map<CreatureType, Integer[]> probabilityOfEating() {
        Map<CreatureType, Integer[]> probabilityOfEating = new HashMap<>() {{
            put(CreatureType.WOLF,            new Integer[]{ null,     0,     0,     0,     0,    10,    15,    60,    80,    60,    70,    15,    10,    40,     0,    0});
            put(CreatureType.BOA,             new Integer[]{    0,  null,    15,     0,     0,     0,     0,    20,    40,     0,     0,     0,     0,    10,     0,    0});
            put(CreatureType.FOX,             new Integer[]{    0,     0,  null,     0,     0,     0,     0,    70,    90,     0,     0,     0,     0,    60,    40,    0});
            put(CreatureType.BEAR,            new Integer[]{    0,    80,     0,  null,     0,    40,    80,    80,    90,    70,    70,    50,    20,    10,     0,    0});
            put(CreatureType.EAGLE,           new Integer[]{    0,     0,    10,     0,  null,     0,     0,    90,    90,     0,     0,     0,     0,    80,     0,    0});
            put(CreatureType.HORSE,           new Integer[]{    0,     0,     0,     0,     0,  null,     0,     0,     0,     0,     0,     0,     0,     0,     0,  100});
            put(CreatureType.DEER,            new Integer[]{    0,     0,     0,     0,     0,     0,  null,     0,     0,     0,     0,     0,     0,     0,     0,  100});
            put(CreatureType.RABBIT,          new Integer[]{    0,     0,     0,     0,     0,     0,     0,  null,     0,     0,     0,     0,     0,     0,     0,  100});
            put(CreatureType.MOUSE,           new Integer[]{    0,     0,     0,     0,     0,     0,     0,     0,  null,     0,     0,     0,     0,     0,    90,  100});
            put(CreatureType.GOAT,            new Integer[]{    0,     0,     0,     0,     0,     0,     0,     0,     0,  null,     0,     0,     0,     0,     0,  100});
            put(CreatureType.SHEEP,           new Integer[]{    0,     0,     0,     0,     0,     0,     0,     0,     0,     0,  null,     0,     0,     0,     0,  100});
            put(CreatureType.BOAR,            new Integer[]{    0,     0,     0,     0,     0,     0,     0,     0,    50,     0,     0,  null,     0,     0,    90,  100});
            put(CreatureType.BUFFALO,         new Integer[]{    0,     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,  null,     0,     0,  100});
            put(CreatureType.DUCK,            new Integer[]{    0,     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,  null,    90,  100});
            put(CreatureType.CATERPILLAR,     new Integer[]{    0,     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,  100});
            put(CreatureType.GRASS,           new Integer[]{    0,     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,    0});
        }};
        return probabilityOfEating;
    }

    private Integer getChance(CreatureType thisType, CreatureType type) {
        return switch (type) {
            case WOLF -> probabilityOfEating().get(thisType)[0];
            case BOA -> probabilityOfEating().get(thisType)[1];
            case FOX -> probabilityOfEating().get(thisType)[2];
            case BEAR -> probabilityOfEating().get(thisType)[3];
            case EAGLE -> probabilityOfEating().get(thisType)[4];
            case HORSE -> probabilityOfEating().get(thisType)[5];
            case DEER -> probabilityOfEating().get(thisType)[6];
            case RABBIT -> probabilityOfEating().get(thisType)[7];
            case MOUSE -> probabilityOfEating().get(thisType)[8];
            case GOAT -> probabilityOfEating().get(thisType)[9];
            case SHEEP -> probabilityOfEating().get(thisType)[10];
            case BOAR -> probabilityOfEating().get(thisType)[11];
            case BUFFALO -> probabilityOfEating().get(thisType)[12];
            case DUCK -> probabilityOfEating().get(thisType)[13];
            case CATERPILLAR -> probabilityOfEating().get(thisType)[14];
            default -> probabilityOfEating().get(thisType)[15];
        };
    }

    public ArrayList<CreatureType> listsOfTypeForEating(ArrayList<CreatureType> typeOfAnimalOfTheCell, CreatureType thisType) {
        ArrayList<CreatureType> typeForEating = new ArrayList<>();

        for (CreatureType type : typeOfAnimalOfTheCell) {
            for (Map.Entry<CreatureType, Integer[]> entry : probabilityOfEating().entrySet()) {
                if (entry.getKey().equals(type)) {
                    if (getChance(thisType, type) == null || getChance(thisType, type) == 0) {
                    }
                    else {
                        typeForEating.add(type);
                    }
                }
            }
        }
        return typeForEating;
    }

    public boolean shouldBeEaten(CreatureType thisType, CreatureType victimType) {
        return RandomHelper.get(101) <= getChance(thisType, victimType);
    }
}
