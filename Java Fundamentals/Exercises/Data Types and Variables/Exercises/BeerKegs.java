package DataTypesAndVariablesEXERCISE;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte lines = Byte.parseByte(scanner.nextLine());
        double currentMax = Double.MAX_VALUE;
        String currentMaxName = "";
        for (int i = 1; i <= lines; i++) {
            String nameKeg = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            long height = Long.parseLong(scanner.nextLine());
            double volume = Math.PI * Math.pow(radius, 2) * height;
            if (volume > currentMax) {
                currentMax = volume;
                currentMaxName = nameKeg;
            }
        }
        System.out.println(currentMaxName);
    }
}
