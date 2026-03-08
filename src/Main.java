import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandartGreenhous greenhouse = new StandartGreenhous("Крутая теплица");

        Leica leica = new Leica("Садовый черт 3000");

        List<String> coordinates = new ArrayList<>();
        coordinates.add("Вася-0");
        coordinates.add("Петя-2");
        coordinates.add("Катя-1");
        coordinates.add("Вика-0");
        coordinates.add("Миша-3");

        leica.doWater(greenhouse, coordinates);

        leica.printHistory();



    }
}