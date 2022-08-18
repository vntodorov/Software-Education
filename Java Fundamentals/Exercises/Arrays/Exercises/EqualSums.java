package ArraysEXERCISE;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArray = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean isFound = false;
        for (int i = 0; i <= numArray.length - 1; i++) {
            int rightSum = 0;
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += numArray[j];

            }
            for (int k = i + 1; k <= numArray.length - 1; k++) {
                rightSum += numArray[k];
            }
            if (leftSum == rightSum) {
                System.out.println(i);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("no");
        }
    }
}

