package Exam;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        String audience = scanner.nextLine();
        boolean isFull = false;
        double profit = 0;
        int AllPeople = 0;
        while (!audience.equals("Movie time!")) {
            int NumAudience = Integer.parseInt(audience);
            AllPeople += NumAudience;
            if (AllPeople > capacity) {
                isFull = true;
                break;
            }
            double Price = NumAudience * 5;
            if (NumAudience % 3 == 0) {
                Price -= 5;
            }
            profit += Price;
            audience = scanner.nextLine();
        }
        if (isFull) {
            System.out.println("The cinema is full.");
        } else {
            System.out.printf("There are %d seats left in the cinema.%n", capacity - AllPeople);
        }
        System.out.printf("Cinema income - %.0f lv.", profit);
    }
}
