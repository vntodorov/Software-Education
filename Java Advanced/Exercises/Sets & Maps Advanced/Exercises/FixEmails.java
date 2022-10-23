package SetsAndMapsAdvancedEXERCISES;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        while (!name.equals("stop")){
            String email = scanner.nextLine();

            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")){
                emails.put(name, email);
            }

            name = scanner.nextLine();
        }

        emails.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
