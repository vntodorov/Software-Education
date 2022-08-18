package DataTypesAndVariablesEXERCISE;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Yield = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int totalSpices = 0;
        while (Yield >= 100) {
            int spices = Yield - 26;
            totalSpices += spices;
            days++;
            Yield -= 10;
        }
        if (totalSpices >= 26){
            totalSpices -= 26;
        }
        System.out.printf("%d%n%d", days, totalSpices);
    }
}
