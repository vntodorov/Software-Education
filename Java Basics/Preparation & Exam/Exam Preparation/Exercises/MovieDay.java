package Exam;

import java.util.Scanner;

public class MovieDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ScreenTime = Integer.parseInt(scanner.nextLine());
        int scenes = Integer.parseInt(scanner.nextLine());
        int TimeForScene = Integer.parseInt(scanner.nextLine());
        double PrepareTime = ScreenTime * 15 / 100.00;
        double FullTime = scenes * TimeForScene + PrepareTime;
        if (FullTime <= ScreenTime){
            System.out.printf("You managed to finish the movie on time! You have %d minutes left!", Math.round(ScreenTime - FullTime));
        } else {
            System.out.printf("Time is up! To complete the movie you need %.0f minutes.", FullTime - ScreenTime);
        }
    }
}
