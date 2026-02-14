public class Ship extends Transport implements NeedOilInterface, NeedFixInterface{


    public Ship(int id, double speed, double capacity) {
        super(id, speed, capacity);
    }

    @Override
    public void fix() {
        System.out.println("Ship" + getId() + ": поднять паруса");

    }

    @Override
    public void refuel() {
        System.out.println("Ship" + getId() + ": заправить");

    }

    @Override
    public double calculateTime(double distance) {
        return distance/(getSpeed() -2);// так как против течения
    }
}
