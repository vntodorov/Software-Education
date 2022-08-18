package ListLAB;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String commands = scanner.nextLine();
        while (!commands.equals("end")) {
            List<String> commandsLine = Arrays.stream(commands.split(" ")).collect(Collectors.toList());
            String command = commandsLine.get(0);
            int number = Integer.parseInt(commandsLine.get(1));
            switch (command) {
                case "Add":
                    numList.add(number);
                    break;
                case "Remove":
                    numList.remove(Integer.valueOf(number));
                    break;
                case "RemoveAt":
                    numList.remove(number);
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandsLine.get(2));
                    numList.add(index, number);
                    break;
            }
            commands = scanner.nextLine();
        }
        for (int number : numList) {
            System.out.print(number + " ");
        }
    }
}
