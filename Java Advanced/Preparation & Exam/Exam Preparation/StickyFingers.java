package ExamPreparation;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        String[] movements = scanner.nextLine().split("\\,");

        int[] thiefPosition = new int[2];

        int stoleMoney = 0;

        boolean gotCaught = false;

        for (int row = 0; row < size; row++) {
            String[] currentRow = scanner.nextLine().split("\\s+");
            for (int col = 0; col < currentRow.length; col++) {
                if (currentRow[col].equals("D")) {
                    thiefPosition[0] = row;
                    thiefPosition[1] = col;
                }
            }
            matrix[row] = currentRow;
        }


        for (String currentMovement : movements) {
            if (isInBounds(thiefPosition, currentMovement, matrix)) {

                matrix[thiefPosition[0]][thiefPosition[1]] = "+";
                thiefPosition = newPosition(thiefPosition, currentMovement);

                String currentSymbol = matrix[thiefPosition[0]][thiefPosition[1]];

                if (currentSymbol.equals("P")) {
                    System.out.printf("You got caught with %d$, and you are going to jail.%n", stoleMoney);
                    matrix[thiefPosition[0]][thiefPosition[1]] = "#";
                    gotCaught = true;
                    break;
                } else if (currentSymbol.equals("$")) {
                    int currentStoleMoney = thiefPosition[0] * thiefPosition[1];
                    stoleMoney += currentStoleMoney;
                    System.out.printf("You successfully stole %d$.%n", currentStoleMoney);
                }

                matrix[thiefPosition[0]][thiefPosition[1]] = "D";

            } else {
                System.out.println("You cannot leave the town, there is police outside!");
            }

        }

        if (!gotCaught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stoleMoney);
        }

        for (String[] arr : matrix) {
            System.out.println(String.join(" ", arr));
        }

    }

    private static int[] newPosition(int[] thiefPosition, String currentMovement) {

        int currentRow = thiefPosition[0];
        int currentCol = thiefPosition[1];

        switch (currentMovement) {
            case "up":
                currentRow -= 1;
                break;
            case "right":
                currentCol += 1;
                break;
            case "down":
                currentRow += 1;
                break;
            case "left":
                currentCol -= 1;
                break;
        }

        return new int[]{currentRow, currentCol};

    }

    public static boolean isInBounds(int[] thiefPosition, String currentMovement, String[][] matrix) {

        int currentRow = thiefPosition[0];
        int currentCol = thiefPosition[1];

        switch (currentMovement) {
            case "up":
                return currentRow - 1 >= 0;
            case "right":
                return currentCol + 1 < matrix[currentRow].length;
            case "down":
                return currentRow + 1 < matrix.length;
            case "left":
                return currentCol - 1 >= 0;
        }
        return false;
    }

}
