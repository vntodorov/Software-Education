package ConditionalStatementsAdvanced.exercises;

import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hExam = Integer.parseInt(scanner.nextLine());
        int mExam = Integer.parseInt(scanner.nextLine());
        int hArrive = Integer.parseInt(scanner.nextLine());
        int mArrive = Integer.parseInt(scanner.nextLine());
        int TotalExamTime = (hExam * 60) + mExam;
        int TotalArriveTime = (hArrive * 60) + mArrive;
        int diff = Math.abs(TotalArriveTime - TotalExamTime);
        int NewHour = diff / 60;
        int NewMinutes = diff % 60;
        if (TotalExamTime < TotalArriveTime) {
            System.out.println("Late");
            if (diff <= 59) {
                System.out.printf("%d minutes after the start", diff);
            } else {
                System.out.printf("%d:%02d hours after the start", NewHour, NewMinutes);
            }
        } else if (diff <= 30) {
            System.out.println("On time");
            if (diff != 0) {
                System.out.printf("%d minutes before the start", diff);
            }
        } else {
            System.out.println("Early");
            if (diff <= 59) {
                System.out.printf("%d minutes before the start", diff);
            } else {
                System.out.printf("%d:%02d hours before the start", NewHour, NewMinutes);
            }
        }
    }
}

