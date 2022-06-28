package ru.javarush.island.model.animals.herbivore;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.location.RandomHelper;
import ru.javarush.island.model.animals.type.CreatureType;
import ru.javarush.island.model.animals.absract.Herbivore;

public class Mouse extends Herbivore {

    public Mouse(GameSettings settings, CreatureType type) {
        super(settings, type);
        this.amountOfFoodToFeed = RandomHelper.get(101) * 0.01/100;
    }
}
