package ru.javarush.island.model.animals.absract;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.location.Cell;
import ru.javarush.island.location.Island;
import ru.javarush.island.location.RandomHelper;
import ru.javarush.island.model.animals.type.AdjacentCellType;
import ru.javarush.island.model.animals.type.CreatureType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Animal extends BasicItem {

    protected Cell currentCell;


    protected Animal(GameSettings settings, CreatureType type) {
        super(settings, type);
    }

    public void setCurrentCell(Cell cell) {
        this.currentCell = cell;
        currentCell.addAnimal(this);
    }

    private Cell chooseCell() {
        List<Cell> optionCell = new ArrayList<>();
        for (Map.Entry<AdjacentCellType, Cell> entry : this.currentCell.mapOfAdjacentCells.entrySet()) {
            if (entry.getValue() != null) {
                if (entry.getValue().getAmountTypeOfAnimal(this.type) < this.settings.GetMaxAmount(this.type)) {
                    optionCell.add(entry.getValue());
                }
            }
        }
        if (optionCell.size() != 0) {
            int direction = RandomHelper.get(optionCell.size());
            return optionCell.get(direction);
        }
        return null;
    }

    public void move() {
        int countStep = RandomHelper.get((this.movementSpeed + 1));
        for (int step = 1; step <= countStep; step++) {
            var cell = chooseCell();
            if (cell != null) {
                this.currentCell.removeAnimal(this, false);
                this.currentCell = cell;
                cell.addAnimal(this);
            }
        }
    }

    public void eat() {
        ArrayList<Animal> listOfVictim = currentCell.
                getListOfVictim(settings.listsOfTypeForEating(currentCell.getTypeOfCreatureOfTheCell(), type));

        for (int attempt = 0; attempt < 3; attempt++) {
            if (this.amountOfFoodToFeed < settings.GetMaxAmountOfFoodToFeed(type)) {
                eatAnimal(listOfVictim);
            }
        }
    }

    protected void eatAnimal(ArrayList<Animal> listOfVictim) {
        for (Animal victimAnimal : listOfVictim) {
            if (!settings.shouldBeEaten(type, victimAnimal.type)) {
                continue;
            }
            amountOfFoodToFeed += victimAnimal.getWeight();
            if (amountOfFoodToFeed > settings.GetMaxAmountOfFoodToFeed(type)) {
                amountOfFoodToFeed = settings.GetMaxAmountOfFoodToFeed(type);
            }
            currentCell.removeAnimal(victimAnimal, true);
        }
    }

    public void breed() {
        Map<CreatureType, Integer> mapCountDifferentTypeOfAnimal = this.currentCell.getMapCountDifferentTypeOfAnimal();
        for (Map.Entry<CreatureType, Integer> entry : mapCountDifferentTypeOfAnimal.entrySet()) {
            if (this.type.equals(entry.getKey())) {
                int newAnimals = (int) (entry.getValue() / 2 * 0.2);
                if (this.settings.GetMaxAmount(this.type) > entry.getValue()) {
                    for (int i = 0; i < newAnimals; i++) {
                        Island.createdChildAnimal(this.currentCell, this.type);
                    }
                }
            }
        }
    }

    public void looseHealth() {
        this.amountOfFoodToFeed -= settings.GetMaxAmountOfFoodToFeed(this.type)*0.1;
        if (this.amountOfFoodToFeed < 0) {
            currentCell.removeAnimal(this, true);
        }
    }
}
