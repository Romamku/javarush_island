package ru.javarush.island;

import ru.javarush.island.display.Display;
import ru.javarush.island.location.Island;


public class Main {
    public static void main(String[] args) {
        Display.firstPart(); // ���� ��� ������, � ������
        System.out.println("������");
        Island island = new Island(10, 10); // ��� ������� �������� ������ ����� ������, ����� ������ ����� ������

        island.growGrassInAIsland();

        System.out.println();

    }
}

