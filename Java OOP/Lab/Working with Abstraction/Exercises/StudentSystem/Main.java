package WorkingWithAbstractionLAB.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();
        String input = scanner.nextLine();

        while (!input.equals("Exit")) {
            String[] data = input.split("\\s+");
            String command = data[0];

            if (command.equals("Create")){
                studentSystem.create(data);

            } else if (command.equals("Show")){
                String studentName = data[1];
                studentSystem.show(studentName);
            }

            input = scanner.nextLine();

        }
    }
}
