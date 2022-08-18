package FinalExamEXERCISE;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        StringBuilder keyBuilder = new StringBuilder(key);
        String command = scanner.nextLine();
        while (!command.equals("Generate")){
            String currentCommand = command.split(">>>")[0];
            switch (currentCommand){
                case "Contains":
                    String substring = command.split(">>>")[1];
                    if (keyBuilder.toString().contains(substring)){
                        System.out.printf("%s contains %s%n", keyBuilder, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String action = command.split(">>>")[1];
                    int flipStartIndex = Integer.parseInt(command.split(">>>")[2]);
                    int flipEndIndex = Integer.parseInt(command.split(">>>")[3]);
                    String currentSubstring = keyBuilder.substring(flipStartIndex, flipEndIndex);
                    if (action.equals("Upper")){
                        currentSubstring = currentSubstring.toUpperCase();
                    } else {
                        currentSubstring = currentSubstring.toLowerCase();
                    }
                    keyBuilder.replace(flipStartIndex, flipEndIndex, currentSubstring);
                    System.out.println(keyBuilder);
                    break;
                case "Slice":
                    int sliceStartIndex = Integer.parseInt(command.split(">>>")[1]);
                    int sliceEndIndex = Integer.parseInt(command.split(">>>")[2]);
                    keyBuilder.delete(sliceStartIndex, sliceEndIndex);
                    System.out.println(keyBuilder);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + keyBuilder);
    }
}
