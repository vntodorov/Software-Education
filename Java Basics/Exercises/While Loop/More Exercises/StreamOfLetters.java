package WhileLoop;

import java.util.Scanner;

public class StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String symbol = scanner.nextLine();
        int c = 0;
        int o = 0;
        int n = 0;
        String word = "";
        while (!symbol.equals("End")) {
            char letter = symbol.charAt(0);
            if ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')) {
                switch (letter) {
                    case 'c':
                        c++;
                        if (c != 1) {
                            word += letter;
                        }
                        break;
                    case 'o':
                        o++;
                        if (o != 1) {
                            word += letter;
                        }
                        break;
                    case 'n':
                        n++;
                        if (n != 1) {
                            word += letter;
                        }
                        break;
                    default:
                        word += letter;
                }
            }
            if (c > 0 && o > 0 && n > 0) {
                System.out.print(word + " ");
                word = "";
                c = 0;
                o = 0;
                n = 0;
            }
            symbol = scanner.nextLine();
        }
    }
}
