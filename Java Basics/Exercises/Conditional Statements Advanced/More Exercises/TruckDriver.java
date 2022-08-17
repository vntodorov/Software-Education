package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String season = scanner.nextLine();
        double km = Double.parseDouble(scanner.nextLine());
        double salary = 0;
        if (km > 10000 && km <= 20000){
            salary = (km * 1.45) * 4;
        }
        switch (season){
            case "Spring":
            case "Autumn":
                if (km <= 5000){
                    salary = (km * 0.75) * 4;
                } else if (km > 5000 && km <= 10000){
                    salary = (km * 0.95) * 4;
                }
                break;
            case "Summer":
                if (km <= 5000){
                    salary = (km * 0.90) * 4;
                } else if (km > 5000 && km <= 10000){
                    salary = (km * 1.10) * 4;
                }
                break;
            case "Winter":
                if (km <= 5000){
                    salary = (km * 1.05) * 4;
                } else if (km > 5000 && km <= 10000){
                    salary = (km * 1.25) * 4;
                }
                break;
        }
        salary = salary - salary * 10 / 100;
        System.out.printf("%.2f", salary);
    }
}
