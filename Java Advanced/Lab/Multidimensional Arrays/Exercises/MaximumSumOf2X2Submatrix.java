package MultidimensionalArraysLAB;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays
                .stream(scanner.nextLine().split(",\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int columns = dimensions[1];

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays
                    .stream(scanner.nextLine().split(",\\s"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }

        int[][] maxSumMatrix = new int[2][2];
        int maxSum = Integer.MIN_VALUE;

        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {

                int sum = matrix[r][c] + matrix[r][c + 1]
                        + matrix[r + 1][c] + matrix[r + 1][c + 1];

                if (sum > maxSum){
                    maxSum = sum;

                    maxSumMatrix[0][0] = matrix[r][c];
                    maxSumMatrix[0][1] = matrix[r][c + 1];
                    maxSumMatrix[1][0] = matrix[r + 1][c];
                    maxSumMatrix[1][1] = matrix[r + 1][c + 1];

                }
            }

        }

        for (int[] sumMatrix: maxSumMatrix){
            for (int num : sumMatrix){
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println(maxSum);
    }
}
