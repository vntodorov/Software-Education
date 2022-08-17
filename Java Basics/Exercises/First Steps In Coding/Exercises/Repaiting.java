package FirstStepsInCoding.exercises;

import java.util.Scanner;

public class Repaiting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int naylon = Integer.parseInt(scanner.nextLine());
        int paint = Integer.parseInt(scanner.nextLine());
        int vero = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());
        int TotalNaylon = naylon + 2;
        double TotalPaint = paint + (paint * 10 / 100.00);
        double MPrice = TotalNaylon * 1.50 + TotalPaint * 14.50 + vero * 5.00 + 0.40;
        double WorkPrice = (MPrice * 30 / 100.00) * hours;
        double TotalPrice = MPrice + WorkPrice;
        System.out.println(TotalPrice);



    }
}
