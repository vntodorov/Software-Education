package DataTypes;

import java.util.Arrays;
import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long input = Integer.parseInt(scanner.nextLine());
        for (long i = 1; i <= input ; i++) {
            long[] numArray = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
            long sum = 0;
            long greaterNumber = Math.abs(Math.max(numArray[0], numArray[1]));
            while (greaterNumber > 0){
                long currentNum = greaterNumber % 10;
                sum += currentNum;
                greaterNumber /= 10;
            }
            System.out.println(sum);
        }
    }
}
