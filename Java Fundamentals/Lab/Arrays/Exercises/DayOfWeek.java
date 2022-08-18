package ArraysLAB;

import java.util.Locale;
import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] days = new String[]{
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };
        int number = Integer.parseInt(scanner.nextLine());
        if (number >= 1 && number <= 7){
            System.out.println(days[number - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
