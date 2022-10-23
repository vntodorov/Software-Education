package MultidimensionalArraysLAB;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = new String[rows][cols];
        String[][] secondMatrix = new String[rows][cols];


        for (int i = 0; i < rows; i++) {
            firstMatrix[i] = scanner.nextLine().split("\\s+");
        }

        for (int i = 0; i < rows; i++) {
            secondMatrix[i] = scanner.nextLine().split("\\s+");
        }

        String[][] finalMatrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                String firstElement = firstMatrix[row][col];
                String secondElement = secondMatrix[row][col];

                if (firstElement.equals(secondElement)) {
                    finalMatrix[row][col] = firstElement;

                } else {
                    finalMatrix[row][col] = "*";
                }


            }

        }

        for (String[] arr : finalMatrix){
            for (String element : arr){
                System.out.print(element + " ");
            }
            System.out.println();
        }


    }
}
