package ru.javarush.island.model.animals.herbivore;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.model.animals.type.CreatureType;
import ru.javarush.island.model.animals.absract.Herbivore;

public class Sheep extends Herbivore {
    public static final double AMOUNT = GameSettings.getSetting().GetMaxAmount(CreatureType.SHEEP);

    public Sheep(GameSettings settings, CreatureType type) {
        super(settings, type);
    }
}
