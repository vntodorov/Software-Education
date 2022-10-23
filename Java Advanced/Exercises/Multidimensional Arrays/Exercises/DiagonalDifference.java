package MultidimensionalArraysEXERCISES;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int sumPrimary = 0;
        int sumSecondary = 0;

        for (int i = 0; i < matrix.length; i++) {
            sumPrimary += matrix[i][i];
        }

        int colIndex = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            sumSecondary += matrix[row][colIndex];
            colIndex++;
        }

        System.out.println(Math.abs(sumPrimary - sumSecondary));
    }
}
