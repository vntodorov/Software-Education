package FirstStepsInCoding.lab;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double meters = Double.parseDouble(scanner.nextLine());
        double price = meters * 7.61;
        double discount = price * 0.18;
        double result = price - discount;
        System.out.println("The final price is: " + result + " lv.");
        System.out.println("The discount is: " + discount + " lv.");

    }
}