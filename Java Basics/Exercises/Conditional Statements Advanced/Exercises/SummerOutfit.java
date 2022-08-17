package ConditionalStatementsAdvanced.exercises;

import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  celsius = Integer.parseInt(scanner.nextLine());
        String day = scanner.nextLine();
        String outfit = "";
        String shoes = "";
        if (celsius >= 10 && celsius <= 18){
            switch (day){
                case "Morning":
                    outfit = "Sweatshirt";
                    shoes = "Sneakers";
                    break;
                case "Afternoon":
                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
            }
        } else if (celsius > 18 && celsius <= 24){
            switch (day){
                case "Morning":
                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                case "Afternoon":
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                    break;
            }
        } else if (celsius >= 25){
            switch (day){
                case "Morning":
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                    break;
                case "Afternoon":
                    outfit = "Swim Suit";
                    shoes = "Barefoot";
                    break;
                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
            }
        }
        System.out.printf("It's %d degrees, get your %s and %s.", celsius, outfit, shoes);
    }
}
