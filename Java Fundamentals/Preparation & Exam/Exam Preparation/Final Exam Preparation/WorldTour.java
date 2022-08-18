package FinalExamEXERCISE;

import java.util.Arrays;
import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destinations = scanner.nextLine();
        String command = scanner.nextLine();
        StringBuilder newDestinations = new StringBuilder(destinations);
        while (!command.equals("Travel")){
            String currentCommand = command.split(":")[0];
            switch (currentCommand){
                case "Add Stop":
                    int addIndex = Integer.parseInt(command.split(":")[1]);
                    if (addIndex >= 0 && addIndex < newDestinations.length()){
                        String addDestination = command.split(":")[2];
                        newDestinations.insert(addIndex, addDestination);
                    }
                    break;
                case "Remove Stop":
                    int firstRemoveIndex = Integer.parseInt(command.split(":")[1]);
                    int secondRemoveIndex = Integer.parseInt(command.split(":")[2]);
                    if (firstRemoveIndex >= 0 && firstRemoveIndex < newDestinations.length() && secondRemoveIndex >= 0 && secondRemoveIndex <= newDestinations.length() - 1){
                        newDestinations.delete(firstRemoveIndex, secondRemoveIndex + 1);
                    }
                    break;
                case "Switch":
                    String oldDestination = command.split(":")[1];
                    String newDestination = command.split(":")[2];
                    if (newDestinations.toString().contains(oldDestination)){
                        String updatedText = newDestinations.toString().replace(oldDestination, newDestination);
                        newDestinations = new StringBuilder(updatedText);
                    }
            }
            System.out.println(newDestinations);
            command = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + newDestinations);
    }
}
