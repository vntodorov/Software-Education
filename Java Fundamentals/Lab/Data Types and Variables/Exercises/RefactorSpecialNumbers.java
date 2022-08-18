package DataTypesAndVariablesLAB;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberRoutes = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberRoutes; i++) {
            int allSum = 0;
            int currentNum = i;
            while (currentNum > 0) {
                allSum += currentNum % 10;
                currentNum /= 10;
            }
            if (allSum == 5 || allSum == 7 || allSum == 11) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }
    }
}
