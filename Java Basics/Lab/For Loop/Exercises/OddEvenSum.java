package ForLoop.lab;

import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int EvenSum = 0;
        int OddSum = 0;
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0){
                EvenSum += number;
            } else {
                OddSum += number;
            }
        }
        if (EvenSum == OddSum){
            System.out.printf("Yes%nSum = %d", EvenSum);
        } else {
            System.out.printf("No%nDiff = %d", Math.abs(EvenSum - OddSum));
        }
    }
}
