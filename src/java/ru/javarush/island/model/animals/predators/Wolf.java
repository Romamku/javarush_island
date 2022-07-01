package ru.javarush.island.model.animals.predators;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.model.animals.type.CreatureType;
import ru.javarush.island.model.animals.absract.Predator;

public class Wolf extends Predator {

    public Wolf(GameSettings settings, CreatureType type) {
        super(settings, type);
    }
}
