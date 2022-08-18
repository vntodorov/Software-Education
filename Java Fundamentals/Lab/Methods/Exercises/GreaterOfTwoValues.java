package MethodsLAB;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        switch (type){
            case "int":
                int firstNumber = Integer.parseInt(scanner.nextLine());
                int secondNumber = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(firstNumber, secondNumber));
                break;
            case "char":
                char first = scanner.nextLine().charAt(0);
                char second = scanner.nextLine().charAt(0);
                System.out.println(getMax(first, second));
                break;
            case "string":
                String firstName = scanner.nextLine();
                String secondName = scanner.nextLine();
                System.out.println(getMax(firstName, secondName));
                break;
        }


    }

    public static int getMax(int firstNumber, int secondNumber){
        if (firstNumber > secondNumber){
            return firstNumber;
        } else {
            return secondNumber;
        }
    }

    public static char getMax(char first, char second){
        if (first > second){
            return first;
        } else {
            return second;
        }
    }

    public static String getMax(String firstName, String secondName){
        String result = "";
        if (firstName.compareTo(secondName) > 0){
            result = firstName;
        } else {
            result = secondName;
        }
        return result;
    }
}
