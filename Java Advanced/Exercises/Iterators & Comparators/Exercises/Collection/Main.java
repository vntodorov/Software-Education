package IteratorsAndComparatorsEXERCISES.Collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListyIterator listyIterator = null;

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] data = command.split("\\s+");
            String currentCommand = data[0];

            switch (currentCommand) {
                case "Create":
                    if (data.length > 1) {
                        String[] names = Arrays.copyOfRange(data, 1, data.length);
                        listyIterator = new ListyIterator(names);
                    } else {
                        listyIterator = new ListyIterator();
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Move":
                    System.out.println(listyIterator.Move());
                    break;
                case "Print":
                    try {
                        listyIterator.Print();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "PrintAll":
                    listyIterator.PrintAll();
                    break;
            }

            command = scanner.nextLine();
        }


    }
}
