package Exam;

import java.util.Scanner;

public class SeriesCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String serial = scanner.nextLine();
        int seasons = Integer.parseInt(scanner.nextLine());
        int episodes = Integer.parseInt(scanner.nextLine());
        double TimeWithoutAds = Double.parseDouble(scanner.nextLine());
        double Ads = TimeWithoutAds * 20 / 100;
        double EpisodeTime = TimeWithoutAds + Ads;
        int SpecialTime = seasons * 10;
        double Full = Math.floor(EpisodeTime * episodes * seasons + SpecialTime);
        System.out.printf("Total time needed to watch the %s series is %.0f minutes.", serial, Full);
    }
}

