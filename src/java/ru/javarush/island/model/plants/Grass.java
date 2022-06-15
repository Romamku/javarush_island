package ru.javarush.island.model.plants;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.model.animals.type.CreatureType;
import ru.javarush.island.model.animals.absract.BasicItem;

public class Grass extends BasicItem {
    protected static int count;
    protected static final double AMOUNT = GameSettings.getSetting().GetMaxAmount(CreatureType.GRASS);
    public Grass(GameSettings settings, CreatureType type) {
        super(settings, type);
    }

    public void growth() {
        if(weight < settings.GetMaxAmount(type)) {
            weight++;
        }
    }
}
