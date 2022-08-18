package ListEXERCISE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List<String> guestsNames = new ArrayList<>();
        for (int i = 1; i <= lines ; i++) {
            String[] commands = scanner.nextLine().split(" ");
            String currentName = commands[0];
            if (commands.length == 3){
                if (guestsNames.contains(currentName)){
                    System.out.printf("%s is already in the list!%n", currentName);
                } else {
                    guestsNames.add(currentName);
                }
            } else {
                if (guestsNames.contains(currentName)){
                    guestsNames.remove(currentName);
                } else {
                    System.out.printf("%s is not in the list!%n", currentName);
                }
            }
        }
        for (String name : guestsNames){
            System.out.println(name);
        }
    }
}
