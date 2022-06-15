package ru.javarush.island.model.animals.absract;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.model.animals.type.CreatureType;

public abstract class BasicItem {

    protected double weight;

    protected double movementSpeed;

    protected double amountOfFoodToFeed;

    public String name;

    protected GameSettings settings;

    protected CreatureType type;

    protected BasicItem(GameSettings settings, CreatureType type) {
        this.settings = settings;
        this.type = type;
        this.name = type.toString();

        this.weight = settings.GetMaxWeight(type);

        this.movementSpeed = settings.GetMaxMovementSpeed(type);

        this.amountOfFoodToFeed = settings.GetMaxAmountOfFoodToFeed(type);
    }
}
