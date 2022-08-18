package MidExamEXERCISE;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] TargetsValue = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String indices = scanner.nextLine();
        int shotTargets = 0;
        while (!indices.equals("End")) {
            int indicesInt = Integer.parseInt(indices);
            if (indicesInt < TargetsValue.length && TargetsValue[indicesInt] != -1) {
                int currentTargetValue = TargetsValue[indicesInt];
                for (int i = 0; i < TargetsValue.length; i++) {
                    if (TargetsValue[i] != -1 && TargetsValue[i] > currentTargetValue) {
                        TargetsValue[i] -= currentTargetValue;
                    } else if (TargetsValue[i] != -1 && TargetsValue[i] <= currentTargetValue) {
                        TargetsValue[i] += currentTargetValue;
                    }
                }
                TargetsValue[indicesInt] = -1;
                shotTargets++;
            }
            indices = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", shotTargets);
        for (int number : TargetsValue) {
            System.out.print(number + " ");
        }
    }
}
