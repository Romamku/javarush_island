package ru.javarush.island.thread;

import ru.javarush.island.location.Island;

public class GrowGrass implements Runnable{

    private final Island island;

    public GrowGrass(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        synchronized (island) {
            island.growGrassInTheIsland();
        }
    }
}
