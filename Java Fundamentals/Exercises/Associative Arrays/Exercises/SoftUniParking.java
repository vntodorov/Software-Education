package MapsLambdaAndStreamApiEXERCISE;

import java.util.*;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> users = new LinkedHashMap<>();
        List<String> allUsers = new ArrayList<>();
        int commands = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= commands; i++) {
            String[] input = scanner.nextLine().split(" ");
            String currentCommand = input[0];
            String username = input[1];
            switch (currentCommand) {
                case "register":
                    String plateNumber = input[2];
                    if (!allUsers.contains(username)) {
                        allUsers.add(username);
                        users.put(username, plateNumber);
                        System.out.printf("%s registered %s successfully%n", username, plateNumber);
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s%n", plateNumber);
                    }
                    break;
                case "unregister":
                    if (!allUsers.contains(username)) {
                        System.out.printf("ERROR: user %s not found%n", username);
                    } else {
                        allUsers.remove(username);
                        users.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    }
                    break;
            }
        }
        users.entrySet().forEach(user -> System.out.printf("%s => %s%n", user.getKey(), user.getValue()));
    }
}
