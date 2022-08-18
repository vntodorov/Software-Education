package ListEXERCISE;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int[] bombNumbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int specialNumber = bombNumbers[0];
        int powerNumber = bombNumbers[1];
        while (numList.contains(specialNumber)) {
            int indexOfSpecial = numList.indexOf(specialNumber);
            int left = Math.max(0, indexOfSpecial - powerNumber);
            int right = Math.min(numList.size() - 1, indexOfSpecial + powerNumber);
            for (int i = right; i >= left; i--) {
                numList.remove(i);
            }
        }
        int sum = 0;
        for (int number : numList) {
            sum += number;
        }
        System.out.println(sum);
    }
}
