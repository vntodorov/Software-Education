package ForLoop.exercises;

import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 200) {
                p1 += 1.00 / n * 100;
            } else if (number < 400) {
                p2 += 1.00 / n * 100;
            } else if (number < 600) {
                p3 += 1.00 / n * 100;
            } else if (number < 800) {
                p4 += 1.00 / n * 100;
            } else {
                p5 += 1.00 / n * 100;
            }
        }
        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%", p1, p2, p3, p4, p5);
    }
}
