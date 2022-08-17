package ForLoop.exercises;

import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String actor = scanner.nextLine();
        double StartingPoints = Double.parseDouble(scanner.nextLine());
        int judges = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= judges ; i++) {
            String JudgeName = scanner.nextLine();
            double JudgePoints = Double.parseDouble(scanner.nextLine());
            int characters = JudgeName.length();
            StartingPoints += (characters * JudgePoints) / 2;
            if (StartingPoints >= 1250.5){
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actor, StartingPoints);
                break;
            }
        }
        if (StartingPoints < 1250.5){
            System.out.printf("Sorry, %s you need %.1f more!", actor, 1250.5 - StartingPoints);
        }
    }
}
