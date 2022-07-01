package ru.javarush.island.model.animals.absract;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.model.animals.type.CreatureType;
import java.util.ArrayList;

public abstract class Herbivore extends Animal {

    public Herbivore(GameSettings settings, CreatureType type) {
        super(settings, type);
    }

    private void eatGrass() {
        double grassWeight = currentCell.grass.getWeight();
        if (grassWeight > 0) {
            this.amountOfFoodToFeed += 1;
            this.currentCell.grass.setWeight(grassWeight - 1);
        }
    }

    public void eat() {
        ArrayList<Animal> listOfVictim = currentCell.getListOfVictim(settings.listsOfTypeForEating(currentCell.getTypeOfCreatureOfTheCell(), type));

        for (int attempt = 0; attempt < 3; attempt++) {
            if (this.amountOfFoodToFeed < settings.GetMaxAmountOfFoodToFeed(type)) {
                eatAnimal(listOfVictim);
                eatGrass();
            }
        }
    }
}
