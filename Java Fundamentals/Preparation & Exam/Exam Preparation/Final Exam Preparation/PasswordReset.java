package FinalExamEXERCISE;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder password = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();
        while (!command.equals("Done")){
            String currentCommand = command.split("\\s")[0];
            switch (currentCommand){
                case "TakeOdd":
                    StringBuilder newPassword = new StringBuilder();
                    for (int i = 1; i < password.length() ;) {
                        char currentSymbol = password.charAt(i);
                        newPassword.append(currentSymbol);
                        i += 2;
                    }
                    password = newPassword;
                    System.out.println(password);
                    break;
                case "Cut":
                    int cutIndex = Integer.parseInt(command.split("\\s")[1]);
                    int cutLength = Integer.parseInt(command.split("\\s")[2]);
                    password.delete(cutIndex, cutIndex + cutLength);
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = command.split("\\s")[1];
                    String substitute = command.split("\\s")[2];
                    if (password.toString().contains(substring)){
                        String newMessage = password.toString().replace(substring, substitute);
                        password = new StringBuilder(newMessage);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
            }
            command = scanner.nextLine();
        }
        System.out.println("Your password is: " + password);
    }
}
