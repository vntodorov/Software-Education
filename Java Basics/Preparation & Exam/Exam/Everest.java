package EXAM;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Everest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String WillHeSleep = scanner.nextLine();
        int days = 1;
        int CurrentMeters = 5364;
        while (!WillHeSleep.equals("END")) {
            int meters = Integer.parseInt(scanner.nextLine());
            if (WillHeSleep.equals("Yes")) {
                days++;
            }
            if (days > 5) {
                break;
            } else {
                CurrentMeters += meters;
            }
            if (CurrentMeters >= 8848) {
                break;
            }
            WillHeSleep = scanner.nextLine();
        }
        if (CurrentMeters >= 8846) {
            System.out.printf("Goal reached for %d days!", days);
        } else {
            System.out.println("Failed!");
            System.out.println(CurrentMeters);
        }
    }
}
