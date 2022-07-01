package ru.javarush.island.model.animals.absract;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.model.animals.type.CreatureType;

public abstract class Predator extends Animal {

    protected Predator(GameSettings settings, CreatureType type) {
        super(settings, type);
    }
}
