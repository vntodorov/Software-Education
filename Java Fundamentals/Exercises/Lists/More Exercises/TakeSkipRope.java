package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder messageBuilder = new StringBuilder(scanner.nextLine());
        List<Integer> allNumbers = new ArrayList<>();
        for (int i = 0; i < messageBuilder.length(); i++) {
            char currentSymbol = messageBuilder.charAt(i);
            if (currentSymbol >= 48 && currentSymbol <= 57) {
                allNumbers.add(Integer.parseInt(String.valueOf(currentSymbol)));
                messageBuilder.deleteCharAt(i);
                i--;
            }
        }

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i < allNumbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(allNumbers.get(i));
            } else {
                skipList.add(allNumbers.get(i));
            }
        }

        StringBuilder resultString = new StringBuilder();

        for (int i = 0; i < takeList.size(); i++) {
            int takeNum = takeList.get(i);
            int skipNum = skipList.get(i);
            if (takeNum > 0) {
                if (takeNum >= messageBuilder.length()) {
                    resultString.append(messageBuilder);
                } else {
                    resultString.append(messageBuilder, 0, takeNum);
                    messageBuilder.delete(0, takeNum);
                }

            }

            if (skipNum > 0) {
                messageBuilder.delete(0, skipNum);
            }
        }

        System.out.println(resultString);
    }
}
