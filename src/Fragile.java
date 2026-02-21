public enum Fragile {


    VERY("очень хрупкий"),
    NORMAL("нормально хрупкий"),
    ALMOST("почти не хрупкий");

    String name;

    Fragile(String name){
        this.name = name();
    }

    public String getName(){
        return name;
    }
}
