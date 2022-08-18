package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> drumsQuality = Arrays
                .stream(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> initialQuality = new ArrayList<>(drumsQuality);
        String hitPower = scanner.nextLine();
        while (!hitPower.equals("Hit it again, Gabsy!")){
            int hitPowerNum = Integer.parseInt(hitPower);
            for (int i = 0; i < drumsQuality.size(); i++) {
                drumsQuality.set(i, drumsQuality.get(i) - hitPowerNum);
                if (drumsQuality.get(i) <= 0){
                    int price = initialQuality.get(i) * 3;
                    if (savings >= price){
                        savings -= price;
                        drumsQuality.set(i, initialQuality.get(i));
                    } else {
                        drumsQuality.remove(i);
                        initialQuality.remove(i);
                        i--;
                    }
                }
            }
            hitPower = scanner.nextLine();
        }
        drumsQuality.forEach(drum -> System.out.print(drum + " "));
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", savings);

    }
}
