package BasicSyntaxEXERCISE;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String coins = scanner.nextLine();
        double totalCoins = 0;
        while (!coins.equals("Start")) {
            double NumCoins = Double.parseDouble(coins);
            if (NumCoins != 0.10 && NumCoins != 0.20 && NumCoins != 0.50 && NumCoins != 1.00 && NumCoins != 2.00) {
                System.out.printf("Cannot accept %.2f%n", NumCoins);
            } else {
                totalCoins += NumCoins;
            }
            coins = scanner.nextLine();
        }
        String product = scanner.nextLine();
        while (!product.equals("End")) {
            switch (product){
                case "Nuts":
                    if (totalCoins >= 2){
                        System.out.println("Purchased Nuts");
                        totalCoins -= 2;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if (totalCoins >= 0.70){
                        System.out.println("Purchased Water");
                        totalCoins -= 0.70;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (totalCoins >= 1.50){
                        System.out.println("Purchased Crisps");
                        totalCoins -= 1.50;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if (totalCoins >= 0.80){
                        System.out.println("Purchased Soda");
                        totalCoins -= 0.80;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if (totalCoins >= 1){
                        System.out.println("Purchased Coke");
                        totalCoins -= 1;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
            }
            product = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", totalCoins);
    }
}
