package ForLoop.exercises;

import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (max < number) {
                max = number;
            }
            sum += number;
        }
        int SumWithoutMax = sum - max;
        if (SumWithoutMax == max){
            System.out.printf("Yes%nSum = %d", SumWithoutMax);
        } else {
            System.out.printf("No%nDiff = %d", Math.abs(max - SumWithoutMax));
        }
    }
}