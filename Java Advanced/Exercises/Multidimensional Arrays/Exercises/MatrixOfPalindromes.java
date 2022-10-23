package MultidimensionalArraysEXERCISES;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        String[][] matrix = new String[rows][cols];

        char outsideLetter = 'a';

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int second = outsideLetter + col;
                matrix[row][col] = String.format("%c%c%c", outsideLetter, second, outsideLetter);
            }
            outsideLetter++;

        }

        for (String[] arr : matrix){
            for (String word : arr){
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}
