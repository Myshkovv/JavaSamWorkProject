public class Pallet<T extends Box>  {
    private final String id;
    private double maxVolume;
    double boxesVolume;
    private int count;
    private boolean isFull = false;

    private final Box[] boxes;

    public Pallet(String id, int volume, int capacity){
        this.id = id;
        maxVolume = volume;
        this.boxes = new Box[capacity];

    }

    public boolean isFull(){
        return isFull;
    }

    public boolean addBox(T box) {
        if (isFull) return false;
        if (box.getVolume() + boxesVolume > maxVolume){
            isFull = true;
            return false;
        }
        if (count > boxes.length) {
            isFull = true;
            return false;

        }
        boxes[count] = box;
        boxesVolume+=box.getVolume();
        count++;

        if (boxesVolume >= 0.95*maxVolume){
            isFull = true;
        }
        return true;
    }

    public boolean getBox(int index){
        for (int i = 0; i< index; i++){
            if (boxes[i] == null){
                return false;
            }
        }
        return true;
    }

    public double getVolume() {
        return boxesVolume;
    }

    public double getDifferenceVolume(){
        return maxVolume-boxesVolume;
    }


}
