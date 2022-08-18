package ArraysEXERCISE;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int[] numberArr = new int[lines];
        for (int i = 0; i < lines ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            numberArr[i] = number;
            sum += number;
        }
        for (int number : numberArr){
            System.out.print(number + " ");
        }
        System.out.printf("%n%d", sum);
    }
}
