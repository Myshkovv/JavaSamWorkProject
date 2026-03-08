import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StandartGreenhous {
    private String name;
    private String[] owners;
    private Map<String, Row> rows;

    public StandartGreenhous(String name){
        this.name = name;
        this.owners = new String[] {"Вася",  "Петя", "Катя", "Вика", "Миша"};
        this.rows = new HashMap<>();
        for (String owner : owners) {
            rows.put(owner, new Row(owner));
        }

        addStaticChechekler();
    }

    public void addStaticChechekler(){
        for (int i = 0; i<owners.length; i++){
            Chechek chechek1 = new Chechek("Роза мимоза");
            Chechek chechek2 = new Chechek("Роза 2");
            Chechek chechek3 = new Chechek("Роза не роза");
            Chechek chechek4 = new Chechek("Роза роза");
            addChechek(chechek1, owners[i]);
            addChechek(chechek2, owners[i]);
            addChechek(chechek3, owners[i]);
            addChechek(chechek4, owners[i]);
        }
    }



    public boolean addChechek(Chechek chechek, String owner){

        Row row = rows.get(owner);
        if (row != null) {
            return row.addChechek(chechek);
        }
        return false;
    }


    public String getName() {
        return name;
    }



    public Map<String, Row> getRows(){
        return rows;
    }
}
