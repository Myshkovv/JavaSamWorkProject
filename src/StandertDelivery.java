public class StandertDelivery<T extends Item> extends Delivery<T> {


    public StandertDelivery(T item, String address) {
        super(item, address);
    }

    @Override
    public double calculateCost() {
        return 5.0;
    }


}