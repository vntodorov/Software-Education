package WhileLoop.lab;

import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int max = Integer.MIN_VALUE;
        while (!number.equals("Stop")){
            int CurrentNum = Integer.parseInt(number);
            if (CurrentNum > max){
                max = CurrentNum;
            }
            number = scanner.nextLine();
        }
        System.out.println(max);
    }
}
