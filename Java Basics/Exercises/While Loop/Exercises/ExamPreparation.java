package WhileLoop.exercises;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int BadMarks = Integer.parseInt(scanner.nextLine());
        String name = scanner.nextLine();
        int AllBadMarks = 0;
        int AllMarks = 0;
        double SumMarks = 0;
        String LastProblem = "";
        while (!name.equals("Enough")){
            int mark = Integer.parseInt(scanner.nextLine());
            SumMarks += mark;
            AllMarks++;
            LastProblem = name;
            if (mark <= 4){
                AllBadMarks++;
            } if (AllBadMarks == BadMarks){
                System.out.printf("You need a break, %d poor grades.", AllBadMarks);
                break;
            }
            name = scanner.nextLine();
        }
        double AverageScore = SumMarks / AllMarks;
        if (AllBadMarks != BadMarks){
            System.out.printf("Average score: %.2f%n", AverageScore);
            System.out.printf("Number of problems: %d%n", AllMarks);
            System.out.printf("Last problem: %s", LastProblem);
        }
    }
}
