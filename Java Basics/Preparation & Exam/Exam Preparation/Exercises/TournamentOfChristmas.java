package ExamMarch2020;

import java.util.Scanner;

public class TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TournamentDays = Integer.parseInt(scanner.nextLine());
        int WonGames = 0;
        int LostGames = 0;
        int DaysWin = 0;
        int DaysLost = 0;
        double MoneyForDay = 0;
        double MoneyForCharity = 0;
        for (int i = 1; i <= TournamentDays; i++) {
            String sport = scanner.nextLine();
            while (!sport.equals("Finish")) {
                String result = scanner.nextLine();
                if (result.equals("win")) {
                    WonGames++;
                    MoneyForDay += 20;
                } else {
                    LostGames++;
                }
                sport = scanner.nextLine();
            }
            if (WonGames > LostGames) {
                DaysWin++;
                MoneyForDay += MoneyForDay * 10 / 100;
            } else {
                DaysLost++;
            }
            MoneyForCharity += MoneyForDay;
            WonGames = 0;
            LostGames = 0;
            MoneyForDay = 0;
        }
        if (DaysWin > DaysLost) {
            MoneyForCharity += MoneyForCharity * 20 / 100;
            System.out.printf("You won the tournament! Total raised money: %.2f", MoneyForCharity);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", MoneyForCharity);
        }
    }
}
