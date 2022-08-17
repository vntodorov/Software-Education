package ExamMarch2020;

import java.util.Scanner;

public class ChangeBureau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bitcoins = Integer.parseInt(scanner.nextLine());
        double china = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());
        double AllBitcoins = bitcoins * 1168;
        double AllChina = (china * 0.15) * 1.76;
        double AllEuros = (AllBitcoins + AllChina) / 1.95;
        AllEuros -= AllEuros * commission / 100;
        System.out.printf("%.2f", AllEuros);
    }
}
