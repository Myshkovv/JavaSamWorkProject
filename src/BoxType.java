public enum BoxType {

    STANDART("стандартный"),
    FRAGILE("хрупкий");

    String name;

    BoxType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
