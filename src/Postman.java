import java.util.ArrayList;
import java.util.List;

public class Postman {

    private String name;
    private List<Delivery<? extends Item>> orders;

    public Postman(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Delivery<? extends Item> order) {
        orders.add(order);
    }

    public void addAllOrders(List<? extends Delivery<? extends Item>> newOrders) {
        orders.addAll(newOrders);
    }

    public double calculateTotalPrice(){
        double total = 0.0;
        for (Delivery<? extends Item> order : orders) {
            total += order.calculateCost();
        }
        return total;
    }

    public List<Delivery<? extends Item>> getFastDeliveries(List<? extends Delivery<? extends Item>> deliveries) {
        List<Delivery<? extends Item>> fastDeliveries = new ArrayList<>();

        for (int i = 0; i < deliveries.size(); i++) {
            Delivery<? extends Item> delivery = deliveries.get(i);

            if (delivery instanceof FastDelivery) {
                fastDeliveries.add(delivery);
            }
        }
        return fastDeliveries;
    }

    public boolean getCheckWeight(List<? extends Delivery<? extends Item>> deliveries) {
        double total = 0.0;
        for (Delivery<? extends Item> delivery : deliveries) {
            Item item = delivery.getItem();
            if (item instanceof Box) {
                Box box = (Box) item;
                total += box.getWeight();
                if (total> 40) {
                    return false;
                }
            }
        }
        return true;
    }




    





}
