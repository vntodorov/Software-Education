package FinalExamEXERCISE;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        StringBuilder messageBuilder = new StringBuilder(message);
        String command = scanner.nextLine();
        while (!command.equals("Reveal")){
            String currentCommand = command.split(":")[0];
            switch (currentCommand){
                case "InsertSpace":
                    int insertIndex = Integer.parseInt(command.split(":")[2]);
                    messageBuilder.insert(insertIndex, " ");
                    System.out.println(messageBuilder);
                    break;
                case "Reverse":
                    String substring = command.split(":")[2];
                    if (messageBuilder.toString().contains(substring)){
                        String newMessage = messageBuilder.toString().replaceFirst(Pattern.quote(substring), "");
                        String reversedSubstring = new StringBuilder(substring).reverse().toString();
                        messageBuilder = new StringBuilder(newMessage).append(reversedSubstring);
                        System.out.println(messageBuilder);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String oldSubstring = command.split(":")[2];
                    String newSubstring = command.split(":")[4];
                    String newMessage = messageBuilder.toString().replace(oldSubstring, newSubstring);
                    messageBuilder = new StringBuilder(newMessage);
                    System.out.println(messageBuilder);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + messageBuilder);
    }
}
