package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberStrings = Integer.parseInt(scanner.nextLine());
        int[] numArray = new int[numberStrings];
        for (int i = 0; i < numberStrings ; i++) {
            String currentString = scanner.nextLine();
            int sum = 0;
            for (int j = 0; j < currentString.length() ; j++) {
                char currentSymbol = currentString.charAt(j);
                int symbolASCII = currentString.charAt(j);
                switch (currentSymbol){
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    sum += symbolASCII * currentString.length();
                    break;
                    default:
                    sum += symbolASCII / currentString.length();
                }
            }
            numArray[i] = sum;
        }
        Arrays.sort(numArray);
        for (int number : numArray){
            System.out.println(number);
        }
    }
}
