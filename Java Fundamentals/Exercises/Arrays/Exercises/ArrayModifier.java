package ArraysEXERCISE;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArray = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] commands = command.split(" ");
            String currentCommand = commands[0];
            switch (currentCommand) {
                case "swap":
                    int swap1 = Integer.parseInt(commands[1]);
                    int swap2 = Integer.parseInt(commands[2]);
                    int currentNum = numArray[swap1];
                    numArray[swap1] = numArray[swap2];
                    numArray[swap2] = currentNum;
                    break;
                case "multiply":
                    int multiply1 = Integer.parseInt(commands[1]);
                    int multiply2 = Integer.parseInt(commands[2]);
                    numArray[multiply1] = numArray[multiply1] * numArray[multiply2];
                    break;
                case "decrease":
                    for (int i = 0; i < numArray.length; i++) {
                        numArray[i] -= 1;
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < numArray.length; i++) {
            if (i == numArray.length - 1) {
                System.out.print(numArray[i]);
                break;
            } else {
                System.out.print(numArray[i] + ", ");
            }

        }
    }
}

