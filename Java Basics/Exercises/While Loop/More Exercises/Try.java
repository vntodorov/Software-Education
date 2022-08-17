package WhileLoop;

import java.util.Scanner;

public class Try {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int c = 0, o = 0, n = 0;
        StringBuilder word = new StringBuilder();
        while (!command.equals("End")) {
            char letter = command.charAt(0);
            if ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')) {
                switch (letter) {
                    case 'c':
                        if (c > 0) {
                            word.append(letter);
                        }
                        c++;
                        break;
                    case 'o':
                        if (o > 0) {
                            word.append(letter);
                        }
                        o++;
                        break;
                    case 'n':
                        if (n > 0) {
                            word.append(letter);
                        }
                        n++;
                        break;
                    default:
                        word.append(letter);
                }
            }
            if (c > 0 && o > 0 && n > 0) {
                System.out.print(word + " ");
                c = 0;
                o = 0;
                n = 0;
                word = new StringBuilder();
            }
            command = scanner.next();
        }
    }
}
