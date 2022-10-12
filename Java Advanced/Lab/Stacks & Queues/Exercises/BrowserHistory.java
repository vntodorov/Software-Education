package StacksAndQueuesLAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        while (!input.equals("Home")){
            if (input.equals("back")){
                if (browserHistory.size() >= 2){
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                browserHistory.push(input);
                System.out.println(input);
            }
            input = scanner.nextLine();
        }

    }
}
