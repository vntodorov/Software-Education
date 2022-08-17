package EXAM;

import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        double FailMarks = 0;
        double Btw3 = 0;
        double Btw4 = 0;
        double Top = 0;
        double SumAllMarks = 0;
        for (int i = 1; i <= students ; i++) {
            double mark = Double.parseDouble(scanner.nextLine());
            SumAllMarks += mark;
            if (mark < 3.00){
                FailMarks++;
            } else if (mark < 4.00){
                Btw3++;
            } else if (mark < 5.00){
                Btw4++;
            } else {
                Top++;
            }
        }
        double pTop = Top / students * 100;
        double pBtw4 = Btw4 / students * 100;
        double pBtw3 = Btw3 / students * 100;
        double pFail = FailMarks / students * 100;
        double Average = SumAllMarks / students;
        System.out.printf("Top students: %.2f%%%n", pTop);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", pBtw4);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", pBtw3);
        System.out.printf("Fail: %.2f%%%n", pFail);
        System.out.printf("Average: %.2f", Average);
    }
}
