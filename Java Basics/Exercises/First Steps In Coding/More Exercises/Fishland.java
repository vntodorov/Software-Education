package FirstStepsInCoding;

import java.util.Scanner;

public class Fishland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double mackerel = Double.parseDouble(scanner.nextLine());
        double toy = Double.parseDouble(scanner.nextLine());
        double bonito = Double.parseDouble(scanner.nextLine());
        double HorseMackerel = Double.parseDouble(scanner.nextLine());
        int mussels = Integer.parseInt(scanner.nextLine());
        double BonitoPrice = (mackerel + mackerel * 60 / 100) * bonito;
        double HorseMackerelPrice = (toy + toy * 80 / 100) * HorseMackerel;
        double MusselsPrice = mussels * 7.50;
        double result = BonitoPrice + HorseMackerelPrice + MusselsPrice;
        System.out.printf("%.2f", result);

    }
}
