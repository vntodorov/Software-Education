package ForLoop;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        int fail = 0;
        int btw3 = 0;
        int btw4 = 0;
        int top = 0;
        double SumMark = 0;
        for (int i = 1; i <= students; i++) {
            double mark = Double.parseDouble(scanner.nextLine());
            SumMark += mark;
            if (mark < 3.00) {
                fail++;
            } else if (mark >= 3.00 && mark < 4.00) {
                btw3++;
            } else if (mark >= 4.00 && mark < 5.00) {
                btw4++;
            } else {
                top++;
            }
        }
        double average = SumMark / students;
        double p1 = top * 1.00 / students * 100;
        double p2 = btw4 * 1.00 / students * 100;
        double p3 = btw3 * 1.00 / students * 100;
        double p4 = fail * 1.00 / students * 100;
        System.out.printf("Top students: %.2f%%%n", p1);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", p2);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", p3);
        System.out.printf("Fail: %.2f%%%n", p4);
        System.out.printf("Average: %.2f", average);
    }
}
