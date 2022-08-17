package WhileLoop.exercises;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        int FreeSpace = width * length * height;
        String boxes = scanner.nextLine();
        int OccupiedSpace = 0;
        while (!boxes.equals("Done")) {
            int NumBoxes = Integer.parseInt(boxes);
            OccupiedSpace += NumBoxes;
            if (OccupiedSpace > FreeSpace) {
                break;
            }
            boxes = scanner.nextLine();
        }
        int left = Math.abs(OccupiedSpace - FreeSpace);
        if (OccupiedSpace <= FreeSpace){
            System.out.printf("%d Cubic meters left.", left);
        } else {
            System.out.printf("No more free space! You need %d Cubic meters more.", left);
        }
    }
}
