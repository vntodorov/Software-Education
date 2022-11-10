package ExamPreparation;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            matrix[row] = currentRow;

        }

        int[] officerPosition = new int[2];
        updateOfficerPosition(officerPosition, matrix);

        int totalSwordCoins = 0;

        while (totalSwordCoins < 65) {
            String command = scanner.nextLine();
            if (!isInBounds(command, officerPosition, matrix)) {
                matrix[officerPosition[0]][officerPosition[1]] = '-';
                break;
            }

            matrix[officerPosition[0]][officerPosition[1]] = '-';

            if (command.equals("up")) {
                officerPosition[0] -= 1;
            } else if (command.equals("down")) {
                officerPosition[0] += 1;
            } else if (command.equals("left")) {
                officerPosition[1] -= 1;
            } else if (command.equals("right")) {
                officerPosition[1] += 1;
            }

            int currentOfficerRow = officerPosition[0];
            int currentOfficerCol = officerPosition[1];

            if (matrix[currentOfficerRow][currentOfficerCol] >= '1' && matrix[currentOfficerRow][currentOfficerCol] <= '9') {
                totalSwordCoins += Integer.parseInt(String.valueOf(matrix[currentOfficerRow][currentOfficerCol]));
                matrix[currentOfficerRow][currentOfficerCol] = 'A';
            } else if (matrix[currentOfficerRow][currentOfficerCol] == 'M') {
                matrix[currentOfficerRow][currentOfficerCol] = '-';
                updateMirrorMatrix(matrix);
                updateOfficerPosition(officerPosition, matrix);

            } else {
                matrix[currentOfficerRow][currentOfficerCol] = 'A';
            }
        }

        if (totalSwordCoins >= 65) {
            System.out.println("Very nice swords, I will come back for more!");
        } else {
            System.out.println("I do not need more swords!");
        }

        System.out.printf("The king paid %d gold coins.%n", totalSwordCoins);

        for (char[] arr : matrix) {
            for (char symbol : arr) {
                System.out.print(symbol);
            }
            System.out.println();
        }


    }

    public static int[] updateOfficerPosition(int[] currentPositions, char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'A') {
                    currentPositions[0] = row;
                    currentPositions[1] = col;
                    break;
                }
            }

        }
        return currentPositions;
    }

    public static char[][] updateMirrorMatrix(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'M') {
                    matrix[row][col] = 'A';
                    break;
                }
            }
        }

        return matrix;


    }

    public static boolean isInBounds(String direction, int[] officerIndexes, char[][] matrix) {

        int currentRow = officerIndexes[0];
        int currentCol = officerIndexes[1];

        switch (direction) {
            case "up":
                return currentRow - 1 >= 0;
            case "down":
                return currentRow + 1 < matrix.length;
            case "left":
                return currentCol - 1 >= 0;
            case "right":
                return currentCol + 1 < matrix[currentRow].length;
            default:
                throw new IllegalArgumentException("Invalid direction!");
        }
    }
}
