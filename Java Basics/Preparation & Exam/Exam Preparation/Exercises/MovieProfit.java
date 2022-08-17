package Exam;

import java.util.Scanner;

public class MovieProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String movie = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        int tickets = Integer.parseInt(scanner.nextLine());
        double TicketPrice = Double.parseDouble(scanner.nextLine());
        int percentage = Integer.parseInt(scanner.nextLine());
        double Profit = days * tickets * TicketPrice;
        double CinemaProfit = Profit * percentage / 100;
        double FullProfit = Profit - CinemaProfit;
        System.out.printf("The profit from the movie %s is %.2f lv.", movie, FullProfit);
    }
}
