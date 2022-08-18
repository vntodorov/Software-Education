package RegularExpressionsEXERCISE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalSum = 0;
        Pattern pattern = Pattern.compile(">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]+.?[0-9]*)!(?<quantity>[0-9]+)");
        List<String> furniture = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String currentFurniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                totalSum += price * quantity;
                furniture.add(currentFurniture);
            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        furniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalSum);
    }
}
