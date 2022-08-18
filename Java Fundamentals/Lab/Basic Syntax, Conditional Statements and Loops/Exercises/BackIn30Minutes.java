package BasicSyntaxLAB;

import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int AllMinutes = (hours * 60) + minutes + 30;
        int NewHours = AllMinutes / 60;
        int NewMinutes = AllMinutes % 60;
        if (NewHours > 23) {
            NewHours = 0;
        }
        System.out.printf("%d:%02d", NewHours, NewMinutes);
    }
}
