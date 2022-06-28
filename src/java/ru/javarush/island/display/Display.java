package ru.javarush.island.display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Display {

    public static int length;
    public static int width;

    public static void firstPart()  {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));){
            System.out.println("Hi. Here’s the island simulator");
            System.out.println("Enter the desired island size");
            System.out.println("Length: ");
            length = Integer.parseInt(reader.readLine());
            System.out.println("Width: ");
            width = Integer.parseInt(reader.readLine());
        }
        catch (IOException | NullPointerException | NumberFormatException ex) {
            System.out.println("Вы ввели некорректное значение!");
        }
    }
}
