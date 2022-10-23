package MultidimensionalArraysLAB;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];

        for (int row = 0; row < 8; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                String currentElement = matrix[row][col];
                if (currentElement.equals("q") && isValidQueen(matrix, row, col)) {
                    System.out.print(row + " " + col);
                    break;
                }


            }
        }


    }

    public static boolean isValidQueen(String[][] matrix, int currentRow, int currentCol) {

        for (int row = 0; row < 8; row++) {
            if (row == currentRow){
                continue;
            }
            if (matrix[row][currentCol].equals("q")) {
                return false;
            }

        }

        for (int col = 0; col < 8; col++) {
            if (col == currentCol){
                continue;
            }
            if (matrix[currentRow][col].equals("q")) {
                return false;
            }

        }

        for (int row = currentRow + 1, col = currentCol - 1; row < 8 && col >= 0; row++, col--) {
            if (matrix[row][col].equals("q")){
                return false;
            }

        }

        for (int row = currentRow - 1, col = currentCol + 1; row >= 0 && col < 8; row--, col++) {
            if (matrix[row][col].equals("q")){
                return false;
            }

        }

        for (int row = currentRow - 1, col = currentCol - 1; row >= 0 && col >= 0; row--, col--) {
            if (matrix[row][col].equals("q")){
                return false;
            }

        }

        for (int row = currentRow + 1, col = currentCol + 1; row < 8 && col < 8; row++, col++) {
            if (matrix[row][col].equals("q")){
                return false;
            }

        }

        return true;
    }
}
