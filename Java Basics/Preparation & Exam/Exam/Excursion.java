package EXAM;

import java.util.Scanner;

public class Excursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        int cards = Integer.parseInt(scanner.nextLine());
        int tickets = Integer.parseInt(scanner.nextLine());
        double Price = (people * nights * 20) + (people * cards * 1.60) + (people * tickets * 6);
        Price += Price * 25 / 100;
        System.out.printf("%.2f", Price);
    }
}
