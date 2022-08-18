package ArraysEXERCISE;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        int[] firstArray = new int[lines];
        int[] secondArray = new int[lines];
        for (int i = 1; i <= lines; i++) {
            int[] numbersArr = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int currentNum1 = numbersArr[0];
            int currentNum2 = numbersArr[1];
            if (i % 2 == 0){
                secondArray[i - 1] = currentNum1;
                firstArray[i - 1] = currentNum2;
            } else {
                firstArray[i - 1] = currentNum1;
                secondArray[i - 1] = currentNum2;
            }
        }
        for (int number : firstArray){
            System.out.print(number + " ");
        }
        System.out.println();
        for (int number : secondArray){
            System.out.print(number + " ");
        }
    }
}
