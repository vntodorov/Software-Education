package Arrays;

import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        String[] indexes = scanner.nextLine().split(" ");
        int[] ladyBugs = new int[fieldSize];
        for (String index : indexes) {
            int currentIndex = Integer.parseInt(index);
            if (currentIndex >= 0 && currentIndex < ladyBugs.length) {
                ladyBugs[currentIndex] = 1;
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            int currentLadybugIndex = Integer.parseInt(command.split(" ")[0]);
            boolean isValid = false;
            if (currentLadybugIndex >= 0 && currentLadybugIndex < ladyBugs.length) {
                if (ladyBugs[currentLadybugIndex] == 1) {
                    isValid = true;
                }
            }

            String direction = command.split(" ")[1];

            int flyingIndex = Integer.parseInt(command.split(" ")[2]);
            if (flyingIndex < 0) {
                flyingIndex = Math.abs(flyingIndex);
                if (direction.equals("left")) {
                    direction = "right";
                } else {
                    direction = "left";
                }
            }

            if (isValid) {
                ladyBugs[currentLadybugIndex] = 0;
                switch (direction) {
                    case "right":
                        int targetRightIndex = currentLadybugIndex + flyingIndex;
                        if (targetRightIndex > ladyBugs.length) {
                            break;
                        }
                        for (int i = targetRightIndex; i < ladyBugs.length;) {
                            int currentIndex = ladyBugs[i];
                            if (currentIndex == 0) {
                                ladyBugs[i] = 1;
                                break;
                            }
                            i += flyingIndex;
                        }
                        break;
                    case "left":
                        int targetLeftIndex = currentLadybugIndex - flyingIndex;
                        if (targetLeftIndex < 0) {
                            break;
                        }
                        for (int i = targetLeftIndex; i >= 0;) {
                            int currentIndex = ladyBugs[i];
                            if (currentIndex == 0) {
                                ladyBugs[i] = 1;
                                break;
                            }
                            i -= flyingIndex;
                        }
                        break;
                }
            }
            command = scanner.nextLine();
        }
        for (int ladybug : ladyBugs) {
            System.out.print(ladybug + " ");
        }
    }
}