package Methods;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArr = Arrays
                .stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String currentCommand = command.split("\\s")[0];
            switch (currentCommand) {
                case "exchange":
                    int index = Integer.parseInt(command.split("\\s")[1]);
                    if (index >= 0 && index < numArr.length) {
                        numArr = exchangeInArray(numArr, index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    String MaxEvenOrOdd = command.split("\\s")[1];
                    if (MaxEvenOrOdd.equals("odd") && isThereAnOddNumber(numArr)) {
                        System.out.println(indexOfMaxOdd(numArr));
                    } else if (MaxEvenOrOdd.equals("even") && isThereAnEvenNumber(numArr)) {
                        System.out.println(indexOfMaxEven(numArr));
                    } else {
                        System.out.println("No matches");
                    }
                    break;
                case "min":
                    String MinEvenOrOdd = command.split("\\s")[1];
                    if (MinEvenOrOdd.equals("odd") && isThereAnOddNumber(numArr)) {
                        System.out.println(indexOfMinOdd(numArr));
                    } else if (MinEvenOrOdd.equals("even") && isThereAnEvenNumber(numArr)) {
                        System.out.println(indexOfMinEven(numArr));
                    } else {
                        System.out.println("No matches");
                    }
                    break;
                case "first":
                    int countFirst = Integer.parseInt(command.split("\\s")[1]);
                    String firstEvenOrOdd = command.split("\\s")[2];
                    if (countFirst > numArr.length) {
                        System.out.println("Invalid count");
                    } else if (firstEvenOrOdd.equals("odd") && isThereAnOddNumber(numArr)) {
                        int[] firstOddArray = firstOdd(numArr, countFirst);
                        System.out.println(Arrays.toString(firstOddArray));
                    } else if ((firstEvenOrOdd.equals("even") && isThereAnEvenNumber(numArr))) {
                        int[] firstEvenArray = firstEven(numArr, countFirst);
                        System.out.println(Arrays.toString(firstEvenArray));
                    } else {
                        System.out.println("[]");
                    }
                    break;
                case "last":
                    int countLast = Integer.parseInt(command.split("\\s")[1]);
                    String lastEvenOrOdd = command.split("\\s")[2];
                    if (countLast > numArr.length) {
                        System.out.println("Invalid count");
                    } else if (lastEvenOrOdd.equals("odd") && isThereAnOddNumber(numArr)) {
                        int[] lastOddArray = lastOdd(numArr, countLast);
                        System.out.println(Arrays.toString(lastOddArray));
                    } else if ((lastEvenOrOdd.equals("even") && isThereAnEvenNumber(numArr))) {
                        int[] lastEvenArray = lastEven(numArr, countLast);
                        System.out.println(Arrays.toString(lastEvenArray));
                    } else {
                        System.out.println("[]");
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(Arrays.toString(numArr));
    }

    public static int[] exchangeInArray(int[] numArr, int index) {
        int[] exchangedArray = new int[numArr.length];
        int startIndex = 0;
        for (int i = index + 1; i < numArr.length ; i++) {
            exchangedArray[startIndex] = numArr[i];
            startIndex++;
        }
        for (int i = 0; i <= index ; i++) {
            exchangedArray[startIndex] = numArr[i];
            startIndex++;
        }
        return exchangedArray;

    }


    public static boolean isThereAnOddNumber(int[] numArray) {
        for (int number : numArray) {
            if (number % 2 != 0) {
                return true;
            }
        }
        return false;
    }

    public static int indexOfMaxOdd(int[] numArray) {
        int index = 0;
        int maxOddNumber = Integer.MIN_VALUE;
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] % 2 != 0 && numArray[i] >= maxOddNumber) {
                maxOddNumber = numArray[i];
                index = i;
            }

        }
        return index;
    }

    public static int indexOfMinOdd(int[] numArray) {
        int index = 0;
        int minOddNumber = Integer.MAX_VALUE;
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] % 2 != 0 && numArray[i] <= minOddNumber) {
                minOddNumber = numArray[i];
                index = i;
            }

        }
        return index;

    }

    public static int[] firstOdd(int[] numArray, int count) {
        int oddCounter = 0;
        for (int number : numArray) {
            if (number % 2 != 0) {
                oddCounter++;
            }
        }
        if (count > oddCounter) {
            count = oddCounter;
        }
        int[] firstOddArray = new int[count];
        int startIndex = 0;
        for (int number : numArray) {
            if (number % 2 != 0) {
                firstOddArray[startIndex] = number;
                startIndex++;
            }
            if (startIndex == count) {
                break;
            }
        }
        return firstOddArray;

    }

    public static int[] lastOdd(int[] numArray, int count) {
        int oddCounter = 0;
        for (int number : numArray) {
            if (number % 2 != 0) {
                oddCounter++;
            }
        }
        if (count > oddCounter) {
            count = oddCounter;
        }
        int[] lastOddArray = new int[count];
        int startIndex = count - 1;
        for (int i = numArray.length - 1; i >= 0; i--) {
            if (numArray[i] % 2 != 0) {
                lastOddArray[startIndex] = numArray[i];
                startIndex--;
            }
            if (startIndex < 0) {
                break;
            }
        }
        return lastOddArray;

    }


    public static boolean isThereAnEvenNumber(int[] numArray) {
        for (int number : numArray) {
            if (number % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    public static int indexOfMaxEven(int[] numArray) {
        int index = 0;
        int maxEvenNumber = Integer.MIN_VALUE;
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] % 2 == 0 && numArray[i] >= maxEvenNumber) {
                maxEvenNumber = numArray[i];
                index = i;
            }

        }
        return index;
    }

    public static int indexOfMinEven(int[] numArray) {
        int index = 0;
        int minEvenNumber = Integer.MAX_VALUE;
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] % 2 == 0 && numArray[i] <= minEvenNumber) {
                minEvenNumber = numArray[i];
                index = i;
            }

        }
        return index;

    }

    public static int[] firstEven(int[] numArray, int count) {
        int evenCounter = 0;
        for (int number : numArray) {
            if (number % 2 == 0) {
                evenCounter++;
            }
        }
        if (count > evenCounter) {
            count = evenCounter;
        }
        int[] firstEvenArray = new int[count];
        int startIndex = 0;
        for (int number : numArray) {
            if (number % 2 == 0) {
                firstEvenArray[startIndex] = number;
                startIndex++;
            }
            if (startIndex == count) {
                break;
            }
        }
        return firstEvenArray;

    }

    public static int[] lastEven(int[] numArray, int count) {
        int evenCounter = 0;
        for (int number : numArray) {
            if (number % 2 == 0) {
                evenCounter++;
            }
        }
        if (count > evenCounter) {
            count = evenCounter;
        }
        int[] lastEvenArray = new int[count];
        int startIndex = count - 1;
        for (int number : numArray) {
            if (number % 2 == 0) {
                lastEvenArray[startIndex] = number;
                startIndex--;
            }
            if (startIndex < 0) {
                break;
            }
        }
        return lastEvenArray;

    }

}
