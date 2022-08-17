package ConditionalStatements;

import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int magnolias = Integer.parseInt(scanner.nextLine());
        int hyacinth = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int cactus = Integer.parseInt(scanner.nextLine());
        double present = Double.parseDouble(scanner.nextLine());
        double profit = (magnolias * 3.25) + (hyacinth * 4) + (roses * 3.50) + (cactus * 8);
        double RealProfit = profit - profit * 5 / 100;
        if (RealProfit >= present){
            System.out.printf("She is left with %.0f leva.", Math.floor(RealProfit - present));
        } else {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(present - RealProfit));
        }
    }
}
