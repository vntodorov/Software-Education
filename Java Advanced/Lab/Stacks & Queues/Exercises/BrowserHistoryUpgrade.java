package StacksAndQueuesLAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> browserHistoryBackStack = new ArrayDeque<>();
        ArrayDeque<String> browserHistoryForwardStack = new ArrayDeque<>();

        while (!input.equals("Home")){
            if (input.equals("back")){
                if (browserHistoryBackStack.size() >= 2){
                    browserHistoryForwardStack.push(browserHistoryBackStack.pop());
                    System.out.println(browserHistoryBackStack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (input.equals("forward")) {
                if (!browserHistoryForwardStack.isEmpty()){
                    browserHistoryBackStack.push(browserHistoryForwardStack.pop());
                    System.out.println(browserHistoryBackStack.peek());
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                browserHistoryBackStack.push(input);
                browserHistoryForwardStack = new ArrayDeque<>();
                System.out.println(input);
            }
            input = scanner.nextLine();
        }

    }
}
