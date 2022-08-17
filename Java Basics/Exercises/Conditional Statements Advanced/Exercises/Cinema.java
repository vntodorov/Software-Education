package ConditionalStatementsAdvanced.exercises;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String project = scanner.nextLine();
        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        double price = 0;
        switch (project){
            case "Premiere":
                price = 12;
                break;
            case "Normal":
                price = 7.50;
                break;
            case "Discount":
                price = 5.00;
                break;
        }
        System.out.printf("%.2f leva", price * r * c);
    }
}
