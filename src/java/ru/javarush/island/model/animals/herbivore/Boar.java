package ru.javarush.island.model.animals.herbivore;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.model.animals.type.CreatureType;
import ru.javarush.island.model.animals.absract.Herbivore;

public class Boar extends Herbivore {

    public Boar(GameSettings settings, CreatureType type) {
        super(settings, type);
    }
}
