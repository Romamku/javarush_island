package ru.javarush.island.location;

import ru.javarush.island.game.GameSettings;
import ru.javarush.island.model.animals.absract.Animal;
import ru.javarush.island.model.animals.herbivore.Horse;
import ru.javarush.island.model.animals.type.CreatureType;
import java.util.ArrayList;
import java.util.List;

public class Island {

    CellStorage cellStorage;

    GameSettings settings;

    List<Animal> listOfAnimal;

    public Island(int length, int width) {
        this.cellStorage = new CellStorage(length, width);
        this.settings = new GameSettings();
        this.listOfAnimal = new ArrayList<>();


        for (Cell cell : cellStorage.getAll()) {
            int c = RandomHelper.get(Horse.AMOUNT); // пока это все в работе, добавл€ю коней, провер€ю
            for (int i = 0; i < c; i++) {
                Horse horse = new Horse(GameSettings.getSetting(), CreatureType.HORSE);
                horse.SetCurrentCell(cell);
                listOfAnimal.add(horse);
            }
        }
    }

    public void growGrassInAIsland() {
        for (Cell cell : cellStorage.getAll()) {
            cell.grass.growth();
        }

        System.out.println("“рава выросла на 1 во всех €чейках");// писал дл€ себ€
    }
}
