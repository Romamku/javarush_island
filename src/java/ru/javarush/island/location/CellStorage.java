package ru.javarush.island.location;

import java.util.Map;
import java.util.TreeMap;

public class CellStorage {

    private final Map<String, Cell> cellHashMap;

    CellStorage(int column, int row) {
        this.cellHashMap = createCellHashMap(column, row);
        findAdjacentCell();
    }

    private Map<String, Cell> createCellHashMap(int islandLength, int islandWidth) {
        Map<String, Cell> cellHashMap = new TreeMap<>();

        for (int rowIndex = 0; rowIndex < islandWidth; rowIndex++) {
            for (int columnIndex = 0; columnIndex < islandLength; columnIndex++) {
                Cell cell = new Cell(columnIndex, rowIndex);
                cellHashMap.put(cell.name, cell);
            }
        }
        System.out.println();
        return cellHashMap;
    }

    private void findAdjacentCell() {
        for (Cell cell : cellHashMap.values()) {
            cell.setAdjacentCells(this);
        }
    }

    public Cell getCell(int column, int row) {
        String cellName = Cell.createName(column, row);
        return cellHashMap.getOrDefault(cellName, null);
    }

    public Cell[] getAllCell() {
        return cellHashMap.values().toArray(new Cell[0]);
    }
}
