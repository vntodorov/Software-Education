package Exam;

import java.util.Scanner;

public class FilmPremiere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String project = scanner.nextLine();
        String packet = scanner.nextLine();
        int tickets = Integer.parseInt(scanner.nextLine());
        double Price = 0;
        switch (project){
            case "John Wick":
                if (packet.equals("Drink")){
                    Price = 12 * tickets;
                } else if (packet.equals("Popcorn")){
                    Price = 15 * tickets;
                } else {
                    Price = 19 * tickets;
                }
                break;
            case "Star Wars":
                if (packet.equals("Drink")){
                    Price = 18 * tickets;
                } else if (packet.equals("Popcorn")){
                    Price = 25 * tickets;
                } else {
                    Price = 30 * tickets;
                }
                if (tickets >= 4){
                    Price = Price - Price * 30 / 100;
                }
                break;
            case "Jumanji":
                if (packet.equals("Drink")){
                    Price = 9 * tickets;
                } else if (packet.equals("Popcorn")){
                    Price = 11 * tickets;
                } else {
                    Price = 14 * tickets;
                }
                if (tickets == 2){
                    Price = Price - Price * 15 / 100;
                }
                break;
        }
        System.out.printf("Your bill is %.2f leva.", Price);
    }
}
