public abstract class Delivery<T extends Item> {
    private T item;
    private String address;
    private boolean isPrioritet = false;
    private int id;
    private static int nextId=0;

    public Delivery(T item, String address) {
        this.item = item;
        this.address = address;
        id = nextId;
        nextId++;
    }

    public T getItem() {
        return item;
    }

    public String getAddress() {
        return address;
    }

    public abstract double calculateCost();

    public boolean isPrioritet() {
        return isPrioritet;
    }

    public void setPrioritet(boolean prioritet) {
        isPrioritet = prioritet;
    }
    public int getId() {
        return id;
    }



}
