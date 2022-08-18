package MidExamEXERCISE;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleForTheLift = Integer.parseInt(scanner.nextLine());
        int[] currentLiftState = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < currentLiftState.length; i++) {
            int currentNum = currentLiftState[i];
            while (currentNum != 4) {
                if (peopleForTheLift == 0) {
                    break;
                }
                currentNum++;
                peopleForTheLift--;
            }
            currentLiftState[i] = currentNum;
        }
        if (currentLiftState[currentLiftState.length - 1] != 4) {
            System.out.println("The lift has empty spots!");
            for (int number : currentLiftState) {
                System.out.print(number + " ");
            }
        } else if (peopleForTheLift != 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleForTheLift);
            for (int number : currentLiftState) {
                System.out.print(number + " ");
            }
        } else {
            for (int number : currentLiftState) {
                System.out.print(number + " ");
            }
        }
    }
}
