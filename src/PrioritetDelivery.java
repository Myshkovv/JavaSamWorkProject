public class PrioritetDelivery<T extends Item> extends StandertDelivery<T> {


    public PrioritetDelivery(T item, String address) {
        super(item, address);
        setPrioritet(true);
    }

}