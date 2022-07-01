package ru.javarush.island.thread;

import ru.javarush.island.location.Island;

public class PrintStatistics implements Runnable{

    private final Island island;

    public PrintStatistics(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        synchronized (island) {
            island.printStatistics();
        }
    }
}
