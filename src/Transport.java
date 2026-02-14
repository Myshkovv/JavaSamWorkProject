public abstract class Transport {
    private int id;
    private double speed;
    private double capasity;

    public Transport(int id, double speed, double capacity){
        this.id = id;
        this.speed = speed;
        this.capasity = capacity;
    }

    public abstract double calculateTime(double distance);


    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getId() {
        return id;
    }

    public double getCapasity() {
        return capasity;
    }
}
