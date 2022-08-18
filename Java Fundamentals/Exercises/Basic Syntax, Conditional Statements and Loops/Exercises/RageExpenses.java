package BasicSyntaxEXERCISE;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int LostGames = Integer.parseInt(scanner.nextLine());
        double HeadsetPrice = Double.parseDouble(scanner.nextLine());
        double MousePrice = Double.parseDouble(scanner.nextLine());
        double KeyboardPrice = Double.parseDouble(scanner.nextLine());
        double DisplayPrice = Double.parseDouble(scanner.nextLine());
        int headsetCount = LostGames / 2;
        int mouseCount = LostGames / 3;
        int keyboardCount = LostGames / 6;
        int displayCount = LostGames / 12;
        double totalSum = (headsetCount * HeadsetPrice) + (mouseCount * MousePrice) + (keyboardCount * KeyboardPrice) + (displayCount * DisplayPrice);
        System.out.printf("Rage expenses: %.2f lv.", totalSum);
    }
}
