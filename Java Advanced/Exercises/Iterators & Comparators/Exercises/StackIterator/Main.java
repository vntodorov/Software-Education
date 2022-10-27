package IteratorsAndComparatorsEXERCISES.StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Stack stack = new Stack();

        while (!command.equals("END")) {
            String[] data = command.split("\\s+");
            String currentCommand = data[0];

            switch (currentCommand) {
                case "Push":
                    for (int i = 1; i < data.length; i++) {
                        int number = Integer.parseInt(data[i].split("\\,")[0]);
                        stack.push(number);
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        for (Integer num : stack){
            System.out.println(num);
        }

    }
}
