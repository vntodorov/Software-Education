package ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizes = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(sizes[0]);
        int cols = Integer.parseInt(sizes[1]);

        char[][] matrix = new char[rows][cols];

        int[] positionIndexes = new int[2];

        for (int row = 0; row < rows; row++) {
            char[] currentRow = scanner.nextLine().replace(" ", "").toCharArray();
            for (int col = 0; col < currentRow.length; col++) {
                if (currentRow[col] == 'Y') {
                    positionIndexes[0] = row;
                    positionIndexes[1] = col;

                }

            }
            matrix[row] = currentRow;
        }

        String command = scanner.nextLine();
        List<String> rightCommands = new ArrayList<>();


        while (!command.equals("Finish")) {

            if (willMove(command, positionIndexes, matrix)) {

                if (command.equals("up")) {
                    positionIndexes[0] -= 1;
                    rightCommands.add("up");

                } else if (command.equals("down")) {
                    positionIndexes[0] += 1;
                    rightCommands.add("down");

                } else if (command.equals("right")) {
                    positionIndexes[1] += 1;
                    rightCommands.add("right");

                } else if (command.equals("left")) {
                    positionIndexes[1] -= 1;
                    rightCommands.add("left");

                }
            }

            command = scanner.nextLine();
        }

        if (matrix[positionIndexes[0]][positionIndexes[1]] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + String.join(", ", rightCommands));
        } else {
            System.out.println("The map is fake!");
        }


    }

    public static boolean willMove(String direction, int[] positions, char[][] matrix) {

        int currentRow = positions[0];
        int currentCol = positions[1];

        switch (direction) {

            case "up":
                return currentRow - 1 >= 0 && matrix[currentRow - 1][currentCol] != 'T';
            case "down":
                return currentRow + 1 < matrix.length && matrix[currentRow + 1][currentCol] != 'T';
            case "right":
                return currentCol + 1 < matrix[currentRow].length && matrix[currentRow][currentCol + 1] != 'T';
            case "left":
                return currentCol - 1 >= 0 && matrix[currentRow][currentCol - 1] != 'T';
            default:
                throw new IllegalArgumentException("invalid direction");

        }

    }
}
