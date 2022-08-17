package ExamMarch2020;

import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int MinutesWalk = Integer.parseInt(scanner.nextLine());
        int NumWalks = Integer.parseInt(scanner.nextLine());
        int AllCalories = Integer.parseInt(scanner.nextLine());
        int BurnedCalories = (MinutesWalk * NumWalks) * 5;
        double NeedToBurnCalories = AllCalories * 50 / 100.00;
        if (BurnedCalories >= NeedToBurnCalories){
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", BurnedCalories);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.", BurnedCalories);
        }
    }
}
