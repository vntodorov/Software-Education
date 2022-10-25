package FunctionalProgrammingEXERCISES;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Set<String> filters = new HashSet<>();

        String command = scanner.nextLine();

        while (!command.equals("Print")) {

            String[] data = command.split("\\;");

            String addOrRemove = data[0];
            String type = data[1];
            String parameter = data[2];

            if (addOrRemove.contains("Add")) {
                filters.add(type + ";" + parameter);
            } else {
                filters.remove(type + ";" + parameter);
            }

            command = scanner.nextLine();
        }

        filters.forEach(filter -> {
            Predicate<String> filterToApply = getPredicate(filter);
            names.removeIf(filterToApply);

        });

        names.forEach(name -> System.out.print(name + " "));
    }

    private static Predicate<String> getPredicate(String filter) {
        String[] data = filter.split("\\;");

        String type = data[0];
        String parameter = data[1];
        switch (type){
            case "Starts with":
                return s -> s.startsWith(parameter);
            case "Ends with":
                return s -> s.endsWith(parameter);
            case "Length":
                return s -> s.length() == Integer.parseInt(parameter);
            case "Contains":
                return s -> s.contains(parameter);
        }

        return null;


    }
}
