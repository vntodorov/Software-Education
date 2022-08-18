package FinalExamEXERCISE;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encryptedMessage = scanner.nextLine();
        StringBuilder encryptedMessageBuilder = new StringBuilder(encryptedMessage);
        String command = scanner.nextLine();
        while (!command.equals("Decode")){
            String currentCommand = command.split("\\|")[0];
            String substring = "";
            switch (currentCommand){

                case "Move":

                    int moveIndex = Integer.parseInt(command.split("\\|")[1]);
                    substring = encryptedMessageBuilder.substring(0, moveIndex);
                    encryptedMessageBuilder.append(substring);
                    encryptedMessageBuilder.delete(0, moveIndex);
                    break;

                case "Insert":

                    int insertIndex = Integer.parseInt(command.split("\\|")[1]);
                    String insertLetter = command.split("\\|")[2];
                    encryptedMessageBuilder.insert(insertIndex, insertLetter);
                    break;

                case "ChangeAll":

                    String changeLetter = command.split("\\|")[1];
                    String newLetter = command.split("\\|")[2];
                    String newWord = encryptedMessageBuilder.toString().replace(changeLetter, newLetter);
                    encryptedMessageBuilder = new StringBuilder(newWord);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", encryptedMessageBuilder);
    }
}
