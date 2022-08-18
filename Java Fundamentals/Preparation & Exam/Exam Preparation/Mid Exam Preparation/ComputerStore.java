package MidExamEXERCISE;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String partPrice = scanner.nextLine();
        boolean isSpecial = false;
        double allSum = 0;
        double taxes = 0;
        while (!partPrice.equals("regular")){
            if (partPrice.equals("special")){
                isSpecial = true;
                break;
            }
            double partPriceNum = Double.parseDouble(partPrice);
            if (partPriceNum >= 0){
                allSum += partPriceNum;
                taxes += partPriceNum * 20 / 100;
            } else {
                System.out.println("Invalid price!");
            }
            partPrice = scanner.nextLine();
        }
        double sumWithTaxes = allSum + taxes;
        if (isSpecial){
            sumWithTaxes -= sumWithTaxes * 10 / 100;
        }
        if (sumWithTaxes > 0){
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", allSum);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", sumWithTaxes);
        } else {
            System.out.println("Invalid order!");
        }
    }
}
