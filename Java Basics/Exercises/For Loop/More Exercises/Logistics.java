package ForLoop;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cargo = Integer.parseInt(scanner.nextLine());
        int minibus = 0;
        int truck = 0;
        int train = 0;
        int AllTones = 0;
        int BusTones = 0;
        int TruckTones = 0;
        int TrainTones = 0;
        for (int i = 1; i <= cargo; i++) {
            int tone = Integer.parseInt(scanner.nextLine());
            AllTones += tone;
            if (tone <= 3) {
                BusTones += tone;
                minibus += tone * 200;
            } else if (tone <= 11) {
                TruckTones += tone;
                truck += tone * 175;
            } else {
                TrainTones += tone;
                train += tone * 120;
            }
        }
        double total = minibus + truck + train;
        double average = total / AllTones;
        double p1 = BusTones * 1.00 / AllTones * 100;
        double p2 = TruckTones * 1.00 / AllTones * 100;
        double p3 = TrainTones * 1.00 / AllTones * 100;
        System.out.printf("%.2f%n", average);
        System.out.printf("%.2f%%%n", p1);
        System.out.printf("%.2f%%%n", p2);
        System.out.printf("%.2f%%", p3);
    }
}
