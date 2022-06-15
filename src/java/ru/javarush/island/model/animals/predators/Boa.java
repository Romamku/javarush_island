package ru.javarush.island.model.animals.predators;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.model.animals.type.CreatureType;
import ru.javarush.island.model.animals.absract.Predator;

public class Boa extends Predator {
    public static final double AMOUNT = GameSettings.getSetting().GetMaxAmount(CreatureType.BOA);

    protected Boa(GameSettings settings, CreatureType type) {
        super(settings, type);
    }
}
