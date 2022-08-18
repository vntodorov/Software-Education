package Arrays;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int currentLength = 1;
        int[] currentOldArray = new int[currentLength];
        for (int i = 1; i <= rows; i++) {
            int[] currentArray = new int[i];
            currentArray[0] = 1;
            currentArray[currentArray.length - 1] = 1;
            for (int j = 1; j < currentArray.length - 1; j++) {
                currentArray[j] = currentOldArray[j] + currentOldArray[j - 1];
            }
            for (int number : currentArray) {
                System.out.print(number + " ");
            }
            System.out.println();
            currentOldArray = currentArray;
            currentLength++;
        }
    }
}

