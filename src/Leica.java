import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Leica {

    private String name;
    private List<WateringHistory>  listHistory;

    public Leica(String name){
        this.name = name;
        this.listHistory = new ArrayList<>();

    }


    public void doWater(StandartGreenhous greenhous, List<String> stringCoordinates){

        for (String str : stringCoordinates){
            String[] stringCoordinat = str.split("-");

            int index = Integer.parseInt(stringCoordinat[1]);
            String owner = stringCoordinat[0];

            Row row = greenhous.getRows().get(owner);

            ArrayList<Chechek> chechekler = new ArrayList<>(row.getChechekler());

            Chechek chechekToWater = chechekler.get(index);

            chechekToWater.waterChechek();
            Coordinate coord = new Coordinate(owner, index);
            WateringHistory history = new WateringHistory(coord, chechekToWater.getId());
            listHistory.add(history);
            System.out.println(chechekToWater.info() + " - полит из лейки");

        }

    }

    public void printHistory() {
        System.out.println("История лейки : " + name);

        for (int i = 0; i < listHistory.size(); i++) {
            WateringHistory record = listHistory.get(i);
            System.out.println("  " + (i+1) + ". " + record.getInfo());
        }

        System.out.println();
    }

    public String getName() {
        return name;
    }

    public List<WateringHistory> getListHistory() {
        return listHistory;
    }
}
