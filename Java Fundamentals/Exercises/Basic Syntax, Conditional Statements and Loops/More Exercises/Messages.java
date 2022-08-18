package BasicSyntax;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        String word = "";
        char currentSymbol = 0;
        for (int i = 1; i <= lines; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 0:
                    currentSymbol = ' ';
                    word += currentSymbol;
                    break;
                case 2:
                    currentSymbol = 'a';
                    word += currentSymbol;
                    break;
                case 22:
                    currentSymbol = 'b';
                    word += currentSymbol;
                    break;
                case 222:
                    currentSymbol = 'c';
                    word += currentSymbol;
                    break;
                case 3:
                    currentSymbol = 'd';
                    word += currentSymbol;
                    break;
                case 33:
                    currentSymbol = 'e';
                    word += currentSymbol;
                    break;
                case 333:
                    currentSymbol = 'f';
                    word += currentSymbol;
                    break;
                case 4:
                    currentSymbol = 'g';
                    word += currentSymbol;
                    break;
                case 44:
                    currentSymbol = 'h';
                    word += currentSymbol;
                    break;
                case 444:
                    currentSymbol = 'i';
                    word += currentSymbol;
                    break;
                case 5:
                    currentSymbol = 'j';
                    word += currentSymbol;
                    break;
                case 55:
                    currentSymbol = 'k';
                    word += currentSymbol;
                    break;
                case 555:
                    currentSymbol = 'l';
                    word += currentSymbol;
                    break;
                case 6:
                    currentSymbol = 'm';
                    word += currentSymbol;
                    break;
                case 66:
                    currentSymbol = 'n';
                    word += currentSymbol;
                    break;
                case 666:
                    currentSymbol = 'o';
                    word += currentSymbol;
                    break;
                case 7:
                    currentSymbol = 'p';
                    word += currentSymbol;
                    break;
                case 77:
                    currentSymbol = 'q';
                    word += currentSymbol;
                    break;
                case 777:
                    currentSymbol = 'r';
                    word += currentSymbol;
                    break;
                case 7777:
                    currentSymbol = 's';
                    word += currentSymbol;
                    break;
                case 8:
                    currentSymbol = 't';
                    word += currentSymbol;
                    break;
                case 88:
                    currentSymbol = 'u';
                    word += currentSymbol;
                    break;
                case 888:
                    currentSymbol = 'v';
                    word += currentSymbol;
                    break;
                case 9:
                    currentSymbol = 'w';
                    word += currentSymbol;
                    break;
                case 99:
                    currentSymbol = 'x';
                    word += currentSymbol;
                    break;
                case 999:
                    currentSymbol = 'y';
                    word += currentSymbol;
                    break;
                case 9999:
                    currentSymbol = 'z';
                    word += currentSymbol;
                    break;
            }
        }
        System.out.println(word);
    }
}

