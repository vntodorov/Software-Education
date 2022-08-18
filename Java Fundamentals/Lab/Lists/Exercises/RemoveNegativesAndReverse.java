package ListLAB;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) < 0) {
                int value = numList.get(i);
                numList.remove(Integer.valueOf(value));
                i -= 1;
            }
        }
        if (numList.size() > 0) {
            Collections.reverse(numList);
            for (int number : numList) {
                System.out.print(number + " ");
            }
        } else {
            System.out.println("empty");
        }
    }
}
