public class Drone extends Transport implements NeedFixInterface{


    public Drone(int id, double speed, double capacity) {
        super(id, speed, capacity);
    }

    @Override
    public void fix() {
        System.out.println("Drone" + getId() + ": отдать на починку китайцам");

    }

    @Override
    public double calculateTime(double distance) {
        return distance/getSpeed();
    }
}
