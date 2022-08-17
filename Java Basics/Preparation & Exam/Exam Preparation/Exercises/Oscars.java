package Exam;

import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String actor = scanner.nextLine();
        double points = Double.parseDouble(scanner.nextLine());
        int judge = Integer.parseInt(scanner.nextLine());
        boolean isEnough = false;
        for (int i = 1; i <= judge ; i++) {
            String JudgeName = scanner.nextLine();
            double JudgePoints = Double.parseDouble(scanner.nextLine());
            double GettingPoints = (JudgeName.length() * JudgePoints) / 2;
            points += GettingPoints;
            if (points > 1250.5){
                isEnough = true;
                break;
            }
        }
        if (isEnough){
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actor, points);
        } else {
            System.out.printf("Sorry, %s you need %.1f more!", actor, 1250.5 - points);
        }
    }
}
