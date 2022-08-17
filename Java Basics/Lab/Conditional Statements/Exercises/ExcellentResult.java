package ConditionalStatements.lab;

import java.util.Scanner;

public class ExcellentResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int grade = Integer.parseInt(scanner.nextLine());
        boolean IsItExcellent = grade >= 5;
        if (IsItExcellent){
            System.out.println("Excellent!");
        }
    }
}
