package ConditionalStatements;

import java.util.Scanner;

public class Firm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int NeededHours = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        double TotalDays = (days - days * 10 / 100.00);
        double WorkHours = (TotalDays * 8);
        double TotalHours = Math.floor(WorkHours + days * 2 * workers);
        if (TotalHours >= NeededHours) {
            System.out.printf("Yes!%.0f hours left.", TotalHours - NeededHours);
        } else {
            System.out.printf("Not enough time!%.0f hours needed.", NeededHours - TotalHours);
        }
    }
}
