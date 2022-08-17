package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int juniors = Integer.parseInt(scanner.nextLine());
        int seniors = Integer.parseInt(scanner.nextLine());
        String trace = scanner.nextLine();
        int AllParticipants = juniors + seniors;
        double price = 0;
        switch (trace){
            case "trail":
                price = juniors * 5.50 + seniors * 7;
                break;
            case "cross-country":
                price = juniors * 8 + seniors * 9.50;
                if (AllParticipants >= 50){
                    price = price - price * 25 / 100;
                }
                break;
            case "downhill":
                price = juniors * 12.25 + seniors * 13.75;
                break;
            case "road":
                price = juniors * 20 + seniors * 21.50;
                break;
        }
        price = price - price * 5 / 100;
        System.out.printf("%.2f", price);
    }
}
