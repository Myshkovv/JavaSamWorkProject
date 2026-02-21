public class StandartBox extends Box{

    double weight;
    private static int MAX_VOLUME = 500;
    private static int MIN_VOLUME = 100;

    public StandartBox(double length, double width, double height, double weight ) {
        super(length, width, height);
        if (getVolume() > MAX_VOLUME | getVolume() < MIN_VOLUME) {
            throw new IllegalArgumentException("Недопустимый обьем");
        } else {
            this.weight = weight;
            System.out.println("создан стандарт бокс id:" + getId());
        }


    }



}
