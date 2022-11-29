package InterfacesAndAbstractionLAB.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();

        while (!"End".equals(type)) {

            String[] data = type.split("\\s+");

            if (data.length == 2) {
                Robot robot = new Robot(data[0], data[1]);
                identifiables.add(robot);
            } else {
                Citizen citizen = new Citizen(data[0], Integer.parseInt(data[1]), data[2]);
                identifiables.add(citizen);
            }
            type = scanner.nextLine();
        }

        String endNumber = scanner.nextLine();

        identifiables.stream().map(Identifiable::getId).filter(id -> id.endsWith(endNumber)).forEach(System.out::println);

    }
}
