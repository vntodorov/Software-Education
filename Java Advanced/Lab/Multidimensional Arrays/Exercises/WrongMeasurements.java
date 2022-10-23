package MultidimensionalArraysLAB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = readArray(scanner);
        }

        int[] indexesToReplace = readArray(scanner);

        int valueToReplace = matrix[indexesToReplace[0]][indexesToReplace[1]];

        List<int[]> correctValues = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == valueToReplace) {
                    int correctValue = getNearbySum(matrix, r, c, valueToReplace);
                    correctValues.add(new int[]{r, c, correctValue});
                }
            }

        }

        for (int[] correctValue : correctValues){
            int row = correctValue[0];
            int col = correctValue[1];
            matrix[row][col] = correctValue[2];
        }

        for (int[] arr : matrix) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    private static int getNearbySum(int[][] matrix, int r, int c, int valueToReplace) {

        int sum = 0;

        if (isInBounds(matrix, r + 1, c) && matrix[r + 1][c] != valueToReplace) {
            sum += matrix[r + 1][c];
        }
        if (isInBounds(matrix, r - 1, c) && matrix[r - 1][c] != valueToReplace) {
            sum += matrix[r - 1][c];
        }
        if (isInBounds(matrix, r, c + 1) && matrix[r][c + 1] != valueToReplace) {
            sum += matrix[r][c + 1];
        }
        if (isInBounds(matrix, r, c - 1) && matrix[r][c - 1] != valueToReplace) {
            sum += matrix[r][c - 1];
        }

        return sum;

    }

    private static boolean isInBounds(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }


}
