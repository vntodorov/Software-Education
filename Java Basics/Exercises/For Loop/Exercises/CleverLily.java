package ForLoop.exercises;

import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        double washing = Double.parseDouble(scanner.nextLine());
        int ToyPrice = Integer.parseInt(scanner.nextLine());
        int toys = 0;
        double ToysSum = 0;
        double sum = 0;
        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0){
                int addon = i * 5;
                sum += addon - 1;
            } else {
                toys ++;
            }
        }
        ToysSum = toys * ToyPrice;
        sum += ToysSum;
        if (sum >= washing){
            System.out.printf("Yes! %.2f", sum - washing);
        } else {
            System.out.printf("No! %.2f", washing - sum);
        }
    }
}
