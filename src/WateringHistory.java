public class WateringHistory {

    private Coordinate coordinate;
    private int checheckId;

    public WateringHistory(Coordinate coordinate, int checheckId){
        this.checheckId = checheckId;
        this.coordinate = coordinate;
    }

    public String getInfo(){
        String s = coordinate.getOwner() + " " + coordinate.getIndex() + ", id цветка:  " + checheckId;
        return s;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getChecheckId() {
        return checheckId;
    }

}
