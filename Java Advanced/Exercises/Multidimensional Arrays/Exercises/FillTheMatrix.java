package MultidimensionalArraysEXERCISES;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int number = Integer.parseInt(input.split(",\\s")[0]);
        String pattern = input.split(",\\s")[1];

        int[][] matrix = new int[number][number];

        switch (pattern) {

            case "A":
                patternA(matrix, number);
                break;
            case "B":
                patternB(matrix, number);
                break;
        }

        printMatrix(matrix);

    }


    public static int[][] patternA(int[][] matrix, int number) {

        int counter = 1;
        for (int col = 0; col < number; col++) {
            for (int row = 0; row < number; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
        return matrix;

    }

    public static int[][] patternB(int[][] matrix, int number) {

        int counter = 1;

        for (int col = 0; col < number; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < number; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {

        for (int[] arr : matrix) {
            for (int number : arr) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

    }


}
