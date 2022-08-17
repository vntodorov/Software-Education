package WhileLoop.lab;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int grade = 1;
        int BadMarks = 0;
        double AllGrade = 0;
        while (grade <= 12){
            double mark = Double.parseDouble(scanner.nextLine());
            AllGrade += mark;
            if (mark < 4.00){
                BadMarks++;
                if (BadMarks == 2){
                    System.out.printf("%s has been excluded at %d grade", name, grade);
                    break;
                }
            } else {
                grade++;
            }
        }
        double AverageGrade = AllGrade / 12;
        if (grade > 12){
            System.out.printf("%s graduated. Average grade: %.2f", name, AverageGrade);
        }
    }
}
