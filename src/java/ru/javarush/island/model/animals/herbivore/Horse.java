package ru.javarush.island.model.animals.herbivore;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.model.animals.type.CreatureType;
import ru.javarush.island.model.animals.absract.Herbivore;

public class Horse extends Herbivore {

    public Horse(GameSettings settings, CreatureType type) {
        super(settings, type);
    }
}
