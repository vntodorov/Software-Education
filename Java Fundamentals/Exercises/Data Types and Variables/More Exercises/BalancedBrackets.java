package DataTypes;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        int inRowOpen = 0;
        int inRowClose = 0;
        int openBrackets = 0;
        int closeBrackets = 0;
        boolean isBalanced = true;
        for (int i = 1; i <= lines; i++) {
            String word = scanner.nextLine();
            switch (word) {
                case "(":
                    openBrackets++;
                    inRowOpen++;
                    inRowClose = 0;
                    break;
                case ")":
                    closeBrackets++;
                    inRowClose++;
                    inRowOpen = 0;
                    break;
            }
            if (inRowOpen == 2 || inRowClose == 2) {
                isBalanced = false;
            }
        }
        if (isBalanced && openBrackets == closeBrackets) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
