public enum PalletType {

    A("длинный", 20),
    B("узкий", 10);

    String name;
    int capacity;


    PalletType(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }

    public String getName(){
        return name;
    }

    public int getCapacity(){
        return capacity;
    }


}
