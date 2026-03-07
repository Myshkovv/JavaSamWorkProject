public class FastDelivery<T extends Item> extends StandertDelivery<T> {


    public FastDelivery(T item, String address) {
        super(item, address);
    }

    @Override
    public double calculateCost() {
        return 20.0;
    }


}