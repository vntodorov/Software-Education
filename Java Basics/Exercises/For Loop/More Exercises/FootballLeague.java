package ForLoop;

import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        int fans = Integer.parseInt(scanner.nextLine());
        int fansA = 0;
        int fansB = 0;
        int fansV = 0;
        int fansG = 0;
        for (int i = 1; i <= fans; i++) {
            String sector = scanner.nextLine();
            switch (sector) {
                case "A":
                    fansA++;
                    break;
                case "B":
                    fansB++;
                    break;
                case "V":
                    fansV++;
                    break;
                case "G":
                    fansG++;
                    break;
            }
        }
        double Apercentage = fansA * 1.00 / fans * 100;
        double Bpercentage = fansB * 1.00 / fans * 100;
        double Vpercentage = fansV * 1.00 / fans * 100;
        double Gpercentage = fansG * 1.00 / fans * 100;
        double AllPercentage = fans * 1.00 / capacity * 100;
        System.out.printf("%.2f%%%n", Apercentage);
        System.out.printf("%.2f%%%n", Bpercentage);
        System.out.printf("%.2f%%%n", Vpercentage);
        System.out.printf("%.2f%%%n", Gpercentage);
        System.out.printf("%.2f%%", AllPercentage);
    }
}
