package WhileLoop.lab;

import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int min = Integer.MAX_VALUE;
        while (!number.equals("Stop")){
            int CurrentNum = Integer.parseInt(number);
            if (CurrentNum < min){
                min = CurrentNum;
            }
            number = scanner.nextLine();
        }
        System.out.println(min);
    }
}
