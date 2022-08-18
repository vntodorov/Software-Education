package MapsLambdaAndStreamApiEXERCISE;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> sideUsers = new LinkedHashMap<>();
        List<String> users = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {
                String side = input.split(" \\| ")[0];
                String user = input.split(" \\| ")[1];
                if (!users.contains(user)) {
                    users.add(user);
                    if (!sideUsers.containsKey(side)) {
                        sideUsers.put(side, new ArrayList<>());
                    }
                    sideUsers.get(side).add(user);
                }
            } else if (input.contains("->")) {
                String user = input.split(" -> ")[0];
                String side = input.split(" -> ")[1];
                if (users.contains(user)) {
                    sideUsers.entrySet().forEach(entry -> entry.getValue().remove(user));
                } else {
                    users.add(user);
                }
                if (sideUsers.containsKey(side)) {
                    sideUsers.get(side).add(user);
                } else {
                    sideUsers.put(side, new ArrayList<>());
                    sideUsers.get(side).add(user);
                }
                System.out.printf("%s joins the %s side!%n", user, side);
            }
            input = scanner.nextLine();
        }
        sideUsers.entrySet().stream().filter(entry -> entry.getValue().size() > 0)
                .forEach(entry -> {
                            System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                            entry.getValue().forEach(player -> System.out.println("! " + player));
                        }
                );
    }
}
