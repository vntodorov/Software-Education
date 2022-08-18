package ListEXERCISE;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("end")){
            String[] commandsLine = command.split(" ");
            String currentCommand = commandsLine[0];
            int element = Integer.parseInt(commandsLine[1]);
            switch (currentCommand){
                case "Delete":
                    numList.removeAll(Collections.singleton(element));
                    break;
                case "Insert":
                    int position = Integer.parseInt(commandsLine[2]);
                    numList.add(position, element);
                    break;
            }
            command = scanner.nextLine();
        }
        for (int number : numList){
            System.out.print(number + " ");
        }
    }
}
