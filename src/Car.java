public class Car extends Transport implements NeedOilInterface, NeedFixInterface {


    public Car(int id, double speed, double capacity) {
        super(id, speed, capacity);
    }

    @Override
    public double calculateTime(double distance) {
        return distance/getSpeed() + 1;//так как пробки допустим
    }

    @Override
    public void fix() {
        System.out.println("Car" + getId() + ": заменить масло");

    }

    @Override
    public void refuel() {
        System.out.println("Car" + getId() + ": заправить");
    }
}
