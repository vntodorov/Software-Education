package NestedLoops.lab;

import java.util.Scanner;

public class Clock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <= 23 ; i++) {
            for (int j = 0; j <= 59 ; j++) {
                System.out.printf("%02d:%02d%n", i, j);
            }
        }
    }
}
