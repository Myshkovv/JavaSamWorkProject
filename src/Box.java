public abstract class Box {
    private static int nextId;
    private  int id;
    private double length;
    private double width;
    private double height;
    private double volume;

    public Box(double length, double width, double height){
        this.id = nextId;
        nextId++;
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = length * width * height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return volume;
    }

    public int getId() {
        return id;
    }

    // длина высота ширина, узнавать обьем

}
