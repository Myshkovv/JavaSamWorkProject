import java.util.HashSet;
import java.util.Set;

public class ElitGreenhouse {
    private String name;
    private Set<Chechek> chechekler;

    public ElitGreenhouse(String name){
        this.name = name;
        this.chechekler = new HashSet<>();
    }

    public ElitGreenhouse(String name, Set<Chechek> chechekler){
        this.name = name;
        this.chechekler = chechekler;
    }

    public boolean addChechek(Chechek chechek){
        if (chechekler.add(chechek)){
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
