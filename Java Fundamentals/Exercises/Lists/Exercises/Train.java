package ListEXERCISE;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagonsList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] commandsLine = command.split(" ");
            String currentCommand = commandsLine[0];
            if (currentCommand.equals("Add")) {
                int number = Integer.parseInt(commandsLine[1]);
                wagonsList.add(number);
            } else {
                int currentCommandInt = Integer.parseInt(currentCommand);
                for (int i = 0; i < wagonsList.size(); i++) {
                    int currentWagon = wagonsList.get(i);
                    int sumWagon = currentCommandInt + currentWagon;
                    if (sumWagon <= maxCapacity){
                        wagonsList.set(i, sumWagon);
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (int number : wagonsList){
            System.out.print(number + " ");
        }
    }
}
