package ArraysEXERCISE;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArray = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < numArray.length; i++) {
            boolean isTop = true;
            int currentElement = numArray[i];
            for (int j = i + 1; j < numArray.length ; j++) {
                if (currentElement <= numArray[j]){
                    isTop = false;
                    break;
                }
            }
            if (isTop){
                System.out.print(currentElement + " ");
            }
        }
    }
}
