package BasicSyntaxEXERCISE;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String PassTry = scanner.nextLine();
        boolean isCorrect = true;
        String password = "";
        int tries = 0;
        for (int position = username.length() - 1; position >= 0 ; position--) {
            char CurrentSymbol = username.charAt(position);
            password += CurrentSymbol;
        }
        while (!PassTry.equals(password)){
            tries ++;
            if (tries == 4){
                System.out.printf("User %s blocked!", username);
                isCorrect = false;
                break;
            }
            System.out.println("Incorrect password. Try again.");
            PassTry = scanner.nextLine();
        }
        if (isCorrect){
            System.out.printf("User %s logged in.", username);
        }
    }
}
