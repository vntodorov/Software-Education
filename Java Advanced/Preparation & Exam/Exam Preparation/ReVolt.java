package ExamPreparation;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int commands = Integer.parseInt(scanner.nextLine());

        int[] playerPosition = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            String currentRow = scanner.nextLine();
            if (currentRow.contains("f")) {
                playerPosition[0] = row;
                playerPosition[1] = currentRow.indexOf("f");
            }
            matrix[row] = currentRow.toCharArray();

        }

        boolean didWin = false;

        while (commands > 0) {
            String direction = scanner.nextLine();
            commands--;

            matrix[playerPosition[0]][playerPosition[1]] = '-';

            switch (direction) {
                case "up":
                    playerPosition[0] -= 1;

                    updatePosition(playerPosition, matrix);

                    if (matrix[playerPosition[0]][playerPosition[1]] == 'B') {
                        playerPosition[0] -= 1;
                    } else if (matrix[playerPosition[0]][playerPosition[1]] == 'T') {
                        playerPosition[0] += 1;
                    }

                    break;
                case "down":
                    playerPosition[0] += 1;

                    updatePosition(playerPosition, matrix);

                    if (matrix[playerPosition[0]][playerPosition[1]] == 'B') {
                        playerPosition[0] += 1;
                    } else if (matrix[playerPosition[0]][playerPosition[1]] == 'T') {
                        playerPosition[0] -= 1;
                    }

                    break;
                case "left":
                    playerPosition[1] -= 1;

                    updatePosition(playerPosition, matrix);

                    if (matrix[playerPosition[0]][playerPosition[1]] == 'B') {
                        playerPosition[1] -= 1;
                    } else if (matrix[playerPosition[0]][playerPosition[1]] == 'T') {
                        playerPosition[1] += 1;
                    }

                    break;
                case "right":
                    playerPosition[1] += 1;

                    updatePosition(playerPosition, matrix);

                    if (matrix[playerPosition[0]][playerPosition[1]] == 'B') {
                        playerPosition[1] += 1;
                    } else if (matrix[playerPosition[0]][playerPosition[1]] == 'T') {
                        playerPosition[1] -= 1;
                    }

                    break;
            }

            updatePosition(playerPosition, matrix);

            if (matrix[playerPosition[0]][playerPosition[1]] == 'F') {
                matrix[playerPosition[0]][playerPosition[1]] = 'f';
                didWin = true;
                break;
            }

            matrix[playerPosition[0]][playerPosition[1]] = 'f';

        }

        if (didWin) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        for (char[] arr : matrix) {
            for (char symbol : arr) {
                System.out.print(symbol);
            }
            System.out.println();
        }

    }

    public static void updatePosition(int[] playerPosition, char[][] matrix) {

        int currentRow = playerPosition[0];
        int currentCol = playerPosition[1];

        if (currentRow < 0) {
            currentRow = matrix.length - 1;
        } else if (currentRow >= matrix.length) {
            currentRow = 0;
        } else if (currentCol < 0) {
            currentCol = matrix[currentRow].length - 1;
        } else if (currentCol >= matrix[currentRow].length) {
            currentCol = 0;
        }

        playerPosition[0] = currentRow;
        playerPosition[1] = currentCol;

    }
}
