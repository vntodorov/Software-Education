package Methods;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        typeOperations(type, scanner);
    }

    public static void typeOperations(String type, Scanner scanner) {
        if (type.equals("string")) {
            String word = scanner.nextLine();
            System.out.println("$" + word + "$");
        } else {
            if (type.equals("int")) {
                int number = Integer.parseInt(scanner.nextLine());
                System.out.println(number * 2);
            } else {
                double doubleNumber = Double.parseDouble(scanner.nextLine());
                System.out.printf("%.2f", doubleNumber * 1.5);
            }

        }
    }
}