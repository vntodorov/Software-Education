package WorkingWithAbstractionEXERCISES.TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] values = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < values.length; j++) {
                String name = values[j];
                int currentIndex = TrafficLights.valueOf(name).ordinal() + 1;
                if (currentIndex >= TrafficLights.values().length){
                    currentIndex = 0;
                }
                values[j] = TrafficLights.values()[currentIndex].name();
            }
            System.out.println(String.join(" ", values));
        }
    }
}
