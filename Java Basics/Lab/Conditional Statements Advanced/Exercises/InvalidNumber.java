package ConditionalStatementsAdvanced.lab;

import java.util.Scanner;

public class InvalidNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        boolean valid = (number >= 100 && number <= 200) || (number == 0);
        if (!valid) {
            System.out.println("invalid");
        }
    }
}
