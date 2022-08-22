package Methods;

import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        theProductOfInts(num1, num2, num3);

    }

    public static void theProductOfInts(int num1, int num2, int num3) {
        int negativeCounter = 0;
        if (num1 < 0){
            negativeCounter++;
        }
        if (num2 < 0){
            negativeCounter++;
        }
        if (num3 < 0){
            negativeCounter++;
        }
        if (num1 == 0 || num2 == 0 || num3 == 0) {
            System.out.println("zero");
        } else if (negativeCounter == 1 || negativeCounter == 3) {
            System.out.println("negative");
        } else {
            System.out.println("positive");
        }
    }
}
