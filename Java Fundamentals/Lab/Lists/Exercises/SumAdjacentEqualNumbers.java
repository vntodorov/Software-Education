package ListLAB;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        for (int i = 0; i < numList.size() - 1; i++) {
            double currentFirstNum = numList.get(i);
            double currentSecondNum = numList.get(i + 1);
            if (currentFirstNum == currentSecondNum){
                numList.set(i, currentFirstNum + currentSecondNum);
                numList.remove(i + 1);
                i = -1;
            }
        }
        for (double number : numList){
            DecimalFormat df = new DecimalFormat("0.#");
            System.out.print(df.format(number) + " ");
        }
    }
}
