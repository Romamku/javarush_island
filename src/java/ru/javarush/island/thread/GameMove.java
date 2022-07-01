package ru.javarush.island.thread;

import ru.javarush.island.location.Island;

public class GameMove implements Runnable {

    private final Island island;

    public GameMove(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        synchronized (island) {
            island.moveCreature();
            island.breadCreature();
            island.eatCreature();
            island.looseHealth();
        }
    }
}
