package ForLoop;

import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = Double.parseDouble(scanner.nextLine());
        int year = Integer.parseInt(scanner.nextLine());
        double LivingMoney = 0;
        int age = 17;
        for (int i = 1800; i <= year; i++) {
            age++;
            if (i % 2 == 0) {
                LivingMoney += 12000;
            } else {
                LivingMoney += 12000 + 50 * age;
            }
        }
        double left = Math.abs(money - LivingMoney);
        if (money >= LivingMoney) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", left);
        } else {
            System.out.printf("He will need %.2f dollars to survive.", left);
        }
    }
}
