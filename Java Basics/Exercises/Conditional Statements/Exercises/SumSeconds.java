package ConditionalStatements.exercises;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sec1 = Integer.parseInt(scanner.nextLine());
        int sec2 = Integer.parseInt(scanner.nextLine());
        int sec3 = Integer.parseInt(scanner.nextLine());
        int sum = (sec1 + sec2 + sec3) / 60;
        int sum1 = (sec1 + sec2 + sec3) % 60;
        if (sum1 < 10) {
            System.out.printf("%d:0%d", sum, sum1);
        } else {
            System.out.printf("%d:%d", sum, sum1);
        }
    }
}
