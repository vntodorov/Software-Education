package EXAM;

import java.util.Scanner;

public class FootballKit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double ShirtPrice = Double.parseDouble(scanner.nextLine());
        double NeededSum = Double.parseDouble(scanner.nextLine());
        double ShortsPrice = ShirtPrice * 75 / 100;
        double SocksPrice = ShortsPrice * 20 / 100;
        double BudsPrice = (ShirtPrice + ShortsPrice) * 2;
        double Price = ShirtPrice + ShortsPrice + SocksPrice + BudsPrice;
        Price -= Price * 15 / 100;
        if (Price >= NeededSum){
            System.out.println("Yes, he will earn the world-cup replica ball!");
            System.out.printf("His sum is %.2f lv.", Price);
        } else {
            System.out.println("No, he will not earn the world-cup replica ball.");
            System.out.printf("He needs %.2f lv. more.", NeededSum - Price);
        }
    }
}
