package ru.javarush.island.location;

import java.util.Random;

public class RandomHelper {

    private static final Random random = new Random();

    public static int get(double max) {

        return  random.nextInt((int)max);
    }
}
