package RegularExpressionsEXERCISE;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double price = 0;
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("%(?<name>[A-Z][a-z]+)%[^.|$%]*<(?<product>\\w+)>[^.|$%]*\\|(?<quantity>[0-9]+)\\|[^.|$%\\d]*(?<price>[0-9]+\\.?[0-9]*)\\$");
        while (!input.equals("end of shift")){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String name = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double currentPrice = Double.parseDouble(matcher.group("price"));
                double finalPrice = currentPrice * quantity;
                price += finalPrice;
                System.out.printf("%s: %s - %.2f%n", name, product, finalPrice);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", price);
    }
}
