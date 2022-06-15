package ru.javarush.island.model.animals.absract;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.location.Cell;
import ru.javarush.island.location.RandomHelper;
import ru.javarush.island.model.animals.type.AdjacentCellType;
import ru.javarush.island.model.animals.type.CreatureType;

public abstract class Animal extends BasicItem {

    private Cell currentCell;

    protected Animal(GameSettings settings, CreatureType type) {
        super(settings, type);
    }

    public void SetCurrentCell(Cell cell) {
        this.currentCell = cell;
        currentCell.addAnimal(this);
    }


    public void eat() {
    }

    private int choosePath() {
        return RandomHelper.get(4);
    }
//тут я пока не закончил в порядок метод приводить
    public void move(){
        int direction = choosePath();
        int countStep = RandomHelper.get(this.movementSpeed);

        if (direction == AdjacentCellType.TOP.ordinal()) {
            for (int step = 1; step <= countStep; step++) {
                if (currentCell.mapOfAdjacentCells.get(direction) != null) {
                    this.currentCell = currentCell.mapOfAdjacentCells.get(direction);
                }
                else {
                    break;
                }
            }
        }
        else if (direction == AdjacentCellType.BOTTOM.ordinal()) {
            for (int step = 1; step <= countStep; step++) {
                if (currentCell.mapOfAdjacentCells.get(direction) != null) {
                    this.currentCell = currentCell.mapOfAdjacentCells.get(direction);
                }
                else {
                    break;
                }
            }
        }
        else if (direction == AdjacentCellType.LEFT.ordinal()) {
            for (int step = 1; step <= countStep; step++) {
                if (currentCell.mapOfAdjacentCells.get(direction) != null) {
                    this.currentCell = currentCell.mapOfAdjacentCells.get(direction);
                }
                else {
                    break;
                }
            }
        } else {
            for (int step = 1; step <= countStep; step++) {
                if (currentCell.mapOfAdjacentCells.get(direction) != null) {
                    this.currentCell = currentCell.mapOfAdjacentCells.get(direction);
                }
                else {
                    break;
                }
            }
        }
    }

    public void breed() {
    }
}
