package MapsLambdaAndStreamApiEXERCISE;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> orders = new LinkedHashMap<>();
        Map<String, Integer> OrdersQuantity = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("buy")){
            String name = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            int quantity = Integer.parseInt(input.split(" ")[2]);
            if (!orders.containsKey(name)){
                OrdersQuantity.put(name,quantity);
            } else {
                int currentQuantity = OrdersQuantity.get(name);
                OrdersQuantity.put(name, currentQuantity + quantity);
            }
            orders.put(name,price);
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Double> entry : orders.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), OrdersQuantity.get(entry.getKey()) * entry.getValue());
        }
    }
}
