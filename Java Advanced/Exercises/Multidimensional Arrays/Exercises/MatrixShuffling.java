package MultidimensionalArraysEXERCISES;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");

        }

        String operation = scanner.nextLine();

        while (!operation.equals("END")) {
            Pattern pattern = Pattern.compile("^swap\\s[0-9]+\\s[0-9]+\\s[0-9]+\\s[0-9]+$");
            Matcher matcher = pattern.matcher(operation);
            if (matcher.find()) {
                int row1 = Integer.parseInt(operation.split("\\s+")[1]);
                int col1 = Integer.parseInt(operation.split("\\s+")[2]);
                int row2 = Integer.parseInt(operation.split("\\s+")[3]);
                int col2 = Integer.parseInt(operation.split("\\s+")[4]);
                if (isInBounds(matrix, row1, col1, row2, col2)) {
                    String currentWord = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = currentWord;
                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            operation = scanner.nextLine();
        }

    }

    private static boolean isInBounds(String[][] matrix, int row1, int col1, int row2, int col2) {

        return row1 >= 0 && row1 < matrix.length && col1 >= 0 && col1 < matrix[row1].length &&
                row2 >= 0 && row2 < matrix.length && col2 >= 0 && col2 < matrix[row2].length;

    }

    public static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
