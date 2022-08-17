package ForLoop;

import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int EvenSum = 0;
        int OddSum = 0;
        for (int i = 1; i <= n ; i++) {
            int number1 = Integer.parseInt(scanner.nextLine());
            int number2 = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0){
                EvenSum = number1 + number2;
            } else {
                OddSum = number1 + number2;
            }
        }
        int diff = Math.abs(EvenSum - OddSum);
        if (EvenSum == OddSum || n < 2){
            System.out.printf("Yes, value=%d", OddSum);
        } else {
            System.out.printf("No, maxdiff=%d", diff);
        }
    }
}
