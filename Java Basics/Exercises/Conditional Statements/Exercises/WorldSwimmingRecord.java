package ConditionalStatements.exercises;

import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double record = Double.parseDouble(scanner.nextLine());
        double meters = Double.parseDouble(scanner.nextLine());
        double seconds = Double.parseDouble(scanner.nextLine());
        double result = meters * seconds;
        double water = Math.floor(meters / 15) * 12.5;
        double FinalResult = result + water;
        if (FinalResult >= record){
            System.out.printf("No, he failed! He was %.2f seconds slower.", FinalResult - record);
        } else {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", FinalResult);
        }
    }
}