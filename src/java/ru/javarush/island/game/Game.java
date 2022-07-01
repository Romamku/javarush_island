package ru.javarush.island.game;

import ru.javarush.island.display.Display;
import ru.javarush.island.location.Island;
import ru.javarush.island.thread.GameMove;
import ru.javarush.island.thread.GrowGrass;
import ru.javarush.island.thread.PrintStatistics;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game implements Runnable {

    @Override
    public void run() {
        Display.firstPart();
        Island island = new Island(Display.length, Display.width);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.scheduleAtFixedRate(new GrowGrass(island), 0, 2, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new GameMove(island), 0, 2, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new PrintStatistics(island), 0, 1, TimeUnit.SECONDS);

        while (true) {
            try {
                Thread.sleep(5000);
                if (island.currentCountOfAnimal() == 0) {
                    scheduledExecutorService.shutdown();
                    System.out.println("All the animals died");
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

