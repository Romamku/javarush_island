package ru.javarush.island;

import ru.javarush.island.display.Display;
import ru.javarush.island.location.Island;


public class Main {
    public static void main(String[] args) {
        Display.firstPart(); // пока нет ничего, в работе
        System.out.println("Запуск");
        Island island = new Island(10, 10); // для быстрой проверки ставлю такой размер, можно менять какой угодно

        island.growGrassInAIsland();

        System.out.println();

    }
}

