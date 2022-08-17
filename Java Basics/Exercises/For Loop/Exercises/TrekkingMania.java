package ForLoop.exercises;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groups = Integer.parseInt(scanner.nextLine());
        double musala = 0;
        double monblan = 0;
        double celem = 0;
        double k2 = 0;
        double everest = 0;
        double All = 0;
        for (int i = 1; i <= groups; i++) {
            int members = Integer.parseInt(scanner.nextLine());
            All += members;
            if (members <= 5){
                musala += members;
            } else if (members <= 12){
                monblan += members;
            } else if (members <= 25){
                celem += members;
            } else if (members <= 40){
                k2 += members;
            } else {
                everest += members;
            }
        }
        double p1 = musala / All * 100;
        double p2 = monblan / All * 100;
        double p3 = celem / All * 100;
        double p4 = k2 / All * 100;
        double p5 = everest / All * 100;
        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%", p1, p2, p3, p4, p5);
    }
}

