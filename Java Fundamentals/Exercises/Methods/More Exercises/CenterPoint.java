package Methods;

import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        closestToTheCenter(x1, y1, x2, y2);
    }

    public static void closestToTheCenter (int x1, int y1, int x2, int y2){
        int result = Math.abs(x1 + y1);
        int result2 = Math.abs(x2 + y2);
        if (result2 < result){
            System.out.printf("(%d, %d)", x2, y2);
        } else {
            System.out.printf("(%d, %d)", x1, y1);
        }
    }
}
