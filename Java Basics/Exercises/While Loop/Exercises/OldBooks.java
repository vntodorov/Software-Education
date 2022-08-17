package WhileLoop.exercises;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String book = scanner.nextLine();
        String SearchedBook = scanner.nextLine();
        int AllBooks = 0;
        while (!SearchedBook.equals(book)) {
            if (SearchedBook.equals("No More Books")) {
                System.out.println("The book you search is not here!");
                break;
            }
            AllBooks++;
            SearchedBook = scanner.nextLine();
        }
        if (SearchedBook.equals(book)) {
            System.out.printf("You checked %d books and found it.", AllBooks);
        } else {
            System.out.printf("You checked %d books.", AllBooks);
        }
    }
}
