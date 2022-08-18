package MidEXAM;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> booksList = Arrays.stream(scanner.nextLine().split("&")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("Done")){
            String[] commandsLine = command.split(" \\| ");
            String currentCommand = commandsLine[0].split(" ")[0];
            switch (currentCommand){
                case "Add":
                    String currentAddBook = commandsLine[1];
                    if (!booksList.contains(currentAddBook)){
                        booksList.add(0, currentAddBook);
                    }
                    break;
                case "Take":
                    String currentTakeBook = commandsLine[1];
                    booksList.remove(currentTakeBook);
                    break;
                case "Swap":
                    String book1 = commandsLine[1];
                    String book2 = commandsLine[2];
                    if (booksList.contains(book1) && booksList.contains(book2)){
                        int indexOf1 = booksList.indexOf(book1);
                        int indexOf2 = booksList.indexOf(book2);
                        booksList.set(indexOf1, book2);
                        booksList.set(indexOf2, book1);
                    }
                    break;
                case "Insert":
                    String currentInsertBook = commandsLine[1];
                    if (!booksList.contains(currentInsertBook)){
                        booksList.add(currentInsertBook);
                    }
                    break;
                case "Check":
                    int index = Integer.parseInt(commandsLine[1]);
                    if (index >= 0 && index <= booksList.size() - 1){
                        String currentBook = booksList.get(index);
                        System.out.println(currentBook);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(String.join(", ", booksList));
    }
}
