package ExamPreparation;

import java.util.Scanner;

public class Bee {

    public static int beeRow;

    public static int beeCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String currentRow = scanner.nextLine();
            if (currentRow.contains("B")) {
                beeRow = row;
                beeCol = currentRow.indexOf("B");
            }
            matrix[row] = currentRow.toCharArray();
        }

        String command = scanner.nextLine();

        int flowers = 0;
        boolean isLost = false;

        while (!command.equals("End")) {

            matrix[beeRow][beeCol] = '.';

            switch (command) {
                case "up":
                    beeRow--;
                    if (isInBounds(beeRow, beeCol, matrix) && matrix[beeRow][beeCol] == 'O') {
                        matrix[beeRow][beeCol] = '.';
                        beeRow--;
                    }
                    break;
                case "down":
                    beeRow++;
                    if (isInBounds(beeRow, beeCol, matrix) && matrix[beeRow][beeCol] == 'O') {
                        matrix[beeRow][beeCol] = '.';
                        beeRow++;
                    }
                    break;
                case "left":
                    beeCol--;
                    if (isInBounds(beeRow, beeCol, matrix) && matrix[beeRow][beeCol] == 'O') {
                        matrix[beeRow][beeCol] = '.';
                        beeCol--;
                    }
                    break;
                case "right":
                    beeCol++;
                    if (isInBounds(beeRow, beeCol, matrix) && matrix[beeRow][beeCol] == 'O') {
                        matrix[beeRow][beeCol] = '.';
                        beeCol++;
                    }
                    break;
            }

            if (isInBounds(beeRow, beeCol, matrix)) {
                if (matrix[beeRow][beeCol] == 'f') {
                    flowers++;
                }
                matrix[beeRow][beeCol] = 'B';
            } else {
                isLost = true;
                break;
            }

            command = scanner.nextLine();
        }

        if (isLost){
            System.out.println("The bee got lost!");
        }

        if (flowers >= 5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        }

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
}
