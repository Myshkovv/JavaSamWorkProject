import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Row {

    private String name;
    private List<Chechek> chechekler;

    public Row(String name){
        this.name = name;
        this.chechekler = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Chechek> getChechekler(){
        return Collections.unmodifiableList(chechekler);
    }

    public boolean addChechek(Chechek chechek){
        return chechekler.add(chechek);
    }
}
