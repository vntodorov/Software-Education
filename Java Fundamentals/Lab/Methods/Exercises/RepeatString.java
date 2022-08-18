package MethodsLAB;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int repeats = Integer.parseInt(scanner.nextLine());
        String finalName = nameRepeat(word, repeats);
        System.out.println(finalName);

    }

    public static String nameRepeat(String word, int repeats) {
        String name = "";
        for (int i = 1; i <= repeats; i++) {
                name += word;
            }
        return name;
    }
}
