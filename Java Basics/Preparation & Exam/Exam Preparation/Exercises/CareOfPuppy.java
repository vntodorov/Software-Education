package ExamMarch2020;

import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int FoodKg = Integer.parseInt(scanner.nextLine());
        String grams = scanner.nextLine();
        int FoodGrams = FoodKg * 1000;
        int AllGrams = 0;
        while (!grams.equals("Adopted")){
            int NumGrams = Integer.parseInt(grams);
            AllGrams += NumGrams;
            grams = scanner.nextLine();
        }
        int left = Math.abs(FoodGrams - AllGrams);
        if (FoodGrams >= AllGrams){
            System.out.printf("Food is enough! Leftovers: %d grams.", left);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", left);
        }
    }
}
