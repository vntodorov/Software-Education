package ExamMarch2020;

import java.util.Scanner;

public class MountainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double RecordSecs = Double.parseDouble(scanner.nextLine());
        double NeededMeters = Double.parseDouble(scanner.nextLine());
        double SecsFor1Meter = Double.parseDouble(scanner.nextLine());
        double SecsLate = Math.floor(NeededMeters / 50) * 30;
        double AllSecs = NeededMeters * SecsFor1Meter + SecsLate;
        if (AllSecs < RecordSecs) {
            System.out.printf("Yes! The new record is %.2f seconds.", AllSecs);
        } else {
            System.out.printf("No! He was %.2f seconds slower.", AllSecs - RecordSecs);
        }
    }
}
