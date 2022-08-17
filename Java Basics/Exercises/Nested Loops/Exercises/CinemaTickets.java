package NestedLoops.exercises;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String movie = scanner.nextLine();
        int student = 0;
        int standard = 0;
        int kid = 0;
        int seats = 0;
        int Tickets = 0;
        double full = 0;
        while (!movie.equals("Finish")) {
            int AllSeats = Integer.parseInt(scanner.nextLine());
            String type = scanner.nextLine();
            for (int i = 1; i <= AllSeats; i++) {
                if (type.equals("student")) {
                    student++;
                } else if (type.equals("standard")) {
                    standard++;
                } else if (type.equals("kid")) {
                    kid++;
                } else {
                    break;
                }
                seats++;
                if (i == AllSeats){
                    break;
                }
                type = scanner.nextLine();
            }
            full = seats * 1.00 / AllSeats * 100;
            System.out.printf("%s - %.2f%% full.%n", movie, full);
            Tickets += seats;
            seats = 0;
            movie = scanner.nextLine();
        }
        double p1 = student * 1.00 / Tickets * 100;
        double p2 = standard * 1.00 / Tickets * 100;
        double p3 = kid * 1.00 / Tickets * 100;
        System.out.printf("Total tickets: %d%n", Tickets);
        System.out.printf("%.2f%% student tickets.%n", p1);
        System.out.printf("%.2f%% standard tickets.%n", p2);
        System.out.printf("%.2f%% kids tickets.", p3);
    }
}

