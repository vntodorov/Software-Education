package ConditionalStatements;

import java.util.Scanner;

public class SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int DaysOff = Integer.parseInt(scanner.nextLine());
        int WorkDays = 365 - DaysOff;
        int PlayTime = (DaysOff * 127) + (WorkDays * 63);
        int LeftTime = Math.abs(30000 - PlayTime);
        int Hours = LeftTime / 60;
        int Minutes = LeftTime % 60;
        if (PlayTime > 30000) {
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", Hours, Minutes);
        } else {
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", Hours, Minutes);
        }
    }
}
