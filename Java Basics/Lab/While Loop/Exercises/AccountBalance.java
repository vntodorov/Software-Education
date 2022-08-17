package WhileLoop.lab;

import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String increase = scanner.nextLine();
        double sum = 0;
        while (!increase.equals("NoMoreMoney")){
            double CurrentSum = Double.parseDouble(increase);
            if (CurrentSum < 0){
                System.out.println("Invalid operation!");
                break;
            }
            System.out.printf("Increase: %.2f%n", CurrentSum);
            sum += CurrentSum;
            increase = scanner.nextLine();
        }
        System.out.printf("Total: %.2f", sum);
    }
}
