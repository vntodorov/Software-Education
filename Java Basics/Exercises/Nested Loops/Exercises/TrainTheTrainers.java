package NestedLoops.exercises;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int judge = Integer.parseInt(scanner.nextLine());
        String presentation = scanner.nextLine();
        double SumMark = 0;
        int AllPresentations = 0;
        double AllAverageMarks = 0;
        while (!presentation.equals("Finish")) {
            AllPresentations++;
            for (int i = 1; i <= judge; i++) {
                double mark = Double.parseDouble(scanner.nextLine());
                SumMark += mark;
            }
            double AverageMark = SumMark / judge;
            AllAverageMarks += AverageMark;
            System.out.printf("%s - %.2f.%n", presentation, AverageMark);
            SumMark = 0;
            presentation = scanner.nextLine();
        }
        AllAverageMarks = AllAverageMarks / AllPresentations;
        System.out.printf("Student's final assessment is %.2f.", AllAverageMarks);
    }
}

