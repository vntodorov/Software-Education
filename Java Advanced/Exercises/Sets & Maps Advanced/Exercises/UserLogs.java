package SetsAndMapsAdvancedEXERCISES;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();

        while (!input.equals("end")) {

            String[] allDetails = input.split("\\s+");
            String currentIP = allDetails[0].split("\\=")[1];
            String currentUser = allDetails[2].split("\\=")[1];

            userLogs.putIfAbsent(currentUser, new LinkedHashMap<>());

            if (!userLogs.get(currentUser).containsKey(currentIP)) {
                userLogs.get(currentUser).put(currentIP, 1);

            } else {
                int currentValue = userLogs.get(currentUser).get(currentIP);
                userLogs.get(currentUser).put(currentIP, currentValue + 1);

            }


            input = scanner.nextLine();
        }

        for (var user : userLogs.entrySet()) {
            String currentUser = user.getKey();
            System.out.println(currentUser + ":");
            List<String> currentDetails = new ArrayList<>();
            for (var ip : user.getValue().entrySet()) {
                currentDetails.add(String.format("%s => %d", ip.getKey(), ip.getValue()));
            }
            System.out.print(String.join(", ", currentDetails));
            System.out.print(".");
            System.out.println();


        }


    }
}
