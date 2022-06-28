package ru.javarush.island.location;

import ru.javarush.island.display.Statistics;
import ru.javarush.island.game.GameSettings;
import ru.javarush.island.model.animals.type.AdjacentCellType;
import ru.javarush.island.model.plants.Grass;
import ru.javarush.island.model.animals.type.CreatureType;
import ru.javarush.island.model.animals.absract.Animal;

import java.util.*;

public class Cell {

    private int row;

    private int column;

    private List<Animal> animals = new ArrayList<>();

    public Grass grass;

    public final String name;

    public Map<AdjacentCellType, Cell> mapOfAdjacentCells;

    public Cell(int column, int row) {
        this.row = row;
        this.column = column;

        this.name = createName(this.column, this.row);
        this.grass = new Grass(GameSettings.getSetting(), CreatureType.GRASS);
        this.mapOfAdjacentCells = new HashMap<>() {{
            put(AdjacentCellType.TOP, null);
            put(AdjacentCellType.BOTTOM, null);
            put(AdjacentCellType.LEFT, null);
            put(AdjacentCellType.RIGHT, null);
        }};
    }

    public static String createName(int column, int row) {
        return column + "_" + row;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal, boolean collectStatistics) {
        if (collectStatistics) {
            Statistics.mapDeathAnimal.compute(animal.type, (a, b) -> b + 1);
        }
        animals.remove(animal);
    }

    public void setAdjacentCells(CellStorage cellStorage) {
        mapOfAdjacentCells.put(AdjacentCellType.TOP, cellStorage.getCell(this.column, this.row - 1));
        mapOfAdjacentCells.put(AdjacentCellType.BOTTOM, cellStorage.getCell(this.column, this.row + 1));
        mapOfAdjacentCells.put(AdjacentCellType.LEFT, cellStorage.getCell(this.column - 1, this.row));
        mapOfAdjacentCells.put(AdjacentCellType.RIGHT, cellStorage.getCell(this.column + 1, this.row));
    }

    public int getAmountTypeOfAnimal(CreatureType type) {
        int countTypeOfAnimal = 0;
        for (Animal animal : animals) {
            if (type.equals(animal.type)) {
                countTypeOfAnimal++;
            }
        }
        return countTypeOfAnimal;
    }

    public Animal[] getAllAnimalFromCurrentCell() {
        return animals.toArray(new Animal[animals.size()]);
    }

    public int getCountOfAnimalOfTheCell() {
        return animals.size();
    }

    public ArrayList<CreatureType> getTypeOfCreatureOfTheCell() {
        ArrayList<CreatureType> typeOfAnimalOfTheCell = new ArrayList<>();
        for (Animal animal : animals) {
            if (!typeOfAnimalOfTheCell.contains(animal.type)) {
                typeOfAnimalOfTheCell.add(animal.type);
            }
        }
        return typeOfAnimalOfTheCell;
    }

    public int getCountTheTypeOfAnimalOfTheCell(CreatureType type) {
        int count = 0;
        for (Animal animal : animals) {
            if (animal.type.equals(type)) {
                count++;
            }
        }
        return count;
    }

    public Map<CreatureType, Integer> getMapCountDifferentTypeOfAnimal() {
        Map<CreatureType, Integer> mapCountDifferentTypeOfAnimal = new HashMap<>();
        for (CreatureType type : getTypeOfCreatureOfTheCell()) {
            mapCountDifferentTypeOfAnimal.put(type, getCountTheTypeOfAnimalOfTheCell(type));
        }
        return mapCountDifferentTypeOfAnimal;
    }

    public ArrayList<Animal> getListOfVictim(ArrayList<CreatureType> types) {
        ArrayList<Animal> listOfVictim = new ArrayList<>();

        for (CreatureType type : types) {
            for (Animal animal : this.animals) {
                if (type.equals(animal.type)) {
                    listOfVictim.add(animal);
                }
            }
        }
        Collections.shuffle(listOfVictim);
        return listOfVictim;
    }
}
