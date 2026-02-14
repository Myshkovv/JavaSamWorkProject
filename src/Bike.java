public class Bike extends Transport implements NeedFixInterface{

    public Bike(int id, double speed, double capacity) {
        super(id, speed, capacity);
    }

    @Override
    public void fix() {
        System.out.println("Bike" + getId() + ": подкачать колеса");
    }

    @Override
    public double calculateTime(double distance) {
        return distance/getSpeed() + ((int) (distance/15)) * 0.5;//каждые 15 км перерыв
    }
}
