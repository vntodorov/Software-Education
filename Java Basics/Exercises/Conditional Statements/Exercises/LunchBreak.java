package ConditionalStatements.exercises;

import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String movie = scanner.nextLine();
        int duration = Integer.parseInt(scanner.nextLine());
        int Break = Integer.parseInt(scanner.nextLine());
        double FreeTime = Break - ((Break / 8.00) + (Break / 4.00));
        double left = Math.ceil(Math.abs(FreeTime - duration));
        if (FreeTime >= duration) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", movie, left);
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", movie, left);
        }
    }
}
