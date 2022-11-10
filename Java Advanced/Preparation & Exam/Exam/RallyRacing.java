package EXAM;

import java.util.Scanner;

public class RallyRacing {

    public static int carRow = 0;
    public static int carCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String racingNumber = scanner.nextLine();

        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replace(" ", "").toCharArray();
        }

        int kilometers = 0;

        String direction = scanner.nextLine();

        boolean didWin = false;

        while (!direction.equals("End")) {
            kilometers += 10;

            switch (direction) {
                case "up":
                    if (isInBounds(carRow - 1, carCol, matrix)){
                        carRow--;
                }
                    break;
                case "down":
                    if (isInBounds(carRow + 1, carCol, matrix)){
                        carRow++;
                    }
                    break;
                case "left":
                    if (isInBounds(carRow, carCol - 1, matrix)){
                        carCol--;
                    }
                    break;
                case "right":
                    if (isInBounds(carRow, carCol + 1, matrix)){
                        carCol++;
                    }
                    break;
            }

            if (matrix[carRow][carCol] == 'T'){
                matrix[carRow][carCol] = '.';
                carRow = tunnelRow(matrix);
                carCol = tunnelCol(matrix);
                matrix[carRow][carCol] = '.';
                kilometers += 20;
            } else if (matrix[carRow][carCol] == 'F'){
                matrix[carRow][carCol] = 'C';
                didWin = true;
                break;
            }

            direction = scanner.nextLine();
        }

        if (didWin){
            System.out.printf("Racing car %s finished the stage!%n", racingNumber);
        } else {
            System.out.printf("Racing car %s DNF.%n", racingNumber);
            matrix[carRow][carCol] = 'C';
        }

        System.out.printf("Distance covered %d km.%n", kilometers);

        for (char[] arr : matrix){
            for (char symbol : arr){
                System.out.print(symbol);
            }
            System.out.println();
        }




    }

    public static boolean isInBounds(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    public static int tunnelRow(char[][] matrix){

        int tunnelRow = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'T'){
                    tunnelRow = row;
                }
            }
        }

        return tunnelRow;
    }

    public static int tunnelCol(char[][] matrix){

        int tunnelCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'T'){
                    tunnelCol = col;
                }
            }
        }

        return tunnelCol;
    }
}
