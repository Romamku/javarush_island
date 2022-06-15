package ru.javarush.island.location;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.model.animals.type.AdjacentCellType;
import ru.javarush.island.model.plants.Grass;
import ru.javarush.island.model.animals.type.CreatureType;
import ru.javarush.island.model.animals.absract.Animal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cell {
    public final String name;
    public int row;
    public int column;
    public Grass grass;

    public Map<AdjacentCellType, Cell> mapOfAdjacentCells;

    private List<Animal> animals = new ArrayList<>();

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
        animals.stream().forEach(x -> System.out.println(animal.name + " β ÿχεικε " + this.name));
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public void setAdjacentCells(CellStorage cellStorage) {
        mapOfAdjacentCells.put(AdjacentCellType.TOP, cellStorage.getCell(this.column, this.row - 1));
        mapOfAdjacentCells.put(AdjacentCellType.BOTTOM, cellStorage.getCell(this.column, this.row + 1));
        mapOfAdjacentCells.put(AdjacentCellType.LEFT, cellStorage.getCell(this.column - 1, this.row));
        mapOfAdjacentCells.put(AdjacentCellType.RIGHT, cellStorage.getCell(this.column + 1, this.row));
    }

}


