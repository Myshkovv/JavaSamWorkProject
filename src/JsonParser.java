import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class JsonParser {

    public static Map<Integer, Product> parseFile(String filename) throws IOException {
        Map<Integer, Product> map = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            Integer currentId = null;
            Product currentProduct = null;
            boolean inProduct = false;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) continue;

                if (line.matches("^\"\\d+\":\\s*\\{$")) {
                    String idStr = line.substring(1, line.indexOf("\":"));
                    currentId = Integer.parseInt(idStr);
                    currentProduct = new Product();
                    inProduct = true;
                    continue;
                }

                if (inProduct && line.contains(":")) {
                    line = line.replaceAll(",$", "");

                    String[] parts = line.split(":", 2);
                    if (parts.length == 2) {
                        String key = parts[0].trim().replace("\"", "");
                        String value = parts[1].trim().replace("\"", "");

                        switch (key) {
                            case "id":
                                currentProduct.setId(Integer.parseInt(value));
                                break;
                            case "name":
                                currentProduct.setName(value);
                                break;
                            case "price":
                                currentProduct.setPrice(Double.parseDouble(value));
                                break;
                            case "category":
                                currentProduct.setCategory(value);
                                break;
                        }
                    }
                }

                if (inProduct && line.equals("}") || line.equals("},")) {
                    if (currentId != null && currentProduct != null) {
                        map.put(currentId, currentProduct);
                    }
                    inProduct = false;
                    currentId = null;
                    currentProduct = null;
                }
            }
        }

        return map;
    }
}

