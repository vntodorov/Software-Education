package ArraysEXERCISE;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArray = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rotations = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= rotations; i++) {
            int currentFirstNum = numArray[0];
            for (int j = 0; j < numArray.length - 1; j++) {
                numArray[j] = numArray[j + 1];
            }
            numArray[numArray.length - 1] = currentFirstNum;
        }
        for (int number : numArray) {
            System.out.print(number + " ");
        }
    }
}
