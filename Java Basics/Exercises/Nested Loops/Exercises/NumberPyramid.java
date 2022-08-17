package NestedLoops.exercises;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int CurrentNumber = 0;
        boolean isDone = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                CurrentNumber++;
                if (CurrentNumber <= n) {
                    System.out.print(CurrentNumber + " ");
                } else {
                    isDone = true;
                    break;
                }
            }
            if (isDone){
                break;
            }
            System.out.println();
        }
    }
}
