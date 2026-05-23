import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        try {
            Map<Integer, Product> data = JsonParser.parseFile("src/products.json");

            System.out.println("Распарсенные данные:");
            for (Map.Entry<Integer, Product> entry : data.entrySet()) {
                System.out.println("ID: " + entry.getKey() + " -> " + entry.getValue());
            }

            Caser caser = new Caser("Магнит", map -> {
                for (Product p : map.values()) {
                    p.setPrice(p.getPrice() * 0.9);
                }
                return map;
            });

            Bank bank = new Bank();

            Map<Integer, Product> modified = caser.terminal(data);
            List<Object> list = caser.order(modified);
            bank.pay(list);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

}