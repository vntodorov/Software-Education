package ForLoop;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int months = Integer.parseInt(scanner.nextLine());
        double AllElectricityCost = 0;
        double OtherCost = 0;
        for (int i = 1; i <= months; i++) {
            double electricity = Double.parseDouble(scanner.nextLine());
            AllElectricityCost += electricity;
            double TotalForMonth = 20 + 15 + electricity;
            OtherCost += TotalForMonth + TotalForMonth * 20 / 100;
        }
        double AllWaterCost = 20 * months;
        double AllInternetCost = 15 * months;
        double Total = AllElectricityCost + AllWaterCost + AllInternetCost + OtherCost;
        double Average = Total / months;
        System.out.printf("Electricity: %.2f lv%n", AllElectricityCost);
        System.out.printf("Water: %.2f lv%n", AllWaterCost);
        System.out.printf("Internet: %.2f lv%n", AllInternetCost);
        System.out.printf("Other: %.2f lv%n", OtherCost);
        System.out.printf("Average: %.2f lv", Average);
    }
}
