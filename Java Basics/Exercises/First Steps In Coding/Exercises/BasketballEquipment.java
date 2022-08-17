package FirstStepsInCoding.exercises;

import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tax = Integer.parseInt(scanner.nextLine());
        double shoes = tax - tax * 40 / 100.00;
        double eqipment = shoes - shoes * 20 / 100;
        double ball = eqipment * 25 / 100;
        double accessories = ball * 20 / 100;
        double total = tax + shoes + eqipment + ball + accessories;
        System.out.println(total);



    }
}