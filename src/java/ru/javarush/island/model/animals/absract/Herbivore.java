package ru.javarush.island.model.animals.absract;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.model.animals.type.CreatureType;

public abstract class Herbivore extends Animal {

    public Herbivore(GameSettings settings, CreatureType type) {
        super(settings, type);
    }
}
