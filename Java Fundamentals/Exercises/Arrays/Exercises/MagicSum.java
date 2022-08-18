package ArraysEXERCISE;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArray = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int magicNum = Integer.parseInt(scanner.nextLine());
        for (int firstNumber = 0; firstNumber < numArray.length; firstNumber++) {
            for (int secondNumber = firstNumber + 1; secondNumber < numArray.length ; secondNumber++) {
                if (numArray[firstNumber] + numArray[secondNumber] == magicNum){
                    System.out.printf("%d %d%n", numArray[firstNumber], numArray[secondNumber]);
                }
            }
        }
    }
}
