import java.util.List;

class Bank {
    public void pay(List<Object> items) {
        System.out.println("=== Покупки ===");
        for (Object item : items) {
            System.out.println(item);
        }
        System.out.println("==============");
    }
}