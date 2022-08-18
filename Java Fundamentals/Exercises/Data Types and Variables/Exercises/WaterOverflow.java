package DataTypesAndVariablesEXERCISE;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte lines = Byte.parseByte(scanner.nextLine());
        int sum = 0;
        for (int i = 1; i <= lines; i++) {
            int liters = Integer.parseInt(scanner.nextLine());
            sum += liters;
            if (sum > 255) {
                System.out.println("Insufficient capacity!");
                sum -= liters;
            }
        }
        System.out.println(sum);
    }
}
