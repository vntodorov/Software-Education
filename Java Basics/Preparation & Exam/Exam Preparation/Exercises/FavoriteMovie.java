package Exam;

import java.util.Scanner;

public class FavoriteMovie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String movie = scanner.nextLine();
        int movies = 0;
        int CurrentSum = 0;
        int AllSum = 0;
        String CurrentMovie = "";
        while (!movie.equals("STOP")) {
            movies++;
            int characters = movie.length();
            for (int i = 0; i < characters; i++) {
                char symbol = movie.charAt(i);
                int Sum = symbol;
                if (symbol >= 'a' && symbol <= 'z') {
                    Sum -= characters * 2;
                } else if (symbol >= 'A' && symbol <= 'Z') {
                    Sum -= characters;
                }
                AllSum += Sum;
            }
            if (CurrentSum < AllSum) {
                CurrentSum = AllSum;
                CurrentMovie = movie;
            }
            if (movies == 7) {
                System.out.println("The limit is reached.");
                break;
            }
            AllSum = 0;
            movie = scanner.nextLine();
        }
        System.out.printf("The best movie for you is %s with %d ASCII sum.", CurrentMovie, CurrentSum);
    }
}
