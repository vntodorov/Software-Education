package MethodsEXERCISE;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        while (!number.equals("END")){
            isPalindrome(number);
            number = scanner.nextLine();
        }

    }

    public static void isPalindrome(String number){
        String newWord = "";
        for (int i = number.length() - 1; i >= 0 ; i--) {
            newWord += number.charAt(i);
        }
        System.out.println(number.equals(newWord));
    }
}
