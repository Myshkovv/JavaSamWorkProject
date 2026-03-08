
public class Chechek {
    private int id;
    private String name;
    public static int nextId = 0;
    private boolean isWater;

    public Chechek(String name){
        this.name = name;
        this.id = nextId;
        nextId++;
        this.isWater = false;
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof Chechek)) return false;

        Chechek chechek = (Chechek) object;

        return this.id == chechek.id;
    }

    @Override
    public int hashCode() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void waterChechek(){
        isWater = true;
    }

    public String info(){
        return  "Цветок: " + "id: "+ id + " Имя: " + name;
    }

    public boolean isWater() {
        return isWater;
    }

    public int getId(){
        return  id;
    }
}
