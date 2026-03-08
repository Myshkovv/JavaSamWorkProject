public class Coordinate {

    private String owner;
    private int index;

    public Coordinate(String owner, int index){
        this.index = index;
        this.owner = owner;
    }


    public String getOwner() {
        return owner;
    }

    public int getIndex() {
        return index;
    }
}
