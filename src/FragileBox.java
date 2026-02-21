public class FragileBox extends Box{

    private static int MAX_VOLUME = 100;
    private double volume;
    private Fragile fragile;

    public FragileBox(double length, double width, double height, Fragile fragile) {
        super(length, width, height);
        this.fragile = fragile;
        if (getVolume() > MAX_VOLUME) {
            throw new IllegalArgumentException("Недопустимый обьем");
        } else {
            this.volume = length * height * width;
            System.out.println("создан хрупкий бокс");
        }
    }


    public String getFraguleLevel(){
        return fragile.getName();
    }

}
