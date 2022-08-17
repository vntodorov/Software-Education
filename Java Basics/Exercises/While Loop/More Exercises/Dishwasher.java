package WhileLoop;

import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bottles = Integer.parseInt(scanner.nextLine());
        String dishes = scanner.nextLine();
        int quantity = bottles * 750;
        int plates = 0;
        int pots = 0;
        int circle = 0;
        int consummation = 0;
        while (!dishes.equals("End")){
            circle++;
            int NumDishes = Integer.parseInt(dishes);
            if (circle % 3 == 0){
                pots += NumDishes;
                consummation += NumDishes * 15;
            } else {
                plates += NumDishes;
                consummation += NumDishes * 5;
            }
            if (consummation > quantity){
                break;
            }
            dishes = scanner.nextLine();
        }
        int left = Math.abs(quantity - consummation);
        if (quantity >= consummation){
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", plates, pots);
            System.out.printf("Leftover detergent %d ml.", left);
        } else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", left);
        }
    }
}
