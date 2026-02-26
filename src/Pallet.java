public class Pallet<T extends Box>  {
    private final String id;
    private double maxVolume;
    double boxesVolume = 0;
    private int count = 0;
    private boolean isFull = false;

    private Box[] boxes;

    public Pallet(String id, PalletType palletType, double maxVolume){
        this.id = id;
        this.maxVolume = maxVolume;
        this.boxes = new Box[palletType.getCapacity()];
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
        if (count >= boxes.length) {
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

    public Box getBox(int index){
        return boxes[index];
    }

    public int getCount(){
        return count;
    }

    public Box[] getBoxes(){
        return boxes;
    }

    public double getVolume() {
        return boxesVolume;
    }

    public double getDifferenceVolume(){
        return maxVolume-boxesVolume;
    }

    public void deleteBox(int indexToRemove){
        if (indexToRemove < 0 || indexToRemove >= boxes.length) {
            return;
        }

        for (int i = indexToRemove; i< boxes.length-1; i++){
            boxes[i] = boxes[i+1];
        }
        boxes[boxes.length-1] = null;
        count--;

    }

    public String getId() {
        return id;
    }

    public void sort(){
        int lastIndex = count-1;
        while (lastIndex > 0){
            for (int i = 0; i < lastIndex; i++){
                if (boxes[i].getVolume() > boxes[i+1].getVolume()){
                    Box transferBox = boxes[i];
                    boxes[i] = boxes[i+1];
                    boxes[i+1] = transferBox;
                }

            }
            lastIndex --;
        }
    }
}
