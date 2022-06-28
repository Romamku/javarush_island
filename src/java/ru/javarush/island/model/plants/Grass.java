package ru.javarush.island.model.plants;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.location.RandomHelper;
import ru.javarush.island.model.animals.type.CreatureType;
import ru.javarush.island.model.animals.absract.BasicItem;

public class Grass extends BasicItem {
    protected static final double AMOUNT = GameSettings.getSetting().GetMaxAmount(CreatureType.GRASS);
    public Grass(GameSettings settings, CreatureType type) {
        super(settings, type);
        this.weight = RandomHelper.get(AMOUNT);
    }

    public void growth() {
        for (int i = 0; i < 10; i++) {
            if(weight < settings.GetMaxAmount(type)) {
                weight++;
            }
            else {
                break;
            }
        }
    }
}
