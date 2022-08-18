package ListEXERCISE;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandsLine = command.split(" ");
            String currentCommand = commandsLine[0];
            switch (currentCommand) {
                case "Add":
                    int addNumber = Integer.parseInt(commandsLine[1]);
                    numList.add(addNumber);
                    break;
                case "Insert":
                    int insertNumber = Integer.parseInt(commandsLine[1]);
                    int insertIndex = Integer.parseInt(commandsLine[2]);
                    if (insertIndex >= 0 && insertIndex < numList.size()) {
                        numList.add(insertIndex, insertNumber);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(commandsLine[1]);
                    if (removeIndex >= 0 && removeIndex < numList.size()) {
                        numList.remove(removeIndex);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String direction = commandsLine[1];
                    if (direction.equals("left")) {
                        int countLeft = Integer.parseInt(commandsLine[2]);
                        for (int i = 1; i <= countLeft ; i++) {
                            int firstNumber = numList.get(0);
                            numList.add(firstNumber);
                            numList.remove(0);
                        }
                    } else if (direction.equals("right")){
                        int countRight = Integer.parseInt(commandsLine[2]);
                        for (int i = 1; i <= countRight; i++) {
                            int lastNumber = numList.get(numList.size() - 1);
                            numList.add(0, lastNumber);
                            numList.remove(numList.size() - 1);
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        for (int number : numList){
            System.out.print(number + " ");
        }
    }
}
