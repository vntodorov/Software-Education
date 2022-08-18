package ArraysLAB;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArray = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        while (numArray.length > 1) {
            int[] newNumArray = new int[numArray.length - 1];
            for (int i = 0; i < newNumArray.length; i++) {
                newNumArray[i] = numArray[i] + numArray[i + 1];
            }
            numArray = newNumArray;
        }
        System.out.println(numArray[0]);
    }
}
