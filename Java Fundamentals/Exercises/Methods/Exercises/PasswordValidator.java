package MethodsEXERCISE;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        boolean isCharactersRuleValid = CharactersRule(password);
        boolean isConsistRuleValid = ConsistRule(password);
        boolean isDigitsRuleValid = DigitsRule(password);
        if (!isCharactersRuleValid) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!isConsistRuleValid) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!isDigitsRuleValid) {
            System.out.println("Password must have at least 2 digits");
        }
        if (isCharactersRuleValid && isConsistRuleValid && isDigitsRuleValid) {
            System.out.println("Password is valid");
        }
    }

    public static boolean CharactersRule(String password) {
        boolean isCharactersRuleValid = false;
        if (password.length() >= 6 && password.length() <= 10) {
            isCharactersRuleValid = true;
        }
        return isCharactersRuleValid;
    }

    public static boolean ConsistRule(String password) {
        boolean isConsistRuleValid = false;
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.toLowerCase().charAt(i);
            if ((currentSymbol >= 'a' && currentSymbol <= 'z') || (currentSymbol >= 48 && currentSymbol <= 57)) {
                isConsistRuleValid = true;
            } else {
                isConsistRuleValid = false;
                break;
            }
        }
        return isConsistRuleValid;
    }

    public static boolean DigitsRule(String password) {
        boolean isDigitsRuleValid = false;
        int digitsCount = 0;
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.charAt(i);
            if (currentSymbol >= 48 && currentSymbol <= 57) {
                digitsCount++;
                if (digitsCount == 2) {
                    isDigitsRuleValid = true;
                    break;
                }
            }
        }
        return isDigitsRuleValid;
    }
}
