package WorkingWithAbstractionLAB;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int row = 1; row <= n - 1; row++) {
            printRow(n, row);

        }

        for (int star = 1; star <= n ; star++) {
            System.out.print("* ");
        }
        System.out.println();

        for (int row = n - 1; row >= 1 ; row--) {
            printRow(n, row);
        }


    }

    private static void printRow(int n, int row) {
        for (int space = 1; space <= n - row; space++) {
            System.out.print(" ");
        }

        for (int star = 1; star <= row; star++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
