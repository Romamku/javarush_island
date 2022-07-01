package ru.javarush.island.location;

import ru.javarush.island.display.Statistics;
import ru.javarush.island.game.GameSettings;
import ru.javarush.island.model.animals.absract.Animal;
import ru.javarush.island.model.animals.herbivore.*;
import ru.javarush.island.model.animals.predators.*;
import ru.javarush.island.model.animals.type.CreatureType;
import java.util.ArrayList;

public class Island {

    private CellStorage cellStorage;

    private GameSettings settings;

    private static Statistics statistics;

    public Island(int length, int width) {
        this.cellStorage = new CellStorage(length, width);
        this.settings = new GameSettings();
        statistics = new Statistics();
        fillTheIslandWithAnimal();
        System.out.println();
        System.out.println("The original number of animals on the island is: " + currentCountOfAnimal());
        getCountTypeAnimals();
        System.out.println("The original number of grass on the island is: " + countGrass());
    }

    private void fillTheIslandWithAnimal() {
        for (Cell cell : cellStorage.getAllCell()) {
            CreatureType[] types = CreatureType.values();
            for (CreatureType type : types) {
                if (!type.equals(CreatureType.GRASS)) {
                    int countAnimalOfCell = RandomHelper.get(settings.GetMaxAmount(type));
                    for (int i = 0; i < countAnimalOfCell; i++) {
                        Animal animal = createAnimal(type);
                        animal.setCurrentCell(cell);
                    }
                }
            }
        }
    }

    public static Animal createAnimal(CreatureType type) {
        return switch (type) {
            case CATERPILLAR -> new Caterpillar(GameSettings.getSetting(), CreatureType.CATERPILLAR);
            case BEAR -> new Bear(GameSettings.getSetting(), CreatureType.BEAR);
            case BOA -> new Boa(GameSettings.getSetting(), CreatureType.BOA);
            case EAGLE -> new Eagle(GameSettings.getSetting(), CreatureType.EAGLE);
            case FOX -> new Fox(GameSettings.getSetting(), CreatureType.FOX);
            case BOAR -> new Boar(GameSettings.getSetting(), CreatureType.BOAR);
            case BUFFALO -> new Buffalo(GameSettings.getSetting(), CreatureType.BUFFALO);
            case DEER -> new Deer(GameSettings.getSetting(), CreatureType.DEER);
            case DUCK -> new Duck(GameSettings.getSetting(), CreatureType.DUCK);
            case GOAT -> new Goat(GameSettings.getSetting(), CreatureType.GOAT);
            case HORSE -> new Horse(GameSettings.getSetting(), CreatureType.HORSE);
            case MOUSE -> new Mouse(GameSettings.getSetting(), CreatureType.MOUSE);
            case RABBIT -> new Rabbit(GameSettings.getSetting(), CreatureType.RABBIT);
            case SHEEP -> new Sheep(GameSettings.getSetting(), CreatureType.SHEEP);
            default -> new Wolf(GameSettings.getSetting(), CreatureType.WOLF);
        };
    }

    public void moveCreature() {
        for (Cell cell : cellStorage.getAllCell()) {
            for (Animal animal : cell.getAllAnimalFromCurrentCell()) {
                animal.move();
            }
        }
    }

    public void eatCreature() {
        for (Cell cell : cellStorage.getAllCell()) {
            for (Animal animal : cell.getAllAnimalFromCurrentCell()) {
                animal.eat();
            }
        }
    }

    public void breadCreature() {
        for (Cell cell : cellStorage.getAllCell()) {
            ArrayList<CreatureType> types = new ArrayList<>();
            for (Animal animal : cell.getAllAnimalFromCurrentCell()) {
                if (!types.contains(animal.type)){
                    animal.breed();
                }
                types.add(animal.type);
            }
        }
    }

    public static void createdChildAnimal(Cell cell, CreatureType type) {
        Animal animalChild = createAnimal(type);
        animalChild.setCurrentCell(cell);
        Statistics.mapBirthNewAnimal.compute(type, (a, b) -> b+1);
    }

    public double countGrass() {
        double count = 0;
        for (Cell cell : cellStorage.getAllCell()) {
            count += cell.grass.getWeight();
        }
        return count;
    }

    public void growGrassInTheIsland() {
        for (Cell cell : cellStorage.getAllCell()) {
            cell.grass.growth();
        }
    }

    private String getCountTheTypeOfAnimalOfTheIsland(CreatureType type) {
        int count = 0;
        for (Cell cell : cellStorage.getAllCell()) {
            count += cell.getCountTheTypeOfAnimalOfTheCell(type);
        }
        return type.name() + " : " + count + " / " ;
    }

    public void getCountTypeAnimals() {
        CreatureType[] types = CreatureType.values();
        for (CreatureType type : types) {
            if (!type.equals(CreatureType.GRASS) && type.equals(CreatureType.CATERPILLAR)) {
                System.out.print(getCountTheTypeOfAnimalOfTheIsland(type) + " ");
            }
        }
        System.out.println();
    }

    public int currentCountOfAnimal() {
        int count = 0;
        for (Cell cell : cellStorage.getAllCell()) {
            count += cell.getCountOfAnimalOfTheCell();
        }
        return count;
    }

    public void looseHealth() {
        for (Cell cell : cellStorage.getAllCell()) {
            for (Animal animal : cell.getAllAnimalFromCurrentCell()) {
                animal.looseHealth();
            }
        }
    }

    public void printStatistics() {
        CreatureType[] types = CreatureType.values();
        StringBuilder result = new StringBuilder();
        for (CreatureType type : types) {
            if (!type.equals(CreatureType.GRASS)) {
                int countAllAnimal = 0;
                for (Cell cell : cellStorage.getAllCell()) {
                    countAllAnimal += cell.getCountTheTypeOfAnimalOfTheCell(type);
                }
                int countBornAnimal = Statistics.mapBirthNewAnimal.get(type);
                int countDeadAnimal = Statistics.mapDeathAnimal.get(type);
                result.append(type.name()).append(":").append(countAllAnimal).append("/+").append(countBornAnimal).append("/-").append(countDeadAnimal).append("; ");
            }
        }
        System.out.println(result);
    }
}
