package ConditionalStatements.lab;

import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        boolean IsEven = a % 2 == 0;
        if(IsEven){
            System.out.println("even");
        } else {
            System.out.println("odd");
        }

    }
}