package MidExamEXERCISE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> targetValuesList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("End")){
            String[] commandLines = command.split(" ");
            String currentCommand = commandLines[0];
            int index = Integer.parseInt(commandLines[1]);
            int number = Integer.parseInt(commandLines[2]);
            boolean isValid = index >= 0 && index <= targetValuesList.size() - 1;
            switch (currentCommand){
                case "Shoot":
                    if (isValid){
                        int currentTarget = targetValuesList.get(index);
                        currentTarget -= number;
                        if (currentTarget <= 0){
                            targetValuesList.remove(index);
                        } else {
                            targetValuesList.set(index, currentTarget);
                        }
                    }
                    break;
                case "Add":
                    if (isValid){
                        targetValuesList.add(index, number);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    if (index - number >= 0 && index + number < targetValuesList.size()){
                        for (int i = index - number; i <= index + number ; i++) {
                            targetValuesList.remove(index - number);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        List<String> resulList = new ArrayList<>();
        for (int number : targetValuesList){
            resulList.add(String.valueOf(number));
        }
        System.out.println(String.join("|", resulList));
    }
}
