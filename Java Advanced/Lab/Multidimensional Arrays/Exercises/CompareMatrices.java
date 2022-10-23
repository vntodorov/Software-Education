package MultidimensionalArraysLAB;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstInput = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] firstMatrix = new int[firstInput[0]][firstInput[1]];

        for (int i = 0; i < firstInput[0]; i++) {

            int[] firstArr = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            firstMatrix[i] = firstArr;
        }

        int[] secondInput = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] secondMatrix = new int[secondInput[0]][secondInput[1]];

        for (int i = 0; i < secondInput[0]; i++) {

            int[] secondArr = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            secondMatrix[i] = secondArr;
        }

        if (areEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }


    public static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }

    }

    public static boolean areEqual(int[][] first, int[][] second) {
        if (first.length != second.length) {
            return false;

        } else {

            for (int r = 0; r < first.length; r++) {

                int[] firstArr = first[r];
                int[] secondArr = second[r];

                if (firstArr.length != secondArr.length) {
                    return false;
                } else {
                    for (int c = 0; c < firstArr.length; c++) {
                        int firstNum = firstArr[c];
                        int secondNum = secondArr[c];
                        if (firstNum != secondNum) {
                            return false;
                        }
                    }
                }


            }
        }
        return true;
    }
}
