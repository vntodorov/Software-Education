package FirstStepsInCoding.exercises;

import java.util.Scanner;

public class VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pages = Integer.parseInt(scanner.nextLine());
        int HourPages = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int result = (pages / HourPages) / days;
        System.out.println(result);
    }
}
