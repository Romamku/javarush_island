package ru.javarush.island.display;

import ru.javarush.island.model.animals.type.CreatureType;
import java.util.HashMap;
import java.util.Map;

public class Statistics {

    public static Map<CreatureType, Integer> mapBirthNewAnimal;

    public static Map<CreatureType, Integer> mapDeathAnimal;

    public Statistics() {
        mapBirthNewAnimal = getMap();
        mapDeathAnimal = getMap();
    }

    private static Map<CreatureType, Integer> getMap() {
        Map<CreatureType, Integer> basicMap = new HashMap<>();
        CreatureType[] types = CreatureType.values();
        for (CreatureType type : types) {
            if (!type.equals(CreatureType.GRASS)){
                basicMap.put(type, 0);
            }
        }
        return basicMap;
    }
}
