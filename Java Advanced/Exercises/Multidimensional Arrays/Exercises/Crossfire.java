package MultidimensionalArraysEXERCISES;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        int[][] matrix = new int[rows][cols];

        int counter = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = counter;
                counter++;
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            int rowCommand = Integer.parseInt(command.split("\\s+")[0]);
            int columnCommand = Integer.parseInt(command.split("\\s+")[1]);
            int radiusCommand = Integer.parseInt(command.split("\\s+")[2]);

            for (int currentCol = columnCommand; currentCol >= columnCommand - radiusCommand; currentCol--) {
                if (isInBounds(rowCommand, currentCol, matrix)){
                    matrix[rowCommand][currentCol] = 0;
                }
            }

            for (int currentRow = rowCommand - 1; currentRow >= rowCommand - radiusCommand; currentRow--) {
                if (isInBounds(currentRow, columnCommand, matrix)){
                    matrix[currentRow][columnCommand] = 0;
                }
            }

            for (int currentCol = columnCommand + 1; currentCol <= columnCommand + radiusCommand; currentCol++) {
                if (isInBounds(rowCommand, currentCol, matrix)){
                    matrix[rowCommand][currentCol] = 0;
                }
            }

            for (int currentRow = rowCommand + 1; currentRow <= rowCommand + radiusCommand; currentRow++) {
                if (isInBounds(currentRow, columnCommand, matrix)){
                    matrix[currentRow][columnCommand] = 0;
                }
            }

            updateMatrixAfterBomb(matrix);

            command = scanner.nextLine();
        }
        for (int[] arr : matrix){
            if (arr.length == 0){
                continue;
            }
            for (int number : arr){
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public static boolean isInBounds(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    public static int[][] updateMatrixAfterBomb (int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            int zeroCounter = 0;
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumber = matrix[row][col];
                if (currentNumber == 0) {
                    zeroCounter++;
                }
            }
            int[] arr = new int[matrix[row].length - zeroCounter];
            for (int i = 0, col = 0; i < arr.length; i++, col++) {
                if (matrix[row][col] == 0) {
                    i--;
                } else {
                    arr[i] = matrix[row][col];
                }
            }
            matrix[row] = arr;
        }
        return matrix;
    }
}
