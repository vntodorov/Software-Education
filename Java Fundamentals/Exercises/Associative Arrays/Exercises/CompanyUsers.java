package MapsLambdaAndStreamApiEXERCISE;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> companies = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String company = input.split(" -> ")[0];
            String id = input.split(" -> ")[1];
            if (!companies.containsKey(company)) {
                companies.put(company, new ArrayList<>());
                companies.get(company).add(id);
            } else {
                List<String> currentIds = companies.get(company);
                boolean isExist = false;
                for (String currentId : currentIds) {
                    if (currentId.equals(id)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    companies.get(company).add(id);
                }
            }
            input = scanner.nextLine();
        }
        companies.entrySet().forEach(company -> {
                    System.out.println(company.getKey());
                    company.getValue().forEach(id -> System.out.printf("-- %s%n", id));
                }
        );
    }
}
