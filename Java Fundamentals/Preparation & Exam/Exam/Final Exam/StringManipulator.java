package FinalEXAM;

import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        StringBuilder wordBuilder = new StringBuilder(word);
        String command = scanner.nextLine();
        while (!command.equals("End")){

            String currentCommand = command.split("\\s")[0];

            switch (currentCommand){

                case "Translate":
                    String oldWord = command.split("\\s")[1];
                    String replacement = command.split("\\s")[2];
                    String newWord = wordBuilder.toString().replace(oldWord, replacement);
                    System.out.println(newWord);
                    wordBuilder = new StringBuilder(newWord);
                    break;

                case "Includes":
                    String substring = command.split("\\s")[1];
                    if (wordBuilder.toString().contains(substring)){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;

                case "Start":
                    String startSubstring = command.split("\\s")[1];
                    String startingWord = wordBuilder.substring(0, startSubstring.length());
                    if (startSubstring.equals(startingWord)){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;

                case "Lowercase":
                    String lowercaseWord = wordBuilder.toString().toLowerCase();
                    System.out.println(lowercaseWord);
                    wordBuilder = new StringBuilder(lowercaseWord);
                    break;

                case "FindIndex":
                    String findChar = command.split("\\s")[1];
                    int index = wordBuilder.lastIndexOf(findChar);
                    System.out.println(index);
                    break;

                case "Remove":
                    int startIndex = Integer.parseInt(command.split("\\s")[1]);
                    int count = Integer.parseInt(command.split("\\s")[2]);
                    wordBuilder.delete(startIndex, startIndex + count);
                    System.out.println(wordBuilder);
                    break;
            }

            command = scanner.nextLine();

        }
    }
}
