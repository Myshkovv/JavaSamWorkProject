import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Caser {
    private String shopName;
    private Function<Map<Integer, Product>, Map<Integer, Product>> operation;


    public Caser(String shopName, Function<Map<Integer, Product>, Map<Integer, Product>> operation) {
        this.shopName = shopName;
        this.operation = operation;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Function<Map<Integer, Product>, Map<Integer, Product>> getOperation() {
        return operation;
    }

    public void setOperation(Function<Map<Integer, Product>, Map<Integer, Product>> operation) {
        this.operation = operation;
    }


    public Map<Integer, Product> terminal(Map<Integer, Product> data) {
        System.out.println("Магазин: " + shopName);
        return operation.apply(data);
    }

    public List<Object> order(Map<Integer, Product> data) {
        List<Object> list = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry : data.entrySet()) {
            list.add("ID: " + entry.getKey() + " -> " + entry.getValue());
        }
        return list;
    }
}