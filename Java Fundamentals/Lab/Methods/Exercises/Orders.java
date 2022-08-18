package MethodsLAB;

import java.util.Scanner;

public class Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        printCalculatedPrice(product, quantity);
    }

    public static void printCalculatedPrice(String product, int quantity){
        double result = 0;
        switch (product){
            case "coffee":
                result = quantity * 1.50;
                break;
            case "water":
                result = quantity * 1.00;
                break;
            case "coke":
                result = quantity * 1.40;
                break;
            case "snacks":
                result = quantity * 2.00;
                break;
        }
        System.out.printf("%.2f", result);
    }

}
