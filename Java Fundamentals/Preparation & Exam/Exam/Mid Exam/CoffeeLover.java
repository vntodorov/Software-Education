package MidEXAM;

import java.util.*;
import java.util.stream.Collectors;

public class CoffeeLover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> coffeeList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        int commands = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= commands; i++) {
            String command = scanner.nextLine();
            String[] commandsLine = command.split(" ");
            String currentCommand = commandsLine[0];
            switch (currentCommand) {
                case "Include":
                    String currentCoffee = commandsLine[1];
                    coffeeList.add(currentCoffee);
                    break;
                case "Remove":
                    String firstOrLast = commandsLine[1];
                    int numberOfCoffees = Integer.parseInt(commandsLine[2]);
                    if (firstOrLast.equals("first") && coffeeList.size() > numberOfCoffees) {
                        for (int j = 1; j <= numberOfCoffees; j++) {
                            coffeeList.remove(0);
                        }
                    } else if (firstOrLast.equals("last") && coffeeList.size() > numberOfCoffees) {
                        for (int j = 1; j <= numberOfCoffees; j++) {
                            coffeeList.remove(coffeeList.size() - 1);
                        }
                    }
                    break;
                case "Prefer":
                    int index1 = Integer.parseInt(commandsLine[1]);
                    int index2 = Integer.parseInt(commandsLine[2]);
                    boolean isValid = index1 >= 0 && index1 <= coffeeList.size() - 1
                            && index2 >= 0 && index2 <= coffeeList.size() - 1;
                    if (isValid) {
                        String firstCoffee = coffeeList.get(index1);
                        String secondCoffee = coffeeList.get(index2);
                        coffeeList.set(index1, secondCoffee);
                        coffeeList.set(index2, firstCoffee);
                    }
                    break;
                case "Reverse":
                    Collections.reverse(coffeeList);
                    break;
            }
        }
        System.out.println("Coffees:");
        for (String currentCoffee : coffeeList){
            System.out.print(currentCoffee + " ");
        }
    }
}
