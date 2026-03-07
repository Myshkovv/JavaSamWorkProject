public class Box extends Item {
    private double weight;
    private int id;
    private static int nextId=0;

    public Box(String name, double weight) {
        super(name);
        this.weight = weight;
        id = nextId;
        nextId++;
    }

    public double getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }
}