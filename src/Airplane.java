public class Airplane extends Transport implements NeedOilInterface, NeedFixInterface{


    public Airplane(int id, double speed, double capacity) {
        super(id, speed, capacity);
    }

    @Override
    public void fix() {
        System.out.println("Airplane" + getId() + ": починить");

    }

    @Override
    public void refuel() {
        System.out.println("Airplane" + getId() + ": заправить");

    }

    @Override
    public double calculateTime(double distance) {
        return distance/getSpeed() + 0.5; //время на посадку и высадку
    }
}
