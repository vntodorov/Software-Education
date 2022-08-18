package DataTypes;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= lines ; i++) {
            String character = scanner.nextLine();
            char currentSymbol = character.charAt(0);
            int newCurrentASCII = (int) currentSymbol + key;
            System.out.printf("%c", newCurrentASCII);

        }
    }
}
