package Arrays;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int[] numArray = new int[number];
        numArray[0] = 1;
        if (number == 1) {
            System.out.println(numArray[0]);
        } else {
            numArray[1] = 1;
            for (int i = 2; i < numArray.length; i++) {
                numArray[i] = numArray[i - 1] + numArray[i - 2];
            }
            System.out.println(numArray[numArray.length - 1]);
        }
    }
}
