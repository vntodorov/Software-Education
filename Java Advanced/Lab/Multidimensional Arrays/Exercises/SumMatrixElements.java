package MultidimensionalArraysLAB;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split("\\,\\s")[0]);
        int cols = Integer.parseInt(input.split("\\,\\s")[1]);

        int[][] matrix = new int[rows][cols];
        int sum = 0;


        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays
                    .stream(scanner.nextLine().split("\\,\\s"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }

        for (int[] arr : matrix){
            for (int number : arr){
                sum += number;
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }
}
