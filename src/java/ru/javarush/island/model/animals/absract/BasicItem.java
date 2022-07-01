package ru.javarush.island.model.animals.absract;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.location.RandomHelper;
import ru.javarush.island.model.animals.type.CreatureType;

public abstract class BasicItem {

    protected double amount;

    protected double weight;

    protected double movementSpeed;

    protected double amountOfFoodToFeed;

    public String name;

    public GameSettings settings;

    public CreatureType type;

    public double getAmount() {
        return amount;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    protected BasicItem(GameSettings settings, CreatureType type) {
        this.settings = settings;
        this.type = type;
        this.name = type.toString();
        this.weight = settings.GetMaxWeight(type);
        this.movementSpeed = settings.GetMaxMovementSpeed(type);
        double maxAmountOfFoodToFeed = settings.GetMaxAmountOfFoodToFeed(type);
        this.amountOfFoodToFeed = RandomHelper.get(maxAmountOfFoodToFeed + 1);
    }
}
