package ru.javarush.island.model.animals.predators;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.model.animals.type.CreatureType;
import ru.javarush.island.model.animals.absract.Predator;

public class Bear extends Predator {

    public Bear(GameSettings settings, CreatureType type) {
        super(settings, type);
    }
}
