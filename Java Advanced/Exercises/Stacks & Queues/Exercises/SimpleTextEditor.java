package StacksAndQueuesEXERCISES;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int operations = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stringStack = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < operations; i++) {

            String input = scanner.nextLine();
            String currentCommand = input.split("\\s+")[0];

            switch (currentCommand){
                case "1":
                    String string = input.split("\\s+")[1];
                    stringStack.push(text.toString());
                    text.append(string);
                    break;
                case "2":
                    int count = Integer.parseInt(input.split("\\s+")[1]);
                    stringStack.push(text.toString());
                    text.delete(text.length() - count, text.length());
                    break;
                case "3":
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    text = new StringBuilder(stringStack.pop());
                    break;
            }
        }
    }
}
