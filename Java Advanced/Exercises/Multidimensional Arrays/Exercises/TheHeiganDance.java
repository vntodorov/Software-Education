package MultidimensionalArraysEXERCISES;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double heiganDamageEachTurn = Double.parseDouble(scanner.nextLine());

        int playerHealth = 18500;
        double heiganHealth = 3000000;

        int[][] matrix = new int[15][15];

        matrix[7][7] = 2;

        int[] currentPlayerPosition = {7, 7};

        String finalSpell = "";

        while (true) {

            if (playerHealth > 0) {
                heiganHealth -= heiganDamageEachTurn;
            }

            if (finalSpell.equals("Cloud")) {
                playerHealth -= 3500;
                if (playerHealth > 0) {
                    finalSpell = "";
                }
            }
            if (heiganHealth <= 0 || playerHealth <= 0) {
                break;
            }
            String command = scanner.nextLine();

            String currentSpell = command.split("\\s+")[0];
            int currentRow = Integer.parseInt(command.split("\\s+")[1]);
            int currentCol = Integer.parseInt(command.split("\\s+")[2]);

            matrixAfterSpell(matrix, currentRow, currentCol);

            int currentPlayerRow = currentPlayerPosition[0];
            int currentPlayerCol = currentPlayerPosition[1];

            if (matrix[currentPlayerRow][currentPlayerCol] == 1) {

                triesToMove(matrix, currentPlayerPosition);

                if (currentPlayerRow == currentPlayerPosition[0] && currentPlayerCol == currentPlayerPosition[1]) {

                    switch (currentSpell) {

                        case "Cloud":
                            playerHealth -= 3500;
                            finalSpell = "Cloud";
                            break;

                        case "Eruption":
                            playerHealth -= 6000;
                            finalSpell = "Eruption";
                            break;
                    }

                }

            }

            matrix = new int[15][15];
            matrix[currentPlayerPosition[0]][currentPlayerPosition[1]] = 2;


        }

        finalSpell = finalSpell.equals("Cloud") ? "Plague Cloud" : "Eruption";

        if (heiganHealth > 0) {
            System.out.printf("Heigan: %.2f%n", heiganHealth);
        } else {
            System.out.println("Heigan: Defeated!");
        }

        if (playerHealth > 0) {
            System.out.printf("Player: %d%n", playerHealth);
        } else {
            System.out.printf("Player: Killed by %s%n", finalSpell);
        }

        System.out.printf("Final position: %d, %d", currentPlayerPosition[0], currentPlayerPosition[1]);
    }

    public static int[][] matrixAfterSpell(int[][] matrix, int currentRow, int currentCol) {

        for (int row = currentRow - 1, col = currentCol - 1; row <= currentRow + 1 && col <= currentCol + 1; row++, col++) {
            if (isInBounds(matrix, row, col)) {
                matrix[row][col] = 1;
            }

        }

        for (int row = currentRow - 1; row <= currentRow + 1; row++) {
            if (isInBounds(matrix, row, currentCol)) {
                matrix[row][currentCol] = 1;
            }
        }

        for (int col = currentCol - 1; col <= currentCol + 1; col++) {
            if (isInBounds(matrix, currentRow, col)) {
                matrix[currentRow][col] = 1;
            }
        }

        for (int row = currentRow + 1, col = currentCol - 1; row >= currentRow - 1 && col <= currentCol + 1; row--, col++) {
            if (isInBounds(matrix, row, col)) {
                matrix[row][col] = 1;
            }

        }


        return matrix;

    }

    public static int[] triesToMove(int[][] matrix, int[] currentPosition) {
        int currentRow = currentPosition[0];
        int currentCol = currentPosition[1];

        if (isInBounds(matrix, currentRow - 1, currentCol) && matrix[currentRow - 1][currentCol] != 1) {
            currentPosition[0] = currentRow - 1;

        } else if (isInBounds(matrix, currentRow, currentCol + 1) && matrix[currentRow][currentCol + 1] != 1) {
            currentPosition[1] = currentCol + 1;

        } else if (isInBounds(matrix, currentRow + 1, currentCol) && matrix[currentRow + 1][currentCol] != 1) {
            currentPosition[0] = currentRow + 1;

        } else if (isInBounds(matrix, currentRow, currentCol - 1) && matrix[currentRow][currentCol - 1] != 1) {
            currentPosition[1] = currentCol - 1;
        }

        return currentPosition;

    }


    public static boolean isInBounds(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;

    }


}
