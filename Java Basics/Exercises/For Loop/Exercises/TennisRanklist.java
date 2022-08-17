package ForLoop.exercises;

import java.util.Scanner;

public class TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tournaments = Integer.parseInt(scanner.nextLine());
        int CurrentPoints = Integer.parseInt(scanner.nextLine());
        int YearPoints = 0;
        int wins = 0;
        for (int i = 1; i <= tournaments; i++) {
            String place = scanner.nextLine();
            switch (place) {
                case "W":
                    wins++;
                    YearPoints += 2000;
                    break;
                case "F":
                    YearPoints += 1200;
                    break;
                case "SF":
                    YearPoints += 720;
                    break;
            }
        }
        int AllPoints = CurrentPoints + YearPoints;
        double AveragePoints = YearPoints * 1.00 / tournaments;
        double WonTournaments = wins * 1.00 / tournaments * 100;
        System.out.printf("Final points: %d%n", AllPoints);
        System.out.printf("Average points: %.0f%n", Math.floor(AveragePoints));
        System.out.printf("%.2f%%", WonTournaments);
    }
}
